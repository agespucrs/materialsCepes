<%@page import="br.ages.crud.model.CopiaLivro"%>
<%@page import="br.ages.crud.model.Livro"%>
<%@page import="br.ages.crud.model.Autor"%>
<%@page import="br.ages.crud.model.Idioma"%>
<%@page import="br.ages.crud.model.Editora"%>
<%@page import="br.ages.crud.util.Util"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	Livro livro = (Livro) request.getAttribute("livro");
	CopiaLivro copia = (CopiaLivro) request.getAttribute("copia");
	//Idioma idioma = (Idioma) request.get
%>
<script type="text/javascript">
	function alterar() {
		//chamar funcao de verificar campos
		var formCadastro = document.forms[0];
		formCadastro.action = "main?acao=alterLivro&id_livro=<%=livro.getIdLivro()%>";
		formCadastro.submit();
	}
</script>
<jsp:include page="/template/head.jsp"></jsp:include>
<div class="panel panel-primary panel-addLivro">
	<div class="panel-heading text-center">Edição de Livro</div>
	<div class="panel-body"><jsp:include page="/template/msg.jsp"></jsp:include>

		<form action="main?acao=alterLivro&id_livro=<%=livro.getIdLivro()%>"
			method="post">
			<jsp:include page="/template/msg.jsp"></jsp:include>
			<div class="form-group">
				<label class="form-label ages">Titulo: <span class="red">*</span></label>
				<input class="form-control" id="titulo" name="titulo"
					value="<%=livro.getTitulo()%>" type="text" maxlength="120" required />

				<label class="form-label ages">Sub-Titulo: <span class="red">*</span></label>
				<input class="form-control" id="subtitulo" name="subtitulo"
					value="<%=livro.getSubtitulo()%>" type="text" maxlength="120"
					required>

				<div class="row">
					<div class="col-sm-6">
						<%
							int livroIdAutor = livro.getAutores().get(0).getId_autor();
						%>
						<%
							String livroNomeAutor = livro.getAutores().get(0).getNome();
						%>
						<label class="form-label ages">Autor: <span class="red">*</span></label>
						<div class="input-group">
							<select class="form-control" id="autor" name="autor" required>
								<option value="<%=livroIdAutor%>"><%=livroNomeAutor%></option>
								<%
									List<Autor> listaAutores = (List<Autor>) request.getAttribute("autores");
									int sizeListaAutores = listaAutores.size();
									for (Autor autor : listaAutores) {
								%>
								<option value="<%=autor.getId_autor()%>"
									<%=(autor.getNome() + " " + autor.getSobrenome()).equals(request.getParameter("autor"))
						? "selected"
						: ""%>><%=autor.getNome() + " " + autor.getSobrenome()%></option>
								<%
									}
								%>
							</select>
							<div class="input-group-btn">
								<a class="btn btn-info" href="" data-toggle="tooltip"
									title="Click aqui para adicionar um Autor!"><span
									class="glyphicon glyphicon-plus"></span> Autor </a>
							</div>
						</div>
					</div>
					<div class="col-sm-6">
						<label class="form-label ages">Editora: <span class="red">*</span></label>
						<div class="input-group">
							<select class="form-control" id="editora" name="editora" required>
								<option value="<%=livro.getLingua()%>"><%=livro.getEditora().getNome()%></option>
								<%
									List<Editora> listaEditora = (List<Editora>) request.getAttribute("editoras");
									int sizeListaEditoras = listaEditora.size();
									for (Editora editora : listaEditora) {
								%>
								<option value="<%=editora.getIdEditora()%>"
									<%=editora.getNome().equals(request.getParameter("editora")) ? "selected" : ""%>><%=editora.getNome()%></option>
								<%
									}
								%>
							</select>
							<div class="input-group-btn">
								<a class="btn btn-info" href="" data-toggle="tooltip"
									title="Click aqui para adicionar uma Editora!"><span
									class="glyphicon glyphicon-plus"></span> Editora</a>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4">
						<label class="form-label ages">Codigo Biblioteca: <span
							class="red">*</span></label> <input class="form-control" id="isbn"
							name="isbn" value="<%=copia.getCodigoIsbn()%>" type="text"
							maxlength="120" required>
					</div>
					<div class="col-sm-4">
						<label class="form-label ages">Preço Aquisição: </label>
						<div class="input-group">
							<div class="input-group-btn">
								<a class="btn btn-default">R$</a>
							</div>
							<input class="preco form-control" id="preco" name="preco"
								value="<%=livro.getPreco()%>" style="text-align: right;">
						</div>
					</div>
					<div class="col-sm-4">
						<label class="form-label ages">Lingua: </label> <select
							class="form-control" id="lingua" name="lingua" required>
							<%
								List<Idioma> listaLingua = (List<Idioma>) request.getAttribute("idiomas");
								for (Idioma l : listaLingua) {
									if (l.getId() == livro.getLingua()) {
							%>
							<option value="<%=l.getId()%>" selected><%=l.getNome()%>
							</option>
							<%
								} else {
							%>
							<option value="<%=l.getId()%>"><%=l.getNome()%>
							</option>
							<%
								}
								}
							%>
						</select>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4">
						<label class="form-label ages">Edição: </label> <input
							class="form-control" id="edicao" name="edicao"
							value="<%=livro.getEdicao()%>" type="text">
					</div>
					<div class="col-sm-4">
						<label class="form-label ages">Data Entrada: </label> <input
							class="form-control" id="ano" name="ano"
							value="<%=livro.getAno()%>" type="text"
							style="text-align: right;">
					</div>
					<div class="col-sm-4">
						<label class="form-label ages">Paginas: </label> <input
							class="form-control" id="paginas" name="paginas"
							value="<%=livro.getPaginas()%>" type="text">
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<label class="checkbox-inline ages"><input type="checkbox"
							name="brochura" value="<%=livro.getBrochura()%>">Brochura</label>
						<label class="checkbox-inline ages"><input type="checkbox"
							name="video" value="<%=livro.isVideo()%>">Video</label> <label
							class="checkbox-inline ages"><input type="checkbox"
							name="cd_dvd" value="<%=livro.isCd_dvd()%>">CD/DVD</label> <label
							class="checkbox-inline ages"><input type="checkbox"
							name="ebook" value="<%=livro.isE_book()%>">E-Book</label> <label
							class="checkbox-inline ages"><input type="checkbox"
							name="capaDura" value="">Capa Dura</label> <label
							class="checkbox-inline ages"><input type="checkbox"
							name="expiral" value="">Expiral</label> <label
							class="checkbox-inline ages"><input type="checkbox"
							name="revista" value="<%=livro.getRevista()%>">Revista</label>
					</div>
				</div>
				<label class="form-label ages">Observação: </label>
				<textarea class="form-control" cols="80" rows="2" id="descricao"
					name="descricao" value="${param.descricao}"></textarea>
			</div>
			<p>
				Campos que contém <span class="red">*</span> são obrigatórios
			</p>

			<div class="text-center">
				<input class="btn btn-warning btn-limpar pull-left" type="reset"
					value="Limpar"> <input
					class="btn btn-primary btn-add pull-right" type="submit"
					value="Cadastrar">
			</div>

			<input id="idCopia" type="hidden"
				value="<%=copia.getIdCopiaLivro()%>" />
		</form>
	</div>
</div>
<jsp:include page="/template/foot.jsp"></jsp:include>
<script>
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
		$('.preco').mask('#.##0,00', {
			reverse : true
		});
	});
</script>