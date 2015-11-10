package br.ages.crud.command;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.EditoraBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.model.Editora;

public class ListEditoraCommand implements Command {

	private String proxima;
	private EditoraBO editoraBO;
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		this.editoraBO = new EditoraBO();
		proxima = "editora/listEditora.jsp";

		try {
			List<Editora> listaEditoras = editoraBO.listarEditora();
			request.setAttribute("listaEditoras", listaEditoras);
		} catch (NegocioException e) {
			e.printStackTrace();
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}

}
