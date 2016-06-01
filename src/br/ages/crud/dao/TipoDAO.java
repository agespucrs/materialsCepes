package br.ages.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Marca;
import br.ages.crud.model.Tipo;
import br.ages.crud.model.TipoEquipamento;
import br.ages.crud.util.ConexaoUtil;

public class TipoDAO {

	private Connection conexao;

	public TipoDAO() {
		conexao = null;
	}

	public List<Tipo> consultarPeloTipo(TipoEquipamento tipo) throws PersistenciaException, SQLException {
		List<Tipo> lista = new ArrayList<Tipo>();

		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_TIPO WHERE ");
			sql.append("TIPO_EQUIPAMENTO = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setString(1, tipo.valor().toUpperCase());

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				Tipo dto = new Tipo();
				dto.setId(resultset.getInt("ID_TIPO"));
				dto.setNome(resultset.getString("NOME"));

				lista.add(dto);
			}

			return lista;
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}

	}
}
