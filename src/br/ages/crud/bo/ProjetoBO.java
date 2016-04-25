package br.ages.crud.bo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import br.ages.crud.dao.ProjetoDAO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Projeto;

public class ProjetoBO {
	
	private ProjetoDAO dao;
	
	public ProjetoBO(){
		dao = new ProjetoDAO();		
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

}
