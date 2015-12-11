package br.ages.crud.command;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.AutorBO;
import br.ages.crud.model.Autor;
import br.ages.crud.util.MensagemContantes;

public class ConsultarAutorCommand implements Command {

	private String proximo;

	private AutorBO autorBO;

	@Override
	public String execute(HttpServletRequest request) {
		proximo = "autor/consultarAutor.jsp";
		this.autorBO = new AutorBO();

		try {
			Integer idAutor = Integer.parseInt(request.getParameter("id_autor"));
			Autor autor = autorBO.consultarAutor(idAutor);
			
			
			request.setAttribute("autor", autor);
			//request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_REMOVE_USUARIO.replace("?", idLivro.toString()).concat("<br/>"));
			
			
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proximo;
	}

}
