package com.cliente.domain.factory;

import java.time.LocalDate;

import com.cliente.domain.model.Cliente;

public class ClienteFactory {
	
	private static final String NOME_CLIENTE = "José";
	private static final LocalDate DATA_NASCIMENTO_CLIENTE = LocalDate.of(1992, 03, 02);
	private static final String TELEFONE_CLIENTE = "83976767654";
	
	public static Cliente criarCliente() {
		return Cliente.builder()
				.nome(NOME_CLIENTE)
				.dataNascimento(DATA_NASCIMENTO_CLIENTE)
				.telefone(TELEFONE_CLIENTE)
				.build();
	}

}
