package br.ages.crud.bo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import br.ages.crud.dao.TipoDAO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Tipo;
import br.ages.crud.model.TipoEquipamento;

public class TipoBO {

	private TipoDAO dao;

	public TipoBO() {
		dao = new TipoDAO();
	}

	public List<Tipo> consultarPeloTipo(TipoEquipamento tipo) throws NegocioException, SQLException, ParseException {
		try {
			return dao.consultarPeloTipo(tipo);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}

}
