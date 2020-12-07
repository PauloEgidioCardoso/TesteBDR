CREATE TABLE usuario (
	id_usuario SERIAL PRIMARY KEY NOT NULL,
	login CHARACTER VARYING(100) NOT NULL,
	senha CHARACTER VARYING(100) NOT NULL,
	nome CHARACTER VARYING(100) NOT NULL,
	administrador BOOLEAN NOT NULL
);

INSERT INTO usuario (login, senha, nome, administrador) 
		VALUES ('joca1234', '5050', 'José Carlos', true),
				('ana1991', '4143', 'Ana Claudia', false);
				
				