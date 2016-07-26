package br.ages.crud.model;

import java.io.Serializable;

public class Tipo implements Serializable{
	private static final long serialVersionUID = -8923605889983302676L;
	
	private Integer id;
	private String nome;
	private String tipoEquipamento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoEquipamento() {
		return tipoEquipamento;
	}

	public void setTipoEquipamento(String tipoEquipamento) {
		this.tipoEquipamento = tipoEquipamento;
	}
}
