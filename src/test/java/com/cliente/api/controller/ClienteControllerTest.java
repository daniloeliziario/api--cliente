package com.cliente.api.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClienteControllerTest {

	@LocalServerPort
	private int port;
	
	private static final String USUARIO_SENHA = "serasa";
	
	private static final String BODY_JSON_CORRETO = "{ \"nome\": \"Gabriel\","
			+ "\"dataNascimento\": \"1996-12-25\", "
			+ "\"telefone\": \"83981693171\"}";
	
	private static final String BODY_JSON_INCORRETO = "{ \"nome\": \"Gabriel\","
			+ "\"dataNascimento\": \"1996-12-25\"}";
	
	@BeforeEach
	public void setUp() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
	}
	
	@Test
	void deveRetornarStatus200QuandoConsultarClienteComSucesso() {
		RestAssured.given()
			.basePath("/clientes")
				.accept(ContentType.JSON)
			.auth()
				.basic(USUARIO_SENHA, USUARIO_SENHA)
		.when()
			.get()
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	void deveRetornarStatus200QuandoConsultarClienteParametizadoComSucesso() {
		RestAssured.given()
			.basePath("/clientes/{id}")
				.pathParam("id", 1)
				.accept(ContentType.JSON)
			.auth()
				.basic(USUARIO_SENHA, USUARIO_SENHA)
		.when()
			.get()
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	void deveRetornarStatus201QuandoAdicionarClienteComSucesso() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.given()
			.basePath("/clientes")
				.body(BODY_JSON_CORRETO)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
			.auth()
				.basic(USUARIO_SENHA, USUARIO_SENHA)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.CREATED.value());
	}
	
	@Test
	void deveRetornarStatus400QuandoAdicionarClienteComBodyJsonIncorreto() {
		RestAssured.given()
			.basePath("/clientes")
			.body(BODY_JSON_INCORRETO)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
			.auth()
				.basic(USUARIO_SENHA, USUARIO_SENHA)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value());
	}
	
	@Test
	void deveRetornarStatus404QuandoConsultarClienteComRecursoInvalido() {
		RestAssured.given()
			.basePath("/clientess")
				.accept(ContentType.JSON)
			.auth()
				.basic(USUARIO_SENHA, USUARIO_SENHA)
		.when()
			.get()
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}
	
	@Test
	void deveRetornarStatus405QuandoConsultarClienteComMetodoNaoSuportado() {
		RestAssured.given()
			.basePath("/clientes")
				.accept(ContentType.JSON)
			.auth()
				.basic(USUARIO_SENHA, USUARIO_SENHA)
		.when()
			.put()
		.then()
			.statusCode(HttpStatus.METHOD_NOT_ALLOWED.value());
	}
	
	@Test
	void deveRetornarStatus406QuandoConsultarClienteComFormatoNaoAceito() {
		RestAssured.given()
			.basePath("/clientes")
				.accept(ContentType.XML)
			.auth()
				.basic(USUARIO_SENHA, USUARIO_SENHA)
		.when()
			.get()
		.then()
			.statusCode(HttpStatus.NOT_ACCEPTABLE.value());
	}
	
	@Test
	void deveRetornarStatus415QuandoAdicionarClienteComMediaTypeNaoSuportado() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.given()
			.basePath("/clientes")
				.body(BODY_JSON_CORRETO)
				.contentType(ContentType.XML)
				.accept(ContentType.JSON)
			.auth()
				.basic(USUARIO_SENHA, USUARIO_SENHA)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value());
	}
	
}
