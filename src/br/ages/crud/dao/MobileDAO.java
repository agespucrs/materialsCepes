package br.ages.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.util.ConexaoUtil;

public class MobileDAO {

	public List<String> listarTiposMobile() throws PersistenciaException, SQLException {
		StringBuilder sql = new StringBuilder();
		Connection conexao = null;
		List<String> listaTipos = new ArrayList<String>();

		try {
			conexao = ConexaoUtil.getConexao();

			sql.append("SELECT DISTINCT(TIPO_MOBILE)");
			sql.append(" FROM TB_MOBILE WHERE 1=1");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				String nome = resultset.getString("TIPO_MOBILE");
				listaTipos.add(nome);
			}

			return listaTipos;
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}

	}

}
