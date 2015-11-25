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

import br.ages.crud.bo.EditoraBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Autor;
import br.ages.crud.model.Livro;
import br.ages.crud.util.ConexaoUtil;
import br.ages.crud.util.MensagemContantes;

import com.mysql.jdbc.Statement;

public class LivroDAO {

	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	private ArrayList<Livro> listarLivros;
	private Livro consultarLivro;

	public LivroDAO() {
		listarLivros = new ArrayList<>();
	}

	public boolean cadastrarLivro(Livro livro) throws PersistenciaException,
			SQLException, ParseException {

		Connection conexao = null;
		try {

			Integer idLivro = null;

			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();

			java.util.Date utilDate = new java.util.Date();
			java.sql.Date dataCadastro = new java.sql.Date(utilDate.getTime());

			if (consultaCodigoISBNExistente(livro, conexao)) {

				sql.append("UPDATE TB_LIVRO SET TITULO = ?,"
						+ " SUBTITULO = ?," + " DATA_CADASTRO = ?,"
						+ " PRECO = ?," + " LINGUA = ?," + " EDICAO = ?,"
						+ " ANO = ?," + " PAGINAS = ?," + " VIDEO = ?,"
						+ " CD_DVD = ?," + " E_BOOK = ?," + " DESCRICAO = ?,"
						+ " BRUXURA_REVISTA = ?," + " ID_EDITORA = ?,"
						+ " EXCLUIDO = ?" + " WHERE CODIGO_ISBN = ?");

				PreparedStatement statement = conexao.prepareStatement(sql
						.toString());

				if (livroEstaExcluido(livro, conexao)) {
					statement.setString(1, livro.getTitulo());
					statement.setString(2, livro.getSubtitulo());
					statement.setDate(3, dataCadastro);
					statement.setLong(4, livro.getPreco());
					statement.setString(5, livro.getLingua());
					statement.setInt(6, livro.getEdicao());
					java.sql.Date anoLivro = new java.sql.Date(livro.getAno()
							.getTime());
					statement.setDate(7, anoLivro);
					statement.setInt(8, livro.getPaginas());
					statement.setBoolean(9, livro.isVideo());
					statement.setBoolean(10, livro.isCd_dvd());
					statement.setBoolean(11, livro.isE_book());
					statement.setString(12, livro.getDescricao());
					statement.setBoolean(13, livro.getBruxura_revista());
					statement.setInt(14, livro.getEditora().getIdEditora());
					statement.setBoolean(15, false);
					statement.setString(16, livro.getCodigoISBN());

					statement.executeUpdate();

					return true;
				} else {
					return false;
				}
				// END TO DO
			} else {
				sql.append("INSERT INTO TB_LIVRO (TITULO, SUBTITULO, DATA_CADASTRO, PRECO, LINGUA, CODIGO_ISBN, EDICAO, ANO, PAGINAS, VIDEO, CD_DVD, E_BOOK, DESCRICAO, BRUXURA_REVISTA, ID_EDITORA, EXCLUIDO)");
				sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

				PreparedStatement statement = conexao.prepareStatement(
						sql.toString(), Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, livro.getTitulo());
				statement.setString(2, livro.getSubtitulo());
				statement.setDate(3, dataCadastro);
				statement.setLong(4, livro.getPreco());
				statement.setString(5, livro.getLingua());
				statement.setString(6, livro.getCodigoISBN());
				statement.setInt(7, livro.getEdicao());
				if (livro.getAno() != null) {
					java.sql.Date anoLivro = new java.sql.Date(livro.getAno()
							.getTime());
					statement.setDate(8, anoLivro);
				} else {
					statement.setDate(8, null);
				}
				if (livro.getPaginas() != null) {
					statement.setInt(9, livro.getPaginas());
				} else {
					statement.setString(9, null);
				}
				statement.setBoolean(10, livro.isVideo());
				statement.setBoolean(11, livro.isCd_dvd());
				statement.setBoolean(12, livro.isE_book());
				statement.setString(13, livro.getDescricao());
				statement.setBoolean(14, livro.getBruxura_revista());
				statement.setInt(15, livro.getEditora().getIdEditora());
				statement.setBoolean(16, livro.getStatus());

				statement.executeUpdate();

				ResultSet resultset = statement.getGeneratedKeys();

				if (resultset.first()) {
					idLivro = resultset.getInt(1);
				}

				ArrayList<Integer> idAutores = new ArrayList<Integer>();
				for (Autor aut : livro.getAutores()) {
					idAutores.add(aut.getId_autor());
				}

				cadastraAutoresLivros(idLivro, idAutores, conexao);
				return true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
	}

	private boolean consultaCodigoISBNExistente(Livro livro, Connection conexao)
			throws SQLException {
		Integer codISBN = null;

		Livro livroISBNExistente = new Livro();

		StringBuilder sql = new StringBuilder();

		sql.append("select * from tb_livro where CODIGO_ISBN = ?");
		PreparedStatement statement = conexao.prepareStatement(sql.toString());
		statement.setString(1, livro.getCodigoISBN());

		ResultSet resultset = statement.executeQuery();
		if (resultset.first()) {
			codISBN = resultset.getInt(1);
		}

		if (codISBN == null) {
			return false;
		}

		return true;
	}

	private boolean livroEstaExcluido(Livro livro, Connection conexao)
			throws SQLException {

		Integer excluido = 0;

		StringBuilder sql = new StringBuilder();

		sql.append("select EXCLUIDO from tb_livro where CODIGO_ISBN = ?");
		PreparedStatement statement = conexao.prepareStatement(sql.toString());
		statement.setString(1, livro.getCodigoISBN());

		ResultSet resultset = statement.executeQuery();
		if (resultset.first()) {
			excluido = resultset.getInt(1);
		}

		if (excluido == 0) {
			return false;
		}

		return true;
	}

	private void cadastraAutoresLivros(int IdLivro,
			ArrayList<Integer> idAutores, Connection conexao)
			throws SQLException {
		for (Integer idAutor : idAutores) {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO TB_LIVRO_AUTOR (ID_LIVRO, ID_AUTOR) VALUES (?,?)");
			PreparedStatement statement = conexao.prepareStatement(sql
					.toString());
			statement.setInt(1, IdLivro);
			statement.setInt(2, idAutor);
			statement.executeUpdate();
		}
	}

	public List<Livro> listarLivros() throws PersistenciaException,
			SQLException, NegocioException, ParseException {

		Connection conexao = null;

		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_LIVRO INNER JOIN TB_EDITORA ON tb_livro.id_EDITORA = tb_editora.ID_EDITORA INNER JOIN TB_livro_AUTOR ON tb_livro.id_livro = tb_livro_autor.id_livro ORDER BY tb_livro.ID_LIVRO");

			PreparedStatement statement = conexao.prepareStatement(sql
					.toString());

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				if (!resultset.getBoolean("EXCLUIDO")) {
					EditoraBO editora = new EditoraBO();
					Livro dto = new Livro();
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
					dto.setDescricao(resultset.getString("DESCRICAO"));
					dto.setBruxura_revista(resultset
							.getBoolean("BRUXURA_REVISTA"));
					dto.setEditora(editora.consultarEditora(resultset
							.getInt("ID_EDITORA")));
					listarLivros.add(dto);
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		return listarLivros;
	}

	public Livro consultarLivro(Integer idLivro) throws PersistenciaException,
			SQLException, NegocioException, ParseException {

		Connection conexao = null;

		try {

			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_LIVRO WHERE ID_LIVRO = ? ");

			PreparedStatement statement = conexao.prepareStatement(sql
					.toString());
			statement.setInt(1, idLivro);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				EditoraBO editora = new EditoraBO();
				Livro dto = new Livro();
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
				dto.setBruxura_revista(resultset.getBoolean("BRUXURA_REVISTA"));
				dto.setDescricao(resultset.getString("DESCRICAO"));
				dto.setEditora(editora.consultarEditora(resultset
						.getInt("ID_EDITORA")));
				dto.setAutores(consultarAutoresLivros(idLivro, conexao));
				consultarLivro = dto;
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		return consultarLivro;
	}

	private ArrayList<Autor> consultarAutoresLivros(Integer IdLivro,
			Connection conexao) throws SQLException {
		ArrayList<Integer> listaIdAutor = new ArrayList<Integer>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ID_AUTOR FROM TB_LIVRO_AUTOR WHERE ID_LIVRO = ?");
		PreparedStatement statement = conexao.prepareStatement(sql.toString());
		statement.setInt(1, IdLivro);
		ResultSet resultset = statement.executeQuery();
		while (resultset.next()) {
			listaIdAutor.add(resultset.getInt("ID_AUTOR"));
		}
		return consultarAutores(listaIdAutor, conexao);
	}

	private ArrayList<Autor> consultarAutores(ArrayList<Integer> idAutores,
			Connection conexao) throws SQLException {
		ArrayList<Autor> listaAutores = new ArrayList<Autor>();
		for (Integer idAutor : idAutores) {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_AUTOR WHERE ID_AUTOR = ?");

			PreparedStatement statement = conexao.prepareStatement(sql
					.toString());
			statement.setInt(1, idAutor);

			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Autor dto = new Autor();
				dto.setId_autor(resultset.getInt("ID_AUTOR"));
				dto.setNome(resultset.getString("NOME"));
				dto.setSobrenome(resultset.getString("SOBRENOME"));
				listaAutores.add(dto);
			}
		}
		return listaAutores;
	}

	public void alterarLivro (Livro livro) throws PersistenciaException, SQLException, ParseException {
		Connection conexao = null;
		
		try {

			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date dataCadastro = new java.sql.Date(utilDate.getTime());
					
				
			sql.append("UPDATE TB_LIVRO SET TITULO = ?,"
					+ " SUBTITULO = ?," + " DATA_CADASTRO = ?,"
					+ " PRECO = ?," + " LINGUA = ?," + " EDICAO = ?,"
					+ " ANO = ?," + " PAGINAS = ?," + " VIDEO = ?,"
					+ " CD_DVD = ?," + " E_BOOK = ?," + " DESCRICAO = ?,"
					+ " BRUXURA_REVISTA = ?," + " ID_EDITORA = ?,"
					+ " EXCLUIDO = ?" + " WHERE ID_LIVRO = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, livro.getTitulo());
			statement.setString(2, livro.getSubtitulo());
			statement.setDate(3, dataCadastro);
			statement.setLong(4, livro.getPreco());
			statement.setString(5, livro.getLingua());
			statement.setInt(6, livro.getEdicao());
			java.sql.Date anoLivro = new java.sql.Date(livro.getAno().getTime());
			statement.setDate(7, anoLivro);
			statement.setInt(8, livro.getPaginas());
			statement.setBoolean(9, livro.isVideo());
			statement.setBoolean(10, livro.isCd_dvd());
			statement.setBoolean(11, livro.isE_book());
			statement.setString(12, livro.getDescricao());
			statement.setBoolean(13, livro.getBruxura_revista());
			statement.setInt(14, livro.getEditora().getIdEditora());
			statement.setBoolean(15, false);
			statement.setString(16, livro.getCodigoISBN());

			statement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
	}

	public void removerLivro(Integer idLivro) throws PersistenciaException {
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE TB_LIVRO SET EXCLUIDO='1' WHERE ID_LIVRO = ?");

			PreparedStatement statement = conexao.prepareStatement(sql
					.toString());
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
