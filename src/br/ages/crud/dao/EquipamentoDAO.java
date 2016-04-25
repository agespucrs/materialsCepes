package br.ages.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

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
			sql.append("SELECT * FROM VW_EQUIPAMENTOS where Ativo='S'");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				Equipamento equipamentoAtual = new Equipamento();
				equipamentoAtual.setId(resultset.getInt("Id_Equipamento"));
				equipamentoAtual.setTipoEquipamento(resultset.getString("Tipo_Equipamento"));
				equipamentoAtual.setSubTipo(resultset.getString("Sub_Tipo"));
				equipamentoAtual.setMarca(resultset.getString("Nome"));
				equipamentoAtual.setModelo(resultset.getString("Modelo"));
				equipamentoAtual.setNumeroPatrimonio(resultset.getInt("N_PATRIMONIO"));
				equipamentoAtual.setDataCadastro(resultset.getDate("Data_Cadastro"));
				equipamentoAtual.setValor(resultset.getDouble("Valor_Aquisicao"));
				listarEquipamentos.add(equipamentoAtual);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		return listarEquipamentos;
	}

	public boolean removerEquipamento(int id) throws PersistenciaException, SQLException {
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
	
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE TB_EQUIPAMENTOS SET ATIVO = 'N' WHERE ID_EQUIPAMENTO=?");
	
			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, id);
			statement.executeUpdate();
	
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
	}
	
	
	// REVISAR...
	
		
		public boolean alterarEquipamento(int id, String nome) throws PersistenciaException, SQLException, ParseException {
			Connection conexao = null;
			try {
				conexao = ConexaoUtil.getConexao();
	
				StringBuilder sql = new StringBuilder();
				sql.append("UPDATE TB_EQUIPAMENTOS SET NOME=? WHERE ID_EQUIPAMENTO=?");
	
				PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
	
				statement.setString(1, nome);
				statement.setInt(2, id);
	
				statement.executeUpdate();
	
				return true;
	
			} catch (ClassNotFoundException | SQLException e) {
				throw new PersistenciaException(e);
			} finally {
				conexao.close();
			}
		}
}

