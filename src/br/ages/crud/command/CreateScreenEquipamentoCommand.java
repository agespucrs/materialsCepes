package br.ages.crud.command;

import javax.servlet.http.HttpServletRequest;

public class CreateScreenEquipamentoCommand implements Command {

	private String proxima;

	@Override
	public String execute(HttpServletRequest request) {

		this.proxima = "";

		String tela = request.getParameter("tela");

		try {

			switch (tela) {
			case "equipamento":
				this.proxima = "equipamento/addEquipamento.jsp";
				break;
			case "computador":
				this.proxima = "equipamento/addComputador.jsp";
				break;
			case "periferico":
				this.proxima = "equipamento/addPeriferico.jsp";
				break;
			case "movel":
				this.proxima = "equipamento/addMovel.jsp";
				break;
			case "marca":
				this.proxima = "equipamento/addMarca.jsp";
				break;
			case "copiaLivro":
				this.proxima = "livro/addCopiaLivro.jsp";
				break;
			case "emprestimoLivro":
				this.proxima = "livro/emprestimoLivro.jsp";
				break;
			case "listProjeto":
				this.proxima = "projeto/listProjeto.jsp";
				break;
			case "equipamentoProjeto":
				this.proxima = "projeto/equipamentoProjeto.jsp";
				break;
			case "equipeProjeto":
				this.proxima = "projeto/equipeProjeto.jsp";
				break;
			case "addProjeto":
				this.proxima = "projeto/addProjeto.jsp";
				break;

			default:
				this.proxima = "equipamento/listEquipamentos.jsp";
				break;
			}

		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}
}
