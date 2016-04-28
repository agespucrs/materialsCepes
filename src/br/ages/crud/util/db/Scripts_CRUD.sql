/**
 * Projeto CePESMaterials
 * Script de cria��o de banco de dados
 * Cria��o: 09/09/2015 - Cassio
 */


USE cepes_e;

CREATE TABLE TB_FUNCAO (
  ID_FUNCAO int(11) NOT NULL AUTO_INCREMENT,
  NOME varchar(255) NOT NULL,
  DESCRICAO varchar(255) NOT NULL,
  PRIMARY KEY (ID_FUNCAO)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE TB_USUARIO (
  ID_USUARIO int(11) NOT NULL AUTO_INCREMENT,
  USUARIO varchar(30) NOT NULL,
  SENHA varchar(8) NOT NULL,
  ADMINISTRADOR tinyint(1) NOT NULL,
  MATRICULA varchar(11) NOT NULL,
  NOME varchar(120) NOT NULL,
  EMAIL varchar(120) NOT NULL,
  DATA_CADASTRO datetime NOT NULL,
  ID_FUNCAO int(11) NOT NULL,
  CPF varchar(11) NOT NULL,
  PRIMARY KEY (`ID_USUARIO`),
  UNIQUE KEY `MATRICULA_UNIQUE` (`MATRICULA`),
  UNIQUE KEY `CPF_UNIQUE` (`CPF`),
  KEY `fk_TB_FUNCAO_idx` (`ID_FUNCAO`),
  CONSTRAINT `fk_TB_FUNCAO` FOREIGN KEY (`ID_FUNCAO`) REFERENCES `TB_FUNCAO` (`ID_FUNCAO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE TB_PROJETOS (
  ID_PROJETO int(11) NOT NULL AUTO_INCREMENT,
  NOME_PROJETO varchar(120) NOT NULL,
  PROGRAMA varchar(120) NOT NULL,
  ORIGEM varchar(120) NOT NULL,
  DATA_CADASTRO datetime NOT NULL,
  ID_CORDENADOR int(11) NOT NULL,
  PRIMARY KEY (`ID_PROJETO`),
  KEY `FK_ID_CORDENADOR_idx` (`ID_CORDENADOR`),
  CONSTRAINT `FK_ID_CORDENADOR` FOREIGN KEY (`ID_CORDENADOR`) REFERENCES `TB_USUARIO` (`ID_USUARIO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE TB_IDIOMA (
  ID_IDIOMA int(11) NOT NULL AUTO_INCREMENT,
  NOME varchar(120) NOT NULL,
  PAIS varchar(120) NOT NULL,
  PRIMARY KEY (`ID_IDIOMA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

   
CREATE TABLE TB_AUTOR (
  ID_AUTOR int(11) NOT NULL AUTO_INCREMENT,
  NOME varchar(60) NOT NULL,
  SOBRENOME varchar(60) NOT NULL,
  PRIMARY KEY (ID_AUTOR)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE TB_EDITORA (
  ID_EDITORA int(11) NOT NULL AUTO_INCREMENT,
  NOME varchar(255) NOT NULL,
  PRIMARY KEY (ID_EDITORA)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE TB_LIVRO (
  ID_LIVRO int(11) NOT NULL,
  TITULO varchar(120) NOT NULL,
  SUBTITULO varchar(120) NOT NULL,
  DATA_CADASTRO datetime NOT NULL,
  PRECO decimal(5,2) DEFAULT NULL,
  ID_IDIOMA int(11) NOT NULL,
  CODIGO_ISBN varchar(13) NOT NULL,
  EDICAO int(3) NOT NULL,
  ANO int(4) DEFAULT NULL,
  PAGINAS int(4) DEFAULT NULL,
  VIDEO tinyint(1) NOT NULL,
  CD_DVD tinyint(1) NOT NULL,
  E_BOOK tinyint(1) DEFAULT NULL,
  BROCHURA tinyint(1) DEFAULT NULL,
  DESCRICAO text,
  ID_EDITORA int(11) NOT NULL,
  EXCLUIDO tinyint(1) DEFAULT NULL,
  REVISTA tinyint(1) NOT NULL,
  PRIMARY KEY (`ID_LIVRO`),
  UNIQUE KEY `CODISBN_UNIQUE` (`CODIGO_ISBN`),
  KEY `fk_TB_IDIOMA_idx` (`ID_IDIOMA`),
  KEY `fk_TB_EDITORA_idx` (`ID_EDITORA`),
  CONSTRAINT `fk_TB_EDITORA` FOREIGN KEY (`ID_EDITORA`) REFERENCES `TB_EDITORA` (`ID_EDITORA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_TB_IDIOMA` FOREIGN KEY (`ID_IDIOMA`) REFERENCES `TB_IDIOMA` (`ID_IDIOMA`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE TB_LIVRO_AUTOR (
  ID_LIVRO int(11) NOT NULL,
  ID_AUTOR int(11) NOT NULL,
  KEY fk_livro_idx (id_livro),
  KEY fk_autor (id_autor),
  CONSTRAINT fk_autor FOREIGN KEY (id_autor) REFERENCES TB_AUTOR (id_autor) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_livro FOREIGN KEY (id_livro) REFERENCES TB_LIVRO (ID_LIVRO) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE TB_MARCA (
  ID_MARCA int(11) NOT NULL AUTO_INCREMENT,
  NOME varchar(255) NOT NULL,
  PRIMARY KEY (ID_MARCA)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE TB_EQUIPAMENTOS (
  ID_EQUIPAMENTO int(11) NOT NULL AUTO_INCREMENT,
  N_PATRIMONIO int(13) NOT NULL,
  STATUS tinyint(1) NOT NULL,
  MODELO varchar(120) DEFAULT NULL,
  VALOR_AQUISICAO decimal(9,2) DEFAULT NULL,
  DATA_CADASTRO datetime NOT NULL,
  OBSERVACAO text,
  ID_MARCA int(11) NOT NULL,
  ID_PROJETO int(11) NOT NULL,
  PRIMARY KEY (`ID_EQUIPAMENTO`),
  UNIQUE KEY `n_patrimonio_UNIQUE` (`N_PATRIMONIO`),
  KEY `FK_ID_MARCA_idx` (`ID_MARCA`),
  CONSTRAINT `FK_ID_MARCA` FOREIGN KEY (`ID_MARCA`) REFERENCES `TB_MARCA` (`ID_MARCA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ID_PROJETO` FOREIGN KEY (`ID_PROJETO`) REFERENCES `TB_PROJETOS` (`ID_PROJETO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE TB_COMPUTADOR (
  ID_COMPUTADOR int(11) NOT NULL,
  TIPO_COMPUTADOR varchar(120) NOT NULL,
  ID_EQUIPAMENTO int(11) NOT NULL,
  PRIMARY KEY (`ID_COMPUTADOR`),
  UNIQUE KEY `ID_EQUIPAMENTO_UNIQUE` (`ID_EQUIPAMENTO`),
  CONSTRAINT `FK_ID_EQUIPAMENTO` FOREIGN KEY (`ID_EQUIPAMENTO`) REFERENCES `TB_EQUIPAMENTOS` (`ID_EQUIPAMENTO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE TB_MOBILE (
  ID_MOBILE int(11) NOT NULL AUTO_INCREMENT,
  TIPO_MOBILE varchar(120) NOT NULL,
  ID_EQUIPAMENTO int(11) NOT NULL,
  PRIMARY KEY (`ID_MOBILE`),
  KEY `FK_ID_EQUIP_MOVEL_idx` (`ID_EQUIPAMENTO`),
  CONSTRAINT `FK_ID_EQUIP_MOVEL` FOREIGN KEY (`ID_EQUIPAMENTO`) REFERENCES `TB_EQUIPAMENTOS` (`ID_EQUIPAMENTO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE TB_PERIFERICO (
  ID_PERIFERICO int(11) NOT NULL AUTO_INCREMENT,
  TIPO_PERIFERICO varchar(120) NOT NULL,
  ID_EQUIPAMENTO int(11) NOT NULL,
  PRIMARY KEY (`ID_PERIFERICO`),
  KEY `FK_ID_EQUIPAMENTO_idx` (`ID_EQUIPAMENTO`),
  CONSTRAINT `FK_ID_EQUIP_PERI` FOREIGN KEY (`ID_EQUIPAMENTO`) REFERENCES `TB_EQUIPAMENTOS` (`ID_EQUIPAMENTO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE TB_MARCA
ADD ATIVO varchar(1) DEFAULT 'S' NOT NULL;

ALTER TABLE TB_EQUIPAMENTOS
ADD ATIVO varchar(1) DEFAULT 'S' NOT NULL;

CREATE TABLE TB_TIPO(
ID_TIPO INT(11) NOT NULL AUTO_INCREMENT,
IDENT_TIPO VARCHAR(1),
NOME VARCHAR(255),
PRIMARY KEY (ID_TIPO)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;   

ALTER TABLE TB_PERIFERICO MODIFY COLUMN TIPO_PERIFERICO INT (11) NOT NULL;

ALTER TABLE TB_COMPUTADOR MODIFY COLUMN TIPO_COMPUTADOR INT (11) NOT NULL;

ALTER TABLE TB_MOBILE MODIFY COLUMN TIPO_MOBILE INT(11) NOT NULL;

ALTER TABLE TB_PERIFERICO CHANGE TIPO_PERIFERICO ID_TIPO INT(11) NOT NULL;

ALTER TABLE TB_COMPUTADOR CHANGE TIPO_COMPUTADOR ID_TIPO INT(11) NOT NULL;

ALTER TABLE TB_MOBILE CHANGE TIPO_MOBILE ID_TIPO INT(11) NOT NULL;

ALTER TABLE TB_PERIFERICO
ADD CONSTRAINT fk_PerTip
FOREIGN KEY (ID_TIPO)
REFERENCES TB_TIPO(ID_TIPO);

ALTER TABLE TB_MOBILE
ADD CONSTRAINT fk_MobTip
FOREIGN KEY (ID_TIPO)
REFERENCES TB_TIPO(ID_TIPO);

ALTER TABLE TB_COMPUTADOR
ADD CONSTRAINT fk_ComTip
FOREIGN KEY (ID_TIPO)
REFERENCES TB_TIPO(ID_TIPO);


/**
 * NECESSARIO FAZER MANUTEN��O NA VIEW DEVIDO A MELHORA NA TABELA DE COMPUTADOR, MOBILE E PERIFERICO
 * QUALQUER COISA EU ALTERO... EDUARDO
 */
CREATE OR REPLACE VIEW VW_EQUIPAMENTOS AS
SELECT 
if(Id_Mobile is not null, 'Dispositivo Movel', 
  if(Id_Computador is not null, 'Computador', 'Periferico')
) as Tipo_Equipamento,
--
if(Id_Mobile is not null, Tipo_Mobile, 
  if(Id_Computador is not null, TIPO_COMPUTADOR, TIPO_PERIFERICO)
) as Sub_Tipo,
--
EQUIP.Id_Equipamento,
--
Id_Computador, Id_Periferico, Id_Mobile, N_Patrimonio, EQUIP.Data_Cadastro, Valor_Aquisicao, MAR.Nome, Modelo, 
EQUIP.Ativo, Observacao, Nome_Projeto
FROM 
TB_EQUIPAMENTOS as EQUIP
left join TB_COMPUTADOR as COMP on COMP.ID_EQUIPAMENTO = EQUIP.ID_EQUIPAMENTO
left join TB_PERIFERICO as PERIF on PERIF.ID_EQUIPAMENTO = EQUIP.ID_EQUIPAMENTO
left join TB_MOBILE AS MOB on MOB.ID_EQUIPAMENTO = EQUIP.ID_EQUIPAMENTO
inner join TB_MARCA as MAR on MAR.ID_MARCA = EQUIP.ID_MARCA
inner join TB_PROJETOS as PROJ on PROJ.ID_PROJETO = EQUIP.ID_PROJETO;


ALTER TABLE TB_TIPO
ADD STATUS tinyint(1) default 1 NOT NULL;
