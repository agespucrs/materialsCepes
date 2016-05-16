package br.ages.crud.command;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	private String proxima = null;
	
	@Override
	public String execute(HttpServletRequest request)
			throws SQLException, PersistenciaException, ParseException, NegocioException {
		
		int numeroPatrimonio = Integer.parseInt(request.getParameter("numeroPatrimonio"));
		int status = Integer.parseInt(request.getParameter("status"));
		String tipoEquipamento = request.getParameter("tipoEquipamento");
		int marca = Integer.parseInt(request.getParameter("marca"));
		String modelo = request.getParameter("modelo");
		double valor = Double.parseDouble(request.getParameter("valor"));
		int projeto = Integer.parseInt(request.getParameter("projeto"));
		String observacao = request.getParameter("descricao");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dataAux = request.getParameter("dataCadastro");
		Date dataCadastro = formatter.parse(dataAux);
		
		if (tipoEquipamento.equals(TipoEquipamento.COMPUTADOR.valor())) {
			ComputadorBO computadorBO = new ComputadorBO();
			int tipoComputador = Integer.parseInt(request.getParameter("tipoComputador"));

			Computador computador = new Computador();
			computador.setNumeroPatrimonio(numeroPatrimonio);
			computador.setStatus(status);
			computador.setTipoComputador(tipoComputador);
			computador.setMarca(marca);
			computador.setModelo(modelo);
			computador.setValor(valor);
			computador.setDataCadastro(dataCadastro);
			computador.setProjeto(projeto);
			computador.setObservacoes(observacao);			
			
			if (computadorBO.cadastraComputador(computador)) {
				proxima = "main?acao=listEquipamento";
				request.setAttribute("msgSucesso",
						MensagemContantes.MSG_SUC_CADASTRO_EQUIPAMENTO.replace("?",
								String.format("%d", computador.getNumeroPatrimonio())));
			} 
			else {
				proxima = "main?acao=addEquipamento";
				request.setAttribute("msgErro",
						MensagemContantes.MSG_ERR_CADASTRO_EQUIPAMENTO_EXISTENTE.replace("?", 
								String.format("%d", computador.getNumeroPatrimonio())));
			}
			
		}
		else if(tipoEquipamento.equals(TipoEquipamento.PERIFERICO.valor())) {
			PerifericoBO perifericoBO = new PerifericoBO();
			int tipoPeriferico = Integer.parseInt(request.getParameter("tipoPeriferico"));
			
			Periferico periferico = new Periferico();
			periferico.setNumeroPatrimonio(numeroPatrimonio);
			periferico.setStatus(status);
			periferico.setTipoPeriferico(tipoPeriferico);
			periferico.setMarca(marca);
			periferico.setModelo(modelo);
			periferico.setValor(valor);
			periferico.setDataCadastro(dataCadastro);
			periferico.setProjeto(projeto);
			periferico.setObservacoes(observacao);
			
			if (perifericoBO.cadastraPeriferico(periferico)) {
				proxima = "main?acao=listEquipamento";
				request.setAttribute("msgSucesso",
						MensagemContantes.MSG_SUC_CADASTRO_EQUIPAMENTO.replace("?",
								String.format("%d", periferico.getNumeroPatrimonio())));
			}
			else {
				proxima = "main?acao=addEquipamento";
				request.setAttribute("msgErro",
						MensagemContantes.MSG_ERR_CADASTRO_EQUIPAMENTO_EXISTENTE.replace("?",
								String.format("%d", periferico.getNumeroPatrimonio())));
			}
			
		}
		else if(tipoEquipamento.equals(TipoEquipamento.DISPOSITIVO_MOVEL.valor())) {
			DispositivoMovelBO mobileBO = new DispositivoMovelBO();
			int tipoMobile = Integer.parseInt(request.getParameter("tipoMobile"));
			
			DispositivoMovel mobile = new DispositivoMovel();
			mobile.setNumeroPatrimonio(numeroPatrimonio);
			mobile.setStatus(status);
			mobile.setTipoDispositivoMovel(tipoMobile);
			mobile.setMarca(marca);
			mobile.setModelo(modelo);
			mobile.setValor(valor);
			mobile.setDataCadastro(dataCadastro);
			mobile.setProjeto(projeto);
			mobile.setObservacoes(observacao);
			
			if(mobileBO.cadastraDispositivoMovel(mobile)) {
				proxima = "main?acao=listEquipamento";
				request.setAttribute("msgSucesso",
						MensagemContantes.MSG_SUC_CADASTRO_EQUIPAMENTO.replace("?",
								String.format("%d", mobile.getNumeroPatrimonio())));
			}
			else {
				proxima = "main?acao=addEquipamento";
				request.setAttribute("msgErro",
						MensagemContantes.MSG_ERR_CADASTRO_EQUIPAMENTO_EXISTENTE.replace("?", 
								String.format("%d", mobile.getNumeroPatrimonio())));
			}
		}
		
		return proxima;
	}

}
