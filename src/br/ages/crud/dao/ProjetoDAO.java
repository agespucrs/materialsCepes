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
import br.ages.crud.model.Marca;
import br.ages.crud.model.Projeto;
import br.ages.crud.util.ConexaoUtil;

public class ProjetoDAO {

	private List<Projeto> listaProjeto;

	public ProjetoDAO() {

		listaProjeto = new ArrayList<Projeto>();

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
			sql.append("VALUES (?)");

			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, projeto.getNome_projeto());
			statement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
	}
}
