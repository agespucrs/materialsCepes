package br.ages.crud.bo;

import java.sql.SQLException;
import java.text.ParseException;

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
}
