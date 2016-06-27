package br.ages.crud.model;

import java.util.Date;

public class UsuarioProjeto {

	private Integer idUsuario;
	private String nomeUsuario;
	private Integer idProjeto;
	private Date dataAlocacao;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdProjeto() {
		return idProjeto;
	}

	public void setIdProjeto(Integer idProjeto) {
		this.idProjeto = idProjeto;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public Date getDataAlocacao() {
		return dataAlocacao;
	}

	public void setDataAlocacao(Date dataAlocacao) {
		this.dataAlocacao = dataAlocacao;
	}

}
