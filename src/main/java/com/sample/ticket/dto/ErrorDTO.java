package com.sample.ticket.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Objeto DTO que llevara como respuesta los errores de las peticiones
 * 
 * @author Israel I.R.E
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDTO implements Serializable {

	private static final long serialVersionUID = -3753846937272180822L;

	/**
	 * Descripcion sobre el error
	 */
	private String msg;

	/**
	 * Lista de errores
	 */
	private List<String> errors;

	/**
	 * Clave de estatus
	 */
	private int httpStatus;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
