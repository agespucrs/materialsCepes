<%@page import="br.ages.crud.model.Editora"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/registerUser.css" />
<link rel="stylesheet" href="./css/comum.css" />
<title>Editar Editora</title>

<%

	Editora editora = (Editora) request.getAttribute("editora");

%>

<script type="text/javascript">
	function alterar() {
		//chamar funcao de verificar campos
		var formCadastro = document.forms[0];
		formCadastro.action = "main?acao=alterEditora&id_editora="<%=editora.getIdEditora()%>;
		formCadastro.submit();
	}
</script>
</head>
<body>
	<jsp:include page="/template/head.jsp"></jsp:include>
	<form method="post" action="main?acao=alterEditora&id_editora=<%=editora.getIdEditora()%>">
		<jsp:include page="/template/msg.jsp"></jsp:include>

		<fieldset class="fieldset_register">
			<legend>Editar Editora</legend>

			<div class="campo">
				<label for="matricula">Nome</label> <sup class="red">*</sup> <input
					type="text" id="nome" name="nome" maxlength="15"
					required="required" value="<%=editora.getNome()%>" />
			</div>
		</fieldset>
	</form>
</body>
</html>