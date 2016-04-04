package br.ages.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Computador;
import br.ages.crud.util.ConexaoUtil;

public class ComputadorDAO {

	public boolean cadastrarComputador(Computador computador) throws PersistenciaException, SQLException, ParseException {
		Connection conexao = null;
		boolean valorDeRetorno = false;
		try {
			Integer idEquipamento = null;
			conexao = ConexaoUtil.getConexao();

			//inicio de transacao
			
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO TB_EQUIPAMENTO ");
			sql.append("(N_PATRIMONIO, STATUS, MODELO, VALOR_AQUISICAO, DATA_CADASTRO, OBSERVACAO, ID_MARCA, ID_PROJETO) ");
			sql.append("VALUES ");
			sql.append("(           ?,      ?,      ?,               ?,             ?,          ?,        ?,          ?)");

			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, computador.getNumeroPatrimonio());
			statement.setString(2, computador.getStatus());
			statement.setString(3, computador.getModelo());
			statement.setString(4, computador.getValor());
			statement.setString(5, computador.getDataCadastro());
			statement.setString(6, computador.getObservacoes());
			statement.setString(7, computador.getMarca());
			statement.setString(8, computador.getProjeto());
			
			statement.executeUpdate();

			ResultSet resultset = statement.getGeneratedKeys();
			if (resultset.first()) {
				idEquipamento = resultset.getInt(1);
				
				sql = new StringBuilder();
				sql.append("INSERT INTO TB_COMPUTADOR ");
				sql.append("(ID_EQUIPAMENTO, TIPO_COMPUTADOR) ");
				sql.append("VALUES ");
				sql.append("(             ?,               ?)");
				
				statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, idEquipamento);
				statement.setString(2, computador.getTipoComputador());
				
				statement.executeUpdate();
				
				resultset = statement.getGeneratedKeys();
				if(resultset.first()) {
					//commit da transacao
					valorDeRetorno = true;
				}
				//else
					//rollback
			}
			//else
				//rollback

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		
		return valorDeRetorno;
	}

	public List<Computador> listarComputadores() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean alterarComputador(Computador computador) throws PersistenciaException, SQLException, ParseException {
		Connection conexao = null;
		boolean valorDeRetorno = false;
		try {
			Integer idEquipamento = null;
			conexao = ConexaoUtil.getConexao();
			
			//inicio de transacao
			
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE TB_EQUIPAMENTO ");
			sql.append("SET N_PATRIMONIO = ?, ");
			sql.append("SET STATUS = ?, ");
			sql.append("SET MODELO = ?, ");
			sql.append("SET VALOR_AQUISICAO = ?, ");
			sql.append("SET DATA_CADASTRO = ?, ");
			sql.append("SET OBSERVACAO = ?, ");
			sql.append("SET ID_MARCA = ?, ");
			sql.append("SET ID_PROJETO = ? ");
			sql.append("WHERE ID_EQUIPAMENTO = ?");
			
			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, computador.getNumeroPatrimonio());
			statement.setString(2, computador.getStatus());
			statement.setString(3, computador.getModelo());
			statement.setString(4, computador.getValor());
			statement.setString(5, computador.getDataCadastro());
			statement.setString(6, computador.getObservacoes());
			statement.setString(7, computador.getMarca());
			statement.setString(8, computador.getProjeto());
			statement.setInt(9, computador.getId());
			statement.executeUpdate();
		
			ResultSet resultset = statement.getGeneratedKeys();
			if (resultset.first()) {
				idEquipamento = resultset.getInt(1);
				
				sql = new StringBuilder();
				sql.append("UPDATE TB_COMPUTADOR ");
				sql.append("SET TIPO_COMPUTADOR = ? ");
				sql.append("WHERE ID_EQUIPAMENTO = ?");
				
				statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, computador.getTipoComputador());
				statement.setInt(2, idEquipamento);
				statement.executeUpdate();
				
				resultset = statement.getGeneratedKeys();
				if(resultset.first()) {
					//commit da transacao
					valorDeRetorno = true;
				}
				//else
					//rollback
			}
			//else
				//rollback
		
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		
		return valorDeRetorno;
	}

}
