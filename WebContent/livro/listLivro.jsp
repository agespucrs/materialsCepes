<%@page import="br.ages.crud.model.Livro"%>
<%@page import="br.ages.crud.util.Util"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/template/head.jsp"%>
<div class="panel panel-primary panel-list">

	<div class="panel-heading text-center">Lista Livros</div>

	<div class="panel-body">

		<jsp:include page="/template/msg.jsp"></jsp:include>

		<div class="table-responsive">

			<table class="table table-hover table-striped table-bordered">
			<tr >
				<td></td>
				<td>Código ISBN</td>
				<td>Título</td>
				<td>Edição</td>
				<td>Ano</td>
				<td>Data</td>
				<td>Ações</td>
			</tr>
			
			<%
				List<Livro> listaLivros = (List<Livro>) request.getAttribute("listaLivros");
				int sizeListaLivros = listaLivros.size();
				int tdChangeColor = 0;
				
				for (Livro livro : listaLivros) {
			%>
			<tr>
				<td><input type="checkbox" /></td>
				<td><%= livro.getCodigoISBN() %></td>
				<td><%= livro.getTitulo() %></td>
				<td><%= livro.getEdicao() %></td>
				<%if (livro.getAno() == null) {%>
				<td>Não Informado</td><%}else{ %>
				<td><%= Util.toAno(livro.getAno())%></td><%} %>
				<td><%= Util.toDataNormal(livro.getDataCadastro()) %></td>
				<td>
						<a href="/CePESMaterials/main?acao=consultarLivro&id_livro=<%=livro.getIdLivro()%>"><img class="img" src="img/view.png"/></a>
						<a href="/CePESMaterials/main?acao=telaLivro&id_livro=<%=livro.getIdLivro()%>&isEdit=sim"><img class="img" src="img/edit.png"/></a>
						<a href="/CePESMaterials/main?acao=removerLivro&id_livro=<%=livro.getIdLivro()%>"><img class="img" src="img/trash.png"/></a>
						</td>
			</tr>
			<%
				}
			%>
			</table>
			
			<div id="totalRegistros" style="background: rgba(0,0,0,1)height: 40px;background: black;width: 100%;text-align: right;padding-right: 30px;line-height: 40px;"><%
			if(sizeListaLivros == 0)
			{
				%> <p>Nenhum livro encontrado.</p> <%	
			}
			%>	 
			<p style="color: white;">Total de registros: <%= sizeListaLivros %></div></p>
			
</div>
</div>
</div>


<jsp:include page="/template/foot.jsp"></jsp:include>


