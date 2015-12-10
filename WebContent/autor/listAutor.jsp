<%@page import="br.ages.crud.model.Autor"%>
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
<body style="">
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
		<fieldset class="fieldset_listLivros" style="background: URL('img/banner_black.jpg'); min-height: 515px;">
			
			<div id="titleList" style="font-size: 20px; font-style: italic; margin-left: 50px;"> Listagem de Autor</div>
			
			<div>
			<table id="tbLista" cellspacing="0" >
			<tr style="background: black; height: 50px; line-height: 50px; border: none;">
				<td></td>
				<td>Nome</td>
				<td>Sobrenome</td>
				<td>Ações</td>
			</tr>
			
			<%
				List<Autor> listaAutores = (List<Autor>) request.getAttribute("listaAutores");
				int sizeListaAutores = listaAutores.size();
				int tdChangeColor = 0;
				
				for (Autor autor : listaAutores) {
			%>

			<%
				if(tdChangeColor == 0)
				{
					%>
					<tr class="tdInset">
					<%
					tdChangeColor++;
				}
				else
				{
			%>
					<tr class="tdOutset">
			<%
					tdChangeColor = 0;
				}
			%>
			
				<td><input type="checkbox" /></td>
				<td><%= autor.getNome() %></td>
				<td><%= autor.getSobrenome() %></td>
				<td>
						<a href="/CePESMaterials/main?acao=consultarAutor&id_autor=<%=autor.getId_autor()%>"><img class="img" src="img/view.png"/>
						<a href="/CePESMaterials/main?acao=telaAutor&id_autor=<%=autor.getId_autor()%>&isEdit=sim"><img class="img" src="img/edit.png"/></a>
						<a href="/CePESMaterials/main?acao=removerAutor&id_autor=<%=autor.getId_autor()%>"><img class="img" src="img/trash.png"/></a>
						</td>
			</tr>
			<%
				}
			%>
			</table>
			
			<div id="totalRegistros" style="background: rgba(0,0,0,1)height: 40px;background: black;width: 100%;text-align: right;padding-right: 30px;line-height: 40px;"><%
			if(sizeListaAutores == 0)
			{
				%> <p>Nenhum autor encontrado.</p> <%	
			}
			%>	 
			<p style="color: white;">Total de registros: <%= sizeListaAutores %></div></p>
			
			
				
		</fieldset>
	</form>
</body>

<jsp:include page="/template/foot.jsp"></jsp:include>

</html>