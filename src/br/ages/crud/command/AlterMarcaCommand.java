package br.ages.crud.command;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.MarcaBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Marca;
import br.ages.crud.util.MensagemContantes;

public class AlterMarcaCommand implements Command {

	private String proxima;

	private MarcaBO marcaBO;

	@Override
	public String execute(HttpServletRequest request)
			throws SQLException, PersistenciaException, ParseException, NegocioException {

		marcaBO = new MarcaBO();
		proxima = "main?acao=telaEquipamento&tela=marca";

		int id = Integer.parseInt(request.getParameter("idMarcaAlteracao"));
		String nome = request.getParameter("nomeAlteracao");

		try {
			marcaBO.alterarMarca(id, nome);
			request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_ALTERAR_MARCA);
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}

}
