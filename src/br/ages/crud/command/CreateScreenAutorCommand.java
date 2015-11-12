package br.ages.crud.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.AutorBO;
import br.ages.crud.model.Autor;

public class CreateScreenAutorCommand implements Command {

	private String proxima;

	private AutorBO autorBO;

	public String execute(HttpServletRequest request) throws SQLException {

		autorBO = new AutorBO();
		
		try {
		// Verifica se abre tela edição de autor ou de adição de autor.
		String isEdit = request.getParameter("isEdit");
		if (isEdit != null && "sim".equals(isEdit)) {
			int autorId = Integer.parseInt(request.getParameter("autor_id"));
			
			// Criar funçao AutorDAO.consultarAutor(int autorId)
			 Autor autor = autorBO.consultarAutor(autorId);
			request.setAttribute("autor", autor);
			
			proxima = "autor/editAutor.jsp";
		} else {
			proxima = "autor/addAutor.jsp";
		}
		


		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}
}
