package br.ages.crud.bo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import br.ages.crud.dao.PerifericoDAO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Periferico;

public class PerifericoBO {
	PerifericoDAO perifericoDAO = null;
	
	public PerifericoBO() {
		perifericoDAO = new PerifericoDAO();
	}
	
	public boolean cadastraPeriferico(Periferico periferico) throws NegocioException, SQLException, ParseException {
		try {
			return perifericoDAO.cadastrarPeriferico(periferico);
		} catch (Exception e) {
			throw new NegocioException(e);
		}
	}
	
	public List<Periferico> listarPeriferico() throws NegocioException {
		List<Periferico> listPeriferico = null;
		try {
			listPeriferico = perifericoDAO.listarPerifericos();
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
		return listPeriferico;
	}
	
	public void alterarPeriferico(Periferico periferico) throws NegocioException, SQLException, ParseException {
		try {
			perifericoDAO.alterarPeriferico(periferico);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}
}
