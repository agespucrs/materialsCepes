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
import br.ages.crud.model.Autor;
import br.ages.crud.util.ConexaoUtil;

public class AutorDAOv1 {
	
	private ArrayList<Autor> listarAutores;
	private Autor consultarAutor;
	
	public AutorDAOv1() {
		listarAutores = new ArrayList<>();
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
	
	public void removerAutor(Integer idAutor) throws PersistenciaException { // Quando autor esta assiociado a um livro?
		
	}
	
	public Autor consultarAutor(Integer idAutor) throws PersistenciaException, SQLException {		
		Connection conexao = null;

		try {

			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT FROM TB_AUTOR WHERE ID_AUTOR = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, idAutor);
			ResultSet resultset = statement.executeQuery();
			
			Autor dto = new Autor();
			dto.setId_autor(resultset.getInt("ID_AUTOR"));
			dto.setNome(resultset.getString("NOME"));
			dto.setSobrenome(resultset.getString("SOBRENOME"));
			consultarAutor = dto;
			
		} catch (ClassNotFoundException | SQLException e) {
		throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
	return consultarAutor;
	}
}