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
				<input type="text" /> <img style="width: 18px;" src="img/search.png" />
				<select><option>Campo1</option></select>
				<div id="ordenar">Ordenar: <select><option>Campo1</option></select></div>
			</div>
			
			<div id="titleList"> Listagem de Livros</div>
			
			<div id="fieldCamposExtras">
				<input type="checkbox"> CD/DVD 
				<input type="checkbox"> E-Book
				<select><option>Editora</option></select>
				<select><option>Autor</option></select>	
			</div>
			
			<table id="tbLista" border="1">
			<tr>
				<td></td>
				<td>Código ISBN</td>
				<td>Título</td>
				<td>Edição</td>
				<td>Ano</td>
				<td>Situação</td>
				<td>Data</td>
				<td>Ações</td>
			</tr>
			<tr>
				<td><input type="checkbox" /></td>
				<td>12300123</td>
				<td>O senhor dos anéis</td>
				<td>2</td>
				<td>2008</td>
				<td>Emprestado</td>
				<td>10/01/2015</td>
				<td><img class="img" src="img/view.png"/><img class="img" src="img/edit.png"/><img class="img" src="img/trash.png"/></td>
			</tr>
			<tr>
				<td><input type="checkbox" /></td>
				<td>12300123</td>
				<td>O senhor dos anéis</td>
				<td>2</td>
				<td>2008</td>
				<td>Emprestado</td>
				<td>10/01/2015</td>
				<td><img class="img" src="img/view.png"/><img class="img" src="img/edit.png"/><img class="img" src="img/trash.png"/></td>
			</tr>
			<tr>
				<td><input type="checkbox" /></td>
				<td>12300123</td>
				<td>O senhor dos anéis</td>
				<td>2</td>
				<td>2008</td>
				<td>Emprestado</td>
				<td>10/01/2015</td>
				<td><img class="img" src="img/view.png"/><img class="img" src="img/edit.png"/><img class="img" src="img/trash.png"/></td>
			</tr>
			<tr>
				<td><input type="checkbox" /></td>
				<td>12300123</td>
				<td>O senhor dos anéis</td>
				<td>2</td>
				<td>2008</td>
				<td>Emprestado</td>
				<td>10/01/2015</td>
				<td><img class="img" src="img/view.png"/><img class="img" src="img/edit.png"/><img class="img" src="img/trash.png"/></td>
			</tr>
			<tr>
				<td><input type="checkbox" /></td>
				<td>12300123</td>
				<td>O senhor dos anéis</td>
				<td>2</td>
				<td>2008</td>
				<td>Emprestado</td>
				<td>10/01/2015</td>
				<td><img class="img" src="img/view.png"/><img class="img" src="img/edit.png"/><img class="img" src="img/trash.png"/></td>
			</tr>
			
			</table>
			
			<div id="totalRegistros"> Total de registros: 2</div>
			
		</fieldset>
	</form>
</body>
</html>