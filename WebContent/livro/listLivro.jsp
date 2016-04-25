<%@page import="br.ages.crud.model.Livro"%>
<%@page import="br.ages.crud.model.Autor"%>
<%@page import="br.ages.crud.util.Util"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/template/head.jsp"%>
<div class="panel panel-primary panel-list-livro">

	<div class="panel-heading text-center">Lista Livros</div>

	<div class="panel-body">

		<jsp:include page="/template/msg.jsp"></jsp:include>
		
		<div class="table-responsive">
			<table id="listaLivros" class="table table-responsive table-striped table-hover table-condensed table-bordered">
				<thead>
					<tr >
						<th style="text-align: center;"></th>
						<th style="text-align: center;">Código</th>
						<th style="text-align: center;">Título</th>
						<th style="text-align: center;">Edição</th><%--
						<th style="text-align: center;">Ano</th>
						<th style="text-align: center;">Data</th>
						<th style="text-align: center;">Autor</th>--%>
						<th data-sortable="false" style="text-align: center; width:10px"></th>
						<th data-sortable="false" style="text-align: center; width:10px"></th>
					</tr>
				</thead>
				<%
					List<Livro> listaLivros = (List<Livro>) request.getAttribute("listaLivros");
					int sizeListaLivros = listaLivros.size();
					for (Livro livro : listaLivros) {
				%>
				<tr>
					<td><input type="checkbox" /></td>
					<td><%= livro.getCodigoISBN() %></td>
					<td><%= livro.getTitulo() %></td>
					<td><%= livro.getEdicao() %></td><%-- 
					<%if (livro.getAno() == null) 
						{ %>
						<td>Não Informado</td>
						<%
						} else {  %>
						<td><%= Util.toAno(livro.getAno())%>
						</td>
					<%  } %>
					<td><%= Util.toDataNormal(livro.getDataCadastro()) %></td>--%>
					<%-- <%
						for (Autor autor: livro.getAutores()) {
							String nome=autor.getNome();
											
					%>
					<td><%=nome%></td>
					<%
						}
					%> --%>
					<td>FIXO tem que alterar</td>
					<td align="center"><a href="/CePESMaterials/main?acao=telaLivro&id_livro=<%=livro.getIdLivro()%>&isEdit=sim" title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a></td>
					<td align="center"><a href="/CePESMaterials/main?acao=removerLivro&id_livro=<%=livro.getIdLivro()%>" title="Deletar"> <i class="glyphicon glyphicon-trash"></i></a></td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
	</div>
</div>

<jsp:include page="/template/foot.jsp"></jsp:include>

<script>
$(document).ready(function(){
	$('#listaLivros').dataTable({
	    "language": {
            "lengthMenu": "Mostrando _MENU_ registros por página",
            "zeroRecords": "Sem registros",
            "info": "Mostrando _PAGE_ de _PAGES_ páginas",
            "infoEmpty": "Nenhum registros encontrados!",
            "infoFiltered": "(Filtrado _MAX_ do total deregistros)",
            "search":"Busca",
           	"paginate": {
                "first":      "Primeiro",
                "last":       "Último",
                "next":       "Próximo",
                "previous":   "Anterior"
	        },
        }
	});
});;
</script>
