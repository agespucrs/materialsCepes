package br.ages.crud.bo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import br.ages.crud.dao.ComputadorDAO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Computador;

public class ComputadorBO {
	ComputadorDAO computadorDAO = null;
	
	public ComputadorBO() {
		computadorDAO = new ComputadorDAO();
	}
	
	public boolean cadastraComputador(Computador computador) throws NegocioException, SQLException, ParseException {
		try {
			return computadorDAO.cadastrarComputador(computador);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}
	
	public List<Computador> listarComputador() throws NegocioException {
		List<Computador> listComputador = null;
		try {
			listComputador = computadorDAO.listarComputadores();
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
		return listComputador;
	}
	
	public void alterarComputador(Computador computador) throws NegocioException, SQLException, ParseException {
		try {
			computadorDAO.alterarComputador(computador);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}
}
