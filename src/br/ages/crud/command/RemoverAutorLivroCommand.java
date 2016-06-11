package br.ages.crud.command;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.AutorBO;
import br.ages.crud.util.MensagemContantes;

public class RemoverAutorLivroCommand implements Command {

	private String proximo;

	private AutorBO autorBO;

	@Override
	public String execute(HttpServletRequest request) {
		String idLivro = request.getParameter("idLivro");
		String idAutor = request.getParameter("idAutor");
		String idCopia = request.getParameter("idCopia");
		this.autorBO = new AutorBO();

		try {
			int idAutorInt = Integer.parseInt(idAutor);
			int idLivroInt = Integer.parseInt(idLivro);
			autorBO.removerAutoresLivro(idAutorInt, idLivroInt);
//			request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_REMOVE_AUTOR.replace("?", idAutor.toString()).concat("<br/>"));
			
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}
	
		
		
		proximo = "main?acao=telaLivro&id_livro="+idLivro+"+&id_copia="+idCopia+"&isEdit=sim";
		
		return proximo;
	}

}
