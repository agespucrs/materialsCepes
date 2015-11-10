<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<head>
<style>
	@media screen and (max-width: 768px) {
		
		#divLogin { margin-right: 0px !important; }
		body { background-image: URL('img/pucrscel.png') !important; }
		
	}
</style>

</head>

<body style="background-image:URL('img/pucrs.png'); background-repeat: no-repeat; margin: 0px; padding: 0px; background-attachment: fixed;">
	

	<div id="divLogin" style="width: 350px;float: right; margin-right: 250px; padding: 25px; margin-top: 120px;">
		
		
		<span style="color: white; font-weight: bold; font-size: 30px;"><img src="img/login.png"/>&nbsp;&nbsp;CePES</span>
		<br><br>
		
		<form method="post" class="login_form" action="main?acao=login">
		<table style="width: 350px; margin: 0 auto; background-color: rgba(0, 0, 0, 0.8); -webkit-border-radius: 5px;-moz-border-radius: 5px; border-radius: 5px; color: white; padding: 25px; border: 1px solid white;">
			<tr>
				<td><label>Usuario:</label></td>
				<td><input id="login" name="login" type="text" placeholder="Digite seu usuario..." required/></td>
				<td><img src="img/1442277808_19.png" width="25px;" style="float: left;" title="Somente letras e numeros."/></td>
			</tr>
			<tr>
				<td><label>Senha:</label></td>
				<td><input id="senha" name="senha" type="password" placeholder="Digite sua senha..."required/></td>
				<td><img src="img/1442277808_19.png" width="25px;" style="float: left;" title="Somente letras e numeros e somente 8 caracteres." /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="reset" value="Limpa" /> <input type="submit" value="Enter" id="logar" name="logar" style="background-color: #028805; color: white; border: 2px solid #028805;"/></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><a link="#">Esqueci meus dados de acesso.</a></td>
				<td></td>
			</tr>
		</table>
		</form>
		
		<div style="color: white; width: 350px; background: #b0101a URL('img/scull.png') no-repeat; border: 1px solid white; float: right; height: 100px; margin-top: 5px; -webkit-border-radius: 5px;-moz-border-radius: 5px; border-radius: 5px;"/>
			
		</div>	
	</div>


</body>
</html>