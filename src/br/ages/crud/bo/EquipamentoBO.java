package br.ages.crud.bo;

import java.sql.SQLException;
import java.util.List;

import br.ages.crud.dao.EquipamentoDAO;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Equipamento;

public class EquipamentoBO {
	EquipamentoDAO equipamentoDAO = null;
	
	public EquipamentoBO() {
		equipamentoDAO = new EquipamentoDAO();
	}

	public List<Equipamento> listarEquipamento() throws PersistenciaException, SQLException {
		return equipamentoDAO.listarEquipamentos();
	}
}
