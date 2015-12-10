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
		<title>Editar Livro</title>
<%
	Livro livro = (Livro) request.getAttribute("livro");
%>
		<script type="text/javascript">
		
			function cadastrar() {
				
				var formCadastro = document.forms[0]; 
				var err = false;
				
				if(document.getElementById("isbn").value == "undefined" || document.getElementById("isbn").value == "")
						err = true;
				if(document.getElementById("titulo").value == "undefined" || document.getElementById("titulo").value == "")
					err = true;
				if(document.getElementById("subtitulo").value == "undefined" || document.getElementById("subtitulo").value == "")
					err = true;
				if(document.getElementById("lingua").value == "undefined" || document.getElementById("lingua").value == "")
					err = true;
				if(document.getElementById("edicao").value == "undefined" || document.getElementById("edicao").value == "")
					err = true;
				
				
				if(!err)
				{
					formCadastro.action ="main?acao=telaLivro&isEdit=sim";
					formCadastro.submit();
				}
				else
				{
					document.getElementById("msgErro").style.display = "block";
					document.getElementById("msgErro").innerHTML = "Preencha os campos obrigatórios";
				}	
				
			
			}
			
			function onlyNumber(e)
			{
				var valueof = e.value;
				var value = valueof.match(/^[\0-9]+$/);
				e.value = value;
				
			}
			
			function precoMask(e)
			{
				var valueof = e.value;
				var value = valueof.match(/^[\0-9.]+$/);
				e.value = value;
			}
			
			function virgulaPraPonto(e)
			{
				e.value = e.value.replace(",",".");
				
			}
		
		</script>
		<script type="text/javascript">
			function alterar() {
				//chamar funcao de verificar campos
				var formCadastro = document.forms[0];
				formCadastro.action = "main?acao=alterLivro&id_livro="<%=livro.getIdLivro()%>;
				formCadastro.submit();
			}
		</script>
</head>
<body>
	
	

	<jsp:include page="/template/head.jsp"></jsp:include>
	<div id="msgErro" class="msgErro" style="display: none;"></div>
	<h1>Editar Livro</h1>
	<div class="main">
		<form action="" method="post">
			<input type="hidden" id="id_livro" name="id_livro" value="<%=livro.getIdLivro()%>">
			<jsp:include page="/template/msg.jsp"></jsp:include>
			<fieldset>
				<table cellpadding="5">
					<tr>
						<td>Autor</td>
						<td>
							<select id="autor" name="autor">
							<%
								List<Autor> listaAutores = (List<Autor>) livro.getAutores();
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
							<%/*
								List<Editora> listaEditora = (List<Editora>) request.getAttribute("editoras");
								int sizeListaEditoras = listaEditora.size();
								for (Editora editora: listaEditora) {
							*/%>
									<option value="<%=livro.getEditora().getIdEditora()%>"><%=livro.getEditora().getNome()%></option>			
							<%
								//}
							%>
							</select>
						</td>
					</tr>
					<tr>
						<td>Código ISBN <sup class="red">*</sup></td>
						<td><input type="text" id="isbn" name="isbn" maxlength="13" value="<%=livro.getCodigoISBN()%>" onkeyup="onlyNumber(this)" onkeydown="onlyNumber(this)" required/></td> 
					</tr>
					<tr>
						<td>Título <sup class="red">*</sup></td>
						<td><input type="text" id="titulo" name="titulo" maxlength="120" value="<%=livro.getTitulo()%>" required/></td>
					</tr>
					<tr>
						<td>Subtítulo <sup class="red">*</sup></td>
						<td><input type="text" id="subtitulo" name="subtitulo" maxlength="120" value="<%=livro.getSubtitulo()%>" required/></td>
					</tr>
					<tr>
						<td>Preço </td>
						<td><input type="text" id="preco" name="preco" maxlength="45" value="<%=livro.getPreco()%>" onkeyup="precoMask(this)" onkeydown="precoMask(this)"/></td>
					</tr>
					<tr>
						<td>Lingua <sup class="red">*</sup></td>
						<td><input type="text" id="lingua" name="lingua" maxlength="45" value="<%=livro.getLingua()%>" required/></td>
					</tr>
					<tr>
						<td>Edição <sup class="red">*</sup></td>
						<td><input type="text" id="edicao" name="edicao" maxlength="4" value="<%=livro.getEdicao()%>" onkeyup="onlyNumber(this)" onkeydown="onlyNumber(this)" required /></td>
					</tr>
					<tr>
						<td>Ano</td>
						<td><input type="text" id="ano" name="ano" maxlength="4" value="<%=livro.getAno()%>" onkeyup="onlyNumber(this)" onkeydown="onlyNumber(this)"/></td>
					</tr>
					<tr>
						<td>Páginas</td>
						<td><input type="text" id="paginas" name="paginas" maxlength="4" value="<%=livro.getPaginas()%>" onkeyup="onlyNumber(this)" onkeydown="onlyNumber(this)"/></td>
					</tr>
					<tr>
						<td>Brochura</td>
						<td><input type="checkbox" id="bruxuraRevista" name="bruxuraRevista" value="<%=livro.getBruxura_revista()%>" /></td>						
					</tr>
					<tr>
						<td>Video</td>
						<td><input type="checkbox" id="video" name="video" value="<%=livro.isVideo()%>" /></td>
					</tr>
					<tr>
						<td>CD/DVD</td>
						<td><input type="checkbox" id="cd_dvd" name="cd_dvd" value="<%=livro.isCd_dvd()%>" /></td>
					</tr>
					<tr>
						<td>e-book</td>
						<td><input type="checkbox" id="ebook" name="ebook" value="<%=livro.isE_book()%>" /></td>
					</tr>
					<tr>
						<td>Descrição</td>
						<td><textarea cols="45" rows="4" id="descricao" name="descricao" value="<%=livro.getDescricao()%>"></textarea></td>
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