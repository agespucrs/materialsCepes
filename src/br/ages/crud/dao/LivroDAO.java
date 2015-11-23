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

import com.mysql.jdbc.Statement;

public class LivroDAO {

	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	private ArrayList<Livro> listarLivros;
	private Livro consultarLivro;

	public LivroDAO() {
		listarLivros = new ArrayList<>();
	}

	public void cadastrarLivro(Livro livro) throws PersistenciaException,
			SQLException, ParseException {

		Connection conexao = null;
		try {

			Integer idLivro = null;

			conexao = ConexaoUtil.getConexao();

			if (consultaCodigoISBNExistente(livro, conexao)) {

			} else {
				StringBuilder sql = new StringBuilder();

				sql.append("INSERT INTO TB_LIVRO (TITULO, SUBTITULO, DATA_CADASTRO, PRECO, LINGUA, CODIGO_ISBN, EDICAO, ANO, PAGINAS, VIDEO, CD_DVD, E_BOOK, DESCRICAO, BRUXURA_REVISTA, ID_EDITORA, EXCLUIDO)");
				sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

				java.util.Date utilDate = new java.util.Date();
				java.sql.Date dataCadastro = new java.sql.Date(
						utilDate.getTime());

				PreparedStatement statement = conexao.prepareStatement(
						sql.toString(), Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, livro.getTitulo());
				statement.setString(2, livro.getSubtitulo());
				statement.setDate(3, dataCadastro);
				statement.setLong(4, livro.getPreco());
				statement.setString(5, livro.getLingua());
				statement.setString(6, livro.getCodigoISBN());
				statement.setInt(7, livro.getEdicao());
				java.sql.Date anoLivro = new java.sql.Date(livro.getAno()
						.getTime());
				statement.setDate(8, anoLivro);
				statement.setInt(9, livro.getPaginas());
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
			SQLException {

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
				consultarLivro = dto;
			}

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
