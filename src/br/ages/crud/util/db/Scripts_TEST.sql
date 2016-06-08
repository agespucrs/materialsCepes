/**
 * Projeto CePESMaterials
 * Script de inserção de dados na base para facilitar navegação.
 * Criação: 28/04/2016 - Eduardo C.
 */

use cepes_e;

/* SCRIPTS DE INSERCAO PRA FACILITAR TESTES */
INSERT INTO TB_FUNCAO
(ID_FUNCAO, NOME, DESCRICAO)
VALUES
('1', 'PROF', 'PROF DA PUC');

INSERT INTO TB_USUARIO
(ID_USUARIO,USUARIO,SENHA,ADMINISTRADOR,MATRICULA,NOME,EMAIL,DATA_CADASTRO, ID_FUNCAO, CPF)
VALUES
('10', 'admin', 'admin', '1', '00000', 'Cassio Trindade', 'cassio.trindade@pucrs.br', '2015-10-01 00:00:00', '1', '12345789999');

INSERT INTO TB_IDIOMA
(ID_IDIOMA, PAIS, NOME)
VALUES
(1, 'BRASIL', 'PORTUGUES');

INSERT INTO TB_AUTOR
(ID_AUTOR,NOME,SOBRENOME)
VALUES
( 1, 'Paulo', 'Coelho');

INSERT INTO TB_EDITORA
(ID_EDITORA,NOME)
VALUES
( 1, 'Abril');

INSERT INTO TB_EDITORA
(ID_EDITORA,NOME)
VALUES
( 2, 'Saraiva');

INSERT INTO TB_LIVRO
(ID_LIVRO,TITULO,SUBTITULO,DATA_CADASTRO,ID_IDIOMA,CODIGO_ISBN,EDICAO, ANO, PAGINAS, VIDEO, CD_DVD, E_BOOK, BROCHURA, DESCRICAO, ID_EDITORA, EXCLUIDO, REVISTA)
VALUES
( 1, 'A arte da guerra', '--', '2015-10-01 00:00:00', 1, 111111111111, 1, 1990, 100, 1, 0, 1, 1, 'NOVO LIVRO', 2, 0, 0);

INSERT INTO TB_LIVRO_AUTOR
(ID_LIVRO,ID_AUTOR)
VALUES
(1, 1);

INSERT INTO TB_LIVRO_AUTOR
(ID_LIVRO,ID_AUTOR)
VALUES
(1, 1);

INSERT INTO TB_MARCA
(ID_MARCA, NOME)
VALUES
(1, 'SAMSUNG');

insert into TB_PROJETOS
(Id_Projeto, Nome_Projeto, Programa, Origem, Data_Cadastro, Id_Cordenador)
values
(1, "Projeto Teste", "Desenvolvimento AGES", "TESTES", "2016-04-05", 10);

insert into TB_EQUIPAMENTOS
(Id_Equipamento, N_Patrimonio, Status, Modelo, 
Valor_Aquisicao, Data_Cadastro, Observacao, Id_Marca, Id_Projeto)
VALUES
(1, 123, 1, "Inspiron 15R", 
2500, '2016-04-05', "Observacao 1", 1, 1);

insert into TB_EQUIPAMENTOS
(Id_Equipamento, N_Patrimonio, Status, Modelo, 
Valor_Aquisicao, Data_Cadastro, Observacao, Id_Marca, Id_Projeto)
VALUES
(2, 456, 1, "HP", 
1000, '2016-04-05', "Observacao 2", 1, 1);

insert into TB_EQUIPAMENTOS
(Id_Equipamento, N_Patrimonio, Status, Modelo, 
Valor_Aquisicao, Data_Cadastro, Observacao, Id_Marca, Id_Projeto)
VALUES
(3, 789, 1, "Galaxy", 
750, '2016-04-05', "Observacao 3", 1, 1);

insert into TB_TIPO (Nome, Tipo_Equipamento) values ('Desktop', 'C');
insert into TB_TIPO (Nome, Tipo_Equipamento) values ('Notebook', 'C');
insert into TB_TIPO (Nome, Tipo_Equipamento) values ('Servidor', 'C');
insert into TB_TIPO (Nome, Tipo_Equipamento) values ('Tablet', 'M');
insert into TB_TIPO (Nome, Tipo_Equipamento) values ('Celular', 'M');
insert into TB_TIPO (Nome, Tipo_Equipamento) values ('Smartphone', 'M');
insert into TB_TIPO (Nome, Tipo_Equipamento) values ('Outros', 'M');
insert into TB_TIPO (Nome, Tipo_Equipamento) values ('Monitor', 'P');
insert into TB_TIPO (Nome, Tipo_Equipamento) values ('TV', 'P');
insert into TB_TIPO (Nome, Tipo_Equipamento) values ('Impressora', 'P');
insert into TB_TIPO (Nome, Tipo_Equipamento) values ('Switch', 'P');
insert into TB_TIPO (Nome, Tipo_Equipamento) values ('Outros', 'P');
insert into TB_TIPO (Nome, Tipo_Equipamento) values ('Mouse', 'A');
insert into TB_TIPO (Nome, Tipo_Equipamento) values ('Teclado', 'A');
insert into TB_TIPO (Nome, Tipo_Equipamento) values ('Caixa de Som', 'A');
insert into TB_TIPO (Nome, Tipo_Equipamento) values ('Cabos (HDMI, VGA, etc)', 'A');
insert into TB_TIPO (Nome, Tipo_Equipamento) values ('Hard Drive', 'A');

insert into tb_funcao values(1, 'Professor Coordenador', '');
insert into tb_funcao values(2, 'Professor Colaborador', '');
insert into tb_funcao values(3, 'Aluno Doutorando', '');
insert into tb_funcao values(4, 'Aluno Mestrando', '');
insert into tb_funcao values(5, 'Aluno Graduando', '');
insert into tb_funcao values(6, 'Aluno Especialização', '');
insert into tb_funcao values(7, 'Técnico Administrativo', '');