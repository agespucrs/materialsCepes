<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.Livro"%>
<%@page import="br.ages.crud.model.Autor"%>
<%@page import="br.ages.crud.model.CopiaLivro"%>
<%@page import="br.ages.crud.model.Idioma"%>
<%@page import="br.ages.crud.model.Editora"%>
<%@page import="br.ages.crud.util.Util"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	Livro livro = (Livro) request.getAttribute("livro");
	CopiaLivro copia = (CopiaLivro) request.getAttribute("copia");
%>

<jsp:include page="/template/head.jsp"></jsp:include>
<div class="panel panel-primary panel-addLivro">
	<div class="panel-heading text-center">Cadastro de Livros</div>
	<div class="panel-body">
		<jsp:include page="/template/msg.jsp"></jsp:include>
		<!-- <div class="table-responsive">	 -->
		<form action="main?acao=addLivro" method="post">
			<div class="form-group">

				<label class="form-label ages">Titulo: <span class="red">*</span></label>
				<input class="form-control" id="titulo" name="titulo"
					value="${param.titulo}" type="text" maxlength="120" required>

				<label class="form-label ages">Sub-Titulo: <span class="red">*</span></label>
				<input class="form-control" id="subtitulo" name="subtitulo"
					value="${param.subtitulo}" type="text" maxlength="120" required>
	
				<div class="row">
					<div class="col-sm-6">
						<label class="form-label ages">Autor: <span class="red">*</span></label>
						<div class="input-group">
							<select class="form-control" id="autor" name="autor" required>
							
								<option value="">Selecione Autor</option>
								
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
							<br />
							<div class="input-group-btn">
								<button class="btn btn-info" onclick="addAutor()">
									<span class="glyphicon glyphicon-plus"></span> Autor
								</button>
							</div>
							
						</div>
						<br />
					
					
						
					</div>
					<div class="col-sm-6">
						<label class="form-label ages">Editora: <span class="red">*</span></label>
						<div class="input-group">
							<select class="form-control" id="editora" name="editora" required>
								<option value="">Selecione Editora</option>
								<%
									List<Editora> listaEditora = (List<Editora>) request.getAttribute("editoras");
									int sizeListaEditoras = listaEditora.size();
									for (Editora editora : listaEditora) {
								%>
								<option value="<%=editora.getIdEditora()%>"
									<%=(editora.getNome()).equals(request.getParameter("editora")) ? "selected" : ""%>><%=editora.getNome()%></option>
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
					<div class="col-sm-6">
						<table id="listaLivros"
							class="table table-responsive table-striped table-hover table-condensed table-bordered">
							<thead>
							
								<tr>
									<th style="text-align: center;">Autor</th>
									<th style="text-align: center;">Remover</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
					<div class="col-sm-6"></div>
				</div>
				<div class="row">
					<div class="col-sm-4">
						<label class="form-label ages">Codigo Biblioteca: <span
							class="red">*</span></label> <input class="form-control" id="isbn"
							name="isbn" value="${param.isbn}" type="text" maxlength="120"
							required>
					</div>
					<div class="col-sm-4">
						<label class="form-label ages">Preço Aquisição: </label>
						<div class="input-group">
							<div class="input-group-btn">
								<a class="btn btn-default">R$</a>
							</div>
							<input class="preco form-control" id="preco" name="preco"
								value="${param.preco}" type="text" style="text-align: right;">
						</div>
					</div>
					<div class="col-sm-4">
						<label class="form-label ages">Lingua: </label> <select
							class="form-control" id="lingua" name="lingua" required>
							<%
								List<Idioma> listaLingua = (List<Idioma>) request.getAttribute("idiomas");
								for (Idioma l : listaLingua) {
							%>
							<option value="<%=l.getId()%>"><%=l.getNome()%>
							</option>
							<%
								}
								
							%>
						</select>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4">
						<label class="form-label ages">Edição: </label> <input
							class="form-control" id="edicao" name="edicao"
							value="${param.edicao}" type="text">
					</div>
					<div class="col-sm-4">
						<label class="form-label ages">Data Entrada: </label> <input
							class="form-control" id="ano" name="ano" value="${param.ano}"
							type="text" style="text-align: right;">
					</div>
					<div class="col-sm-4">
						<label class="form-label ages">Paginas: </label> <input
							class="form-control" id="paginas" name="paginas"
							value="${param.paginas}" type="text">
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<label class="checkbox-inline ages"><input type="checkbox"
							name="brochura" id="brochura" value="check">Brochura</label>
						<label class="checkbox-inline ages" value="check"><input type="checkbox"
							name="video" id="video" value = "check">Video</label> <label
							class="checkbox-inline ages" value="check"><input type="checkbox"
							name="cd_dvd" id ="cd_dvd"value="check">CD/DVD</label> <label
							class="checkbox-inline ages"><input type="checkbox"
							name="ebook" id="ebook" value="check">E-Book</label> <label
							class="checkbox-inline ages"><input type="checkbox"
							name="capaDuara" id="capaDuara" value="check">Capa Dura</label> <label
							class="checkbox-inline ages"><input type="checkbox"
							name="expiral" id="expiral" value="check">Expiral</label> <label
							class="checkbox-inline ages"><input type="checkbox"
							name="revista" value="check">Revista</label>
					</div>
				</div>
				<label class="form-label ages">Observação: </label>
				<textarea class="form-control" cols="80" rows="2" id="descricao"
					name="descricao" value="${param.descricao}"></textarea>
				<p>
					Campos que contém <span class="red">*</span> são obrigatórios
				</p>
			</div>
			<div class="text-center">
				<input class="btn btn-warning btn-limpar pull-left" type="reset"
					value="Limpar" id="limpar" name="limpar" /> <input
					class="btn btn-primary btn-add pull-right" type="submit" value="Cadastrar">
			</div>
		</form>
	</div>
</div>
<jsp:include page="/template/foot.jsp"></jsp:include>
<script type="text/javascript">
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
		$('.preco').mask('#.##0,00', {
			reverse : true
		});
		
		$( this ).on("click", "button#deleteCapitulo", function() {
			deleteCapitulo(this);
		});
	});
	
	
	
	//função atualizar tabela de autor
	function addAutor() {
			// guarda o nome do autor informado pelo usuário
			var e = document.getElementById("autor");
			var idAutor = e.value;
			console.log(idAutor);
			var strUser = e.options[e.selectedIndex].text;
			
			if(idAutor == null || idAutor == ""){
				alert("Inválido");
				return;
			}
			
			var contentToAppend = "	<tr >";
				contentToAppend+= "		<td style=text-align: center;\">" + strUser + "</td>";
				contentToAppend+= "		<td style=\"text-align: center;\">";
				contentToAppend+= "			<button type=\"button\" class=\"btn btn-default btn-xs\" title=\"Remover\" id=\"deleteCapitulo\">";
				contentToAppend+= "				<span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span>";
				contentToAppend+= "			</button>";
				contentToAppend+= "		</td>";
				contentToAppend+= "<input type='hidden' value='"+idAutor+"' id='autores' name='autores'/>";
				contentToAppend+= "	</tr>";
			
			$('#listaLivros > tbody:last-child')
				.append(contentToAppend);
			
	}
	
	//função que remove autor da tabela
	function deleteCapitulo(btn) {
			console.log(btn);
			// Busca a coluna pai do botão
			var td_Btn = $( btn ).parent();
			// Busca a linha pai da coluna do botão
			var tr_td_Btn = $( td_Btn ).parent();
			// Busca todas as colunas da linha do botão
			//var tds = $( tr_td_Btn ).children();
			// Seleciona apenas as colunas do numero do capítulo e do nome do capítulo
			//var capituloNumero = tds.eq(0).text();
			// Remove a linha da tabela
			$( tr_td_Btn ).remove();
			
			//arrNumeroCapitulos = jQuery.grep(arrNumeroCapitulos, function(value) {
			//  return value != strUser;
			//});
	}
	
</script>
