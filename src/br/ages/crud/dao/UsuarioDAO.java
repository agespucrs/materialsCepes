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
import br.ages.crud.model.Usuario;
import br.ages.crud.util.ConexaoUtil;

import com.mysql.jdbc.Statement;

/**
 * 
 * @author C�ssio Trindade
 *
 */
public class UsuarioDAO {

	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	private ArrayList<Usuario> listarUsuarios;

	public UsuarioDAO() {
		listarUsuarios = new ArrayList<>();
	}

	/**
	 * Autentica o usu�rio
	 * 
	 * @author cassio trindade
	 * @param usuarioDTO
	 * @return
	 * @throws PersistenciaException
	 */

	public boolean validarUsuario(Usuario usuarioDTO) throws PersistenciaException {
		try {
			Connection conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_USUARIO ");
			sql.append("WHERE USUARIO = ? AND SENHA = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setString(1, usuarioDTO.getUsuario());
			statement.setString(2, usuarioDTO.getSenha());

			ResultSet resultSet = statement.executeQuery();
			return resultSet.next();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}

	}

	/**
	 * Lista os Usuarios da basee
	 * 
	 * @return
	 * @throws PersistenciaException
	 * @throws SQLException
	 */
	public List<Usuario> listarUsuarios() throws PersistenciaException, SQLException {
		Connection conexao = null;

		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_USUARIO");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				Usuario dto = new Usuario();
				dto.setIdUsuario(resultset.getInt("ID_USUARIO"));
				dto.setMatricula(resultset.getString("MATRICULA"));
				dto.setNome(resultset.getString("NOME"));
				dto.setEmail(resultset.getString("EMAIL"));
				dto.setUsuario(resultset.getString("USUARIO"));
				dto.setSenha(resultset.getString("SENHA"));
				dto.setAdministrador(resultset.getInt("ADMINISTRADOR"));

				listarUsuarios.add(dto);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		return listarUsuarios;
	}

	public void alterarUsuario(Usuario usuario) throws PersistenciaException, SQLException, ParseException {
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append(
					"UPDATE TB_USUARIO SET USUARIO = ?, SENHA = ?, MATRICULA = ?, NOME = ?, EMAIL = ?, ADMINISTRADOR = ?, ID_FUNCAO = ? ");
			sql.append("WHERE ID_USUARIO = ?;");

			// altera o usuario com os parametros da classe
			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, usuario.getUsuario());
			statement.setString(2, usuario.getSenha());
			statement.setString(3, usuario.getMatricula());
			statement.setString(4, usuario.getNome());
			statement.setString(5, usuario.getEmail());
			statement.setInt(6, usuario.getAdministrador());
			statement.setInt(7, usuario.getIdFuncao());
			statement.setInt(8, usuario.getIdUsuario());

			statement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
	}

	public void cadastrarUsuario(Usuario usuario) throws PersistenciaException, SQLException, ParseException {
		Connection conexao = null;
		try {
			Integer idUsuario = null;

			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append(
					"INSERT INTO TB_USUARIO (USUARIO, SENHA, CPF, ADMINISTRADOR, MATRICULA, NOME, EMAIL, DATA_CADASTRO, ID_FUNCAO) ");
			sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? )");

			// converte a data para data Juliana, data que o banco reconhece;
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date dataCadastro = new java.sql.Date(utilDate.getTime());

			// Cadastra a pessoa e gera e busca id gerado
			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, usuario.getUsuario());
			statement.setString(2, usuario.getSenha());
			statement.setString(3, usuario.getCpf());
			statement.setInt(4, usuario.getAdministrador());
			statement.setString(5, usuario.getMatricula());
			statement.setString(6, usuario.getNome());
			statement.setString(7, usuario.getEmail());
			statement.setDate(8, dataCadastro);
			statement.setInt(9, usuario.getIdFuncao());

			statement.executeUpdate();

			ResultSet resultset = statement.getGeneratedKeys();
			if (resultset.first()) {
				idUsuario = resultset.getInt(1);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
	}

	/**
	 * M�todo de remo��o de um usu�rio a partir do seu id.
	 * 
	 * @param idPessoa
	 * @throws PersistenciaException
	 */
	public void removerUsuario(Integer idUsuario) throws PersistenciaException {
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM TB_USUARIO WHERE ID_USUARIO= ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, idUsuario);

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

	public Usuario consultaUsuario(String idUsuario) throws PersistenciaException, SQLException {
		Connection conexao = null;
		Usuario usuario = new Usuario();
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_USUARIO WHERE ID_USUARIO = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setString(1, idUsuario);

			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				usuario.setIdUsuario(resultset.getInt("ID_USUARIO"));
				usuario.setMatricula(resultset.getString("MATRICULA"));
				usuario.setNome(resultset.getString("NOME"));
				usuario.setEmail(resultset.getString("EMAIL"));
				usuario.setUsuario(resultset.getString("USUARIO"));
				usuario.setSenha(resultset.getString("SENHA"));
				usuario.setAdministrador(resultset.getInt("ADMINISTRADOR"));
				usuario.setIdFuncao(resultset.getInt("ID_FUNCAO"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		return usuario;
	}
	
	public List<Usuario> consultarUsuariosProjeto(Integer idProjeto) throws PersistenciaException, SQLException {
		List<Usuario> retorno = new ArrayList<>();
		
		Connection conexao = null;
		Usuario usuario = new Usuario();
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_USUARIO us, TB_USUARIO_PROJETO up"
					+ " WHERE us.ID_USUARIO = up.ID_USUARIO"
					+ " AND up.ID_PROJETO = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, idProjeto);

			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				usuario = new Usuario();
				usuario.setIdUsuario(resultset.getInt("ID_USUARIO"));
				usuario.setMatricula(resultset.getString("MATRICULA"));
				usuario.setNome(resultset.getString("NOME"));
				usuario.setEmail(resultset.getString("EMAIL"));
				usuario.setUsuario(resultset.getString("USUARIO"));
				usuario.setSenha(resultset.getString("SENHA"));
				usuario.setAdministrador(resultset.getInt("ADMINISTRADOR"));
				usuario.setIdFuncao(resultset.getInt("ID_FUNCAO"));
				retorno.add(usuario);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		
		return retorno;
		
	}
	
	public List<Usuario> consultarCoordenadores() throws PersistenciaException, SQLException {
		Connection conexao = null;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID_USUARIO, NOME FROM TB_USUARIO WHERE ID_FUNCAO = 1");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());

			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(resultset.getInt("ID_USUARIO"));
				usuario.setNome(resultset.getString("NOME"));
				usuarios.add(usuario);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		return usuarios;
	}
}
