package br.ages.crud.bo;

import java.sql.SQLException;
import java.util.List;

import br.ages.crud.dao.FuncaoDAO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Funcao;

public class FuncaoBO {

	private FuncaoDAO dao;

	public FuncaoBO() {
		dao = new FuncaoDAO();
	}

	/**
	 * Método que retorna todas as possíveis funções de um usuário.
	 * 
	 * @return
	 * @throws NegocioException
	 */
	public List<Funcao> listarFuncoes() throws NegocioException {

		List<Funcao> funcoes = null;

		try {
			funcoes = dao.listarFuncoes();
		} catch (PersistenciaException | SQLException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

		return funcoes;

	}
}
