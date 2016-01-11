<%@page import="br.ages.crud.model.Editora"%>
<%@page import="br.ages.crud.util.Util"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/template/head.jsp"%>
<div class="panel panel-primary panel-add">

	<div class="panel-heading text-center">Lista Editoras</div>

	<div class="panel-body">

		<jsp:include page="/template/msg.jsp"></jsp:include>

		<div class="table-responsive">

			<table class="table table-hover table-striped table-bordered">

				<thead>
					<tr>
						<th style="text-align: center;"></th>
						<th style="text-align: center;">Nome</th>
						<th style="text-align: center;">Ações</th>
					</tr>
				</thead>

				<tbody>

					<%
						List<Editora> listaEditoras = (List<Editora>) request.getAttribute("listaEditoras");
						int sizeListaEditoras = listaEditoras.size();
						int tdChangeColor = 0;

						for (Editora editora : listaEditoras) {
					%>
					<tr>
						<td><input type="checkbox" /></td>
						<td><%=editora.getNome()%></td>
						<td align="center"><a href="/CePESMaterials/main?acao=consultarEditora&id_editora=<%=editora.getIdEditora()%>"><img class="img" src="img/view.png"></a> 
							<a href="/CePESMaterials/main?acao=telaEditora&id_editora=<%=editora.getIdEditora()%>&isEdit=sim"><img class="img" src="img/edit.png"></a>
							<a href="/CePESMaterials/main?acao=removerEditora&id_editora=<%=editora.getIdEditora()%>"><img class="img" src="img/trash.png"></a>
						</td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>

			<div id="totalRegistros"
				style="background: rgba(0, 0, 0, 1) height: 40px; background: black; width: 100%; text-align: right; padding-right: 30px; line-height: 40px;">
				<%
					if (sizeListaEditoras == 0) {
				%>
				<p>Nenhum livro encontrado.</p>
				<%
					}
				%>
				<p style="color: white;">
					Total de registros:
					<%=sizeListaEditoras%>
			</div>

		</div>
	</div>
</div>

<jsp:include page="/template/foot.jsp"></jsp:include>
