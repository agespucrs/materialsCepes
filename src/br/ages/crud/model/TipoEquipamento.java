package br.ages.crud.model;

public enum TipoEquipamento {
    COMPUTADOR("C"),
    PERIFERICO("P"),
    DISPOSITIVO_MOVEL("M");
	
    private String valor;

    TipoEquipamento(String valor) {
        this.valor = valor;
    }

    public String valor() {
        return valor;
    }
}
