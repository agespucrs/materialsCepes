package br.ages.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Funcao;
import br.ages.crud.util.ConexaoUtil;

public class FuncaoDAO {

	/**
	 * Método que retorna as possíveis funções de um usuário.
	 * 
	 * @return
	 * @throws PersistenciaException
	 * @throws SQLException
	 */
	public List<Funcao> listarFuncoes() throws PersistenciaException, SQLException {
		Connection conexao = null;
		List<Funcao> funcoes = new ArrayList<>();

		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID_FUNCAO, NOME FROM TB_FUNCOES");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				Funcao dto = new Funcao();
				dto.setId(resultset.getInt("ID_FUNCAO"));
				dto.setNome(resultset.getString("NOME"));
				funcoes.add(dto);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		return funcoes;
	}

}
