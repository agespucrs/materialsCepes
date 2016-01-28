package br.ages.crud.command;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.EditoraBO;
import br.ages.crud.bo.UsuarioBO;
import br.ages.crud.model.Editora;
import br.ages.crud.model.Usuario;
import br.ages.crud.util.MensagemContantes;

public class AlterEditoraCommand implements Command {


	private String proxima;

	private EditoraBO editoraBO;

	@Override
	public String execute(HttpServletRequest request) {
		this.editoraBO = new EditoraBO();
		this.proxima = "editora/alterEditora.jsp";

		String nome = request.getParameter("nome");
		Integer idEditora = Integer.parseInt(request.getParameter("id_editora"));
		
		try {
			
			Editora editora = new Editora();
			editora.setNome(nome);
			editora.setIdEditora(idEditora);
			
			editoraBO.alterarEditora(editora);
			proxima = "main?acao=listEditora";
			request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_ALTERADO_USUARIO.replace("?", editora.getNome()));

			
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}
}
















