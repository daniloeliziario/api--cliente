package com.cliente.domain.exception;

public class ClienteException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ClienteException(String recurso) {
		super(recurso);
	}
	
	public ClienteException(String recurso, Throwable causa) {
		super(recurso, causa);
	}

}