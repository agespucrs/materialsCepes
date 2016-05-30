package br.ages.crud.bo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ages.crud.dao.LivroDAO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.CopiaLivro;
import br.ages.crud.model.Livro;
import br.ages.crud.util.MensagemContantes;
import br.ages.crud.validator.LoginValidator;
import br.ages.crud.validator.SenhaValidator;

public class LivroBO {

	LivroDAO livroDAO = null;

	public LivroBO() {
		livroDAO = new LivroDAO();
	}

	public boolean cadastrarLivro(Livro livro) throws NegocioException, SQLException, ParseException {

		try {
			return livroDAO.cadastrarLivro(livro);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

	}

	public List<Livro> listarLivro() throws NegocioException, ParseException {

		List<Livro> listLivro = null;

		try {
			listLivro = livroDAO.listarLivros();
		} catch (PersistenciaException | SQLException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

		return listLivro;

	}

	public List<Livro> listarCopia() throws NegocioException, ParseException {

		List<Livro> listLivro = null;

		try {
			listLivro = livroDAO.listarCopias();
		} catch (PersistenciaException | SQLException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

		return listLivro;

	}

	public Livro consultarLivro(Integer idLivro) throws NegocioException, SQLException, ParseException {
		Livro livro;
		try {
			livro = livroDAO.consultarLivro(idLivro);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
		return livro;
	}

	public void alterarLivro(Livro Livro) throws NegocioException, SQLException, ParseException {

		try {
			livroDAO.alterarLivro(Livro);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}

	public void removerLivro(Integer idLivro) throws NegocioException {
		try {
			livroDAO.removerLivro(idLivro);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}

	public void removerCopiaLivro(Integer idLivro) throws NegocioException {
		try {
			livroDAO.removerCopiaLivro(idLivro);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}

	public void cadastrarCopia(CopiaLivro copia) throws NegocioException {
		try {
			livroDAO.cadastrarCopia(copia);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}

	public void atualizarCopia(CopiaLivro copia) throws NegocioException {
		try {
			livroDAO.atualizarCopia(copia);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}

	public CopiaLivro buscarCopia(Integer id) throws NegocioException, SQLException {
		try {
			return livroDAO.buscarCopia(id);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}
}
