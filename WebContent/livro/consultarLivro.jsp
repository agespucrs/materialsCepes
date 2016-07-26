<%@page import="br.ages.crud.model.Livro"%>
<%@page import="br.ages.crud.model.Autor"%>
<%@page import="br.ages.crud.util.Util"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/comum.css" />
<title>Consulta Livros</title>
</head>
<%Livro livro = (Livro) request.getAttribute("livro");%>
<body>





<%@ include file="/template/head.jsp"%>
	
	<fieldset style="background: URL('img/banner_black.jpg');min-height: 449px; border: none !important; color: #198AB0; padding: 25px; font-size: 12px; width: 100%; margin-top: -20px; top: -10px;">
				
				<div id="titleList" style="font-size: 20px; font-style: italic; margin-left: 50px; color: white; font-weight: bold;"> Consulta de Livro</div>
			
				<br><br>
	
	
	<table cellpadding="5">
					<tr>
						<td>Autor</td>
						<td>
							<select id="autor" name="" readonly>
							<% for(Autor autor : livro.getAutores()){
								%>
							<option value="Autor"><%=autor.getNome()+" "+autor.getSobrenome()%> </option>
							<% } %>
							</select>
						</td>
						<td>Editora</td>
						<td>
							<select id="editora" name="" readonly>
							<option value="Editora"><%=livro.getEditora().getNome()%></option>
							</select>
						</td>
					</tr>
					<tr>
						<td>Código ISBN <sup class="red"></sup></td>
						<td><input readonly type="text" id="isbn" name="isbn" maxlength="13" value="<%=livro.getCodigoISBN()%>" onkeyup="onlyNumber(this)" onkeydown="onlyNumber(this)" required/></td> 
						<td>Título <sup class="red">*</sup></td>
						<td><input readonly type="text" id="titulo" name="titulo" maxlength="120" value="<%=livro.getTitulo()%>" required/></td>
					</tr>
					<tr>
						<td>Subtítulo <sup class="red">*</sup></td>
						<td><input readonly type="text" id="subtitulo" name="subtitulo" maxlength="120" value="<%=livro.getSubtitulo()%>" required/></td>
						<td>Preço </td>
						<td><input readonly type="text" id="preco" name="preco" maxlength="45" value="<%=livro.getPreco()%>" onkeyup="precoMask(this)" onkeydown="precoMask(this)"/></td>
					</tr>
					<tr>
						<td>Lingua <sup class="red">*</sup></td>
						<td><input readonly type="text" id="lingua" name="lingua" maxlength="45" value="<%=livro.getLingua()%>" required/></td>
						<td>Edição <sup class="red">*</sup></td>
						<td><input readonly type="text" id="edicao" name="edicao" maxlength="45" value="<%=livro.getEdicao()%>" onkeyup="onlyNumber(this)" onkeydown="onlyNumber(this)" required /></td>
					</tr>
					<tr>
						<td>Ano</td>
						<td><input readonly type="text" id="ano" name="ano" maxlength="4" value="<%=livro.getAno()%>" onkeyup="onlyNumber(this)" onkeydown="onlyNumber(this)"/></td>
						<td>Páginas</td>
						<td><input readonly type="text" id="paginas" name="paginas" maxlength="4" value="<%=livro.getPaginas()%>" onkeyup="onlyNumber(this)" onkeydown="onlyNumber(this)"/></td>
					</tr>
					<tr>
						<td>Brochura</td>
						<td><%if(livro.getBrochura()){%><input onclick="return false" type="checkbox" id="brochura" name="brochura" checked/><%} else { %><input type="checkbox" id="brochura" name="brochura"/><% %></td>						
						<td>Video</td>
						<td><%if(livro.isVideo()){%><input onclick="alert()" type="checkbox" id="video" name="video" checked/><%} else { %><input type="checkbox" id="video" name="video"/><%}%></td>
					</tr>
					<tr>
						<td>CD/DVD</td>
						<td><%if(livro.iseBook()){%><input onclick="return false" type="checkbox" id="cd_dvd" name="cd_dvd" checked /><%} else { %><input type="checkbox" id="cd_dvd" name="cd_dvd"/><%}%></td></td>
						<td>e-book</td>
						<td><%if(livro.iseBook()){%><input onclick="return false" type="checkbox" id="ebook" name="ebook" checked/><%} else { %><input type="checkbox" id="ebook" name="ebook"/><%}%></td>
					</tr>
					<tr>
						<td>Descrição</td>
						<%if(livro.getDescricao() == "") {%>
						<td><textarea cols="45" rows="4" readonly id="descricao" name="descricao" value="Não possui descrição"></textarea></td>
						<%} else {%>
						<td><textarea cols="45" rows="4" readonly id="descricao" name="descricao" value="<%=livro.getDescricao()%>"></textarea></td>
						<% }} %>
						<td></td>						
					</tr>
				</table>
	</div>
			</fieldset>
			
		</form>
	
	<jsp:include page="/template/foot.jsp"></jsp:include>
