<%@page import="br.ages.crud.model.Livro"%>
<%@page import="br.ages.crud.model.Autor"%>
<%@page import="br.ages.crud.model.Editora"%>
<%@page import="br.ages.crud.util.Util"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/registerUser.css" />
<link rel="stylesheet" href="./css/comum.css" />
<title>Cadastrar Livro</title>
<%
	Livro livro = (Livro) request.getAttribute("livro");
%>
<script type="text/javascript">
	function alterar() {
		//chamar funcao de verificar campos
		var formCadastro = document.forms[0];
		formCadastro.action = "main?acao=alterLivro&id_livro=<%=livro.getIdLivro()%>";
		formCadastro.submit();
	}
</script>
</head>
<body>
	<jsp:include page="/template/head.jsp"></jsp:include>
	<form method="post" action="main?acao=alterLivro&id_livro=<%=livro.getIdLivro()%>">
		<jsp:include page="/template/msg.jsp"></jsp:include>

		<fieldset>
				<table cellpadding="5">
					<tr>
						<td>Autor</td>
						<td>
							<input type="text" name="autor" value="1">
						</td>
					</tr>
					<tr>
						<td>Editora</td>
						<td>
							<input type="text" name="editora" value="1">
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
						<%if (livro.getAno() == null) {%>
						<td><input type="text" id="ano" name="ano" maxlength="4" value="2015" onkeyup="onlyNumber(this)" onkeydown="onlyNumber(this)"/></td><%}else{ %>
						<td><input type="text" id="ano" name="ano" maxlength="4" value="<%=livro.getAno()%>" onkeyup="onlyNumber(this)" onkeydown="onlyNumber(this)"/></td>
						<%} %>
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
						<td><textarea cols="45" rows="4" id="descricao" name="descricao"><%=livro.getDescricao()%></textarea></td>
					</tr>
					<tr>
						<td></td>						
					</tr>
				</table>
				<input type="submit">
			</fieldset>
	</form>
</body>
</html>





