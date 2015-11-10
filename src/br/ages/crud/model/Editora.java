package br.ages.crud.model;
import java.io.Serializable;

public class Editora {
	
	private static final long serialVersionUID = 1L;
	
	private int idEditora;
	private String nome;
	public int getIdEditora() {
		return idEditora;
	}
	
	public void setIdEditora(int idEditora) {
		this.idEditora = idEditora;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Editora() {
	}	

}
