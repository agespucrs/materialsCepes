package br.ages.crud.bo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import br.ages.crud.dao.MarcaDAO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Marca;

/**
 * @author 15280426
 *
 */
public class MarcaBO {

	private MarcaDAO dao;

	public MarcaBO() {
		dao = new MarcaDAO();
	}

	/**
	 * Método para salvar na marca no BD.
	 * 
	 * @param marca
	 * @throws NegocioException
	 * @throws SQLException
	 * @throws ParseException
	 */
	public void cadastraMarca(Marca marca) throws NegocioException, SQLException, ParseException {

		try {
			dao.cadastrarMarca(marca);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

	}

	/**
	 * Método para consultar todas as marcas.
	 * 
	 * @return
	 * @throws NegocioException
	 * @throws SQLException
	 * @throws ParseException
	 */
	public List<Marca> consultarMarcas() throws NegocioException, SQLException, ParseException {

		try {
			return dao.consultarMarcas();
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

	}

	/**
	 * Método para remover uma marca pelo ID.
	 * 
	 * @param id
	 * @return
	 * @throws NegocioException
	 * @throws SQLException
	 */
	public boolean removerMarca(int id) throws NegocioException, SQLException {
		try {
			return dao.removerMarca(id);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}

	/**
	 * Método para alterar uma marca.
	 * 
	 * @param id
	 * @param nome
	 * @return
	 * @throws NegocioException
	 * @throws SQLException
	 * @throws ParseException
	 */
	public boolean alterarMarca(int id, String nome) throws NegocioException, SQLException, ParseException {
		try {
			return dao.alterarMarca(id, nome);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}
}
