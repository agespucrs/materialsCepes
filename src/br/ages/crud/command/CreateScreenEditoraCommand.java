package br.ages.crud.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.dao.EditoraDAO;

public class CreateScreenEditoraCommand implements Command {

	private String proxima;

	private EditoraDAO cadastroDao;

	public String execute(HttpServletRequest request) throws SQLException {

		cadastroDao = new EditoraDAO();
		
		// Verifica se abre tela edição de editora ou de adição de editora.
		String isEdit = request.getParameter("isEdit");
		if (isEdit != null && !"".equals(isEdit)) {
			proxima = "editora/editEditora.jsp";
		} else {
			proxima = "editora/addEditora.jsp";
		}
		try {


		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}
}
