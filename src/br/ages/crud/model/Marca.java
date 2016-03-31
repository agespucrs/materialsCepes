package br.ages.crud.model;

import java.io.Serializable;

/**
 * @author 15280426
 *
 */
public class Marca implements Serializable {

	private static final long serialVersionUID = 8053834457275385394L;

	private int id;
	private String nome;

	public Marca() {

	}

	public Marca(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
