<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.Usuario"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="./css/comum.css" />
		<title>AgES - Adds</title>
		<script type="text/javascript">
		
			function cadastrar() {
				var formCadastro =document.forms[0]; 
				formCadastro.action ="main?acao=addUser";
				formCadastro.submit();
			}
		
		</script>
</head>
<body>
	<jsp:include page="/template/head.jsp"></jsp:include>
	<jsp:include page="/template/msg.jsp"></jsp:include>
	
		<form action="" method="post" style="background: black;">
			<jsp:include page="/template/msg.jsp"></jsp:include>
			
			
			<fieldset style="background: URL('img/banner_black.jpg');min-height: 449px; border: none !important; color: #198AB0; padding: 25px; font-size: 12px; width: 100%; margin-top: -20px; top: -10px;">
				
				<div id="titleList" style="font-size: 20px; font-style: italic; margin-left: 50px; color: white; font-weight: bold;"> Cadastro de Autor</div>
			
				<br><br>
				<table cellpadding="5">
					<tr>
						<td>Matricula <sup class="red">*</sup></td>
						<td><input type="text" id="matricula" name="matricula" maxlength="11" value="${param.matricula}" /></td> 
					</tr>
					<tr>
						<td>Name <sup class="red">*</sup></td>
						<td><input type="text" id="nome" name="nome" maxlength="45" value="${param.nome}" /></td>
					</tr>
					<tr>
						<td>Usuario <sup class="red">*</sup></td>
						<td><input type="text" id="usuario" name="usuario" maxlength="11" value="${param.usuario}" /></td> 
					</tr>
					<tr>
						<td>Senha <sup class="red">*</sup></td>
						<td><input type="text" id="senha" name="senha" maxlength="45" value="${param.senha}" /></td>
					</tr><tr>
						<td>e-Mail Address</td>
						<td><input type="text" id="email" name="email" maxlength="45" value="${param.email}" /></td>
					</tr>
					<tr>
						<td>Administrador <sup class="red">*</sup></td>
						<td><input type="radio" id="adm" name="adm" value="S" <%= "S".equals(request.getParameter("adm")) ? "checked" : "" %>/>SIM
						    <input type="radio" id="adm" name="adm" value="N" <%= "N".equals(request.getParameter("adm")) ? "checked" : "" %>/>NÃO</td>
					</tr>
				</table>
	<br><br>
			<div style="float: left;">
			<span><sup class="red">*</sup> campos obrigatórios</span><br>
			<input class="btn" type="reset"  value="Limpar"  id="limpar" name="limpar" />
			<input class="btn" type="button" value=Cadastrar onclick="cadastrar()"/>
			</div>
			</fieldset>
		</form>
	</div>
	<jsp:include page="/template/foot.jsp"></jsp:include>
</body>
</html>