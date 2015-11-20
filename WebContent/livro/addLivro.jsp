<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.Livro"%>
<%@page import="br.ages.crud.model.Autor"%>
<%@page import="br.ages.crud.model.Editora"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="./css/comum.css" />
		<title>AgES - Adds</title>
		<script type="text/javascript">
		
			function cadastrar() {
				var formCadastro = document.forms[0]; 
				formCadastro.action ="main?acao=addLivro";
				formCadastro.submit();
			}
		
		</script>
</head>
<body>
	<jsp:include page="/template/head.jsp"></jsp:include>
	<h1>Cadastro Livro</h1>
	<div class="main">
		<form action="" method="post">
			<jsp:include page="/template/msg.jsp"></jsp:include>
			<fieldset>
				<table cellpadding="5">
					<tr>
						<td>Autor</td>
						<td>
							<select id="autor" name="autor">
							<%
								List<Autor> listaAutores = (List<Autor>) request.getAttribute("autores");
								int sizeListaAutores = listaAutores.size();
								for (Autor autor: listaAutores) {
							%>
									<option value="<%=autor.getId_autor() %>"><%=autor.getNome()+" "+autor.getSobrenome()%></option>			
							<%
								}
							%>
							</select>
						</td>
					</tr>
					<tr>
						<td>Editora</td>
						<td>
							<select id="editora" name="editora">
							<%
								List<Editora> listaEditora = (List<Editora>) request.getAttribute("editoras");
								int sizeListaEditoras = listaEditora.size();
								for (Editora editora: listaEditora) {
							%>
									<option value="<%=editora.getIdEditora()%>"><%=editora.getNome()%></option>			
							<%
								}
							%>
							</select>
						</td>
					</tr>
					<tr>
						<td>Código ISBN <sup class="red">*</sup></td>
						<td><input type="text" id="isbn" name="isbn" maxlength="13" value="${param.codigoISBN}" required/></td> 
					</tr>
					<tr>
						<td>Título <sup class="red">*</sup></td>
						<td><input type="text" id="titulo" name="titulo" maxlength="120" value="${param.titulo}" required/></td>
					</tr>
					<tr>
						<td>Subtítulo <sup class="red">*</sup></td>
						<td><input type="text" id="subtitulo" name="subtitulo" maxlength="120" value="${param.subtitulo}" required/></td>
					</tr>
					<tr>
						<td>Preço </td>
						<td><input type="text" id="preco" name="preco" maxlength="45" value="${param.preco}" /></td>
					</tr>
					<tr>
						<td>Lingua <sup class="red">*</sup></td>
						<td><input type="text" id="lingua" name="lingua" maxlength="45" value="${param.lingua}" required/></td>
					</tr>
					<tr>
						<td>Edição <sup class="red">*</sup></td>
						<td><input type="text" id="edicao" name="edicao" maxlength="45" value="${param.edicao}" required /></td>
					</tr>
					<tr>
						<td>Ano</td>
						<td><input type="text" id="ano" name="ano" maxlength="4" value="${param.ano}" /></td>
					</tr>
					<tr>
						<td>Páginas</td>
						<td><input type="text" id="paginas" name="paginas" maxlength="4" value="${param.paginas}" /></td>
					</tr>
					<tr>
						<td>Brochura</td>
						<td><input type="checkbox" id="bruxuraRevista" name="bruxuraRevista" value="${param.bruxuraRevista}" /></td>						
					</tr>
					<tr>
						<td>Video</td>
						<td><input type="checkbox" id="video" name="video" value="${param.video}" /></td>
					</tr>
					<tr>
						<td>CD/DVD</td>
						<td><input type="checkbox" id="cd_dvd" name="cd_dvd" value="${param.cddvd}" /></td>
					</tr>
					<tr>
						<td>e-book</td>
						<td><input type="checkbox" id="ebook" name="ebook" value="${param.ebook}" /></td>
					</tr>
					<tr>
						<td>Descrição</td>
						<td><textarea cols="10" rows="4" id="descricao" name="descricao" value="${param.descricao}"></textarea></td>
					</tr>
					<tr>
						<td></td>						
					</tr>
				</table>
			</fieldset>
			<span><sup class="red">*</sup> campos obrigatórios</span>
			<input type="reset"  value="Limpar"  id="limpar" name="limpar" />
			<input type="button" value=Cadastrar onclick="cadastrar()"/>
		</form>
	</div>
	<jsp:include page="/template/foot.jsp"></jsp:include>
</body>
</html>