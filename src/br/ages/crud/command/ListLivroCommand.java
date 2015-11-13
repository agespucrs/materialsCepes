package br.ages.crud.command;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.LivroBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.model.Livro;

public class ListLivroCommand implements Command {

	private String proxima;
	private LivroBO livroBO;
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException, ParseException {
		this.livroBO = new LivroBO();
		proxima = "livro/listLivro.jsp";

		try {
			List<Livro> listaLivros = livroBO.listarLivro();
			request.setAttribute("listaLivros", listaLivros);
		} catch (NegocioException e) {
			e.printStackTrace();
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}

}