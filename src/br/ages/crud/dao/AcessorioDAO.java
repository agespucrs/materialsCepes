package br.ages.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;

import com.mysql.jdbc.Statement;

import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Acessorio;
import br.ages.crud.model.Computador;
import br.ages.crud.util.ConexaoUtil;

public class AcessorioDAO {

	public boolean cadastrarAcessorio(Acessorio acessorio)
			throws PersistenciaException, SQLException, ParseException {
		Connection conexao = null;
		boolean valorDeRetorno = false;
		try {
			Integer idEquipamento = null;
			conexao = ConexaoUtil.getConexao();

			// inicio de transacao

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO TB_EQUIPAMENTOS ");
			sql.append(
					"(STATUS, MODELO, VALOR_AQUISICAO, DATA_CADASTRO, OBSERVACAO, ID_MARCA, ID_PROJETO) ");
			sql.append("VALUES ");
			sql.append(
					"(     ?,      ?,               ?,             ?,          ?,        ?,          ?)");

			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, acessorio.getStatus());
			statement.setString(2, acessorio.getModelo());
			statement.setDouble(3, acessorio.getValor());
			statement.setTimestamp(4, new Timestamp(acessorio.getDataCadastro().getTime()));
			statement.setString(5, acessorio.getObservacoes());
			statement.setInt(6, acessorio.getMarca());
			statement.setInt(7, acessorio.getProjeto());

			statement.executeUpdate();

			ResultSet resultset = statement.getGeneratedKeys();
			if (resultset.first()) {
				idEquipamento = resultset.getInt(1);

				sql = new StringBuilder();
				sql.append("INSERT INTO TB_ACESSORIO ");
				sql.append("(ID_EQUIPAMENTO, ID_TIPO, QUANTIDADE) ");
				sql.append("VALUES ");
				sql.append("(             ?,       ?,          ?)");

				statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, idEquipamento);
				statement.setInt(2, acessorio.getTipoAcessorio());
				statement.setInt(3, acessorio.getQuantidade());

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
