package br.ages.crud.bo;

import java.util.List;

import br.ages.crud.dao.EquipamentoDAO;
import br.ages.crud.model.Equipamento;

public class EquipamentoBO {
	EquipamentoDAO equipamentoDAO = null;
	
	public EquipamentoBO() {
		equipamentoDAO = new EquipamentoDAO();
	}

	public List<Equipamento> listarEquipamento() {
		return equipamentoDAO.listarEquipamentos();
	}
}
