package br.ages.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import com.mysql.jdbc.Statement;

import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Marca;
import br.ages.crud.util.ConexaoUtil;

/**
 * @author 15280426
 *
 */
public class MarcaDAO {

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

}
