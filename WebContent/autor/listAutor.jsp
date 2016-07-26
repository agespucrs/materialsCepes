<%@page import="br.ages.crud.model.Autor"%>
<%@page import="br.ages.crud.util.Util"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/template/head.jsp"%>
<div class="panel panel-primary panel-add">

	<div class="panel-heading text-center">Lista de Autores</div>

	<div class="panel-body">

		<jsp:include page="/template/msg.jsp"></jsp:include>

		<div class="table-responsive">

			<table class="table table-hover table-striped table-bordered">
				<thead>
					<tr>
						<th style="text-align: center;"></th>
						<th style="text-align: center;">Nome</th>
						<th style="text-align: center;">Sobrenome</th>
						<th colspan="2" style="text-align: center;">Ações</th>
					</tr>
				</thead>
				<tbody>
					<%
						List<Autor> listaAutores = (List<Autor>) request.getAttribute("listaAutores");
						int sizeListaAutores = listaAutores.size();
						int tdChangeColor = 0;
						for (Autor autor : listaAutores) {
					%>
					<tr>
						<td><input type="checkbox" /></td>
						<td align="center" class="au-nome"><%=autor.getNome() %></td>
						<td align="center" class="au-sobrenome"><%= autor.getSobrenome() %></td>
						<td align="center"><a href="/CePESMaterials/main?acao=telaAutor&id_autor=<%=autor.getId_autor()%>&isEdit=sim" title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a></td>
						<td align="center"><a href="/CePESMaterials/main?acao=removerAutor&id_autor=<%=autor.getId_autor()%>" title="Deletar"> <i class="glyphicon glyphicon-trash"></i></a></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
			
			<div id="totalRegistros" class="total">
			<%
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
