package br.ages.crud.bo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import br.ages.crud.dao.IdiomaDAO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Idioma;
import br.ages.crud.model.Marca;

public class IdiomaBO {
	private IdiomaDAO dao;

	public IdiomaBO() {
		dao = new IdiomaDAO();
	}

	public Idioma buscarPeloIdentificador(String identificador) throws NegocioException, SQLException, ParseException {

		try {
			return dao.buscarPeloIdentificador(identificador);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}

	public Idioma buscar(Integer id) throws NegocioException, SQLException, ParseException {

		try {
			return dao.buscar(id);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}

	public List<Idioma> consultarIdiomas() throws NegocioException, SQLException, ParseException {

		try {
			return dao.consultarIdioma();
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

	}

}
