package br.ages.crud.command;

import java.awt.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.AutorBO;
import br.ages.crud.bo.EditoraBO;
import br.ages.crud.bo.LivroBO;
import br.ages.crud.bo.UsuarioBO;
import br.ages.crud.model.Autor;
import br.ages.crud.model.Editora;
import br.ages.crud.model.Livro;
import br.ages.crud.model.Usuario;
import br.ages.crud.util.MensagemContantes;

public class AlterLivroCommand implements Command {


	private String proxima;

	private LivroBO livroBO;

	@Override
	public String execute(HttpServletRequest request) {
		this.livroBO = new LivroBO();
		this.proxima = "autor/alterLivro.jsp";

		Integer id_editora = Integer.parseInt(request.getParameter("editora"));
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String sobrenome = request.getParameter("sobrenome");
		String preco = request.getParameter("preco");
		String lingua = request.getParameter("lingua");
		String edicao = request.getParameter("edicao");
		String ano = request.getParameter("ano");
		String paginas = request.getParameter("paginas");
		String bruxuraRevista = request.getParameter("bruxuraRevista");
		String video = request.getParameter("video");
		String cddvd = request.getParameter("cd_dvd");
		String ebook = request.getParameter("ebook");
		String descricao = request.getParameter("descricao");
		Integer idLivro = Integer.parseInt(request.getParameter("id_livro"));
		
		try {
			
			Livro livro = new Livro();
			EditoraBO editoraBO = new EditoraBO();
			Editora editora = editoraBO.consultarEditora(id_editora);
			ArrayList<Autor> autores = new ArrayList<Autor>();
			
			livro.setEditora(editora);
			livro.setTitulo(titulo);
			
			
			livro.setIdLivro(idLivro);
			
			livroBO.alterarLivro(livro);
			proxima = "main?acao=listAutor";
			request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_ALTERADO_USUARIO.replace("?", livro.getTitulo()));

			
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
			//proxima = "main?acao=addUser";
		}

		return proxima;
	}
}
















