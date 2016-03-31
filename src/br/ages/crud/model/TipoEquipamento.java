package br.ages.crud.model;

public enum TipoEquipamento {
    COMPUTADOR("c"),
    PERIFERICO("p"),
    DISPOSITIVO_MOVEL("m");
	
    private String valor;

    TipoEquipamento(String valor) {
        this.valor = valor;
    }

    public String valor() {
        return valor;
    }
}
