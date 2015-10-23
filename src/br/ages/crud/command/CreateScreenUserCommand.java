package br.ages.crud.command;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.dao.UsuarioDAO;
import br.ages.crud.model.Usuario;

public class CreateScreenUserCommand implements Command {

	private String proxima;

	private UsuarioDAO cadastroDao;

	public String execute(HttpServletRequest request) throws SQLException {

		cadastroDao = new UsuarioDAO();
		
		// Verifica se abre tela edição de pessoa ou de adição de pessoa.
		String isEdit = request.getParameter("isEdit");
		if (isEdit != null && "sim".equals(isEdit)) {
			proxima = "user/alterUser.jsp";

		} else {
			proxima = "user/registerUser.jsp";
		}
			
		try {

		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}
}
