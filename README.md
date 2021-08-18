

<h1 align="left">
     api--cliente
</h1>

Tabela de conteúdos
=================
<!--ts-->
   * [Sobre o projeto](#sobre-o-projeto)
   * [Funcionalidades](#funcionalidades)
   * [Como executar o projeto](#como-executar-o-projeto)
     * [Pré-requisitos](#pré-requisitos)
     * [Executando a API localmente](#executando-a-api-localmente)
     	* [Executando a API localmente via Linha de Comando](#executando-a-api-localmente-via-linha-de-comando)
     	* [Executando a API localmente via IDE](#executando-a-api-localmente-via-ide)
     * [Acessando a API localmente](#acessando-a-api-localmente)
     	* [Acessando a API localmente via Navegador](#acessando-a-api-localmente-via-navegador)
     	* [Acessando a API localmente via Postman](#acessando-a-api-localmente-via-postman)
     	* [Acessando a API localmente via Swagger](#acessando-a-api-localmente-via-swagger)
     * [Executando os testes da API](#executando-os-testes-da-api)
     	* [Executando os testes da API via Linha de Comando](#executando-os-testes-da-api-via-linha-de-comando)
     	* [Executando os testes da API via IDE](#executando-os-testes-da-api-via-ide)
     * [Realizando o Deploy da API](#realizando-o-deploy-da-api)
     	* [Realizando o Deploy da API via Linha de Comando](#realizando-o-deploy-da-api-via-linha-de-comando)
     	* [Realizando o Deploy da API via IDE](#realizando-o-deploy-da-api-via-ide)
   * [Tecnologias](#tecnologias)
     * [Back-end](#back-end--java----spring)
   * [Autor](#autor)
<!--te-->


## Sobre o projeto

API responsável por gerenciar clientes

---

## Funcionalidades

Cadastro e consulta de clientes:
- Endpoints:
  - clientes : GET
  - clientes/{id} : GET 
  - clientes : POST
	
---

## Como executar o projeto

### Pré-requisitos

-	 [JDK 11+](https://adoptopenjdk.net/?variant=openjdk11&jvmVariant=hotspot)
-	 [Maven 3](https://maven.apache.org/download.cgi)
-	 [Lombok 1.18.20](https://projectlombok.org/download)

#### Executando a API localmente

##### Executando a API localmente via Linha de Comando

```bash
(Requisito: Java configurado nas variáveis de ambiente)

# Clone este repositório:

$ git clone https://github.com/daniloeliziario/api--cliente.git

# Acesse o caminho do projeto e execute o comando Maven:

$ ./mvnw clean install

# O Maven irá gerar um Fat JAR na pasta target 

# Acesse a pasta e execute o comando:

$ java -jar api--cliente-0.0.1-SNAPSHOT.jar
```

##### Executando a API localmente via IDE

```bash
(Requisito: IDE e plugin do Lombok instalados)

# Clone este repositório

$ git clone https://github.com/daniloeliziario/api--cliente.git

# Execute sua IDE e import o código baixado

# Execute o projeto a partir da classe ApiClienteApplication
```
#### Acessando a API localmente

##### Acessando a API localmente via Navegador

```bash
# O servidor iniciará na porta:8080 

# Acesse http://localhost:8080 via navegador e entre com as credenciais - Login: serasa / Senha: serasa 

# Para visualizar os clientes, digite: http://localhost:8080/clientes
```

##### Acessando a API localmente via Postman

```bash
(Requisito: Postman instalado)

# A coleção já vêm pronta para ser executada. 

# O servidor iniciará na porta:8080 

# Execute o Postman e import a coleção inserida no caminho: 

https://github.com/daniloeliziario/api--cliente/tree/main/src/main/resources/collections

# A coleção contêm os dois endpoints para execução

# Obs.: Caso ocorra erro 401 insira as credenciais - Login: serasa / Senha: serasa
```

##### Acessando a API localmente via Swagger

```bash
# O servidor inciará na porta:8080 

# Acesse http://localhost:8080/swagger-ui.html via navegador e entre com as credenciais - Login: serasa / Senha: serasa 

# Será apresentado os endpoints para execução
```

#### Executando os testes da API

##### Executando os testes da API via Linha de Comando

```bash
# Acesse o caminho do projeto e execute o comando Maven:

$ ./mvnw test
```

##### Executando os testes da API via IDE

```bash
# Execute sua IDE e import o código baixado

# Execute o projeto no segmento testes
```

#### Realizando o Deploy da API

##### Realizando o Deploy da API via Linha de Comando

```bash
# Acesse o caminho do projeto e execute o comando Maven:

$ ./mvnw clean install

# O Maven irá gerar um Fat JAR na pasta target

# Esse arquivo já está pronto para ser deployado
```

##### Realizando o Deploy da API via IDE

```bash
# Execute sua IDE e import o código baixado

# Execute o maven com o comando:

$ clean install

# O Maven irá gerar um Fat JAR na pasta target 

# Esse arquivo já está pronto para ser deployado
```

---

## Tecnologias

As seguintes tecnologias foram utilizadas na construção do projeto:

### **Back-end**  ([Java](https://www.java.com/pt-BR/)  +  [Spring](https://spring.io/))

-   **[Spring Boot](https://spring.io/projects/spring-boot)**
-   **[Spring Security](https://spring.io/projects/spring-security)**
-   **[Springdoc](https://springdoc.org/)**
-   **[H2 Database Engine](https://www.h2database.com/html/main.html/)**
-   **[Logbook](https://github.com/zalando/logbook/)**
-   **[Lombok](https://projectlombok.org/)**
-   **[Rest Assured](https://rest-assured.io/)**
-   **[Apache Commons Lang](https://commons.apache.org/proper/commons-lang/)**

---

## Autor

<h4 align="left">
     <a href="https://www.linkedin.com/in/daniloeliziario/">Danilo Eliziario</a>
</h4>

---

