package br.ages.crud.command;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import br.ages.crud.bo.LivroBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Livro;

public class CopiaLivroCommand implements Command{

	public String proximo;
	
	@Override
	public String execute(HttpServletRequest request)
			throws SQLException, PersistenciaException, ParseException, NegocioException {
		// TODO Auto-generated method stub
		
		LivroBO lb = new LivroBO();
		List<Livro> livros = lb.listarLivro();
		request.setAttribute("listaLivros", livros);
		
		proximo = "livro/addCopiaLivro.jsp";
		
		return proximo;
	}
		
}