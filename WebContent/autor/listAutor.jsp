<%@page import="br.ages.crud.model.Autor"%>
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
	<div class="head">
		<div class="logo">
			<a href="index.jsp"> <img alt="Logo AgES" src="img/FACIN-AGES-poli.jpg">
			</a>
		</div>
		<h1>Bem Vindo ao sistema Fluxo AGES / CePES MAterials</h1>
	</div>
	
	<br><br>
	
	<form method="post" class="login_form" action="main?acao=login">
		<jsp:include page="/template/msg.jsp"></jsp:include>
		<fieldset class="fieldset_listLivros">
			
			<div class="content">
				<input id="search" name="search" type="text" /> <img style="width: 18px;" src="img/search.png" />
				<select id="field" name="field"><option>Campo1</option></select>
				<div id="ordenar">Ordenar: <select id="orderBy" name="orderBy"><option>Campo1</option></select></div>
			</div>
			
			<div id="titleList"> Listagem de Autor</div>
			
			<div id="acaoEmMassa">
			Ação em massa: 
			<select><option>Excluir</option></select>
			<input type="button" value="OK"/>	
			</div>
			
			<table id="tbLista" border="1">
			<tr>
				<td><input id="todos" name="todos" type="checkbox" /></td>
				<td>Nome</td>
				<!--<td>Data Cadastro</td>-->
				<td>Ações</td>
			</tr>
			<tr>
					
			<%
				List<Autor> listaAutores = (List<Autor>) request.getAttribute("listaAutores");
				int sizeListaAutores = listaAutores.size();
				
				
				for (Autor autor: listaAutores) {
			%>

			<tr>
				<td><input type="checkbox" /></td>
				<td><%= autor.getNome()%> <%= autor.getSobrenome() %></td>
				<!--<td><% //autor.getDataCadastro()%></td>-->
				<td><img class="img" src="img/view.png"/><img class="img" src="img/edit.png"/><img class="img" src="img/trash.png"/></td>
			</tr>
			<%
				}
			%>
			</table>
			
			<div id="totalRegistros"><%
			if(sizeListaAutores == 0)
			{
				%> <p>Nenhum autor encontrado.</p> <%	
			}
			%>	 
			Total de registros: <%= sizeListaAutores %></div>
			
			
			
		</fieldset>
	</form>
</body>
</html>