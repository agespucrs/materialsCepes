package br.ages.crud.command;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.ProjetoBO;
import br.ages.crud.bo.UsuarioBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.model.Autor;
import br.ages.crud.model.Projeto;

public class CreateScreenProjetoCommand implements Command {

	public String execute(HttpServletRequest request) throws SQLException, NegocioException, ParseException {
		
		String proxima = "";
		
		try {
			// Verifica se abre tela edição de autor ou de adição de autor.
			String isEdit = request.getParameter("isEdit");
			
			UsuarioBO usuarioBO = new UsuarioBO();
			request.setAttribute("listaCoordenadores", usuarioBO.consultarCoordenadores());
			
			if (isEdit != null && "sim".equals(isEdit)) {
				int idProjeto = Integer.parseInt(request.getParameter("id"));
				
				// Criar funçao AutorDAO.consultarAutor(int autorId)
				Projeto projeto = new ProjetoBO().buscarProjeto(idProjeto);
				request.setAttribute("projeto", projeto);
				
				proxima = "projeto/alterProjeto.jsp";
			} else {
				proxima = "projeto/addProjeto.jsp";
			}

			} catch (Exception e) {
				request.setAttribute("msgErro", e.getMessage());
			}
		
		return proxima;
	}
	

}
