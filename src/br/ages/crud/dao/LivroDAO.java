package br.ages.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Editora;
import br.ages.crud.model.Livro;
import br.ages.crud.model.Usuario;
import br.ages.crud.util.ConexaoUtil;

import com.mysql.jdbc.Statement;

public class LivroDAO {
	
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	private ArrayList<Livro> listarLivros;
	private Livro consultarLivro;
	
	public LivroDAO() {
		listarLivros = new ArrayList<>();
	}
	
	public void cadastrarLivro(Livro livro) throws PersistenciaException, SQLException, ParseException {
		
		Connection conexao = null;
		try {
			
			Integer idLivro = null;

			conexao = ConexaoUtil.getConexao();
			
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO TB_LIVRO (TITULO, SUBTITULO, DATA_CADASTRO, PRECO, LINGUA, CODIGO_ISBN, EDICAO, ANO, PAGINAS, VIDEO, CD_DVD, E_BOOK, DESCRICAO, BRUXURA_REVISTA, EDITORA, AUTOR)");
			sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");

			java.util.Date utilDate = new java.util.Date();
		    java.sql.Date dataCadastro = new java.sql.Date(utilDate.getTime());
			
		    PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, livro.getTitulo());
			statement.setString(2, livro.getSubtitulo());
			statement.setDate(3, dataCadastro);
			statement.setLong(4, livro.getPreco());
			statement.setString(5, livro.getLingua());
			statement.setString(6, livro.getCodigoISBN());
			statement.setInt(7, livro.getEdicao());
			statement.setDate(8, livro.getAno());
			statement.setInt(9, livro.getPaginas());
			statement.setBoolean(10, livro.isVideo());
			statement.setBoolean(11, livro.isCd_dvd());
			statement.setBoolean(12, livro.isE_book());
			statement.setString(13, livro.getDescricao());
			statement.setString(14, livro.getBruxura_revista());
			statement.setInt(15, livro.getEditora().getIdEditora());
			statement.setInt(16, livro.getAutor().getId_autor());
			
			statement.executeUpdate();

			ResultSet resultset = statement.getGeneratedKeys();
			if (resultset.first()) {
				idLivro = resultset.getInt(1);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
	}
	
	public List<Livro> listarLivros() throws PersistenciaException, SQLException {
		
		Connection conexao = null;

		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_LIVRO INNER JOIN TB_EDITORA ON EDITORA = ID_EDITORA INNER JOIN TB_AUTOR ON AUTOR = ID_AUTOR");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				Livro dto = new Livro();
				Editora edi = new Editora();
				
				dto.setIdLivro(resultset.getInt("ID_LIVRO"));
				dto.setTitulo(resultset.getString("TITULO"));
				dto.setSubtitulo(resultset.getString("SUBTITULO"));
				dto.setDataCadastro(resultset.getDate("DATA_CADASTRO"));
				dto.setPreco(resultset.getLong("PRECO"));
				dto.setLingua(resultset.getString("LINGUA"));
				dto.setCodigoISBN(resultset.getString("CODIGO_ISBN"));
				dto.setEdicao(resultset.getInt("EDICAO"));
				dto.setAno(resultset.getDate("ANO"));
				dto.setPaginas(resultset.getInt("PAGINAS"));
				dto.setVideo(resultset.getBoolean("VIDEO"));
				dto.setCd_dvd(resultset.getBoolean("CD_DVD"));
				dto.setE_book(resultset.getBoolean("E_BOOK"));
				dto.setBruxura_revista(resultset.getString("BRUXURA_REVISTA"));
				
				listarLivros.add(dto);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		return listarLivros;
	}
	
	public Livro consultarLivro(Integer idLivro) throws PersistenciaException, SQLException {
		
		Connection conexao = null;

		try {

			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT FROM TB_LIVRO WHERE ID_LIVRO = ? ");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, idLivro);

			statement.execute();

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		return consultarLivro;
	}
	
	public void removerLivro(Integer idLivro) throws PersistenciaException {
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM TB_LIVRO WHERE ID_LIVRO = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, idLivro);

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
