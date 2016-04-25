package br.ages.crud.bo;

import java.sql.SQLException;
import java.util.List;

import br.ages.crud.dao.EquipamentoDAO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Equipamento;
import br.ages.crud.model.Livro;

public class EquipamentoBO {
	EquipamentoDAO equipamentoDAO = null;
	
	public EquipamentoBO() {
		equipamentoDAO = new EquipamentoDAO();
	}

	public List<Equipamento> listarEquipamento() throws PersistenciaException, SQLException, NegocioException {
		List<Equipamento> listaEquipamentos = null;

		try {
			listaEquipamentos = equipamentoDAO.listarEquipamentos();
		} catch (PersistenciaException | SQLException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

		return listaEquipamentos;
	}

	public void removerEquipamento(Integer idEquipamento) throws PersistenciaException, SQLException {
		equipamentoDAO.removerEquipamento(idEquipamento);
	}
}
