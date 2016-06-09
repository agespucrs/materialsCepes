package br.ages.crud.command;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.UsuarioBO;
import br.ages.crud.model.Usuario;
import br.ages.crud.util.MensagemContantes;

public class AlterUserCommand implements Command {


	private String proxima;

	private UsuarioBO usuarioBO;

	@Override
	public String execute(HttpServletRequest request) {
		this.usuarioBO = new UsuarioBO();
		this.proxima = "user/alterUser.jsp";

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String matricula = request.getParameter("matricula");
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		Integer funcao = Integer.parseInt(request.getParameter("tipo"));
		Integer administrador = Integer.parseInt(request.getParameter("adm"));
		Integer idUsuario = Integer.parseInt(request.getParameter("id_usuario"));
		
		try {
			Usuario user = new Usuario();
			user.setNome(nome);
			user.setEmail(email);
			user.setMatricula(matricula);
			user.setUsuario(usuario);
			user.setSenha(senha);
			user.setIdUsuario(idUsuario);
			user.setIdFuncao(funcao);
			user.setAdministrador(administrador);
			
			boolean isValido = usuarioBO.validaCadastroUsuarioA(user);
			if (!isValido) {
				request.setAttribute("msgErro", MensagemContantes.MSG_ERR_USUARIO_DADOS_INVALIDOS);
			} else { // alteracao de usuario com sucesso
				usuarioBO.alterarUsuario(user);
				proxima = "main?acao=listUser";
				request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_ALTERADO_USUARIO.replace("?", user.getNome()));

			}
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
			//proxima = "main?acao=addUser";
		}

		return proxima;
	}
}

