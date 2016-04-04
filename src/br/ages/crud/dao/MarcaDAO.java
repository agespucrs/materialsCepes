package br.ages.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Marca;
import br.ages.crud.util.ConexaoUtil;

/**
 * @author 15280426
 *
 */
public class MarcaDAO {

	private List<Marca> listaMarcas;

	public MarcaDAO() {

		listaMarcas = new ArrayList<Marca>();

	}

	/**
	 * Método responsável por salvar a marca no BD.
	 * 
	 * @param marca
	 * @throws PersistenciaException
	 * @throws SQLException
	 * @throws ParseException
	 */
	public void cadastrarMarca(Marca marca) throws PersistenciaException, SQLException, ParseException {
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO TB_MARCA (NOME)");
			sql.append("VALUES (?)");

			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, marca.getNome());
			statement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
	}

	/**
	 * Método para consultar todas as marcas.
	 * 
	 * @return
	 * @throws PersistenciaException
	 * @throws SQLException
	 * @throws ParseException
	 */
	public List<Marca> consultarMarcas() throws PersistenciaException, SQLException, ParseException {

		Connection conexao = null;

		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_MARCA");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				Marca dto = new Marca();
				dto.setId(resultset.getInt("ID_MARCA"));
				dto.setNome(resultset.getString("NOME"));

				listaMarcas.add(dto);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}

		return listaMarcas;

	}

	/**
	 * Método para remover uma marca.
	 * 
	 * @param id
	 * @return
	 * @throws PersistenciaException
	 * @throws SQLException
	 */
	public boolean removerMarca(int id) throws PersistenciaException, SQLException {
		Connection conexao = null;

		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM TB_MARCA WHERE ID_MARCA=?");

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

	/**
	 * Método para alterar uma marca.
	 * 
	 * @param id
	 * @param nome
	 * @return
	 * @throws PersistenciaException
	 * @throws SQLException
	 * @throws ParseException
	 */
	public boolean alterarMarca(int id, String nome) throws PersistenciaException, SQLException, ParseException {
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE TB_MARCA SET NOME=? WHERE ID_MARCA=?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

			statement.setInt(1, id);
			statement.setString(2, nome);

			statement.executeUpdate();

			return true;

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
	}

}
