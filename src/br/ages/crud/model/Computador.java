package br.ages.crud.model;

public class Computador extends Equipamento {
	int tipoComputador;
	int numeroPatrimonio;

	public int getTipoComputador() {
		return tipoComputador;
	}

	public void setTipoComputador(int tipoComputador2) {
		this.tipoComputador = tipoComputador2;
	}
	
	public int getNumeroPatrimonio() {
		return numeroPatrimonio;
	}
	
	public void setNumeroPatrimonio(int numeroPatrimonio) {
		this.numeroPatrimonio = numeroPatrimonio;
	}
}
