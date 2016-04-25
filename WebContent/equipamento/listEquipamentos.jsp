<%@page import="br.ages.crud.model.Equipamento"%>
<%@page import="br.ages.crud.util.Util"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/template/head.jsp"%>
<div class="panel panel-primary panel-list-equipamanto">

	<div class="panel-heading text-center">Lista Equipamentos</div>

	<div class="panel-body">

		<jsp:include page="/template/msg.jsp"></jsp:include>


		<div class="table-responsive">
			<table id="listaEquipamentos" class="table table-responsive table-striped table-hover table-condensed table-bordered">

				<thead>
					<tr>
						<th style="text-align: center;"></th>
						<th style="text-align: center;">Tipo Equipamento</th>
						<th style="text-align: center;">Numero Patrimônio</th>
						<th style="text-align: center;">Data Cadastro</th>
						<th style="text-align: center;">Valor</th>
						<th style="text-align: center;">Detalhamento</th>
						<th data-sortable="false" style="text-align: center; width:10px"></th>
						<th data-sortable="false" style="text-align: center; width:10px"></th>
					</tr>
				</thead>

				<tbody>
					<%
						int sizeListaEquipamentos = 0;
						List<Equipamento> listaEquipamentos = (List<Equipamento>) request.getAttribute("listaEquipamentos");
						if (listaEquipamentos != null) {
							sizeListaEquipamentos = listaEquipamentos.size();
							for (Equipamento equipamento : listaEquipamentos) {
					%>
					<tr>
						<td><input type="checkbox" /></td>
						<td><%= equipamento.getTipoEquipamento() %></td>
						<td><%= equipamento.getNumeroPatrimonio() %></td>
						<td align="center"><%
							DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
							String dataCadastro = df.format(equipamento.getDataCadastro());
							%>
							<%= dataCadastro %>
						</td>
						<td align="right"><%= equipamento.getValor() %></td>
						<td><b><%= equipamento.getSubTipo() + " " %></b><%= equipamento.getMarca() + " - " + equipamento.getModelo() %></td>

						<td align="center"> 
							<a href="" title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a>
						</td>
						<td align="center">
							<a class="removerEquipamento" href="#" data-toggle="modal" data-id="<%= equipamento.getId() %>" data-target="#myModal">
								<button type="button" class="btn btn-xs btn-info" >
									<span class="glyphicon glyphicon-trash"></span>
								</button>
							</a>
						</td>
					</tr>
					<%
							}
						}
					%>
				</tbody>
			</table>
			<table class="table table-responsive table-striped table-condensed table-bordered">
				<tr>
					<td align="center"><%= sizeListaEquipamentos + " equipamentos no total" %></td>
				</tr>
			</table>
	</div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Remover Equipamento</h4>
			</div>
			<div class="modal-body">Tem certeza que deseja remover o Equipamento?</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
				<a id="botaoRemover" href="#"><button type="button" class="btn btn-primary">Sim</button></a>
			</div>
		</div>
	</div>
</div>

</div>
<jsp:include page="/template/foot.jsp"></jsp:include>
<!-- Initialize the plugin: -->
<script>
$(document).ready(function(){
	$(document).on("click", ".removerEquipamento", function () {
		var id = $(this).data('id');
		$("#botaoRemover").attr('href', 'main?acao=removerEquipamento&id_equipamento='+id);
	});
		
	$('#listaEquipamentos').dataTable({
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
