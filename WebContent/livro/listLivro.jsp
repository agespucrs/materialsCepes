<%@page import="br.ages.crud.model.Livro"%>
<%@page import="br.ages.crud.util.Util"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/comum.css" />
<title>AgES Login</title>

<style>
.content { width: 100%; }
#ordenar { float: right; }
#fieldCamposExtras { margin-top: 20px; float: left;}
#titleList { margin-top: 20px; font-size: 22px; font-weight: bold; } 
#tbLista { clear: both; width: 100%; margin-top: 10px; float: left; border: 1px solid #e4e4e4; }
.img { width: 20px; }
#totalRegistros { float: right; }
#acaoEmMassa { width: 420px; display: block; float: right;}
</style>

</head>
<body>
<%@ include file="/template/head.jsp"%>
	<!-- <div class="head">
		<div class="logo">
			<a href="index.jsp"> <img alt="Logo AgES" src="img/FACIN-AGES-poli.jpg">
			</a>
		</div>
		<h1>Bem Vindo ao sistema Fluxo AGES / CePES MAterials</h1>
	</div>-->
	
	<br><br>
	
	<form method="post" class="login_form" action="main?acao=login">
		<jsp:include page="/template/msg.jsp"></jsp:include>
		<fieldset class="fieldset_listLivros">
			
			<div class="content">
				<input id="search" name="search" type="text" /> <img style="width: 18px;" src="img/search.png" />
				<select id="field" name="field"><option>Campo1</option></select>
				<div id="ordenar">Ordenar: <select id="orderBy" name="orderBy"><option>Campo1</option></select></div>
			</div>
			
			<div id="titleList"> Listagem de Livros</div>
			
			<div id="fieldCamposExtras">
				<input id="cddvd" name="cddvd" type="checkbox"> CD/DVD 
				<input id="ebook" name="ebook" type="checkbox"> E-Book
				<select id="editora" name="editora"><option>Editora</option></select>
				<select id="autor" name="autor"><option>Autor</option></select>	
			</div>
			
			
			<div id="acaoEmMassa">
			Ação em massa: 
			<select><option>Excluir</option></select>
			<input type="button" value="OK"/>	
			</div>
			
			<table id="tbLista" border="1">
			<tr>
				<td></td>
				<td>Código ISBN</td>
				<td>Título</td>
				<td>Edição</td>
				<td>Ano</td>
				<td>Data</td>
				<td>Ações</td>
			</tr>
			
			<%
				List<Livro> listaLivros = (List<Livro>) request.getAttribute("listaLivros");
				int sizeListaLivros = listaLivros.size();
				
				
				for (Livro livro : listaLivros) {
			%>

			<tr>
				<td><input type="checkbox" /></td>
				<td><%= livro.getCodigoISBN() %></td>
				<td><%= livro.getTitulo() %></td>
				<td><%= livro.getEdicao() %></td>
				<%if (livro.getAno() == null) {%>
				<td>Não Informado</td><%}else{ %>
				<td><%= Util.toAno(livro.getAno())%></td><%} %>
				<td><%= Util.toDataNormal(livro.getDataCadastro()) %></td>
				<td>
						<a href="/CePESMaterials/main?acao=consultarLivro&id_livro=<%=livro.getIdLivro()%>"><img class="img" src="img/view.png"/>
						<a href="/CePESMaterials/main?acao=telaLivro&id_livro=<%=livro.getIdLivro()%>&isEdit=sim"><img class="img" src="img/edit.png"/></a>
						<a href="/CePESMaterials/main?acao=removerLivro&id_livro=<%=livro.getIdLivro()%>"><img class="img" src="img/trash.png"/></a>
						</td>
			</tr>
			<%
				}
			%>
			</table>
			
			<div id="totalRegistros"><%
			if(sizeListaLivros == 0)
			{
				%> <p>Nenhum livro encontrado.</p> <%	
			}
			%>	 
			Total de registros: <%= sizeListaLivros %></div>
			
			
			
		</fieldset>
	</form>
</body>
</html>
