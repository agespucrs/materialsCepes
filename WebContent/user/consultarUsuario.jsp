<%@page import="br.ages.crud.model.Usuario"%>
<%@page import="br.ages.crud.util.Util"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/comum.css" />
<title>Consulta Usuários</title>
</head>
<%Usuario usuario = (Usuario) request.getAttribute("usuario");%>
<body>


<%@ include file="/template/head.jsp"%>
	
	<fieldset style="background: URL('img/banner_black.jpg');min-height: 449px; border: none !important; color: #198AB0; padding: 25px; font-size: 12px; width: 100%; margin-top: -20px; top: -10px;">
				
				<div id="titleList" style="font-size: 20px; font-style: italic; margin-left: 50px; color: white; font-weight: bold;"> Consulta de Usuário</div>
			
				<br><br>
	
	
	<table cellpadding="5">
					<tr>
						<td>Matricula <sup class="red">*</sup></td>
						<td><input type="text" id="matricula" name="matricula" maxlength="11" value="<%=usuario.getMatricula()%>" readonly/></td> 
					</tr>
					<tr>
						<td>Name <sup class="red">*</sup></td>
						<td><input type="text" id="nome" name="nome" maxlength="45" value="<%=usuario.getNome()%>" readonly/></td>
					</tr>
					<tr>
						<td>Usuario <sup class="red">*</sup></td>
						<td><input type="text" id="usuario" name="usuario" maxlength="11" value="<%=usuario.getUsuario()%>" readonly/></td> 
					</tr>
					<tr>
						<td>Senha <sup class="red">*</sup></td>
						<td><input type="text" id="senha" name="senha" maxlength="45" value="<%=usuario.getSenha()%>" readonly/></td>
					</tr><tr>
						<td>e-Mail Address</td>
						<td><input type="text" id="email" name="email" maxlength="45" value="<%=usuario.getEmail()%>" readonly/></td>
					</tr>
					<tr>
						<td>Administrador <sup class="red">*</sup></td>
						<%if(usuario.getAdministrador() == "SIM"){%>
						<td><input onclick="javascript: void(0)" type="radio" id="adm" name="adm" value="S" <%= "S".equals(request.getParameter("adm")) ? "checked" : "" %>/>SIM <input type="radio" id="adm" name="adm" value="N" onclick="javascript: void(0)"/>NÃO</td>
						<% }else{ %>
						<td><input onclick="javascript: void(0)" type="radio" id="adm" name="adm" value="N" <%= "N".equals(request.getParameter("adm")) ? "checked" : "" %>/>NÃO <input type="radio" id="adm" name="adm" value="S" onclick="javascript: void(0)"/>SIM</td>
						<%} %>    
					</tr>
				</table>
	</div>
			</fieldset>
			
		</form>
	
	<jsp:include page="/template/foot.jsp"></jsp:include>
