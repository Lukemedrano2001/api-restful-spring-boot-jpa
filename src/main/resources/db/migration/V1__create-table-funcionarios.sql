CREATE TABLE funcionarios(
	id VARCHAR PRIMARY KEY,
	nome VARCHAR NOT NULL,
	data_nascimento DATE NOT NULL,
	email VARCHAR UNIQUE NOT NULL,
	senha VARCHAR NOT NULL,
	salario_em_centavos INT NOT NULL,
	sexo VARCHAR NOT NULL
);