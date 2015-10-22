<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/registerUser.css" />
	<link rel="stylesheet" href="./css/comum.css" />
	<title>Cadastrar Usuário</title>
	<script type="text/javascript">
	
			function cadastrar() {
				//chamar funcao de verificar campos
				
				var formCadastro = document.forms[0]; 
				formCadastro.action ="main?acao=addUser";
				formCadastro.submit();
			}
			
		</script>
</head>
<body>
	<jsp:include page="/template/head.jsp"></jsp:include>
	<form method="post" action="">
		<jsp:include page="/template/msg.jsp"></jsp:include>
		<fieldset class="fieldset_register">
			<legend>Registrar Usuário</legend>
			<div class="campo">
				<label for="matricula">Matricula</label> <sup class="red">*</sup> 
				<input type="text" id="matricula" name="matricula" maxlength="15" value="${param.matricula}" />
			</div>	
			<a href="#" class="tooltip"><img src="" height="5" width="5"/><span>Matrícula da PUCRS</span></a> 
			
			<div class="campo">
				<label for="nome">Nome</label> <sup class="red">*</sup> 
				<input type="text" id="nome" name="nome" maxlength="15" value="${param.nome}" />
			</div>

			<div class="campo">
				<label for="email">Email</label> <sup class="red">*</sup> 
				<input type="text" id="email" name="email" maxlength="15" value="${param.email}" />
			</div>

			<div class="campo">
				<label for="usuario">Usuário</label> <sup class="red">*</sup> 
				<input type="text" id="usuario" name="usuario" maxlength="15" value="${param.usuario}" />
			</div>
			
			<div class="campo">
				<label for="senha">Senha</label> <sup class="red">*</sup>
				<input type="password" id="senha" name="senha" maxlength="15" value="${param.senha}" />
			</div>	
			<a href="#" class="tooltip"><img src="" height="5" width="5"/><span>Texto de no mínimo 8 caractéres, contendo maiúsculas, minúsculas e números</span></a> 
			

			
			
			<div class="cadastrar">
				<input type="button" value=Cadastrar onclick="cadastrar()"/>
			</div>
			<div class=limpar>
				<input type="reset" value="Limpar" id="limpar" name="limpar" />
			</div>
		</fieldset>
		</form>
</body>
</html>