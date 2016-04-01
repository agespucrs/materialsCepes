package br.ages.crud.command;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.EquipamentoBO;
import br.ages.crud.bo.LivroBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Equipamento;
import br.ages.crud.model.Livro;

public class ListEquipamentoCommand implements Command {
	
	private String proxima;
	private EquipamentoBO equipamentoBO;
	
	@Override
	public String execute(HttpServletRequest request)
			throws SQLException, PersistenciaException, ParseException, NegocioException {
		
		this.equipamentoBO = new EquipamentoBO();
		proxima = "equipamento/listEquipamentos.jsp";

		try {
			List<Equipamento> listaEquipamentos = equipamentoBO.listarEquipamento();
			request.setAttribute("listaEquipamentos", listaEquipamentos);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}

}
