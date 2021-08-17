package com.cliente.domain.exception;

import lombok.Getter;

@Getter
public class RecursoNaoEncontradoException extends ClienteException {

	private static final long serialVersionUID = 1L;
	
	private final Long id;

	public RecursoNaoEncontradoException(String recurso, Long id) {
		super(recurso);
		this.id = id;
	}

}
