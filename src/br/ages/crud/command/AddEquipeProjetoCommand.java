package br.ages.crud.command;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import br.ages.crud.bo.ProjetoBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.UsuarioProjeto;
import br.ages.crud.util.MensagemContantes;

public class AddEquipeProjetoCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			throws SQLException, PersistenciaException, ParseException, NegocioException {

		ProjetoBO projetoBO = new ProjetoBO();

		try {
			Integer idProjeto = Integer.parseInt(request.getParameter("projeto"));
			String dataAlocacao = request.getParameter("dtAlocacao");

			projetoBO.removerUsuariosProjeto(idProjeto);

			String[] usuarios = request.getParameterValues("listaEquipe");

			for (String usr : usuarios) {
				UsuarioProjeto usuarioProjeto = new UsuarioProjeto();
				usuarioProjeto.setIdProjeto(idProjeto);
				usuarioProjeto.setIdUsuario(Integer.parseInt(usr));
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				Date date = (Date) formatter.parse(dataAlocacao);
				usuarioProjeto.setDataAlocacao(date);
				projetoBO.inserirUsuarioProjeto(usuarioProjeto);
			}

			request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_CADASTRO_EQUIPE);

		} catch (Exception e) {
			request.setAttribute("msgErro", MensagemContantes.MSG_ERR_ALOCAR_EQUIPE);
		}

		return "main?acao=listProjeto";
	}

}
