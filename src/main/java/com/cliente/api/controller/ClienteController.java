package com.cliente.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cliente.domain.model.Cliente;
import com.cliente.domain.service.ClienteService;

import lombok.extern.slf4j.Slf4j;


@CrossOrigin
@Slf4j
@RestController
@RequestMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody @Valid Cliente cliente) {
		log.info("Cadastrando os clientes");
		
		return clienteService.salvar(cliente);
	}
	
	@GetMapping
	public List<Cliente> listar() {
		log.info("Listando os clientes");
		
		return clienteService.listarTodos();
	}
	
	@GetMapping("/{id}")
	public Cliente buscar(@PathVariable Long id) {
		log.info("Buscando cliente de id {}", id);
		
		return clienteService.buscarOuFalhar(id);
	}

}
