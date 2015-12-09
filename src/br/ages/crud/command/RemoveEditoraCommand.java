package br.ages.crud.command;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.EditoraBO;
import br.ages.crud.util.MensagemContantes;

public class RemoveEditoraCommand implements Command {

	private String proximo;

	private EditoraBO editoraBO;

	@Override
	public String execute(HttpServletRequest request) {
		proximo = "main?acao=listEditora";
		this.editoraBO = new EditoraBO();

		try {
			Integer idEditora = Integer.parseInt(request.getParameter("id_editora"));
			editoraBO.removerEditora(idEditora);
			request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_REMOVE_EDITORA.replace("?", idEditora.toString()).concat("<br/>"));
			
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proximo;
	}

}
