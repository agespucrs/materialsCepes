package br.ages.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Editora;
import br.ages.crud.model.Livro;
import br.ages.crud.util.ConexaoUtil;

import com.mysql.jdbc.Statement;


public class EditoraDAO {

	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	private ArrayList<Editora> listarEditoras;

	public EditoraDAO() {
		listarEditoras = new ArrayList<>();
	}

	public List<Editora> listarEditoras() throws PersistenciaException, SQLException {
		Connection conexao = null;

		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_EDITORA");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				Editora dto = new Editora();
				dto.setIdEditora(resultset.getInt("ID_EDITORA"));
				dto.setNome(resultset.getString("NOME"));
				listarEditoras.add(dto);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		return listarEditoras;
	}

	public void cadastrarEditora(Editora editora) throws PersistenciaException, SQLException, ParseException {
		Connection conexao = null;
		try {
			Integer idEditora = null;

			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO TB_EDITORA (ID_EDITORA, NOME)");
			sql.append("VALUES (?, ?)");

			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, editora.getNome());
			
			statement.executeUpdate();

			ResultSet resultset = statement.getGeneratedKeys();
			if (resultset.first()) {
				idEditora = resultset.getInt(1);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
	}

	public Editora consultarEditora(Integer idEditora) throws PersistenciaException, SQLException {
		
		Connection conexao = null;
		Editora editora = new Editora();
		
		try {

			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_EDITORA WHERE ID_EDITORA = ? ");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, idEditora);
			//statement.execute();
			ResultSet resultset = statement.executeQuery();
			
			editora.setIdEditora(resultset.getInt("ID_EDITORA"));
			editora.setNome(resultset.getString("NOME"));

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		return editora;
	}
	
	public void removerEditora(Integer idEditora) throws PersistenciaException {
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM TB_EDITORA WHERE ID_EDITORA= ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, idEditora);

			statement.execute();
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			try {
				conexao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
