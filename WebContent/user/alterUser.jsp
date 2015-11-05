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
<title>Cadastrar Usuário</title>
<%
	Usuario usuario = (Usuario) request.getAttribute("usuario");
%>
<script type="text/javascript">
	function alterar() {
		//chamar funcao de verificar campos
		var formCadastro = document.forms[0];
		formCadastro.action = "main?acao=alterUser&id_usuario="<%=usuario.getIdUsuario()%>;
		formCadastro.submit();
	}
</script>
</head>
<body>
	<jsp:include page="/template/head.jsp"></jsp:include>
	<form method="post" action="main?acao=alterUser&id_usuario=<%=usuario.getIdUsuario()%>">
		<jsp:include page="/template/msg.jsp"></jsp:include>

		<fieldset class="fieldset_register">
			<legend>Alterar Usuário</legend>

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
			<a href="#" class="tooltip"><img src="" height="5" width="5" /><span>Texto
					de no mínimo 8 caractéres, contendo maiúsculas, minúsculas e
					números</span></a>

			<div class="cadastrar">
				<input type="submit" value="Alterar" id="alterar" name="alterar" />
			</div>
			<div class=limpar>
				<input type="reset" value="Voltar" id="limpar" name="limpar" />
			</div>

		</fieldset>
	</form>
</body>
</html>