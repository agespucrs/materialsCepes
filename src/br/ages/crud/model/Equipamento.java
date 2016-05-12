package br.ages.crud.model;

import java.util.Date;

public class Equipamento {
	int id;
	int numeroPatrimonio;
	int status;
	String tipoEquipamento;
	//subTipo tem o valor TIPO_MOBILE, TIPO_COMPUTADOR, ou TIPO_PERIFERICO,
	//dependendo do tipoEquipamento
	String subTipo;
	int marca;
	String modelo;
	Double valor;
	Date dataCadastro;
	int projeto;
	String observacoes;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroPatrimonio() {
		return numeroPatrimonio;
	}
	
	public void setNumeroPatrimonio(int numeroPatrimonio) {
		this.numeroPatrimonio = numeroPatrimonio;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int i) {
		this.status = i;
	}
	
	public String getTipoEquipamento() {
		return tipoEquipamento;
	}
	
	public void setTipoEquipamento(String tipoEquipamento) {
		this.tipoEquipamento = tipoEquipamento;
	}
	
	public String getSubTipo() {
		return subTipo;
	}

	public void setSubTipo(String subTipo) {
		this.subTipo = subTipo;
	}
	
	public int getMarca() {
		return marca;
	}
	
	public void setMarca(int marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public int getProjeto() {
		return projeto;
	}
	
	public void setProjeto(int projeto) {
		this.projeto = projeto;
	}
	
	public String getObservacoes() {
		return observacoes;
	}
	
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
}
