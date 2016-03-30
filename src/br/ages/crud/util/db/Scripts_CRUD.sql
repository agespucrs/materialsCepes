/***
* Scripts para criaacao e insersao de dados
* Base de Dados do CePES Material 
* Casssio Trindade
* 09/09/2015
***/

USE cepes_e;


-- Tabelas

CREATE TABLE tb_funcao (
  ID_FUNCAO int(11) NOT NULL AUTO_INCREMENT,
  NOME varchar(255) NOT NULL,
  DESCRICAO varchar(255) NOT NULL,
  PRIMARY KEY (ID_FUNCAO)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tb_usuario` (
  `ID_USUARIO` int(11) NOT NULL AUTO_INCREMENT,
  `USUARIO` varchar(30) NOT NULL,
  `SENHA` varchar(8) NOT NULL,
  `ADMINISTRADOR` tinyint(1) NOT NULL,
  `MATRICULA` varchar(11) NOT NULL,
  `NOME` varchar(120) NOT NULL,
  `EMAIL` varchar(120) NOT NULL,
  `DATA_CADASTRO` datetime NOT NULL,
  `ID_FUNCAO` int(11) NOT NULL,
  `CPF` varchar(11) NOT NULL,
  PRIMARY KEY (`ID_USUARIO`),
  UNIQUE KEY `MATRICULA_UNIQUE` (`MATRICULA`),
  UNIQUE KEY `CPF_UNIQUE` (`CPF`),
  KEY `fk_tb_funcao_idx` (`ID_FUNCAO`),
  CONSTRAINT `fk_tb_funcao` FOREIGN KEY (`ID_FUNCAO`) REFERENCES `tb_funcao` (`ID_FUNCAO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
   
CREATE TABLE tb_autor (
  id_autor int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(60) NOT NULL,
  sobrenome varchar(60) NOT NULL,
  PRIMARY KEY (id_autor)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tb_editora (
  ID_EDITORA int(8) NOT NULL AUTO_INCREMENT,
  NOME varchar(255) NOT NULL,
  PRIMARY KEY (ID_EDITORA)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tb_livro (
  ID_LIVRO int(8) NOT NULL AUTO_INCREMENT,
  TITULO varchar(255) NOT NULL,
  SUBTITULO varchar(255) NOT NULL,
  DATA_CADASTRO date NOT NULL,
  PRECO decimal(8,0) DEFAULT NULL,
  LINGUA varchar(255) NOT NULL,
  CODIGO_ISBN decimal(20,0) NOT NULL,
  EDICAO decimal(4,0) NOT NULL,
  ANO date DEFAULT NULL,
  PAGINAS int(4) DEFAULT NULL,
  VIDEO boolean DEFAULT NULL,
  CD_DVD boolean DEFAULT NULL,
  E_BOOK boolean DEFAULT NULL,
  BRUXURA_REVISTA boolean DEFAULT NULL,
  DESCRICAO text,
  ID_EDITORA int(11) NOT NULL,
  EXCLUIDO boolean DEFAULT NULL,
  PRIMARY KEY (ID_LIVRO),
  UNIQUE KEY CODISBN_UNIQUE (CODIGO_ISBN)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tb_livro_autor (
  id_livro int(11) NOT NULL,
  id_autor int(11) NOT NULL,
  KEY fk_livro_idx (id_livro),
  KEY fk_autor (id_autor),
  CONSTRAINT fk_autor FOREIGN KEY (id_autor) REFERENCES tb_autor (id_autor) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_livro FOREIGN KEY (id_livro) REFERENCES tb_livro (ID_LIVRO) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/* SCRIPTS DE INSER��O PRA FACILITAR TESTES */
INSERT INTO tb_funcao
(ID_FUNCAO, NOME, DESCRICAO)
VALUES
('1', 'PROF', 'PROF DA PUC');

INSERT INTO tb_usuario
(ID_USUARIO,USUARIO,SENHA,ADMINISTRADOR,MATRICULA,NOME,EMAIL,DATA_CADASTRO, ID_FUNCAO, CPF)
VALUES
('10', 'admin', 'admin', '1', '00000', 'C�ssio Trindade', 'cassio.trindade@pucrs.br', '2015-10-01 00:00:00', '1', '12345789999');


INSERT INTO tb_editora
(ID_EDITORA,NOME)
VALUES
( 1, 'Abril');

INSERT INTO tb_editora
(ID_EDITORA,NOME)
VALUES
( 2, 'Saraiva');

INSERT INTO tb_livro
(ID_LIVRO,TITULO,SUBTITULO,DATA_CADASTRO,LINGUA,CODIGO_ISBN,EDICAO, ID_EDITORA, EXCLUIDO)
VALUES
( 1, 'A arte da guerra', '--', '2015-10-01 00:00:00', 'pt', 11111111111111111111, 1, 1, 0);

INSERT INTO tb_livro
(ID_LIVRO,TITULO,SUBTITULO,DATA_CADASTRO,LINGUA,CODIGO_ISBN,EDICAO, ID_EDITORA, EXCLUIDO)
VALUES
( 2, 'O pequeno principe', '--', '2015-10-01 00:00:00', 'pt', 11111111111111111112, 1, 2, 0);

INSERT INTO tb_autor
(ID_AUTOR,NOME,SOBRENOME)
VALUES
( 1, 'Paulo', 'Coelho');

INSERT INTO tb_livro_autor
(ID_LIVRO,ID_AUTOR)
VALUES
(1, 1);

INSERT INTO tb_livro_autor
(ID_LIVRO,ID_AUTOR)
VALUES
(2, 1);



