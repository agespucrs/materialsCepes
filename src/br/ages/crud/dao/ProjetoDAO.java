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

import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Projeto;
import br.ages.crud.util.ConexaoUtil;

public class ProjetoDAO {

	private List<Projeto> listaProjetos;

	public ProjetoDAO() {

		listaProjetos = new ArrayList<Projeto>();

	}
	
	/**
	 * Método responsável por salvar a marca no BD.
	 * 
	 * @param marca
	 * @throws PersistenciaException
	 * @throws SQLException
	 * @throws ParseException
	 */
	
	public void cadastrarProjeto(Projeto projeto) throws PersistenciaException, SQLException, ParseException {
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO TB_PROJETO (NOME_PROJETO,PROGRAMA,ORIGEM,DATA_CADASTRO,iD_CORDENADOR)");
			sql.append("VALUES (?,?,?,?,?)");

			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, projeto.getNome());
			statement.setString(2, projeto.getPrograma());
			statement.setString(3, projeto.getOrigem());
			statement.setDate(4,  (Date) projeto.getDataCadastro());
			statement.setInt(5, projeto.getIdCordenador());
			statement.executeUpdate();		

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
			sql.append("SELECT * FROM TB_PROJETOS");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				Projeto dto = new Projeto();
				dto.setId(resultset.getInt("ID_PROJETO"));
				dto.setNome(resultset.getString("NOME_PROJETO"));
				dto.setPrograma(resultset.getString("PROGRAMA"));
				dto.setOrigem(resultset.getString("ORIGEM"));
				dto.setDataCadastro(resultset.getDate("DATA_CADASTRO"));
				dto.setIdCordenador(resultset.getInt("ID_CORDENADOR"));

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
	
	public boolean removerProjeto(int id_projeto) throws PersistenciaException, SQLException{
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
	
	/**
	 * Método para remover um projeto.
	 * 
	 * @param id
	 * @return
	 * @throws PersistenciaException
	 * @throws SQLException
	 */
}
