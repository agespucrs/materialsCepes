package br.ages.crud.command;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.ProjetoBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Projeto;
import br.ages.crud.util.MensagemContantes;

public class AlterProjetoCommand implements Command{

	private String proximo;
	
	@Override
	public String execute(HttpServletRequest request)
			throws SQLException, PersistenciaException, ParseException, NegocioException {
		
		proximo = "";
		
		try{
		ProjetoBO projetoBO = new ProjetoBO();
		
		Projeto projeto = new Projeto();
		projeto.setId(Integer.parseInt(request.getParameter("idProjeto")));
		projeto.setIdCoordenador(Integer.parseInt(request.getParameter("coordenador")));
		projeto.setOrigem(request.getParameter("origem"));
		projeto.setNomeProjeto(request.getParameter("nome"));
		projeto.setPrograma(request.getParameter("programa"));
		projetoBO.cadastraProjeto(projeto);
		
		request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_ALTERAR_PROJETO.replace("?", projeto.getNomeProjeto()));
		
		proximo = "main?acao=listProjeto";
		
		
		}catch (Exception e){
			request.setAttribute("msgErro", e.getMessage());
		}
		
		return proximo;
	}

}
