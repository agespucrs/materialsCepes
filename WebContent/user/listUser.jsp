<%@page import="br.ages.crud.model.Usuario"%>
<%@page import="br.ages.crud.util.Util"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/comum.css" />
<script type="text/javascript">
	function remover(id) {
		var resposta = confirm("Deseja remover o usuario " + id);

		if (resposta == true) {
			var formCadastro = document.forms[0];
			formCadastro.action = "main?acao=removerUsuario&id_usuario=" + id;
			formCadastro.submit();
		}
	}
	
	function alterar(id){
		var form = document.forms[0];
		form.action = "main?acao=alterUser&id_usuario="+id;
		form.submit();
	}
</script>
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
	
	<form class="formlist" method="post" class="login_form" action="main?acao=login">
		<jsp:include page="/template/msg.jsp"></jsp:include>
		<fieldset class="fieldset_listLivros" style="background: URL('img/banner_black.jpg'); min-height: 515px;">
			
			<div id="titleList" style="font-size: 20px; font-style: italic; margin-left: 50px;"> Listagem de Usuários</div>
			
		
			<table id="tbLista" cellspacing="0" >
			<tr style="background: black; height: 50px; line-height: 50px; border: none;">
				<td></td>
				<td>Matricula</td>
				<td>Nome</td>
				<td>E-Mail</td>
				<td>Usuário</td>
				<td>ADM</td>
				<td>Ações</td>
			</tr>

			
			<%
				List<Usuario> listaUsuarios = (List<Usuario>) request.getAttribute("listaUsuarios");
				int sizeListaUsuarios = listaUsuarios.size();
				int tdChangeColor = 0;
				
				for (Usuario usuario : listaUsuarios) {
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
					<td class="alignCenter"><%=usuario.getMatricula()%></td>
					<td class="alignLeft"><%=usuario.getNome()%></td>
					<td class="alignLeft"><%=usuario.getEmail()%></td>
					<td class="alignLeft"><%=usuario.getUsuario()%></td>
					<td class="alignCenter"><%=usuario.getAdministrador()%></td>
					
				<td>
						<a href="/CePESMaterials/main?acao=consultarUser&id_usuario=<%=usuario.getIdUsuario()%>"><img class="img" src="img/view.png"/>
						<a href="/CePESMaterials/main?acao=telaUser&id_usuario=<%=usuario.getIdUsuario()%>&isEdit=sim"><img class="img" src="img/edit.png"/></a>
						<a href="/CePESMaterials/main?acao=removerUser&id_usuario=<%=usuario.getIdUsuario()%>"><img class="img" src="img/trash.png"/></a>
						</td>
			</tr>
			<%
				}
			%>
			</table>
			
			<div id="totalRegistros" style="background: rgba(0,0,0,1)height: 40px;background: black;width: 100%;text-align: right;padding-right: 30px;line-height: 40px;"><%
			if(sizeListaUsuarios == 0)
			{
				%> <p>Nenhum usuário encontrado.</p> <%	
			}
			%>	 
			<p style="color: white;">Total de registros: <%= sizeListaUsuarios %></div></p>
			
			
				
		</fieldset>
	</form>
</body>

<jsp:include page="/template/foot.jsp"></jsp:include>

</html>






