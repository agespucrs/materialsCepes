package br.ages.crud.model;

import java.io.Serializable;
import java.util.Date;
import java.util.*;

public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idLivro;
	private String titulo;
	private String subtitulo;
	private Date dataCadastro;
	private long preco;
	private Editora editora;
	private List<Autor> autores;
	private Integer lingua;
	private String codigoISBN;
	private int edicao;
	private int ano;
	private int paginas;
	private boolean video;
	private boolean cdDvd;
	private boolean eBook;
	private String descricao;
	private boolean brochura;
	private int idCopia;
	private boolean revista;
	private boolean expiral;
	private boolean dura;
	private boolean excluido; // determinar se livro esta ativo/exluido

	public boolean isExcluido() {
		return excluido;
	}

	public void setExcluido(boolean excluido) {
		this.excluido = excluido;
	}

	public Livro() {
		excluido = false;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public int getIdCopia() {
		return idCopia;
	}

	public void setIdCopia(int idCopia) {
		this.idCopia = idCopia;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean getBrochura() {
		return brochura;
	}

	public void setBrochura(boolean brochura) {
		this.brochura = brochura;
	}

	public boolean getRevista() {
		return revista;
	}

	public void setRevista(boolean revista) {
		this.revista = revista;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public long getPreco() {
		return preco;
	}

	public void setPreco(long preco) {
		this.preco = preco;
	}

	public String getCodigoISBN() {
		return codigoISBN;
	}

	public void setCodigoISBN(String codigoISBN) {
		this.codigoISBN = codigoISBN;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public boolean isVideo() {
		return video;
	}

	public void setVideo(boolean video) {
		this.video = video;
	}

	public boolean isCdDvd() {
		return cdDvd;
	}

	public void setCdDvd(boolean cdDvd) {
		this.cdDvd = cdDvd;
	}

	public boolean iseBook() {
		return eBook;
	}

	public void seteBook(boolean eBook) {
		this.eBook = eBook;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Integer getLingua() {
		return lingua;
	}

	public void setLingua(Integer lingua) {
		this.lingua = lingua;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public void setStatus(boolean excluido) {
		
	}	

	public boolean isExpiral() {
		return expiral;
	}

	public void setExpiral(boolean expiral) {
		this.expiral = expiral;
	}

	public boolean isDura() {
		return dura;
	}

	public void setDura(boolean dura) {
		this.dura = dura;
	}

	public boolean getStatus() {
		return excluido;
	}
}
