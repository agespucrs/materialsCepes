package br.ages.crud.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import br.ages.crud.command.AddAutorCommand;
import br.ages.crud.command.AddMarcaCommand;
import br.ages.crud.command.AddEditoraCommand;
import br.ages.crud.command.AddEquipamentoCommand;
import br.ages.crud.command.AddLivroCommand;
import br.ages.crud.command.AddUserCommand;
import br.ages.crud.command.AlterAutorCommand;
import br.ages.crud.command.AlterEditoraCommand;
import br.ages.crud.command.AlterLivroCommand;
import br.ages.crud.command.AlterUserCommand;
import br.ages.crud.command.Command;
import br.ages.crud.command.ConsultarAutorCommand;
import br.ages.crud.command.ConsultarEditoraCommand;
import br.ages.crud.command.ConsultarLivroCommand;
import br.ages.crud.command.ConsultarUserCommand;
import br.ages.crud.command.CreateScreenAutorCommand;
import br.ages.crud.command.CreateScreenEquipamentoCommand;
import br.ages.crud.command.CreateScreenEditoraCommand;
import br.ages.crud.command.CreateScreenLivroCommand;
import br.ages.crud.command.CreateScreenUserCommand;
import br.ages.crud.command.ListAutorCommand;
import br.ages.crud.command.ListEditoraCommand;
import br.ages.crud.command.ListEquipamentoCommand;
import br.ages.crud.command.ListLivroCommand;
import br.ages.crud.command.ListUserCommand;
import br.ages.crud.command.LoginCommand;
import br.ages.crud.command.LoginCommandNovo;
import br.ages.crud.command.LogoutCommand;
import br.ages.crud.command.RemoveAutorCommand;
import br.ages.crud.command.RemoveEditoraCommand;
import br.ages.crud.command.RemoveLivroCommand;
import br.ages.crud.command.RemoveMarcaCommand;
import br.ages.crud.command.RemoveUserCommand;
import br.ages.crud.util.LogParametrosSession;

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
		comandos.put("removerUser", new RemoveUserCommand());
		comandos.put("consultarUser", new ConsultarUserCommand());
		comandos.put("listUser", new ListUserCommand());
		comandos.put("alterUser", new AlterUserCommand());

		// EDITORA
		comandos.put("addEditora", new AddEditoraCommand());
		comandos.put("listEditora", new ListEditoraCommand());
		comandos.put("removerEditora", new RemoveEditoraCommand());
		comandos.put("consultarEditora", new ConsultarEditoraCommand());
		comandos.put("telaEditora", new CreateScreenEditoraCommand());
		comandos.put("alterEditora", new AlterEditoraCommand());

		// AUTOR
		comandos.put("addAutor", new AddAutorCommand());
		comandos.put("listAutor", new ListAutorCommand());
		comandos.put("removerAutor", new RemoveAutorCommand());
		comandos.put("consultarAutor", new ConsultarAutorCommand());
		comandos.put("telaAutor", new CreateScreenAutorCommand());
		comandos.put("alterAutor", new AlterAutorCommand());

		// LIVRO
		comandos.put("addLivro", new AddLivroCommand());
		comandos.put("listLivro", new ListLivroCommand());
		comandos.put("removerLivro", new RemoveLivroCommand());
		comandos.put("telaLivro", new CreateScreenLivroCommand());
		comandos.put("consultarLivro", new ConsultarLivroCommand());
		comandos.put("alterLivro", new AlterLivroCommand());

		// EQUIPAMENTOS (Computador, Perifericos e Dispositivos Moveis)
		comandos.put("telaEquipamento", new CreateScreenEquipamentoCommand());
		comandos.put("addEquipamento", new AddEquipamentoCommand());
		comandos.put("listEquipamento", new ListEquipamentoCommand());
//		comandos.put("removerEquipamento", new RemoveEquipamentoCommand());
//		comandos.put("consultarEquipamento", new ConsultarEquipamentoCommand());
//		comandos.put("alterEquipamento", new AlterEquipamentoCommand());

		// MARCA
		comandos.put("addMarca", new AddMarcaCommand());
		comandos.put("removerMarca", new RemoveMarcaCommand());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String proxima = null;

		try {
			Command comando = verificarComando(acao);
			proxima = comando.execute(request);
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		LogParametrosSession.logParametros(request);

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
