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
		formCadastro.action = "main?acao=alterEditora&id_editora=<%=editora.getIdEditora()%>";
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
				
				<div id="titleList" style="font-size: 20px; font-style: italic; margin-left: 50px; color: white; font-weight: bold;"> Alterar Editora</div>
			
				<br><br>

			<div class="campo">
				<label for="matricula">Nome</label> <sup class="red">*</sup> <input
					type="text" id="nome" name="nome" maxlength="15"
					required="required" value="<%=editora.getNome()%>" />
			</div>
			<div style="float: left;">
			<span><sup class="red">*</sup> campos obrigatórios</span><br>
			<input class="btn" type="reset"  value="Limpar"  id="limpar" name="limpar" />
			<input class="btn" type="button" value=Alterar onclick="alterar()"/>
			</div>
		</fieldset>
		</form>
	</div>
	<jsp:include page="/template/foot.jsp"></jsp:include>
</body>
</html>