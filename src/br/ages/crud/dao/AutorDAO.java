package br.ages.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Autor;
import br.ages.crud.model.Editora;
import br.ages.crud.model.Livro;
import br.ages.crud.util.ConexaoUtil;

import com.mysql.jdbc.Statement;


public class AutorDAO {

	private ArrayList<Autor> listarAutores;
	private ArrayList<Autor> listarAutoresLivro;


	public AutorDAO() {
		listarAutores = new ArrayList<>();
		listarAutoresLivro = new ArrayList<>();

	}

	public List<Autor> listarAutores() throws PersistenciaException, SQLException {
		Connection conexao = null;

		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_AUTOR");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				Autor dto = new Autor();
				dto.setId_autor(resultset.getInt("ID_AUTOR"));
				dto.setNome(resultset.getString("NOME"));
				dto.setSobrenome(resultset.getString("SOBRENOME"));
				listarAutores.add(dto);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		return listarAutores;
	}
	
	public List<Autor> listarAutoresLivro(Livro livro) throws PersistenciaException, SQLException {
		Connection conexao = null;

		try {
			conexao = ConexaoUtil.getConexao();
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT A.ID_AUTOR, NOME, SOBRENOME "); 
			sql.append("FROM TB_AUTOR A ");
			sql.append("INNER JOIN TB_LIVRO_AUTOR LV ON A.ID_AUTOR = LV.ID_AUTOR ");
			sql.append("WHERE ID_LIVRO = ?;");
			
			
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			
			statement.setInt(1, livro.getIdLivro());
			
			ResultSet resultset = statement.executeQuery();
			
			
			
			while (resultset.next()) {
				Autor dto = new Autor();
				dto.setId_autor(resultset.getInt("ID_AUTOR"));
				dto.setNome(resultset.getString("NOME"));
				dto.setSobrenome(resultset.getString("SOBRENOME"));
				listarAutoresLivro.add(dto);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		return listarAutoresLivro;
	}

	public void cadastrarAutor(Autor autor) throws PersistenciaException, SQLException, ParseException {
		Connection conexao = null;
		try {
			Integer idAutor = null;

			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO TB_AUTOR (NOME, SOBRENOME)");
			sql.append("VALUES (?, ?)");

			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, autor.getNome());
			statement.setString(2, autor.getSobrenome());
			
			statement.executeUpdate();

			ResultSet resultset = statement.getGeneratedKeys();
			if (resultset.first()) {
				idAutor = resultset.getInt(1);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
	}
	
	public void alterarAutor(Autor autor) throws PersistenciaException,
		SQLException, ParseException {
		Connection conexao = null;
		try {
			Integer idAutor = null;
		
			conexao = ConexaoUtil.getConexao();
		
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE TB_AUTOR SET NOME = ?, SOBRENOME = ? WHERE id_autor = ?");
			
			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, autor.getNome());
			statement.setString(2, autor.getSobrenome());
			statement.setLong(3, autor.getId_autor());
			statement.executeUpdate();
		
			ResultSet resultset = statement.getGeneratedKeys();
			if (resultset.first()) {
				idAutor = resultset.getInt(1);
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
	}

	public void removerAutor(Integer idAutor) throws PersistenciaException {
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM TB_AUTOR WHERE ID_AUTOR= ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, idAutor);

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
	
	public void removerAutoresLivro(Integer idAutor, Integer idLivro) throws PersistenciaException {
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM TB_LIVRO_AUTOR WHERE ID_AUTOR= ? AND ID_LIVRO = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, idAutor);
			statement.setInt(2, idLivro);
			
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
	
	public Autor consultarAutor(Integer idAutor) throws PersistenciaException, SQLException {		
		Connection conexao = null;

		Autor autor = new Autor();
		try {

			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_AUTOR WHERE ID_AUTOR = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, idAutor);
			ResultSet resultset = statement.executeQuery();
			
			while (resultset.next()) {
				autor.setId_autor(resultset.getInt("ID_AUTOR"));
				autor.setNome(resultset.getString("NOME"));
				autor.setSobrenome(resultset.getString("SOBRENOME"));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
		throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
	
		return autor;
	}
	
	public ArrayList<Autor> consultarAutores(ArrayList<Integer> idAutores) throws PersistenciaException, SQLException {		
		Connection conexao = null;

		ArrayList<Autor> autores = new ArrayList<Autor>();
		try {

			conexao = ConexaoUtil.getConexao();

			StringBuilder sql;
			
			
			for (int i = 0; i < idAutores.size(); i++){
				Autor autor = new Autor();	
			
				sql = new StringBuilder();
				sql.append("SELECT * FROM TB_AUTOR WHERE ID_AUTOR = ?");
				
				PreparedStatement statement = conexao.prepareStatement(sql.toString());
				statement.setInt(1, idAutores.get(i));
				
				ResultSet resultset = statement.executeQuery();
				
				while (resultset.next()) {
				autor.setId_autor(resultset.getInt("ID_AUTOR"));
				autor.setNome(resultset.getString("NOME"));
				autor.setSobrenome(resultset.getString("SOBRENOME"));				
				autores.add(autor);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
		throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}	
		return autores;
	}
}
