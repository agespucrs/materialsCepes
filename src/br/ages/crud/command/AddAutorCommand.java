package br.ages.crud.command;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.AutorBO;
import br.ages.crud.model.Autor;
import br.ages.crud.util.MensagemContantes;

public class AddAutorCommand implements Command {


	private String proxima;

	private AutorBO autorBO;

	@Override
	public String execute(HttpServletRequest request) {
		
		autorBO = new AutorBO();
		proxima = "addAutor.jsp";

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		
		try {
			Autor autor = new Autor();
			autor.setNome(nome);
			autor.setSobrenome(sobrenome);
			
			autorBO.cadastraAutor(autor);
			proxima = "main?acao=listAutor";
			request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_CADASTRO_AUTOR.replace("?", autor.getNome()));

		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}
}
