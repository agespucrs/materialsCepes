package br.ages.crud.bo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ages.crud.dao.AutorDAO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Autor;
import br.ages.crud.model.Editora;
import br.ages.crud.util.MensagemContantes;
import br.ages.crud.validator.LoginValidator;
import br.ages.crud.validator.SenhaValidator;

/**
 * Gerencia os comportamentos de negócio do Usuário Associa os parâmetros da
 * tela as propriedades da classe
 * 
 * @author Cássio Trindade
 * 
 */
public class AutorBO {
	AutorDAO autorDAO = null;

	public AutorBO() {
		autorDAO = new AutorDAO();
	}


	/**
	 * @param pessoaDTO
	 * @throws NegocioException
	 * @throws SQLException
	 * @throws ParseException
	 */
	public void cadastraAutor(Autor autor) throws NegocioException, SQLException, ParseException {

		try {
			autorDAO.cadastrarAutor(autor);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

	}

	/**
	 * @return
	 * @throws NegocioException
	 */
	public List<Autor> listarAutor() throws NegocioException   {

		List<Autor> listAutor = null;

		try {
			listAutor = autorDAO.listarAutores();
		} catch (PersistenciaException | SQLException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

		return listAutor;

	}
	/**
	 * @param idUsuario
	 * @throws NegocioException
	 */
	public void removerAutor(Integer idAutor) throws NegocioException {
		try {
			autorDAO.removerAutor(idAutor);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}

	public Autor consultarAutor(Integer idAutor) throws NegocioException, SQLException, ParseException {
		Autor autor;
		try {
			autor = autorDAO.consultarAutor(idAutor);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
		return autor;
	}
	
	public ArrayList<Autor> consultarAutores(ArrayList<Integer> idAutores) throws NegocioException, SQLException, ParseException {
		ArrayList<Autor> autores;
		try {
			autores = autorDAO.consultarAutores(idAutores);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
		return autores;
	}


	public void alterarAutor(Autor autor) throws NegocioException, SQLException, ParseException {

		try {
			autorDAO.alterarAutor(autor);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

	}
	
}
