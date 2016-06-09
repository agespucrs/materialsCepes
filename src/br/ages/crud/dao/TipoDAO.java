package br.ages.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Marca;
import br.ages.crud.model.Tipo;
import br.ages.crud.model.TipoEquipamento;
import br.ages.crud.util.ConexaoUtil;

public class TipoDAO {

	private Connection conexao;

	public TipoDAO() {
		conexao = null;
	}

	public List<Tipo> consultarPeloTipo(TipoEquipamento tipo) throws PersistenciaException, SQLException {
		List<Tipo> lista = new ArrayList<Tipo>();

		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_TIPO WHERE ");
			sql.append("TIPO_EQUIPAMENTO = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setString(1, tipo.valor().toUpperCase());

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				Tipo dto = new Tipo();
				dto.setId(resultset.getInt("ID_TIPO"));
				dto.setNome(resultset.getString("NOME"));

				lista.add(dto);
			}

			return lista;
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
	}
	
	public Tipo consultarPeloNome(String nome) throws PersistenciaException, SQLException {
		try {
			conexao = ConexaoUtil.getConexao();
			Tipo tipo = new Tipo();
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_TIPO WHERE ");
			sql.append("NOME = trim(?)");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setString(1, nome);

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				tipo.setId(resultset.getInt("ID_TIPO"));
				tipo.setNome(nome);
			}

			return tipo;
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
	}
	
	public int cadastrar(Tipo tipo) throws PersistenciaException, SQLException {
	
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO TB_TIPO ");
			sql.append("(TIPO_EQUIPAMENTO, NOME) ");
			sql.append("VALUES ");
			sql.append("(               ?,    ?)");

			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, tipo.getTipoEquipamento());
			statement.setString(2, tipo.getNome());

			int idNovoTipo = -1;
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				idNovoTipo = resultset.getInt(1);
				tipo.setId(idNovoTipo);
			}

			return idNovoTipo;
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
	}
}
