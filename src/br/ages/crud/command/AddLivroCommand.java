package br.ages.crud.command;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.LivroBO;
import br.ages.crud.model.Livro;
import br.ages.crud.util.MensagemContantes;

public class AddLivroCommand implements Command {


	private String proxima;

	private LivroBO livroBO;

	@Override
	public String execute(HttpServletRequest request) throws ParseException {
		
		livroBO = new LivroBO();
		proxima = "cadastrarLivro.jsp";

		String titulo = request.getParameter("Titulo");
		String subtitulo = request.getParameter("Subtitulo");
		Date dataCadastro = new Date();
		long preco = Long.parseLong(request.getParameter("Preco"));
		String lingua = request.getParameter("Lingua");
		String codigoISBN = request.getParameter("Codigo_Isbn");
		Integer edicao = Integer.parseInt(request.getParameter("Edicao"));
		
		String strano = request.getParameter("ano");
		SimpleDateFormat sdano = new SimpleDateFormat("yyyy");
		Date ano = sdano.parse(strano);
		
		Integer paginas = Integer.parseInt(request.getParameter("Paginas"));
		Boolean video = Boolean.valueOf(request.getParameter("video"));
		Boolean cd_dvd = Boolean.valueOf(request.getParameter("cd_dvd"));
		Boolean e_book = Boolean.valueOf(request.getParameter("E_book"));
		String descricao = request.getParameter("descricao");
		String bruxura_revista = request.getParameter("bruxura_revista");
		
		try {
			
			Livro livro = new Livro();
			livro.setTitulo(titulo);
			livro.setSubtitulo(subtitulo);
			livro.setDataCadastro(dataCadastro);
			livro.setPreco(preco);
			livro.setLingua(lingua);
			livro.setCodigoISBN(codigoISBN);
			livro.setEdicao(edicao);
			livro.setAno(ano);
			livro.setPaginas(paginas);
			livro.setVideo(video);
			livro.setCd_dvd(cd_dvd);
			livro.setE_book(e_book);
			livro.setDescricao(descricao);
			livro.setBruxura_revista(bruxura_revista);
			
			/*boolean isValido = usuarioBO.validaCadastroUsuarioA(user);
			if (!isValido) {
				request.setAttribute("msgErro", MensagemContantes.MSG_ERR_USUARIO_DADOS_INVALIDOS);
			} else { // cadastro de pessoa com sucesso*/
				livroBO.cadastraLivro(livro);
				proxima = "main?acao=listUser";
				request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_CADASTRO_USUARIO.replace("?", livro.getTitulo()));
			/**/
			
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
			//proxima = "main?acao=addUser";
		}
		return proxima;
	}
}

