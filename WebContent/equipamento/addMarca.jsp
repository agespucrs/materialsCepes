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

		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Remover Marca</h4>
					</div>
					<div class="modal-body">Tem certeza que deseja remover esta
						marca?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
						<a id="botaoRemoverMarca" href="#"><button type="button"
								class="btn btn-primary">Sim</button></a>
					</div>
				</div>
			</div>
		</div>

		<div class="table-responsive">
			<table id="listaMarcas" class="table table-responsive table-striped table-hover table-condensed table-bordered">

				<thead>
					<tr>
						<th style="text-align: center;"></th>
						<th style="text-align: center;">ID</th>
						<th style="text-align: center;">Marca</th>
						<th data-sortable="false" style="text-align: center; width:10px"></th>
						<th data-sortable="false" style="text-align: center; width:10px"></th>
					</tr>
				</thead>

				<tbody>
					<%
						MarcaBO marcaBO = new MarcaBO();
						List<Marca> lista = marcaBO.consultarMarcas();

						for (Marca marca : lista) {
					%>
					<tr>
						<td><input type="checkbox" id="<%=marca.getId()%>" /></td>
						<td><%=marca.getId()%></td>
						<td class="col-sm-8"><input type="text"
							id="nomeDigitado<%=marca.getId()%>" value="<%=marca.getNome()%>"
							style="display: none;" /> <span id="nomeText<%=marca.getId()%>"
							style="display: block"><%=marca.getNome()%></span></td>
						<td align="center"><a href="#" id="alterar<%=marca.getId()%>"
							onclick="alterarMarca(<%=marca.getId()%>)" title="Editar"> <i
								class="glyphicon glyphicon-pencil"></i></a>
						<td align="center"><a href="#" class="removerMarca"
							title="Deletar" data-id="<%=marca.getId()%>"
							data-nome="<%=marca.getNome()%>" data-toggle="modal"
							data-target="#myModal"> <i class="glyphicon glyphicon-trash"></i></a></td>
					</tr>
					<%
						}
					%>

				</tbody>
			</table>
			<form name="alteracao" action="main?acao=alterarMarca" method="post">
				<input type="hidden" id="idMarcaAlteracao" name="idMarcaAlteracao"
					value="" /> <input type="hidden" id="nomeAlteracao"
					name="nomeAlteracao" value="" />
			</form>
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
	
	$(document).on("click", ".removerMarca", function () {
	     var id = $(this).data('id');
	     var nome = $(this).data('nome');
	     $("#botaoRemoverMarca").attr('href', 'main?acao=removerMarca&id='+id+'&nomeMensagem='+nome+'');
	     // As pointed out in comments, 
	     // it is superfluous to have to manually call the modal.
	     // $('#addBookDialog').modal('show');
	});
</script>

<script>
	function alterarMarca(idItem) {
		$('#nomeText'+idItem).hide();
		$('#nomeDigitado'+idItem).show();
		$('#alterar'+idItem).attr('onclick','alterarMarcaDois('+idItem+')');
		$('#alteracao').attr('action','main?acao=alterarMarca&idMarcaAlteracao='+idItem+'&nomeAlteracao='+$('#nomeAlteracao').val()+'');
		
	}
	
</script>
<script>
function alterarMarcaDois(idItem){
	$('#idMarcaAlteracao').val(idItem);
	var nome = $('#nomeDigitado'+idItem).val();
	$('#nomeAlteracao').val(nome);
	alteracao.submit();
}
</script>

<script>
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
		
		$('#listaMarcas').dataTable({
		    "language": {
		        "lengthMenu": "Mostrando _MENU_ registros por página",
		        "zeroRecords": "Sem registros",
		        "info": "Mostrando _PAGE_ de _PAGES_ páginas",
		        "infoEmpty": "Nenhum registros encontrados!",
		        "infoFiltered": "(Filtrado _MAX_ do total de registros)",
		        "search":"Busca",
		       	"paginate": {
		            "first":      "Primeiro",
		            "last":       "Último",
		            "next":       "Próximo",
		            "previous":   "Anterior"
		        }
		    }
		});
	});
</script>
