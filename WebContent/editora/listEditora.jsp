<%@page import="br.ages.crud.model.Editora"%>
<%@page import="br.ages.crud.util.Util"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/template/head.jsp"%>
<div class="panel panel-primary panel-add">

	<div class="panel-heading text-center">Lista de Editoras</div>

	<div class="panel-body">

		<jsp:include page="/template/msg.jsp"></jsp:include>

		<div class="table-responsive">

			<table class="table table-hover table-striped table-bordered">

				<thead>
					<tr>
						<th style="text-align: center;"></th>
						<th style="text-align: center;">ID</th>
						<th style="text-align: center;">Nome</th>
						<th colspan="2" style="text-align: center;">Ações</th>
					</tr>
				</thead>
					<tbody>
					<%
						List<Editora> listaEditoras = (List<Editora>) request.getAttribute("listaEditoras");
						int sizeListaEditoras = listaEditoras.size();
						int tdChangeColor = 0;

						for (Editora editora : listaEditoras) {
					%>
					<tr class="coluna-ed">
						<td><input type="checkbox" /></td>
						<td align="center" class="ed-id" id='<%=editora.getIdEditora()%>'><%=editora.getIdEditora()%></td>
						<td align="center" data-teste="lixo" class="ed-nome" ><%=editora.getNome()%><p>
							<form id="formEdit" action="" method="post" class="form-edit">
								<input class="new-ed-nome hidden" type="text" id="nome" name="nome" value="<%=editora.getNome()%>"></input>
							</form>
						</td>
						<td align="center">
							<i class="glyphicon glyphicon-ok pointer hidden" style="cursor:pointer"></i>
							<i class="glyphicon glyphicon-pencil pointer" style="cursor:pointer"></i>	
						</td>
						<td align="center"><a href="/CePESMaterials/main?acao=removerEditora&id_editora=<%=editora.getIdEditora()%>" title="Deletar"> <i class="glyphicon glyphicon-trash"></i></a></td>
					</tr>
					<%
						}
					%>
					
				</tbody>
			</table>
			<div id="totalRegistros" style="background: rgba(0, 0, 0, 1) height: 40px; background: black; width: 100%; text-align: right; padding-right: 30px; line-height: 40px;">
				<%
					if (sizeListaEditoras == 0) {
				%>
				<p>Nenhum livro encontrado.</p>
				<%
					}
				%>
				<p style="color: white;"> Total de registros: <%=sizeListaEditoras%>
			</div>
		</div>
	</div>
</div>
<script>

$(".glyphicon-ok").click(function(){
	var pai = $(this).parent().parent();
	console.log(pai);
	var nome = pai.find('.new-ed-nome').val();
	var id = pai.find('.ed-id').attr('id');
	console.log(nome, id);
	pai.find('.form-edit').prop('action', "main?acao=alterEditora&id_editora=" + id).submit();
});
$('.glyphicon-pencil').click(function(){
	var variavel = $(this).closest('tr').find('td[teste]').attr('teste');
    alert(variavel);
	var pai = $(this).parent().parent();    /* $('#formEdit'); */
	console.log(pai)
	pai.find('.ed-nome p').hide();
	pai.find('.ed-nome input').removeClass('hidden');
	$(this).hide();
	pai.find(".glyphicon-ok").removeClass("hidden");	
});

</script>
<jsp:include page="/template/foot.jsp"></jsp:include>
