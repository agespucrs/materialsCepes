<%@page import="br.ages.crud.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<title>AGES - Agência Experimental de Engenharia de Software</title>
<link rel="icon" href="img/favicon.ico">

<!-- JQUERY -->
<script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="./js/jquery.mask.min.js"></script>

<!-- BOOTSTRAP -->
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="./css/bootstrap-theme.min.css">
<script src="./js/bootstrap.min.js"></script>

<!-- STYLE -->
<link rel="stylesheet" href="./css/style.css">

<!-- Include the plugin's CSS and JS: Cassio DataTable -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.10/css/dataTables.bootstrap.min.css">

<!-- Include the plugin's CSS and JS: Cassio DataTable -->
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.10/js/dataTables.bootstrap.min.js"></script>

<!-- Include the plugin's CSS and JS: Cassio -->
<!-- bootstrap submenu  -->
<script src="./js/bootstrap-submenu.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="./css/bootstrap-submenu.min.css">
<script>
	$(document).ready(function() {
		$('[data-submenu]').submenupicker();
	});
</script>
<script src="./js/jquery.bootstrap-duallistbox.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="./css/bootstrap-duallistbox.min.css">

<!-- Include the plugin's CSS and JS: Cassio DateTime Picker -->

<script type="text/javascript" src="./js/moment.js"></script>
<script type="text/javascript" src="./js/pt-br.js"></script>
<script type="text/javascript" src="./js/transition.js"></script>
<script type="text/javascript" src="./js/collapse.js"></script>
<script type="text/javascript"
	src="./js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="./css/bootstrap-datetimepicker.min.css">
<body>
	<%
		Usuario usuarioSessao = (Usuario) session.getAttribute("usuarioSessao");
	%>
	<div class="container fundo">

		<nav class="navbar navbar-default" style="margin-top: 20px;">
			<div class="container-fluid">

				<div class="navbar-header">
					<a class="navbar-brand" href="index.jsp"> <img
						class="logoNavBar" src="./img/cepes.png" alt="CePES">
					</a>
				</div>

				<ul class="nav navbar-nav">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Projetos <span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="main?acao=telaEquipamento&tela=addProjeto">Cadastrar</a></li>
							<li><a href="main?acao=listProjeto">Listar</a></li>
							<li><a href="main?acao=telaEquipamento&tela=equipeProjeto">Alocar Equipe</a></li>
							<!-- <li><a href="main?acao=telaEquipamento&tela=equipamentoProjeto">Alocar Equipamento</a></li> -->
						</ul>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Equipamentos <span
							class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="main?acao=telaEquipamento&tela=listEquipamento">Listar</a></li>
							<li><a href="main?acao=telaEquipamento&tela=equipamento">Cadastrar Equipamento</a></li>
							<li><a href="main?acao=telaEquipamento&tela=marca">Cadastro Marca</a></li>
						</ul></li>
					<li class="dropdown"><a data-submenu="" data-toggle="dropdown"
						tabindex="0"> Livros <span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a tabindex="0"
								href="main?acao=telaEquipamento&tela=emprestimoLivro">Empréstimo</a></li>
							<li class="divider"></li>
							<li><a tabindex="0" href="main?acao=listLivro">Listar</a></li>
							<li><a tabindex="0" href="main?acao=telaLivro&isEdit=">Cadastrar</a></li>
							<li><a tabindex="0" href="main?acao=copiaLivro">Adicionar Cópia</a></li>
							<li class="divider"></li>
							<li class="dropdown-submenu"><a tabindex="0">Autores</a>
								<ul class="dropdown-menu">
									<li><a tabindex="0" href="main?acao=listAutor&listarTodos=S">Listar</a></li>
									<li><a tabindex="0" href="main?acao=telaAutor">cadastrar</a></li>
								</ul>
							</li>
							<li class="dropdown-submenu"><a tabindex="0">Editoras</a>
								<ul class="dropdown-menu">
									<li><a tabindex="0" href="main?acao=listEditora">Listar</a></li>
									<li><a tabindex="0" href="main?acao=telaEditora">Cadastrar</a></li>
								</ul>
							</li>
						</ul></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Usuários <span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="main?acao=listUser">Listar</a></li>
							<li><a href="main?acao=telaUser&isEdit=">Cadastrar</a></li>
						</ul></li>

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"> <span
							class="glyphicon glyphicon-user"></span> Olá, <%=usuarioSessao.getUsuario()%>
							! <span class="caret"></span>
					</a>

						<ul class="dropdown-menu dropdown-menu-right">
							<li><a href="main?acao=logout">Logout</a></li>
						</ul></li>
				</ul>

			</div>
		</nav>