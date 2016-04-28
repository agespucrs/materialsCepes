package br.ages.crud.model;

public enum TipoEquipamento {
    COMPUTADOR("C"),
    PERIFERICO("P"),
    DISPOSITIVO_MOVEL("P");
	
    private String valor;

    TipoEquipamento(String valor) {
        this.valor = valor;
    }

    public String valor() {
        return valor;
    }
}
