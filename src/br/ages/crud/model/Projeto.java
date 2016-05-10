package br.ages.crud.model;
import java.io.Serializable;
import java.util.Date;
import java.util.*;

public class Projeto {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private String programa;
	private String origem;
	private Date dataCadastro;
	//verificar atributo
	private int idCordenador;
	
	
	public Projeto() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id_projeto) {
		this.id = id_projeto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome_projeto) {
		this.nome = nome_projeto;
	}
	public String getPrograma() {
		return programa;
	}
	public void setPrograma(String programa) {
		this.programa = programa;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date data_cadastro) {
		this.dataCadastro = data_cadastro;
	}
	public int getIdCordenador() {
		return idCordenador;
	}
	public void setIdCordenador(int id_cordenador) {
		this.idCordenador = id_cordenador;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
