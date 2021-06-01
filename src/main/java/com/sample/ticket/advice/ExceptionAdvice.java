package com.sample.ticket.advice;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.sample.ticket.dto.ErrorDTO;
import com.sample.ticket.exceptions.BusinessException;

/**
 * 
 * @author Israel I. Rodriguez E.
 *
 */
@RestControllerAdvice
public class ExceptionAdvice {

	private static String INVALID_JSON_MSG = "Json invalido";

	private static String UNKNOW_ERROR_MSG = "Error desconocido";

	private static String INVALID_INFORMATION_MSG = "Informacion invalida";

	private static String MANDATORY_PARAM = "Informacion obligatoria";

	private static final Logger LOG = LoggerFactory.getLogger(ExceptionAdvice.class);

	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<Object> handleRuntimeException(RuntimeException e) {

		ErrorDTO errorDTO = new ErrorDTO();

		if (e instanceof HttpMessageNotReadableException) {
			List<String> errors = new ArrayList<>();
			errors.add(INVALID_JSON_MSG);
			errorDTO.setMsg("Petición Invalida");
			errorDTO.setErrors(errors);
			errorDTO.setHttpStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
			return new ResponseEntity<>(errorDTO, HttpStatus.UNPROCESSABLE_ENTITY);
		}

		LOG.error("Surgio error desconocido: [RuntimeException] {0}", e);
		return new ResponseEntity<>(UNKNOW_ERROR_MSG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = Throwable.class)
	public ResponseEntity<Object> handleThrowable(Throwable e) {
		ErrorDTO errorDTO = new ErrorDTO();
		List<String> errors = new ArrayList<>();
		if (e instanceof MissingServletRequestParameterException) {

			errorDTO.setHttpStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());

			String param = ((MissingServletRequestParameterException) e).getParameterName();

			errorDTO.setMsg(INVALID_INFORMATION_MSG);
			String msg = String.format(MANDATORY_PARAM, param);
			errors.add(msg);
			errorDTO.setErrors(errors);
			return new ResponseEntity<>(errorDTO, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		LOG.error("Surgio error desconocido: [Throwable]", e);
		errors.add(e.getMessage());
		errorDTO.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorDTO.setErrors(errors);
		errorDTO.setMsg("Solicitud no procesada.");
		return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
		List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
		List<String> errors = new ArrayList<>();
		for (ObjectError error : allErrors) {
			errors.add(error.getDefaultMessage());
		}

		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setMsg(INVALID_INFORMATION_MSG);
		errorDTO.setErrors(errors);
		errorDTO.setHttpStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		return new ResponseEntity<>(errorDTO, HttpStatus.UNPROCESSABLE_ENTITY);

	}

	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity<Object> handleBussinesException(BusinessException e) {

		List<String> errors = new ArrayList<>();
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setHttpStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		errorDTO.setMsg(INVALID_INFORMATION_MSG);

		errors.add(e.getMessage());
		errorDTO.setErrors(errors);
		return new ResponseEntity<>(errorDTO, HttpStatus.UNPROCESSABLE_ENTITY);

	}

}
