package br.ages.crud.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.dao.AutorDAO;

public class CreateScreenAutorCommand implements Command {

	private String proxima;

	private AutorDAO cadastroDao;

	public String execute(HttpServletRequest request) throws SQLException {

		cadastroDao = new AutorDAO();
		
		// Verifica se abre tela edição de autor ou de adição de autor.
		String isEdit = request.getParameter("isEdit");
		if (isEdit != null && !"".equals(isEdit)) {
			proxima = "autor/editAutor.jsp";
		} else {
			proxima = "autor/addAutor.jsp";
		}
		try {


		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}
}
