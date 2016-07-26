package br.ages.crud.model;

public class Acessorio extends Equipamento {
	int tipoAcessorio;
	int quantidade;
	
	public int getTipoAcessorio() {
		return tipoAcessorio;
	}
	
	public void setTipoAcessorio(int tipoAcessorio) {
		this.tipoAcessorio = tipoAcessorio;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
