package br.ages.crud.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.LivroBO;
import br.ages.crud.model.Livro;

public class CreateScreenLivroCommand implements Command {

	private String proxima;

	private LivroBO livroBO;

	public String execute(HttpServletRequest request) throws SQLException {

		livroBO = new LivroBO();
		
		try {
			// Verifica se abre tela edição ou adição de livro.
			String isEdit = request.getParameter("isEdit");
			if (isEdit != null && "sim".equals(isEdit)) {
				int livroId = Integer.parseInt(request.getParameter("livro_id"));
				
				Livro livro= livroBO.consultarLivro(livroId);
				request.setAttribute("livro", livro);
				
				proxima = "livro/editLivro.jsp";
				
			} else {
				
				proxima = "livro/addLivro.jsp";
			
			}

		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}
}
