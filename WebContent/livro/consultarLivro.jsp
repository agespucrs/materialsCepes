<%@page import="br.ages.crud.model.Livro"%>
<%@page import="br.ages.crud.util.Util"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/comum.css" />
<title>Consulta Livros</title>

</head>
<%Livro livro = (Livro) request.getAttribute("livro");%>
<body>
<%@ include file="/template/head.jsp"%>
	<br><h1>Descrição</h1><br>
	<table align='center' border="1">
		<div id="outer">
			<div id="inner">
				<tr>
					<td>CADASTRO DE LIVROS</td>
				</tr>
				<tr>
					<td><label>Codigo ISBN</label></td>
					<td><label>Titulo</label></td>
				</tr>
				<tr>
					<td><label><%=livro.getCodigoISBN()%></label></td>
					<td><label><%=livro.getTitulo()%></label></td>
				</tr>
				<tr>
					<td><label>Lingua</label></td>
					<td><label>Subtitulo</label></td>
				</tr>
				<tr>
					<td>
					<select name="">
					<option value="Lingua"><%=livro.getLingua()%></option>
					</select>
					</td>
					<td>
					<label><%=livro.getSubtitulo()%></label>
					</td>
				</tr>
				<tr>
					<td><label>Autor</label></td>
					<td><label>Editora</label></td>
				</tr>
				<tr>
					<td><select name="">
					<option value="Autor"><%=livro.getAutores().get(0).getNome()+" "+livro.getAutores().get(0).getSobrenome()%> </option>
					</select></td>
					<td><select name="">
					<option value="Editora"><%=livro.getEditora().getNome()%></option>
					</select></td>

				</tr>
				<tr>
					<%if (livro.getDescricao() == null) {%>
					<td colspan='2'><label	>Não possui descrição</label></td>
					<%} else{%>
					<td colspan='2'><textarea rows="4" cols="90" readonly><%=livro.getDescricao()%></textarea></td>
					<%} %>
					<!-- <td colspan='2'><label rows="4" cols="90"><%=livro.getDescricao()%></label></td> -->
				</tr>
				<tr>
					<td><label>Numero de paginas</label></td>
					<td><label>Ano</label></td>
					<td><label>Edicao</label></td>
				</tr>
				<tr>
					<td><label><%=livro.getPaginas()%></label></td>
					<%if (livro.getAno() == null) {%>
					<td>Não Informado</td><%}else{ %>
					<td><%= Util.toAno(livro.getAno())%></td><%} %>
					<td><label><%=livro.getEdicao()%></label></td>
				</tr>
				<tr>
					<td><label>Preco</label></td>
					<td><label>Data de compra</label></td>
				</tr>

				<tr>
					<td><%=livro.getPreco()%></td>
					<td><%=Util.toDataNormal(livro.getDataCadastro())%></td>
					<%if (livro.getBruxura_revista()) {%>
					<td>Brochura</td><%}else{ %>
					<td>Revista</td><%} %>
				</tr>
				<tr>
				<%if (livro.isCd_dvd()) {%>
					<td>CD ou DVD</td><%}%>
					<%if (livro.isVideo()) {%>
					<td>Video</td><%}%>
					<%if (livro.isE_book()) {%>
					<td>E-Book</td><%}%>				
				</tr>

			</div>
		</div>
	</table>
</body>
</html>