<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.Editora"%>
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
				formCadastro.action ="main?acao=addEditora";
				formCadastro.submit();
			}
		
		</script>
</head>
<body>
	<jsp:include page="/template/head.jsp"></jsp:include>
	<h1>Cadastro Editora</h1>
	<div class="main">
		<form action="" method="post">
			<jsp:include page="/template/msg.jsp"></jsp:include>
			<fieldset>
				<table cellpadding="5">
					<tr>
						<td>Nome <sup class="red">*</sup></td>
						<td><input type="text" id="nome" name="nome" maxlength="120" value="${param.nome}" /></td> 
					</tr>
				</table>
			</fieldset>
			<span><sup class="red">*</sup> campos obrigatórios</span>
			<input type="reset"  value="Limpar"  id="limpar" name="limpar" />
			<input type="button" value=Cadastrar onclick="cadastrar()"/>
		</form>
	</div>
	<jsp:include page="/template/foot.jsp"></jsp:include>
</body>
</html>