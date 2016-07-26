package br.ages.crud.command;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.AutorBO;
import br.ages.crud.bo.LivroBO;
import br.ages.crud.util.MensagemContantes;

public class RemoveAutorCommand implements Command {

	private String proximo;

	private AutorBO autorBO;

	@Override
	public String execute(HttpServletRequest request) {
		proximo = "main?acao=listAutor";
		this.autorBO = new AutorBO();

		try {
			Integer idAutor = Integer.parseInt(request.getParameter("id_autor"));
			autorBO.removerAutor(idAutor);
			
			request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_REMOVE_AUTOR.replace("?", idAutor.toString()).concat("<br/>"));
			
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proximo;
	}

}
