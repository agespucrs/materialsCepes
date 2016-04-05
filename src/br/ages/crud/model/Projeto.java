package br.ages.crud.model;
import java.io.Serializable;
import java.util.Date;
import java.util.*;

public class Projeto {

	private static final long serialVersionUID = 1L;
	
	private int id_projeto;
	private String nome_projeto;
	private String programa;
	private String origem;
	//private date data_cadastro;
	//verificar atributo
	private List<Usuario> usuarios;
	
	
	public Projeto() {
		super();
	}
	public int getId_projeto() {
		return id_projeto;
	}
	public void setId_projeto(int id_projeto) {
		this.id_projeto = id_projeto;
	}
	public String getNome_projeto() {
		return nome_projeto;
	}
	public void setNome_projeto(String nome_projeto) {
		this.nome_projeto = nome_projeto;
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
	//public date getData_cadastro() {
	//	return data_cadastro;
	//}
	//public void setData_cadastro(Calendar data_cadastro) {
	//	this.data_cadastro = data_cadastro;
	//}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
