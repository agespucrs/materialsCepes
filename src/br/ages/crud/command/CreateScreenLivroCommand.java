package br.ages.crud.command;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.AutorBO;
import br.ages.crud.bo.EditoraBO;
import br.ages.crud.bo.IdiomaBO;
import br.ages.crud.bo.LivroBO;
import br.ages.crud.model.Autor;
import br.ages.crud.model.CopiaLivro;
import br.ages.crud.model.Editora;
import br.ages.crud.model.Idioma;
import br.ages.crud.model.Livro;

public class CreateScreenLivroCommand implements Command {

	private String proxima;

	private LivroBO livroBO;
	private AutorBO autorBO;
	private EditoraBO editoraBO;
	private IdiomaBO idiomaBO;

	public String execute(HttpServletRequest request) throws SQLException {

		livroBO = new LivroBO();
		autorBO = new AutorBO();
		editoraBO = new EditoraBO();
		idiomaBO = new IdiomaBO();
		try {
			// Verifica se abre tela edicao ou adicao de livro.
			ArrayList<Autor> autores = (ArrayList<Autor>) autorBO.listarAutor();
			ArrayList<Editora> editoras = (ArrayList<Editora>) editoraBO.listarEditora();
			ArrayList<Idioma> idiomas = (ArrayList<Idioma>) idiomaBO.consultarIdiomas();

			String isEdit = request.getParameter("isEdit");
			if (isEdit != null && "sim".equals(isEdit)) {
				Integer idLivro = Integer.parseInt(request.getParameter("id_livro"));
				Integer idCopia = Integer.parseInt(request.getParameter("id_copia"));
				Livro livro = livroBO.consultarLivro(idLivro);
				CopiaLivro copia = livroBO.buscarCopia(idCopia);
				request.setAttribute("livro", livro);
				request.setAttribute("copia", copia);
				request.setAttribute("autores", autores);
				request.setAttribute("editoras", editoras);
				request.setAttribute("idiomas", idiomas);
				proxima = "livro/alterLivro.jsp";

			} else {

				request.setAttribute("autores", autores);
				request.setAttribute("editoras", editoras);
				request.setAttribute("idiomas", idiomas);
				proxima = "livro/addLivro.jsp";

			}

		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}
}
