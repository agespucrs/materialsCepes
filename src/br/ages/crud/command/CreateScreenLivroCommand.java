package br.ages.crud.command;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.AutorBO;
import br.ages.crud.bo.EditoraBO;
import br.ages.crud.bo.LivroBO;
import br.ages.crud.model.Autor;
import br.ages.crud.model.Editora;
import br.ages.crud.model.Livro;

public class CreateScreenLivroCommand implements Command {

	private String proxima;

	private LivroBO livroBO;
	private AutorBO autorBO;
	private EditoraBO editoraBO;

	public String execute(HttpServletRequest request) throws SQLException {

		livroBO = new LivroBO();
		autorBO = new AutorBO();
		editoraBO = new EditoraBO();
		
		try {
			// Verifica se abre tela edição ou adição de livro.
			String isEdit = request.getParameter("isEdit");
			if (isEdit != null && "sim".equals(isEdit)) {
				Integer idLivro = Integer.parseInt(request.getParameter("id_livro"));
				Livro livro = livroBO.consultarLivro(idLivro);
				request.setAttribute("livro", livro);
				proxima = "livro/alterLivro.jsp";
				
			} else {
				
				ArrayList<Autor> autores = (ArrayList<Autor>) autorBO.listarAutor();
				ArrayList<Editora> editoras = (ArrayList<Editora>) editoraBO.listarEditora();
				request.setAttribute("autores", autores);
				request.setAttribute("editoras", editoras);
				
				proxima = "livro/addLivro.jsp";
			
			}

		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}
}
