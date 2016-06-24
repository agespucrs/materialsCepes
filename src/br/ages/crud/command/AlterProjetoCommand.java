package br.ages.crud.command;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;

public class AlterProjetoCommand implements Command{

	private String proximo;
	
	@Override
	public String execute(HttpServletRequest request)
			throws SQLException, PersistenciaException, ParseException, NegocioException {
		
		
		return proximo;
	}

}
