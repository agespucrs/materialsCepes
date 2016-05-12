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
import br.ages.crud.model.CopiaLivro;
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

	public boolean cadastrarLivro(Livro livro) throws PersistenciaException, SQLException, ParseException {

		Connection conexao = null;
		try {

			Integer idLivro = null;

			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();

			java.util.Date utilDate = new java.util.Date();
			java.sql.Date dataCadastro = new java.sql.Date(utilDate.getTime());

			if (consultaCodigoISBNExistente(livro, conexao)) {

				sql.append("UPDATE TB_LIVRO " + " SET TITULO = ?," + " SUBTITULO = ?," + " PRECO = ?,"
						+ " CODIGO_ISBN = ?," + " EDICAO = ?," + " ANO = ?," + " PAGINAS = ?," + " VIDEO = ?,"
						+ " CD_DVD = ?," + " E_BOOK = ?," + " BROCHURA = ?," + " DESCRICAO = ?," + " REVISTA = ?,"
						+ " WHERE CODIGO_ISBN = ?");

				PreparedStatement statement = conexao.prepareStatement(sql.toString());

				if (livroEstaExcluido(livro, conexao)) {
					statement.setString(1, livro.getTitulo());
					statement.setString(2, livro.getSubtitulo());
					statement.setLong(3, livro.getPreco());
					statement.setString(4, livro.getCodigoISBN());
					statement.setInt(5, livro.getEdicao());
					statement.setInt(6, livro.getAno());
					statement.setInt(7, livro.getPaginas());
					statement.setBoolean(8, livro.isVideo());
					statement.setBoolean(9, livro.isCd_dvd());
					statement.setBoolean(10, livro.isE_book());
					statement.setBoolean(11, livro.getBrochura());
					statement.setString(12, livro.getDescricao());
					statement.setBoolean(13, livro.getRevista());
					/**
					 * statement.setBoolean(15, false); statement.setInt(16,
					 * livro.getIdLivro());
					 */

					statement.executeUpdate();

					return true;
				} else {
					return false;
				}
				// END TO DO
			} else {
				sql.append(
						"INSERT INTO TB_LIVRO (TITULO, SUBTITULO, DATA_CADASTRO, PRECO, ID_IDIOMA, CODIGO_ISBN, EDICAO, ANO, PAGINAS, VIDEO, CD_DVD, E_BOOK, BROCHURA, DESCRICAO, ID_EDITORA, EXCLUIDO, REVISTA)");
				sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

				PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, livro.getTitulo());
				statement.setString(2, livro.getSubtitulo());
				statement.setDate(3, dataCadastro);
				statement.setLong(4, livro.getPreco());
				statement.setInt(5, livro.getLingua());
				statement.setString(6, livro.getCodigoISBN());
				statement.setInt(7, livro.getEdicao());
				statement.setInt(8, livro.getAno());
				statement.setInt(9, livro.getPaginas());
				statement.setBoolean(10, livro.isVideo());
				statement.setBoolean(11, livro.isCd_dvd());
				statement.setBoolean(12, livro.isE_book());
				statement.setBoolean(13, livro.getBrochura());
				statement.setString(14, livro.getDescricao());
				statement.setInt(15, livro.getEditora().getIdEditora());
				statement.setBoolean(16, livro.getStatus());
				statement.setBoolean(17, livro.getRevista());

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

	private boolean consultaCodigoISBNExistente(Livro livro, Connection conexao) throws SQLException {
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

	private boolean livroEstaExcluido(Livro livro, Connection conexao) throws SQLException {

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

	private void cadastraAutoresLivros(int IdLivro, ArrayList<Integer> idAutores, Connection conexao)
			throws SQLException {
		for (Integer idAutor : idAutores) {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO TB_LIVRO_AUTOR (ID_LIVRO, ID_AUTOR) VALUES (?,?)");
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, IdLivro);
			statement.setInt(2, idAutor);
			statement.executeUpdate();
		}
	}

	private List<Autor> consultarAutoresLivro(int idLivro) throws PersistenciaException, SQLException {
		List<Autor> lista = new ArrayList<Autor>();
		Connection conexao = null;

		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();

			sql.append("SELECT AUT.NOME as NOME, AUT.SOBRENOME as SOBRENOME FROM TB_AUTOR AUT, ");
			sql.append("TB_LIVRO_AUTOR LIV ");
			sql.append("WHERE AUT.ID_AUTOR = LIV.ID_AUTOR AND ");
			sql.append("LIV.ID_LIVRO = ? ");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());

			statement.setInt(1, idLivro);

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				Autor dto = new Autor();
				dto.setNome(resultset.getString("NOME"));
				dto.setSobrenome(resultset.getString("SOBRENOME"));
				lista.add(dto);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}

		return lista;
	}

	public List<Livro> listarCopias(int idLivro)
			throws PersistenciaException, SQLException, NegocioException, ParseException {

		Connection conexao = null;
		List<Livro> lista = new ArrayList<Livro>();

		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();

			sql.append("SELECT ID_LIVRO, TITULO, SUBTITULO, DATA_CADASTRO, PRECO, ID_IDIOMA, ");
			sql.append("CODIGO, EDICAO, ANO, PAGINAS, VIDEO, CD_DVD, E_BOOK, BROCHURA, DESCRICAO, ID_EDITORA, ");
			sql.append("EXCLUIDO, REVISTA FROM TB_LIVRO LI ");
			sql.append("INNER JOIN TB_LIVRO_COPIA LC ON LI.ID_LIVRO = LC.FK_ID_LIVRO ");
			sql.append("WHERE LI.ID_LIVRO = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());

			statement.setInt(1, idLivro);

			ResultSet resultset = statement.executeQuery();
			
			while (resultset.next()) {
				if (!resultset.getBoolean("EXCLUIDO")) {
					Livro dto = new Livro();
					dto.setTitulo(resultset.getString("TITULO"));
					EditoraBO editora = new EditoraBO();
					dto.setIdLivro(resultset.getInt("ID_LIVRO"));
					dto.setSubtitulo(resultset.getString("SUBTITULO"));
					dto.setDataCadastro(resultset.getDate("DATA_CADASTRO"));
					dto.setPreco(resultset.getLong("PRECO"));
					dto.setLingua(resultset.getInt("ID_IDIOMA"));
					dto.setCodigoISBN(resultset.getString("CODIGO"));
					dto.setEdicao(resultset.getInt("EDICAO"));
					dto.setAno(resultset.getInt("ANO"));
					dto.setPaginas(resultset.getInt("PAGINAS"));
					dto.setVideo(resultset.getBoolean("VIDEO"));
					dto.setCd_dvd(resultset.getBoolean("CD_DVD"));
					dto.setE_book(resultset.getBoolean("E_BOOK"));
					dto.setDescricao(resultset.getString("DESCRICAO"));
					dto.setBrochura(resultset.getBoolean("BROCHURA"));
					dto.setEditora(editora.consultarEditora(resultset.getInt("ID_EDITORA")));
					dto.setRevista(resultset.getBoolean("REVISTA"));
					dto.setAutores(consultarAutoresLivro(dto.getIdLivro()));
					lista.add(dto);
				}
			}

			return lista;

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		
	}

	public List<Livro> listarLivros() throws PersistenciaException, SQLException, NegocioException, ParseException {

		Connection conexao = null;

		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID_LIVRO, TITULO, SUBTITULO, DATA_CADASTRO, PRECO, ");
			sql.append("ID_IDIOMA, CODIGO_ISBN, EDICAO, ANO, PAGINAS, VIDEO, CD_DVD, ");
			sql.append("E_BOOK, BROCHURA, DESCRICAO, ID_EDITORA, EXCLUIDO, REVISTA ");
			sql.append("FROM TB_LIVRO");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				if (!resultset.getBoolean("EXCLUIDO")) {
					Livro dto = new Livro();
					dto.setTitulo(resultset.getString("TITULO"));
					EditoraBO editora = new EditoraBO();
					dto.setIdLivro(resultset.getInt("ID_LIVRO"));
					dto.setSubtitulo(resultset.getString("SUBTITULO"));
					dto.setDataCadastro(resultset.getDate("DATA_CADASTRO"));
					dto.setPreco(resultset.getLong("PRECO"));
					dto.setLingua(resultset.getInt("ID_IDIOMA"));
					dto.setCodigoISBN(resultset.getString("CODIGO_ISBN"));
					dto.setEdicao(resultset.getInt("EDICAO"));
					dto.setAno(resultset.getInt("ANO"));
					dto.setPaginas(resultset.getInt("PAGINAS"));
					dto.setVideo(resultset.getBoolean("VIDEO"));
					dto.setCd_dvd(resultset.getBoolean("CD_DVD"));
					dto.setE_book(resultset.getBoolean("E_BOOK"));
					dto.setDescricao(resultset.getString("DESCRICAO"));
					dto.setBrochura(resultset.getBoolean("BROCHURA"));
					dto.setEditora(editora.consultarEditora(resultset.getInt("ID_EDITORA")));
					dto.setRevista(resultset.getBoolean("REVISTA"));
					dto.setAutores(consultarAutoresLivro(dto.getIdLivro()));
					listarLivros.add(dto);

					List<Livro> copias = listarCopias(dto.getIdLivro());
					if (copias != null && copias.size() > 0) {
						listarLivros.addAll(copias);
					}
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		return listarLivros;
	}

	public Livro consultarLivro(Integer idLivro)
			throws PersistenciaException, SQLException, NegocioException, ParseException {

		Connection conexao = null;

		try {

			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_LIVRO WHERE ID_LIVRO = ? ");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
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
				dto.setLingua(resultset.getInt("ID_IDIOMA"));
				dto.setCodigoISBN(resultset.getString("CODIGO_ISBN"));
				dto.setEdicao(resultset.getInt("EDICAO"));
				dto.setAno(resultset.getInt("ANO"));
				dto.setPaginas(resultset.getInt("PAGINAS"));
				dto.setVideo(resultset.getBoolean("VIDEO"));
				dto.setCd_dvd(resultset.getBoolean("CD_DVD"));
				dto.setE_book(resultset.getBoolean("E_BOOK"));
				dto.setBrochura(resultset.getBoolean("BROCHURA"));
				dto.setDescricao(resultset.getString("DESCRICAO"));
				dto.setEditora(editora.consultarEditora(resultset.getInt("ID_EDITORA")));
				dto.setExcluido(resultset.getBoolean("EXCLUIDO"));
				dto.setRevista(resultset.getBoolean("REVISTA"));
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

	private ArrayList<Autor> consultarAutoresLivros(Integer IdLivro, Connection conexao) throws SQLException {
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

	private ArrayList<Autor> consultarAutores(ArrayList<Integer> idAutores, Connection conexao) throws SQLException {
		ArrayList<Autor> listaAutores = new ArrayList<Autor>();
		for (Integer idAutor : idAutores) {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_AUTOR WHERE ID_AUTOR = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
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

	public void alterarLivro(Livro livro) throws PersistenciaException, SQLException, ParseException {
		Connection conexao = null;

		try {

			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();

			// java.util.Date utilDate = new java.util.Date();
			// java.sql.Date dataCadastro = new
			// java.sql.Date(utilDate.getTime());

			sql.append("UPDATE TB_LIVRO SET TITULO = ?," + " SUBTITULO = ?," + " PRECO = ?," + " LINGUA = ?,"
					+ " EDICAO = ?," + " ANO = ?," + " PAGINAS = ?," + " VIDEO = ?," + " CD_DVD = ?," + " E_BOOK = ?,"
					+ " DESCRICAO = ?," + " BROCHURA = ?," + " ID_EDITORA = ?," + " EXCLUIDO = ?" + " REVISTA = ?"
					+ " WHERE ID_LIVRO = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, livro.getTitulo());
			statement.setString(2, livro.getSubtitulo());
			// statement.setDate(3, dataCadastro);
			statement.setLong(3, livro.getPreco());
			statement.setInt(4, livro.getLingua());
			statement.setInt(5, livro.getEdicao());
			statement.setInt(6, livro.getAno());
			statement.setInt(7, livro.getPaginas());
			statement.setBoolean(8, livro.isVideo());
			statement.setBoolean(9, livro.isCd_dvd());
			statement.setBoolean(10, livro.isE_book());
			statement.setString(11, livro.getDescricao());
			statement.setBoolean(12, livro.getBrochura());
			statement.setInt(13, livro.getEditora().getIdEditora());
			statement.setBoolean(14, false);
			statement.setBoolean(15, livro.getRevista());
			statement.setInt(16, livro.getIdLivro());

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

	public void cadastrarCopia(CopiaLivro copia) throws PersistenciaException {
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO TB_LIVRO_COPIA (FK_ID_LIVRO, CODIGO) VALUES (?, ?)");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, copia.getIdLivro());
			statement.setString(2, copia.getCodigo_isbn());
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
