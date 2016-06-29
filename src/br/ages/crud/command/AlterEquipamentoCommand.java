package br.ages.crud.command;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.AutorBO;
import br.ages.crud.bo.EquipamentoBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Autor;
import br.ages.crud.model.Equipamento;
import br.ages.crud.util.MensagemContantes;

public class AlterEquipamentoCommand implements Command {

	private String proxima;
	private EquipamentoBO equipamentoBO;
	
	@Override
	public String execute(HttpServletRequest request)
			throws SQLException, PersistenciaException, ParseException, NegocioException {
		
		this.equipamentoBO = new EquipamentoBO();
		this.proxima = "equipamento/addEquipamento.jsp";
		
		try {
			int idEquipamento = Integer.parseInt(request.getParameter("id_equipamento"));
			Equipamento equip = equipamentoBO.consultarEquipamento(idEquipamento);
			
			int numeroPatrimonio = equip.getNumeroPatrimonio();
			request.setAttribute("numeroPatrimonio", numeroPatrimonio);
			
			int status = equip.getStatus();
			request.setAttribute("status", status);
			
			Double valor = equip.getValor();
			request.setAttribute("valor", valor);
			
			Date dataCadastro = equip.getDataCadastro();
			request.setAttribute("dataCadastro", dataCadastro);
			
			String subTipo = equip.getSubTipo();
			request.setAttribute("subTipo", subTipo);
			
			//setar parametro para ser usado na tela de edicao posteriormente
			//a partir daqui tambem devemos decidir qual tela (parametro tela) devemos ir
			
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}
}
