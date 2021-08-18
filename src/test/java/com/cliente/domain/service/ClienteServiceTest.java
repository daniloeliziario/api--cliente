package com.cliente.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

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
	
	private static final Integer QNT_CLIENTES_BASE = 2;
	
	@Test
	void deveValidarSeOTamanhoDoListFoiAlteradoAposAdicionarCliente() {
				
		Cliente cliente = ClienteFactory.criarCliente();
		clienteService.salvar(cliente);
		
		List<Cliente> clientes = clienteService.listarTodos();
		
		assertNotEquals(clientes.size(), QNT_CLIENTES_BASE);
		assertEquals(clientes.size(), 3);
		
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
			assertEquals(clientes.size(), QNT_CLIENTES_BASE);
			
			clienteService.buscarOuFalhar(Long.valueOf(1000));
			
		});
		
	}
	
	

}
