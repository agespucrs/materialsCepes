package br.ages.crud.command;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.LivroBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.CopiaLivro;
import br.ages.crud.util.MensagemContantes;

public class AddCopiaLivroCommand implements Command {
	String proxima = "main?acao=copiaLivro";

	@Override
	public String execute(HttpServletRequest request)
			throws SQLException, PersistenciaException, ParseException, NegocioException {
		int idLivro = Integer.parseInt(request.getParameter("livro"));
		String copia = request.getParameter("copia");

		CopiaLivro copiaL = new CopiaLivro();

		copiaL.setIdLivro(idLivro);
		copiaL.setCodigo_isbn(copia);

		if (copiaL.getCodigoIsbn().length() > 11) {
			request.setAttribute("msgErro", MensagemContantes.MSG_ERR_CAMPO_CODIGO_ISBN_MAIOR);
		} else {

			LivroBO bo = new LivroBO();

			try {
				bo.cadastrarCopia(copiaL);
				request.setAttribute("msgSucesso",
						MensagemContantes.MSG_SUC_CADASTRO_COPIA.replace("?", copiaL.getCodigoIsbn()));
			} catch (Exception e) {
				request.setAttribute("msgErro", e.getMessage());
			}
		}
		// TODO Auto-generated method stub
		return proxima;
	}

}