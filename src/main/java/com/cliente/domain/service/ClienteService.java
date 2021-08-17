package com.cliente.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cliente.domain.exception.RecursoJaExisteException;
import com.cliente.domain.exception.RecursoNaoEncontradoException;
import com.cliente.domain.model.Cliente;
import com.cliente.domain.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	private static final String RECURSO_CLIENTE = "Cliente";
	
	@Transactional
	public Cliente salvar(Cliente cliente) {	
		
		Optional<Cliente> clienteExistente = clienteRepository.findByNome(cliente.getNome());
		
		if(clienteExistente.isPresent()) {
			throw new RecursoJaExisteException(RECURSO_CLIENTE);
		} 
		
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> listarTodos() { 
		return clienteRepository.findAll();
	}
	
	public Cliente buscarOuFalhar(Long id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException(RECURSO_CLIENTE, id));
	}

}

