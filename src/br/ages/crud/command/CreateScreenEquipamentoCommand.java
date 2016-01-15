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
			case "computador":
				this.proxima = "equipamento/addComputador.jsp";
				break;
			case "periferico":
				this.proxima = "equipamento/addPeriferico.jsp";
				break;
			case "movel":
				this.proxima = "equipamento/addMovel.jsp";
				break;
			case "marcaModelo":
				this.proxima = "equipamento/addMarcaModelo.jsp";
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
