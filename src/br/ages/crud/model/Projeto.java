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
	private Integer idCoordenador;
	private String nomeCoordenador;
	private List<Usuario> usuarios;

	public Projeto() {

	}

	public Projeto(String nomeProjeto, String programa, String origem, Date dataCadastro, int idCordenador) {
		this.nomeProjeto = nomeProjeto;
		this.programa = programa;
		this.origem = origem;
		this.dataCadastro = dataCadastro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getIdCoordenador() {
		return idCoordenador;
	}

	public void setIdCoordenador(Integer idCoordenador) {
		this.idCoordenador = idCoordenador;
	}

	public String getNomeCoordenador() {
		return nomeCoordenador;
	}

	public void setNomeCoordenador(String nomeCoordenador) {
		this.nomeCoordenador = nomeCoordenador;
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

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
