<%@page import="br.ages.crud.bo.MarcaBO"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.Marca"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="/template/head.jsp"></jsp:include>
<div class="panel panel-primary panel-add-marcaModelo">
	<div class="panel-heading text-center">Cadastro de Marca</div>
	<div class="panel-body">
		<form name="myForm" action="main?acao=addMarca" method="post">
			<jsp:include page="/template/msg.jsp"></jsp:include>

			<div class="form-group">
				<div class="row">
					<div class="col-md-12">
						<label class="form-label ages">Marca <span class="red">*</span></label>
						<div class="input-group">
							<input class="form-control" type="text" id="nome" name="nome"
								value="${param.nome}" required>
							<div class="input-group-btn">
								<a class="btn btn-info" href="#" onclick="myForm.submit();"
									data-toggle="tooltip"
									title="Digite a Marca e click aqui para adicionar!"><span
									class="glyphicon glyphicon-plus"></span> Marca </a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">

				<thead>
					<tr>
						<th style="text-align: center;"></th>
						<th style="text-align: center;">ID</th>
						<th style="text-align: center;">Marca</th>
						<th colspan="2" style="text-align: center;">Ações</th>
					</tr>
				</thead>

				<tbody>
					<%
						MarcaBO marcaBO = new MarcaBO();
						List<Marca> lista = marcaBO.consultarMarcas();

						for (Marca marca : lista) {
					%>
					<tr>
						<td><input type="checkbox" id="<%=marca.getId()%>"/></td>
						<td><%=marca.getId()%></td>
						<td class="col-sm-8"><%=marca.getNome()%></td>
						<td align="center"><a href="" title="Editar"> <i
								class="glyphicon glyphicon-pencil"></i></a>
						<td align="center"><a href="main?acao=removerMarca&id=<%=marca.getId()%>&nomeMensagem=<%=marca.getNome()%>" title="Deletar"> <i
								class="glyphicon glyphicon-trash"></i></a></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>
</div>
<jsp:include page="/template/foot.jsp"></jsp:include>
<script>
	var demo2 = $('.listaModelos').bootstrapDualListbox({
		nonSelectedListLabel : 'Modelos não associados a uma Marca',
		selectedListLabel : 'Modelo associados a uma Marca',
		preserveSelectionOnMove : 'moved',
		moveOnSelect : false,
		nonSelectedFilter : '',
		filterTextClear : 'Mostrar Todos',
		infoTextEmpty : 'Sem Marca '
	});
</script>
<script>
	function submeterForm() {
		$('form#myForm').submit();
	}
</script>
<script>
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>
