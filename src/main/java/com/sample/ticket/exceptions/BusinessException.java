package com.sample.ticket.exceptions;

/**
 * Excepcion generica para errores de negocio.
 * 
 * @author Israel I.R.E
 *
 */
public class BusinessException extends Exception {

	private static final long serialVersionUID = 3353793354378266506L;

	public BusinessException(String msg) {
		super(msg);
	}

}
