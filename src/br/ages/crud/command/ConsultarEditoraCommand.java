package br.ages.crud.command;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.EditoraBO;
import br.ages.crud.model.Editora;
import br.ages.crud.util.MensagemContantes;

public class ConsultarEditoraCommand implements Command {

	private String proximo;

	private EditoraBO editoraBO;

	@Override
	public String execute(HttpServletRequest request) {
		proximo = "editora/consultarEditora.jsp";
		this.editoraBO = new EditoraBO();

		try {
			Integer idEditora = Integer.parseInt(request.getParameter("id_editora"));
			Editora editora = editoraBO.consultarEditora(idEditora);
			
			
			request.setAttribute("editora", editora);
			//request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_REMOVE_USUARIO.replace("?", idLivro.toString()).concat("<br/>"));
			
			
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proximo;
	}

}
