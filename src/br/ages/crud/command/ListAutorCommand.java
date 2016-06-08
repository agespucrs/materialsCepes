package br.ages.crud.command;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.AutorBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.model.Autor;
import br.ages.crud.model.Livro;

public class ListAutorCommand implements Command {

	private String proxima;
	private AutorBO autorBO;
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		this.autorBO = new AutorBO();
		proxima = "autor/listAutor.jsp";
		String idLivroString = request.getParameter("id_livro");
		
		try {
			List<Autor> listaAutores = autorBO.listarTodosAutor();
			request.setAttribute("listaAutores", listaAutores);
			
			int idLivro = Integer.parseInt(idLivroString);
			Livro livro = new Livro();
			livro.setIdLivro(idLivro);
			
			List<Autor> listaAutoresLivro = autorBO.listarAutorLivro(livro);
			request.setAttribute("listaAutoresLivro", listaAutoresLivro);
		} catch (NegocioException e) {
			e.printStackTrace();
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}

}
