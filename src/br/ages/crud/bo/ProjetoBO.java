package br.ages.crud.bo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import br.ages.crud.dao.ProjetoDAO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Projeto;
import br.ages.crud.model.Usuario;
import br.ages.crud.model.UsuarioProjeto;

public class ProjetoBO {

	private ProjetoDAO dao;

	public ProjetoBO() {
		dao = new ProjetoDAO();
	}

	public Projeto buscarProjeto(Integer idProjeto) throws NegocioException, SQLException, ParseException {
		try {
			return dao.buscarProjeto(idProjeto);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}

	/**
	 * Método para salvar na projeto no BD.
	 * 
	 * @param projeto
	 * @throws NegocioException
	 * @throws SQLException
	 * @throws ParseException
	 */

	public void cadastraProjeto(Projeto projeto) throws NegocioException, SQLException, ParseException {

		try {
			dao.cadastrarProjeto(projeto);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}

	/**
	 * Método para consultar todos os projetos.
	 * 
	 * @return
	 * @throws NegocioException
	 * @throws SQLException
	 * @throws ParseException
	 */

	public List<Projeto> listarProjetos() throws NegocioException, SQLException, ParseException {

		try {
			return dao.listarProjetos();
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

	}

	public boolean removerProjeto(int id_projeto) throws NegocioException, SQLException {
		try {
			return dao.removerProjeto(id_projeto);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}

	public List<UsuarioProjeto> consultarUsuariosProjeto(Integer idProjeto) throws NegocioException, SQLException {
		try {
			return dao.consultarUsuariosProjeto(idProjeto);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}
	
	public void removerUsuariosProjeto (Integer idProjeto) throws NegocioException, SQLException {
		try {
			dao.removerUsuariosProjeto(idProjeto);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}
	
	public void inserirUsuarioProjeto(UsuarioProjeto usuarioProjeto) throws NegocioException, SQLException{
		try {
			dao.inserirUsuarioProjeto(usuarioProjeto);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}

}
