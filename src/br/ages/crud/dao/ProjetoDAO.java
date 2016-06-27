package br.ages.crud.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Projeto;
import br.ages.crud.model.Usuario;
import br.ages.crud.model.UsuarioProjeto;
import br.ages.crud.util.ConexaoUtil;

public class ProjetoDAO {

	private List<Projeto> listaProjetos;

	public ProjetoDAO() {

		listaProjetos = new ArrayList<Projeto>();

	}

	public Projeto buscarProjeto(Integer id) throws PersistenciaException, SQLException, ParseException {
		Connection conexao = null;

		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_PROJETOS WHERE ID_PROJETO = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, id);

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				Projeto projeto = new Projeto();

				projeto.setId(resultset.getInt("ID_PROJETO"));
				projeto.setNomeProjeto(resultset.getString("NOME_PROJETO"));
				projeto.setPrograma(resultset.getString("PROGRAMA"));
				projeto.setOrigem(resultset.getString("ORIGEM"));
				projeto.setDataCadastro(resultset.getDate("DATA_CADASTRO"));
				projeto.setIdCoordenador(resultset.getInt("ID_CORDENADOR"));
				projeto.setUsuarios(new ArrayList<Usuario>());
				projeto.getUsuarios().addAll(new UsuarioDAO().consultarUsuariosProjeto(projeto.getId()));
				return projeto;
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}

		return null;
	}

	/**
	 * Método responsável por salvar a projeto no BD.
	 * 
	 * @param projeto
	 * @throws PersistenciaException
	 * @throws SQLException
	 * @throws ParseException
	 */

	public void cadastrarProjeto(Projeto projeto) throws PersistenciaException, SQLException, ParseException {
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			if (null != (Integer) projeto.getId()) {
				StringBuilder sql = new StringBuilder();
				sql.append("UPDATE TB_PROJETOS SET NOME_PROJETO = ?, PROGRAMA = ?, ORIGEM = ?, ID_CORDENADOR = ?");
				sql.append(" WHERE ID_PROJETO = ?");

				PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, projeto.getNomeProjeto());
				statement.setString(2, projeto.getPrograma());
				statement.setString(3, projeto.getOrigem());
				statement.setInt(4, projeto.getIdCoordenador());
				statement.setInt(5, projeto.getId());
				statement.executeUpdate();

			} else {
				StringBuilder sql = new StringBuilder();
				sql.append("INSERT INTO TB_PROJETOS (NOME_PROJETO,PROGRAMA,ORIGEM,DATA_CADASTRO,ID_CORDENADOR)");
				sql.append("VALUES (?,?,?,?,?)");

				Date data = new Date(System.currentTimeMillis());
				PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, projeto.getNomeProjeto());
				statement.setString(2, projeto.getPrograma());
				statement.setString(3, projeto.getOrigem());
				statement.setDate(4, data);
				// statement.setDate(4, (Date) projeto.getData_cadastro());
				statement.setInt(5, projeto.getIdCoordenador());
				statement.executeUpdate();
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
	}

	/**
	 * Método para consultar todos os projetos.
	 * 
	 * @return
	 * @throws PersistenciaException
	 * @throws SQLException
	 * @throws ParseException
	 */
	public List<Projeto> listarProjetos() throws PersistenciaException, SQLException, ParseException {

		Connection conexao = null;

		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_PROJETOS pr, TB_USUARIO usr WHERE pr.ID_CORDENADOR = usr.ID_USUARIO");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				Projeto dto = new Projeto();
				dto.setId(resultset.getInt("ID_PROJETO"));
				dto.setNomeProjeto(resultset.getString("NOME_PROJETO"));
				dto.setPrograma(resultset.getString("PROGRAMA"));
				dto.setOrigem(resultset.getString("ORIGEM"));
				dto.setDataCadastro(resultset.getDate("DATA_CADASTRO"));
				dto.setIdCoordenador(resultset.getInt("ID_CORDENADOR"));
				dto.setNomeCoordenador(resultset.getString("NOME"));
				dto.setUsuarios(new ArrayList<Usuario>());
				dto.getUsuarios().addAll(new UsuarioDAO().consultarUsuariosProjeto(dto.getId()));
				listaProjetos.add(dto);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}

		return listaProjetos;

	}

	/**
	 * Método para remover um projeto.
	 * 
	 * @param id
	 * @return
	 * @throws PersistenciaException
	 * @throws SQLException
	 */

	public boolean removerProjeto(int id_projeto) throws PersistenciaException, SQLException {
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM TB_PROJETOS WHERE ID_PROJETO = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, id_projeto);
			statement.executeUpdate();

			return true;

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}

	}

	public List<UsuarioProjeto> consultarUsuariosProjeto(Integer idProjeto) throws PersistenciaException, SQLException {

		Connection conexao = null;

		List<UsuarioProjeto> usuariosIntegrantes = new ArrayList<>();

		try {

			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append(
					"SELECT up.ID_USUARIO as ID_USUARIO, us.NOME as NOME, up.DATA_ALOCACAO as DATA_ALOCACAO FROM TB_USUARIO_PROJETO up, TB_USUARIO us "
							+ "WHERE up.ID_USUARIO = us.ID_USUARIO AND up.ID_PROJETO = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, idProjeto);

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				UsuarioProjeto dto = new UsuarioProjeto();
				dto.setIdUsuario(resultset.getInt("ID_USUARIO"));
				dto.setNomeUsuario(resultset.getString("NOME"));
				dto.setDataAlocacao(resultset.getDate("DATA_ALOCACAO"));
				usuariosIntegrantes.add(dto);
			}

		} catch (Exception e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}

		return usuariosIntegrantes;
	}

	public void removerUsuariosProjeto(Integer idProjeto) throws PersistenciaException, SQLException {

		Connection conexao = null;

		try {

			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM TB_USUARIO_PROJETO WHERE ID_PROJETO = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, idProjeto);

			statement.execute();

		} catch (Exception e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}

	}
	
	public void inserirUsuarioProjeto(UsuarioProjeto usuarioProjeto) throws NegocioException, SQLException, PersistenciaException{

		Connection conexao = null;

		try {

			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO TB_USUARIO_PROJETO (ID_USUARIO, ID_PROJETO, DATA_ALOCACAO)");
			sql.append("VALUES (?,?,?)");

			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, usuarioProjeto.getIdUsuario());
			statement.setInt(2, usuarioProjeto.getIdProjeto());
			statement.setDate(3, new Date(new java.util.Date().getTime()));

			statement.executeUpdate();

		} catch (Exception e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}

	}
}
