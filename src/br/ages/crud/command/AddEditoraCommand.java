package br.ages.crud.command;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.EditoraBO;
import br.ages.crud.model.Editora;
import br.ages.crud.util.MensagemContantes;

public class AddEditoraCommand implements Command {


	private String proxima;

	private EditoraBO editoraBO;

	@Override
	public String execute(HttpServletRequest request) {
		editoraBO = new EditoraBO();
		proxima = "addEditora.jsp";

		String nome = request.getParameter("nome");
		
		try {
			Editora editora = new Editora();
			editora.setNome(nome);
			
			editoraBO.cadastraEditora(editora);
			proxima = "main?acao=listEditora";
			request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_CADASTRO_EDITORA.replace("?", editora.getNome()));

		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}
}
