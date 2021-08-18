create table if not exists cliente (
	id bigint not null auto_increment,
	nome varchar(80) not null,
	data_nascimento datetime not null,
	telefone varchar(80) not null,
	
	primary key (id)
);