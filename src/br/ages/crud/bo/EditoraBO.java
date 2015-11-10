package br.ages.crud.bo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import br.ages.crud.dao.EditoraDAO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Editora;

public class EditoraBO {
	EditoraDAO editoraDAO = null;

	public EditoraBO() {
		editoraDAO = new EditoraDAO();
	}


	/**
	 * @throws NegocioException
	 * @throws SQLException
	 * @throws ParseException
	 */
	public void cadastraEditora(Editora editora) throws NegocioException, SQLException, ParseException {

		try {
			editoraDAO.cadastrarEditora(editora);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

	}

	/**
	 * @return
	 * @throws NegocioException
	*/
	public List<Editora> listarEditora() throws NegocioException   {

		List<Editora> listEditora = null;

		try {
			listEditora = editoraDAO.listarEditoras();
		} catch (PersistenciaException | SQLException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

		return listEditora;

	}
	
	/**
	 * @param idUsuario
	 * @throws NegocioException
	*/
	public void removerEditora(Integer idEditora) throws NegocioException {
		try {
			editoraDAO.removerEditora(idEditora);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}

}
