<%@page import="br.ages.crud.model.Livro"%>
<%@page import="br.ages.crud.model.Autor"%>
<%@page import="br.ages.crud.util.Util"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/template/head.jsp"%>
<div class="panel panel-primary panel-list">

	<div class="panel-heading text-center">Lista Livros</div>

	<div class="panel-body">

		<jsp:include page="/template/msg.jsp"></jsp:include>

			<div class="form-group"> <!-- a busca devera utilizar uma classe java para gerar o recordset -->
				<div class="row">
					<div class=" col-sm-6">
						<label class="form-label ages">ISBN</label> 
						<input class="form-control" id="isbn" name="isbn"	value="${param.isbn}" type="text" required>
					</div>
					<div class=" col-sm-6">
						<label class="form-label ages">Autor </label> 
						<select class="form-control" id="tipoEquipamento" name="tipoEquipamento"value="${param.modelo}" placeholder="663,15"  type="text" required>
							<option value="" >Selecione o Autor...</option>
							<option value="" >Cássio Trindade</option>
							<option value="" >Paulo Coelho</option>
							<option value="" >Pafuncio Fagundes</option>
							<option value="" >....</option>
						</select>
					</div>
				</div>
				<div class="row">
					<div class=" col-sm-8">
						<label class="form-label ages">Autor </label> 
						<input class="form-control" id="autor" name="valor" value="${param.autor}" placeholder=""  type="value" required>
					</div>
					
					<div class=" col-sm-4">
						<br>
						<input class="btn btn-primary pull-right" type="submit" onclick="" value="Buscar Livro" />
					</div>
				</div>
			</div>
	
		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<tr >
					<td></td>
					<td>Código ISBN</td>
					<td>Título</td>
					<td>Edição</td>
					<td>Ano</td>
					<td>Data</td>
					<td>Autor</td>
					<th colspan="2" style="text-align: center;">Ações</th>
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
			
			<div id="totalRegistros" class="total">
				<%
				if(sizeListaLivros == 0)
				{
					%> <p>Nenhum livro encontrado.</p> <%	
				}
				%>	 
				<p style="color: white;">Total de registros: <%= sizeListaLivros %></div></p>
			</div>
			<div align="center">
			<ul class="pagination"> <!-- criar uma classe java para gerar a paginação -->
				<li><a href="#">&laquo;</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#">&raquo;</a></li>
			</ul>
			</div>
		</div>
	</div>


<jsp:include page="/template/foot.jsp"></jsp:include>


