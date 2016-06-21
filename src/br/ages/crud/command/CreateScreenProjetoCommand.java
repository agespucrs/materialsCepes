package br.ages.crud.command;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.UsuarioBO;
import br.ages.crud.exception.NegocioException;

public class CreateScreenProjetoCommand implements Command {

	public String execute(HttpServletRequest request) throws SQLException, NegocioException, ParseException {
		
		UsuarioBO usuarioBO = new UsuarioBO();
		request.setAttribute("listaCoordenadores", usuarioBO.consultarCoordenadores());
		return "projeto/addProjeto.jsp";
	}

}
