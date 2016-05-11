package br.ages.crud.model;

import java.io.Serializable;
import java.util.Date;
import java.util.*;

public class Projeto {

	private static final long serialVersionUID = 1L;

	private int id;
	private String nomeProjeto;
	private String programa;
	private String origem;
	private Date dataCadastro;
	// verificar atributo
	private int idCordenador;

	public Projeto(){
		
	}
	
	public Projeto(String nomeProjeto, String programa, String origem, Date dataCadastro, int idCordenador) {
		this.nomeProjeto = nomeProjeto;
		this.programa = programa;
		this.origem = origem;
		this.dataCadastro = dataCadastro;
		this.idCordenador = idCordenador;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeProjeto() {
		return nomeProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public int getIdCordenador() {
		return idCordenador;
	}

	public void setIdCordenador(int idCordenador) {
		this.idCordenador = idCordenador;
	}

}
