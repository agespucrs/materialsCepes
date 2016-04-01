package br.ages.crud.command;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.ComputadorBO;
import br.ages.crud.bo.DispositivoMovelBO;
import br.ages.crud.bo.PerifericoBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Computador;
import br.ages.crud.model.DispositivoMovel;
import br.ages.crud.model.Periferico;
import br.ages.crud.model.TipoEquipamento;
import br.ages.crud.util.MensagemContantes;

public class AddEquipamentoCommand implements Command {

	private String proxima;
	
	@Override
	public String execute(HttpServletRequest request)
			throws SQLException, PersistenciaException, ParseException, NegocioException {
		
		//Todos como tipo string ate terminarem a modelagem do banco de dados
		String numeroPatrimonio = request.getParameter("numeroPatrimonio");
		String status = request.getParameter("status");
		String tipoEquipamento = request.getParameter("tipoEquipamento");
		String tipoComputador = request.getParameter("tipoComputador");
		String tipoPeriferico = request.getParameter("tipoPeriferico");
		String tipoMobile = request.getParameter("tipoMobile");
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		String valor = request.getParameter("valor");
		String dataCadastro = request.getParameter("dataCadastro");
		String projeto = request.getParameter("projeto");
		String observacao = request.getParameter("descricao");
		
		if (tipoEquipamento.equals(TipoEquipamento.COMPUTADOR.valor())) {
			ComputadorBO computadorBO = new ComputadorBO();
			//TODO: chamar todos os metodos sets no objeto computador. Aguardando definicao
			//final do banco de dados
			Computador computador = new Computador();
			
			if (computadorBO.cadastraComputador(computador)) {
				proxima = "main?acao=listEquipamento";
				request.setAttribute("msgSucesso",
						MensagemContantes.MSG_SUC_CADASTRO_EQUIPAMENTO.replace("?",
								computador.getTitulo()));
			} 
			else {
				proxima = "main?acao=addEquipamento";
				request.setAttribute("msgErro",
						MensagemContantes.MSG_ERR_CADASTRO_EQUIPAMENTO_EXISTENTE
								.replace("?", computador.getTitulo()));
			}
			
		}
		else if(tipoEquipamento.equals(TipoEquipamento.PERIFERICO.valor())) {
			PerifericoBO perifericoBO = new PerifericoBO();
			//TODO: chamar todos os metodos sets no objeto periferico. Aguardando definicao
			//final do banco de dados
			Periferico periferico = new Periferico();
			
			if (perifericoBO.cadastraPeriferico(periferico)) {
				proxima = "main?acao=listEquipamento";
				request.setAttribute("msgSucesso",
						MensagemContantes.MSG_SUC_CADASTRO_EQUIPAMENTO.replace("?",
								periferico.getTitulo()));
			}
			else {
				proxima = "main?acao=addEquipamento";
				request.setAttribute("msgErro",
						MensagemContantes.MSG_ERR_CADASTRO_EQUIPAMENTO_EXISTENTE
								.replace("?", periferico.getTitulo()));
			}
			
		}
		else if(tipoEquipamento.equals(TipoEquipamento.DISPOSITIVO_MOVEL.valor())) {
			DispositivoMovelBO mobileBO = new DispositivoMovelBO();
			//TODO: chamar todos os metodos sets no objeto mobile. Aguardando definicao
			//final do banco de dados
			DispositivoMovel mobile = new DispositivoMovel();
			
			if(mobileBO.cadastraDispositivoMovel(mobile)) {
				proxima = "main?acao=listEquipamento";
				request.setAttribute("msgSucesso",
						MensagemContantes.MSG_SUC_CADASTRO_EQUIPAMENTO.replace("?",
								mobile.getTitulo()));
			}
			else {
				proxima = "main?acao=addEquipamento";
				request.setAttribute("msgErro",
						MensagemContantes.MSG_ERR_CADASTRO_EQUIPAMENTO_EXISTENTE
								.replace("?", mobile.getTitulo()));
			}
		}
		
		return null;
	}

}
