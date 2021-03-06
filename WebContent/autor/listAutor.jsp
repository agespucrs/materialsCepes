<%@page import="br.ages.crud.model.Autor"%>
<%@page import="br.ages.crud.util.Util"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/template/head.jsp"%>
<div class="panel panel-primary panel-add">

	<div class="panel-heading text-center">Lista Autores</div>

	<div class="panel-body">

		<jsp:include page="/template/msg.jsp"></jsp:include>

		<div class="table-responsive">

			<table class="table table-hover table-striped table-bordered">

				<thead>
					<tr>
				<th style="text-align: center;"></th>
				<th style="text-align: center;">Nome</th>
				<th style="text-align: center;">Sobrenome</th>
				<th style="text-align: center;">A��es</th>
			</tr>
			
			<%
				List<Autor> listaAutores = (List<Autor>) request.getAttribute("listaAutores");
				int sizeListaAutores = listaAutores.size();
				int tdChangeColor = 0;
				
				for (Autor autor : listaAutores) {
			%>
			<tr>
				<td><input type="checkbox" /></td>
				<td><%=autor.getNome() %></td>
				<td><%= autor.getSobrenome() %></td>
				<td>
					<a href="/CePESMaterials/main?acao=consultarAutor&id_autor=<%=autor.getId_autor()%>"><img class="img" src="img/view.png"></a>
					<a href="/CePESMaterials/main?acao=telaAutor&id_autor=<%=autor.getId_autor()%>&isEdit=sim"><img class="img" src="img/edit.png"/></a>
					<a href="/CePESMaterials/main?acao=removerAutor&id_autor=<%=autor.getId_autor()%>"><img class="img" src="img/trash.png"/></a>
				</td>
			</tr>
			<%
				}
			%>
			</table>
			
			<div id="totalRegistros" style="background: rgba(0,0,0,1); height: 40px;background: black;width: 100%;text-align: right;padding-right: 30px;line-height: 40px;"><%
				if(sizeListaAutores == 0)
				{
					%> <p>Nenhum autor encontrado.</p> <%	
				}
				%>	 
				<p style="color: white;">Total de registros: <%= sizeListaAutores %></p>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/template/foot.jsp"></jsp:include>
