package br.ages.crud.command;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.LivroBO;
import br.ages.crud.util.MensagemContantes;

public class RemoveLivroCommand implements Command {

	private String proximo;

	private LivroBO livroBO;

	@Override
	public String execute(HttpServletRequest request) {
		proximo = "main?acao=listUser";
		this.livroBO = new LivroBO();

		try {
			Integer idLivro = Integer.parseInt(request.getParameter("id_livro"));
			livroBO.removerLivro(idLivro);
			request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_REMOVE_USUARIO.replace("?", idLivro.toString()).concat("<br/>"));
			
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proximo;
	}

}
