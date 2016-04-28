package br.ages.crud.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Marca;
import br.ages.crud.model.Periferico;
import br.ages.crud.util.ConexaoUtil;

public class PerifericoDAO {

	public boolean cadastrarPeriferico(Periferico periferico) throws PersistenciaException, SQLException {
		Connection conexao = null;
		boolean valorDeRetorno = false;
		try {
			Integer idEquipamento = null;
			conexao = ConexaoUtil.getConexao();

			// inicio de transacao

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO TB_EQUIPAMENTO ");
			sql.append(
					"(N_PATRIMONIO, STATUS, MODELO, VALOR_AQUISICAO, DATA_CADASTRO, OBSERVACAO, ID_MARCA, ID_PROJETO) ");
			sql.append("VALUES ");
			sql.append(
					"(           ?,      ?,      ?,               ?,             ?,          ?,        ?,          ?)");

			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, periferico.getNumeroPatrimonio());
			statement.setString(2, periferico.getStatus());
			statement.setString(3, periferico.getModelo());
			statement.setDouble(4, periferico.getValor());
			statement.setDate(5, (Date) periferico.getDataCadastro());
			statement.setString(6, periferico.getObservacoes());
			statement.setString(7, periferico.getMarca());
			statement.setString(8, periferico.getProjeto());

			statement.executeUpdate();

			ResultSet resultset = statement.getGeneratedKeys();
			if (resultset.first()) {
				idEquipamento = resultset.getInt(1);

				sql = new StringBuilder();
				sql.append("INSERT INTO TB_PERIFERICO ");
				sql.append("(ID_EQUIPAMENTO, TIPO_PERIFERICO) ");
				sql.append("VALUES ");
				sql.append("(             ?,           ?)");

				statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, idEquipamento);
				statement.setString(2, periferico.getTipoPeriferico());

				statement.executeUpdate();

				resultset = statement.getGeneratedKeys();
				if (resultset.first()) {
					// commit da transacao
					valorDeRetorno = true;
				}
				// else
				// rollback
			}
			// else
			// rollback

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}

		return valorDeRetorno;
	}

	public List<Periferico> listarPerifericos() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean alterarPeriferico(Periferico periferico) throws PersistenciaException, SQLException {
		Connection conexao = null;
		boolean valorDeRetorno = false;
		try {
			Integer idEquipamento = null;
			conexao = ConexaoUtil.getConexao();

			// inicio de transacao

			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE TB_EQUIPAMENTO ");
			sql.append("SET N_PATRIMONIO = ?, ");
			sql.append("SET STATUS = ?, ");
			sql.append("SET MODELO = ?, ");
			sql.append("SET VALOR_AQUISICAO = ?, ");
			sql.append("SET DATA_CADASTRO = ?, ");
			sql.append("SET OBSERVACAO = ?, ");
			sql.append("SET ID_MARCA = ?, ");
			sql.append("SET ID_PROJETO = ? ");
			sql.append("WHERE ID_EQUIPAMENTO = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, periferico.getNumeroPatrimonio());
			statement.setString(2, periferico.getStatus());
			statement.setString(3, periferico.getModelo());
			statement.setDouble(4, periferico.getValor());
			statement.setDate(5, (Date) periferico.getDataCadastro());
			statement.setString(6, periferico.getObservacoes());
			statement.setString(7, periferico.getMarca());
			statement.setString(8, periferico.getProjeto());
			statement.setInt(9, periferico.getId());
			statement.executeUpdate();

			ResultSet resultset = statement.getGeneratedKeys();
			if (resultset.first()) {
				idEquipamento = resultset.getInt(1);

				sql = new StringBuilder();
				sql.append("UPDATE TB_PERIFERICO ");
				sql.append("SET TIPO_PERIFERICO = ? ");
				sql.append("WHERE ID_EQUIPAMENTO = ?");

				statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, periferico.getTipoPeriferico());
				statement.setInt(2, idEquipamento);
				statement.executeUpdate();

				resultset = statement.getGeneratedKeys();
				if (resultset.first()) {
					// commit da transacao
					valorDeRetorno = true;
				}
				// else
				// rollback
			}
			// else
			// rollback

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}

		return valorDeRetorno;
	}

}
