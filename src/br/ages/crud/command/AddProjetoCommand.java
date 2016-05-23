package br.ages.crud.command;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.ProjetoBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Projeto;
import br.ages.crud.util.MensagemContantes;


public class AddProjetoCommand implements Command{

	private String proxima;

	private ProjetoBO projetoBO;

	@Override
	public String execute(HttpServletRequest request)
			throws SQLException, PersistenciaException, ParseException, NegocioException {

		projetoBO = new ProjetoBO();
		
		
		String nomeProjeto = request.getParameter("NOME_PROJETO");
		String programa = request.getParameter("PROGRAMA");
		String origem = request.getParameter("ORIGEM");
		String dataCadastro = request.getParameter("DATE_CADASTRO");
		String idCordenador = request.getParameter("ID_CORDENADOR");
		Date datanow = new Date(System.currentTimeMillis());

			try {				
				Projeto projeto = new Projeto();
				projeto.setNomeProjeto(nomeProjeto);
				projeto.setPrograma(programa);
				projeto.setOrigem(origem);
				projeto.setDataCadastro(datanow);
				projeto.setIdCordenador(1);
				request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_CADASTRO_PROJETO.replace("?", "nome_projeto"));
				proxima = "main?acao=listProjeto";
			} catch (Exception e) {
				request.setAttribute("msgErro", MensagemContantes.MSG_ERR_CADASTRO_PROJETO.replace("?", "nome_projeto"));
				proxima = "main?acao=addProjeto";
			}



		return proxima;
	}

}