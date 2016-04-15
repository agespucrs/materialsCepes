package br.ages.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.ages.crud.bo.EditoraBO;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Equipamento;
import br.ages.crud.model.Livro;
import br.ages.crud.util.ConexaoUtil;

public class EquipamentoDAO {

	private ArrayList<Equipamento> listarEquipamentos;
	
	public EquipamentoDAO() {
		listarEquipamentos = new ArrayList<>();
	}
	
	public List<Equipamento> listarEquipamentos() throws PersistenciaException, SQLException {		
		Connection conexao = null;

		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM cepes_e.VW_EQUIPAMENTOS");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				Equipamento equipamentoAtual = new Equipamento();
				equipamentoAtual.setTipoEquipamento(resultset.getString("Tipo_Equipamento"));
				equipamentoAtual.setNumeroPatrimonio(resultset.getInt("N_PATRIMONIO"));
				equipamentoAtual.setDataCadastro(resultset.getDate("Data_Cadastro"));
				equipamentoAtual.setValor(resultset.getDouble("Valor_Aquisicao"));
				equipamentoAtual.setObservacoes(resultset.getString("Observacao"));
				listarEquipamentos.add(equipamentoAtual);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		return listarEquipamentos;
	}
}
