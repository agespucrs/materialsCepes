package br.ages.crud.command;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.AutorBO;
import br.ages.crud.bo.LivroBO;
import br.ages.crud.dao.LivroDAO;
import br.ages.crud.bo.EditoraBO;
import br.ages.crud.model.Editora;
import br.ages.crud.model.Livro;
import br.ages.crud.model.Autor;
import br.ages.crud.util.MensagemContantes;

public class AddLivroCommand implements Command {

	private String proxima;

	private LivroBO livroBO;
	private EditoraBO editoraBO;
	private AutorBO autorBO;

	@Override
	public String execute(HttpServletRequest request) throws ParseException {

		livroBO = new LivroBO();
		editoraBO = new EditoraBO();
		autorBO = new AutorBO();
		proxima = "livro/addLivro.jsp";

		String titulo = request.getParameter("titulo");
		String subtitulo = request.getParameter("subtitulo");

		String sPreco = (request.getParameter("preco"));
		Float preco = (float) (sPreco.isEmpty() ? 0.0 : Float.parseFloat(sPreco.replace(".", "").replace(",", "."))); 

		String sLingua = (request.getParameter("lingua"));
		Integer lingua = sLingua.equals("") ? null : Integer.parseInt(sLingua);
		
		String codigoISBN = request.getParameter("isbn");

		String sEdicao = (request.getParameter("edicao"));
		Integer edicao = sEdicao.equals("") ? null : Integer.parseInt(sEdicao);

		String sAno = (request.getParameter("ano"));
		Integer ano = sAno.equals("") ? null : Integer.parseInt(sAno);

		String sPaginas = (request.getParameter("paginas"));
		Integer paginas = sPaginas.equals("") ? null : Integer.parseInt(sPaginas);
		
		String descricao = request.getParameter("descricao");
		
		Boolean brochura = isChecked(request.getParameter("brochura"));
		Boolean revista = isChecked(request.getParameter("revista"));
		Boolean video = isChecked(request.getParameter("video")); 
		Boolean cd_dvd = isChecked(request.getParameter("cd_dvd")); 
		Boolean e_book = isChecked(request.getParameter("ebook")); 
		Boolean expiral = isChecked(request.getParameter("expiral")); 
		Boolean dura = isChecked(request.getParameter("dura")); 
		

		// Object receptor
		Integer idEditora = Integer.parseInt(request.getParameter("editora"));
		ArrayList<Integer> idAutores = new ArrayList<Integer>();
		
		try {

			Livro livro = new Livro();
			livro.setTitulo(titulo);
			livro.setSubtitulo(subtitulo);
			livro.setPreco(preco);
			livro.setLingua(lingua);
			livro.setCodigoISBN(codigoISBN);
			livro.setEdicao(edicao);
			livro.setAno(ano);
			livro.setPaginas(paginas);
			livro.setDescricao(descricao);
			livro.setBrochura(brochura);
			livro.setVideo(video);
			livro.setCdDvd(cd_dvd);
			livro.seteBook(e_book);
			livro.setRevista(revista);
			livro.setExpiral(expiral);
			livro.setDura(dura);
			Editora editora = editoraBO.consultarEditora(idEditora);
			livro.setEditora(editora);
			
			ArrayList<Integer> listaIds = new ArrayList<>();
			String[] autores = request.getParameterValues("autores");
			
			for (String autor : autores){
				Integer idAutor = Integer.parseInt(autor);
				
				if (listaIds.contains(idAutor));
					listaIds.add(idAutor);
			}
			
			ArrayList<Autor> autoresBanco = autorBO.consultarAutores(listaIds);
			
			livro.setAutores(autoresBanco);

			/*
			 * boolean isValido = usuarioBO.validaCadastroUsuarioA(user); if
			 * (!isValido) { request.setAttribute("msgErro",
			 * MensagemContantes.MSG_ERR_USUARIO_DADOS_INVALIDOS); } else { //
			 * cadastro de pessoa com sucesso
			 */

			if (livroBO.cadastrarLivro(livro)) {
				
				proxima = "main?acao=listLivro";
				request.setAttribute("msgSucesso",
						MensagemContantes.MSG_SUC_CADASTRO_LIVRO.replace("?", livro.getTitulo()));
			} else {
				proxima = "main?acao=addLivro";
				request.setAttribute("msgErro",
						MensagemContantes.MSG_ERR_CADASTRO_LIVRO_EXISTENTE.replace("?", livro.getTitulo()));
			}
			/**/

		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
			// proxima = "main?acao=addUser";
		}
		return proxima;
	}

	public boolean isNulo(HttpServletRequest request, String parameter) {
		return request.getParameter(parameter) == null;
	}
	
	private Boolean isChecked (String value) {
		return null != value && "check".equals(value);
	}
}
