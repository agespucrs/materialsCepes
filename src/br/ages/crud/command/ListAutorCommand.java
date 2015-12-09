package br.ages.crud.command;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.AutorBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.model.Autor;

public class ListAutorCommand implements Command {

	private String proxima;
	private AutorBO autorBO;
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		this.autorBO = new AutorBO();
		proxima = "autor/listAutor.jsp";

		try {
			List<Autor> listaAutores = autorBO.listarAutor();
			request.setAttribute("listaAutores", listaAutores);
		} catch (NegocioException e) {
			e.printStackTrace();
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}

}
