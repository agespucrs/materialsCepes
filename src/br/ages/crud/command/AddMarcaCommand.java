package br.ages.crud.command;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.MarcaBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Marca;
import br.ages.crud.util.MensagemContantes;

/**
 * @author 15280426
 *
 */
public class AddMarcaCommand implements Command {

	private String proxima;

	private MarcaBO marcaBO;

	@Override
	public String execute(HttpServletRequest request)
			throws SQLException, PersistenciaException, ParseException, NegocioException {

		marcaBO = new MarcaBO();
		proxima = "main?acao=telaEquipamento&tela=marca";

		String nome = request.getParameter("nome");

		try {
			marcaBO.cadastraMarca(new Marca(nome));
			request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_CADASTRO_MARCA.replace("?", nome));
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}

}
