package br.ages.crud.command;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.LivroBO;
import br.ages.crud.bo.UsuarioBO;
import br.ages.crud.model.Livro;
import br.ages.crud.model.Usuario;
import br.ages.crud.util.MensagemContantes;

public class ConsultarUserCommand implements Command {

	private String proximo;

	private UsuarioBO usuarioBO;

	@Override
	public String execute(HttpServletRequest request) {
		proximo = "user/consultarUsuario.jsp";
		this.usuarioBO = new UsuarioBO();

		try {
			
			String idUsuario = request.getParameter("id_usuario");
			Usuario usuario = usuarioBO.consultarUsuario(idUsuario);
						
			request.setAttribute("usuario", usuario);
			
			request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_REMOVE_USUARIO.replace("?", idUsuario.toString()).concat("<br/>"));
			
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proximo;
	}

}
