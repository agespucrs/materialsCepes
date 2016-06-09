package br.ages.crud.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import br.ages.crud.bo.FuncaoBO;
import br.ages.crud.bo.UsuarioBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.model.Funcao;
import br.ages.crud.model.Usuario;

public class CreateScreenUserCommand implements Command {

	private String proxima;

	private UsuarioBO usuarioBO;

	public String execute(HttpServletRequest request) throws SQLException, NegocioException, ParseException {

		usuarioBO = new UsuarioBO();

		List<Funcao> funcoes = new FuncaoBO().listarFuncoes();
		request.setAttribute("funcoes", funcoes);

		// Verifica se abre tela edição de pessoa ou de adição de pessoa.
		String isEdit = request.getParameter("isEdit");
		if (isEdit != null && "sim".equals(isEdit)) {

			Usuario usuario = usuarioBO.consultarUsuario(request.getParameter("id_usuario"));

			request.setAttribute("usuario", usuario);

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
