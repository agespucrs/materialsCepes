package br.ages.crud.model;

import java.io.Serializable;

public class Funcao implements Serializable {

	private static final long serialVersionUID = 8559683778560988017L;

	private Integer id;
	private String nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
