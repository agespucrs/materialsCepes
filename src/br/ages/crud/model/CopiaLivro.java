package br.ages.crud.model;

public class CopiaLivro {
	private int idCopiaLivro;
	private int idLivro;
	private String codigo_isbn;

	public int getIdCopiaLivro() {
		return idCopiaLivro;
	}

	public void setIdCopiaLivro(int idCopiaLivro) {
		this.idCopiaLivro = idCopiaLivro;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public String getCodigo_isbn() {
		return codigo_isbn;
	}

	public void setCodigo_isbn(String codigo_isbn) {
		this.codigo_isbn = codigo_isbn;
	}

}
