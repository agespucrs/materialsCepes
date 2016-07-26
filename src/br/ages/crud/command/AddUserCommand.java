package br.ages.crud.command;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.UsuarioBO;
import br.ages.crud.model.Usuario;
import br.ages.crud.util.MensagemContantes;

public class AddUserCommand implements Command {


	private String proxima;

	private UsuarioBO usuarioBO;

	@Override
	public String execute(HttpServletRequest request) {
		usuarioBO = new UsuarioBO();
		proxima = "user/registerUser.jsp";

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String matricula = request.getParameter("matricula");
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		Integer administrador = Integer.parseInt(request.getParameter("adm"));
		Integer funcao = Integer.parseInt(request.getParameter("tipo"));
		String cpf = request.getParameter("cpf");
		
		Date dataCadastro = new Date();
	

		try {
			Usuario user = new Usuario();
			user.setNome(nome);
			user.setEmail(email);
			user.setMatricula(matricula);
			user.setUsuario(usuario);
			user.setSenha(senha);
			user.setAdministrador(administrador);
			user.setIdFuncao(funcao);
			user.setDataCadastro(dataCadastro);
			user.setCpf(cpf);
			
			boolean isValido = usuarioBO.validaCadastroUsuarioA(user);
			if (!isValido) {
				request.setAttribute("msgErro", MensagemContantes.MSG_ERR_USUARIO_DADOS_INVALIDOS);
			} else { // cadastro de pessoa com sucesso
				usuarioBO.cadastraUsuario(user);
				proxima = "main?acao=listUser";
				request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_CADASTRO_USUARIO.replace("?", user.getNome()));

			}
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
			//proxima = "main?acao=addUser";
		}

		return proxima;
	}
}
