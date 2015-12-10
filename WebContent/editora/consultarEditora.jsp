<%@page import="br.ages.crud.model.Editora"%>
<%@page import="br.ages.crud.util.Util"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/comum.css" />
<title>Consulta Editora</title>
</head>
<%Editora editora = (Editora) request.getAttribute("editora");%>
<body>





<%@ include file="/template/head.jsp"%>
	
	<fieldset style="background: URL('img/banner_black.jpg');min-height: 449px; border: none !important; color: #198AB0; padding: 25px; font-size: 12px; width: 100%; margin-top: -20px; top: -10px;">
				
				<div id="titleList" style="font-size: 20px; font-style: italic; margin-left: 50px; color: white; font-weight: bold;"> Consulta de Editora</div>
			
				<br><br>
	
	
	<table cellpadding="5">
					
					<tr>
						<td>Nome</td>
						<td><input readonly type="text" id="nome" name="nome" maxlength="45" value="<%=editora.getNome()%>" /></td>
					</tr>
				</table>
	</div>
			</fieldset>
			
		</form>
	
	<jsp:include page="/template/foot.jsp"></jsp:include>
