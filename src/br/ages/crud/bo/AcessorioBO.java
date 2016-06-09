package br.ages.crud.bo;

import java.sql.SQLException;
import java.text.ParseException;

import br.ages.crud.dao.AcessorioDAO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.model.Acessorio;

public class AcessorioBO {
	AcessorioDAO acessorioDAO = null;
	
	public AcessorioBO() {
		acessorioDAO = new AcessorioDAO();
	}
	
	public boolean cadastraAcessorio(Acessorio acessorio) throws NegocioException, SQLException, ParseException {
		try {
			return acessorioDAO.cadastrarAcessorio(acessorio);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}
}
