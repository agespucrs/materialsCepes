<%@page import="br.ages.crud.model.Usuario"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/registerUser.css" />
<link rel="stylesheet" href="./css/comum.css" />
<title>Alterar Usuário</title>
<%
	Usuario usuario = (Usuario) request.getAttribute("usuario");
%>
<script type="text/javascript">
	function alterar() {
		//chamar funcao de verificar campos
		var formCadastro = document.forms[0];
		formCadastro.action = "main?acao=alterUser&id_usuario=<%=usuario.getIdUsuario()%>";
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
				
				<div id="titleList" style="font-size: 20px; font-style: italic; margin-left: 50px; color: white; font-weight: bold;"> Alterar Usuário</div>
			
				<br><br>
			
			

			<div class="campo">
				<label for="matricula">Matricula</label> <sup class="red">*</sup> <input
					type="text" id="matricula" name="matricula" maxlength="15"
					required="required" value="<%=usuario.getMatricula()%>" />
			</div>
			<a href="#" class="tooltip"><img src="" height="5" width="5" /><span>Matrícula
					da PUCRS</span></a>

			<div class="campo">
				<label for="nome">Nome</label> <sup class="red">*</sup> <input
					type="text" id="nome" name="nome" maxlength="120"
					value="<%=usuario.getNome()%>" />
			</div>

			<div class="campo">
				<label for="email">Email</label> <sup class="red">*</sup> <input
					type="text" id="email" name="email" maxlength="120"
					value="<%=usuario.getEmail()%>" />
			</div>

			<div class="campo">
				<label for="usuario">Usuário</label> <sup class="red">*</sup> <input
					type="text" id="usuario" name="usuario" maxlength="150"
					value="<%=usuario.getUsuario()%>" />
			</div>

			<div class="campo">
				<label for="senha">Senha</label> <sup class="red">*</sup> <input
					type="password" id="senha" name="senha" maxlength="8"
					value="<%=usuario.getSenha()%>" />
			</div>
			<div style="float: left;">
			<span><sup class="red">*</sup> campos obrigatórios</span><br>
			<input class="btn" type="reset"  value="Limpar"  id="limpar" name="limpar" />
			<input class="btn" type="submit" value=Alterar onclick="alterar()"/>
			</div>
		</fieldset>
		</form>
	</div>
	
	<jsp:include page="/template/foot.jsp"></jsp:include>
</body>
</html>