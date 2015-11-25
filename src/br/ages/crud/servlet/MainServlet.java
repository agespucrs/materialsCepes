package br.ages.crud.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ages.crud.command.AddLivroCommand;
import br.ages.crud.command.AddUserCommand;
import br.ages.crud.command.AlterUserCommand;
import br.ages.crud.command.Command;
import br.ages.crud.command.ConsultarLivroCommand;
import br.ages.crud.command.CreateScreenAutorCommand;
import br.ages.crud.command.CreateScreenEditoraCommand;
import br.ages.crud.command.CreateScreenLivroCommand;
import br.ages.crud.command.CreateScreenUserCommand;
import br.ages.crud.command.ListEditoraCommand;
import br.ages.crud.command.ListLivroCommand;
import br.ages.crud.command.ListUserCommand;
import br.ages.crud.command.LoginCommand;
import br.ages.crud.command.LogoutCommand;
import br.ages.crud.command.RemoveAutorCommand;
import br.ages.crud.command.RemoveEditoraCommand;
import br.ages.crud.command.RemoveLivroCommand;
import br.ages.crud.command.RemoveUserCommand;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Map<String, Command> comandos = new HashMap<String, Command>();

	@Override
	public void init() throws ServletException {
		
		// USUARIO
		comandos.put("login", new LoginCommand());
		comandos.put("logout", new LogoutCommand());
		comandos.put("telaUser", new CreateScreenUserCommand());		
		comandos.put("registerUser", new AddUserCommand());
		comandos.put("removerUsuario", new RemoveUserCommand());
		comandos.put("listUser", new ListUserCommand());
		comandos.put("alterUser", new AlterUserCommand());
		
		// EDITORA
		comandos.put("addEditora", new ListEditoraCommand());
		comandos.put("listEditora", new ListEditoraCommand());
		comandos.put("removerEditora", new RemoveEditoraCommand());
		comandos.put("telaEditora", new CreateScreenEditoraCommand());
		
		// AUTOR
		comandos.put("addAutor", new ListEditoraCommand());
		comandos.put("listAutor", new ListEditoraCommand());
		comandos.put("removerAutor", new RemoveAutorCommand());
		comandos.put("telaAutor", new CreateScreenAutorCommand());
		
		// LIVRO
		comandos.put("addLivro", new AddLivroCommand());
		comandos.put("listLivro", new ListLivroCommand());
		comandos.put("removerLivro", new RemoveLivroCommand());
		comandos.put("telaLivro", new CreateScreenLivroCommand());
		comandos.put("consultarLivro", new ConsultarLivroCommand());
		comandos.put("alterarLivro", new CreateScreenLivroCommand());
		
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String proxima = null;

		try {
			Command comando = verificarComando(acao);
			proxima = comando.execute(request);
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}
		request.getRequestDispatcher(proxima).forward(request, reponse);
		
	}

	private Command verificarComando(String acao) {
		Command comando = null;
		for (String key : comandos.keySet()) {
			if (key.equalsIgnoreCase(acao)) {
				comando = comandos.get(key);
			}
		}
		return comando;
	}
}

