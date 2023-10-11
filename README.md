# BddChamaMedBruno

### Apenas o teste de BDD é de minha autoria ###
### Trabalho de Conclusão de Curso do curso Técnico em Desenvolvimento de Sistemas ### 

CREATE DATABASE Chamadas

CREATE TABLE usuario ( id SERIAL PRIMARY KEY, nome varchar(255) not null, matricula integer not null, cargo integer not null, senha varchar(255) not null, ativo bool default true, foreign key (cargo) references cargo(id) );

INSERT INTO usuario (id, nome, matricula, cargo, senha, ativo) VALUES (1, 'marcio', 123, 1, 123, true)

CREATE TABLE cargo( id SERIAL PRIMARY KEY, nome varchar(255) ) 

INSERT INTO cargo(nome) VALUES('Gestor(a)'), ('Médico(a)'), ('Residente'), ('Enfermeiro(a)-Chefe'), ('Enfermeiro(a)');

CREATE TABLE interruptor ( id SERIAL PRIMARY KEY, interruptor varchar(255) not null, estado bool default true, setor varchar(255) not null );

INSERT INTO interruptor (interruptor, estado, setor) VALUES ('cama 1', true, '1'), ('cama 2', true, '2'), ('cama 3', true, '3'), ('cama 4', true, '4')

CREATE TABLE registro ( id SERIAL PRIMARY KEY, acao VARCHAR(255) , nome varchar(255) , data_hora TIMESTAMP );
