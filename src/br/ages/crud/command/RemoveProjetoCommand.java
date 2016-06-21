package br.ages.crud.command;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.MarcaBO;
import br.ages.crud.bo.ProjetoBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.util.MensagemContantes;

public class RemoveProjetoCommand implements Command{
	private String proxima;

	private ProjetoBO projetoBO;

	@Override
	public String execute(HttpServletRequest request)
			throws SQLException, PersistenciaException, ParseException, NegocioException {

		projetoBO = new ProjetoBO();
		proxima = "main?acao=listProjeto";

		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nomeMensagem");

		try {
				projetoBO.removerProjeto(id);
				request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_REMOVE_PROJETO.replace("?", nome));
		} catch (Exception e) {
				request.setAttribute("msgErro", e.getMessage());
			}
		

		return proxima;
	}

}
