<%@page import="br.ages.crud.model.Autor"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/registerUser.css" />
<link rel="stylesheet" href="./css/comum.css" />
<title>Editar Autor</title>

<%

	Autor autor = (Autor) request.getAttribute("autor");

%>

<script type="text/javascript">
	function alterar() {
		//chamar funcao de verificar campos
		var formCadastro = document.forms[0];
		formCadastro.action = "main?acao=alterAutor&id_autor="<%=autor.getId_autor()%>;
		formCadastro.submit();
	}
</script>
</head>
<body>
	<jsp:include page="/template/head.jsp"></jsp:include>
	<form method="post" action="main?acao=alterAutor&id_autor=<%=autor.getId_autor()%>">
		<jsp:include page="/template/msg.jsp"></jsp:include>

		<fieldset class="fieldset_register">
			<legend>Editar Autor</legend>

			<div class="campo">
				<label for="matricula">Nome</label> <sup class="red">*</sup> <input
					type="text" id="nome" name="nome" maxlength="15"
					required="required" value="<%=autor.getNome()%>" />
			</div>
			<div class="campo">
				<label for="matricula">Sobrenome</label> <sup class="red">*</sup> <input
					type="text" id="sobrenome" name="sobrenome" maxlength="15"
					required="required" value="<%=autor.getSobrenome()%>" />
			</div>
			<input type="submit"/>
		</fieldset>
	</form>
</body>
</html>