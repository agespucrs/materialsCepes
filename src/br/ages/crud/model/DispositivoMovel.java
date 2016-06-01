package br.ages.crud.model;

public class DispositivoMovel extends Equipamento {
	int tipoDispositivoMovel;
	int numeroPatrimonio;

	public int getTipoDispositivoMovel() {
		return tipoDispositivoMovel;
	}
	
	public void setTipoDispositivoMovel(int tipoDisposMovel) {
		this.tipoDispositivoMovel = tipoDisposMovel;
	}
	
	public int getNumeroPatrimonio() {
		return numeroPatrimonio;
	}
	
	public void setNumeroPatrimonio(int numeroPatrimonio) {
		this.numeroPatrimonio = numeroPatrimonio;
	}
}
