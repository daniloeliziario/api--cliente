package com.cliente.domain.exception;

public class RecursoJaExisteException extends ClienteException {

	private static final long serialVersionUID = 1L;

	public RecursoJaExisteException(String recurso) {
		super(recurso);
	}

}
