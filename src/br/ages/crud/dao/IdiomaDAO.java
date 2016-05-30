package br.ages.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.ages.crud.bo.EditoraBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Idioma;
import br.ages.crud.model.Livro;
import br.ages.crud.util.ConexaoUtil;

public class IdiomaDAO {

	public List<Idioma> consultarIdioma() throws PersistenciaException, SQLException, NegocioException, ParseException {

		Connection conexao = null;
		List<Idioma> lista = new ArrayList<Idioma>();

		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();

			sql.append("SELECT * FROM TB_IDIOMA ");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				Idioma dto = new Idioma();
				dto.setId(resultset.getInt("ID_IDIOMA"));
				dto.setNome(resultset.getString("NOME"));
				dto.setPais(resultset.getString("PAIS"));
				dto.setIdentificador(resultset.getString("IDENTIFICADOR"));
				lista.add(dto);
			}

			return lista;

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}

	}

	public Idioma buscarPeloIdentificador(String identificador)
			throws PersistenciaException, SQLException, NegocioException, ParseException {

		Connection conexao = null;

		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();

			sql.append("SELECT * FROM TB_IDIOMA WHERE IDENTIFICADOR = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setString(1, identificador);

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				Idioma dto = new Idioma();
				dto.setId(resultset.getInt("ID_IDIOMA"));
				dto.setNome(resultset.getString("NOME"));
				dto.setPais(resultset.getString("PAIS"));
				dto.setIdentificador(resultset.getString("IDENTIFICADOR"));
				return dto;
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		return null;

	}

	public Idioma buscar(Integer id) throws PersistenciaException, SQLException, NegocioException, ParseException {

		Connection conexao = null;

		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();

			sql.append("SELECT * FROM TB_IDIOMA WHERE ID_IDIOMA = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, id);

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				Idioma dto = new Idioma();
				dto.setId(resultset.getInt("ID_IDIOMA"));
				dto.setNome(resultset.getString("NOME"));
				dto.setPais(resultset.getString("PAIS"));
				dto.setIdentificador(resultset.getString("IDENTIFICADOR"));
				return dto;
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		return null;

	}

}
