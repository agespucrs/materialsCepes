package br.ages.crud.command;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.AutorBO;
import br.ages.crud.bo.EditoraBO;
import br.ages.crud.bo.UsuarioBO;
import br.ages.crud.model.Autor;
import br.ages.crud.model.Editora;
import br.ages.crud.model.Usuario;
import br.ages.crud.util.MensagemContantes;

public class AlterAutorCommand implements Command {


	private String proxima;

	private AutorBO autorBO;

	@Override
	public String execute(HttpServletRequest request) {
		this.autorBO = new AutorBO();
		this.proxima = "autor/alterAutor.jsp";

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		Integer idAutor = Integer.parseInt(request.getParameter("id_autor"));
		
		try {
			
			Autor autor = new Autor();
			autor.setNome(nome);
			autor.setSobrenome(sobrenome);
			autor.setId_autor(idAutor);
			
			autorBO.alterarAutor(autor);
			proxima = "main?acao=listAutor";
			request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_ALTERADO_USUARIO.replace("?", autor.getNome()));

			
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
			//proxima = "main?acao=addUser";
		}

		return proxima;
	}
}
















