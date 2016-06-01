package br.ages.crud.model;

public class Periferico extends Equipamento {
	int tipoPeriferico;
	int numeroPatrimonio;

	public int getTipoPeriferico() {
		return tipoPeriferico;
	}

	public void setTipoPeriferico(int tipoPeriferico2) {
		this.tipoPeriferico = tipoPeriferico2;
	}
	
	public int getNumeroPatrimonio() {
		return numeroPatrimonio;
	}
	
	public void setNumeroPatrimonio(int numeroPatrimonio) {
		this.numeroPatrimonio = numeroPatrimonio;
	}
}
