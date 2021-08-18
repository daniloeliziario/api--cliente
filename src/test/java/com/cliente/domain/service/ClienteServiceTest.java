package com.cliente.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ZERO;
import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ONE;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import com.cliente.domain.exception.RecursoJaExisteException;
import com.cliente.domain.exception.RecursoNaoEncontradoException;
import com.cliente.domain.factory.ClienteFactory;
import com.cliente.domain.model.Cliente;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class ClienteServiceTest {
	
	@Autowired
	private ClienteService clienteService;
	
	@Test
	void deveValidarSeOTamanhoDoListFoiAlteradoAposAdicionarCliente() {
				
		Cliente cliente = ClienteFactory.criarCliente();
		clienteService.salvar(cliente);
		
		List<Cliente> clientes = clienteService.listarTodos();
		
		assertNotEquals(clientes.size(), INTEGER_ZERO);
		assertEquals(clientes.size(), INTEGER_ONE);
		
	}
	
	@Test
	void deveValidarSeOClienteAdicionadoCorrespondeAoRecuperado() {
		
		Cliente cliente = ClienteFactory.criarCliente();
				
		Cliente clienteAdicionado = clienteService.salvar(cliente);
		Cliente clienteRecuperado = clienteService.buscarOuFalhar(clienteAdicionado.getId());
		
		assertEquals(cliente.getNome(), clienteRecuperado.getNome());
		assertEquals(cliente.getDataNascimento(), clienteRecuperado.getDataNascimento());
		assertEquals(cliente.getTelefone(), clienteRecuperado.getTelefone());
		
	}
	
	@Test
	void deveValidarSeOcorreuRecursoJaExisteExceptionAoAdicionarClientesIguais() {
			
		assertThrows(RecursoJaExisteException.class, () -> {
			
			Cliente cliente01 = ClienteFactory.criarCliente();	
			Cliente cliente02 = ClienteFactory.criarCliente();				
					
			clienteService.salvar(cliente01);
			clienteService.salvar(cliente02);
			
		});
		
	}
	
	@Test
	void deveValidarSeOcorreuRecursoNaoEncontradoExceptionAoRecuperarClienteInexistente() {
			
		assertThrows(RecursoNaoEncontradoException.class, () -> {
			
			List<Cliente> clientes = clienteService.listarTodos();
			assertEquals(clientes.size(), INTEGER_ZERO);
			
			clienteService.buscarOuFalhar(Long.valueOf(INTEGER_ONE));
			
		});
		
	}
	
}
