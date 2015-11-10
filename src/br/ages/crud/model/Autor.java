package br.ages.crud.model;
import java.io.Serializable;

public class Autor {
	
	private static final long serialVersionUID = 1L;
	
	private int id_autor;
	private String nome;
	private String sobrenome;
	
	public int getId_autor() {
		return id_autor;
	}
	
	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Autor()
	{
		
	}
	
	public Autor(int id_autor, String nome, String sobrenome) {
		super();
		this.id_autor = id_autor;
		this.nome = nome;
		this.sobrenome = sobrenome;
	}
	
	
	
}
