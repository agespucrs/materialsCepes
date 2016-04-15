<%@page import="br.ages.crud.model.Equipamento"%>
<%@page import="br.ages.crud.util.Util"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
						List<Equipamento> listaEquipamentos = (List<Equipamento>) request.getAttribute("listaEquipamentos");
						int sizeListaEquipamentos = listaEquipamentos.size();
						for (Equipamento equipamento : listaEquipamentos) {
					%>
					<tr>
						<td><input type="checkbox" /></td>
						<td><%= equipamento.getTipoEquipamento() %></td>
						<td><%= equipamento.getNumeroPatrimonio() %></td>
						<td align="center"><%= equipamento.getDataCadastro() %></td>
						<td align="right"><%= equipamento.getValor() %></td>
						<td><%= equipamento.getObservacoes() %></td>

						<td align="center"><a href="" title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a>
						<td align="center"><a href="" title="Deletar"> <i class="glyphicon glyphicon-trash"></i></a></td>
					</tr>
					<!--
					<tr>
						<td><input type="checkbox" /></td>
						<td>Computador</td>
						<td>8912345</td>
						<td align="center">01/01/2016</td>
						<td align="right">3.990,00</td>
						<td><b>Desktop</b> Dell - Optiplex </td>

						<td align="center"><a href="" title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a>
						<td align="center"><a href="" title="Deletar"> <i class="glyphicon glyphicon-trash"></i></a></td>
					</tr>
					-->
					<%
						}
					%>
					<tr>
						<td><input type="checkbox" /></td>
						<td>Periférico</td>
						<td>8912350</td>
						<td align="center">01/01/2016</td>
						<td align="right">660,00</td>
						<td><b>Impressora</b> HP - Deskjet Ink Advantage 1115 </td>

						<td align="center"><a href="" title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a>
						<td align="center"><a href="" title="Deletar"> <i class="glyphicon glyphicon-trash"></i></a></td>
					</tr>
					<tr>
						<td><input type="checkbox" /></td>
						<td>Dispositivo Móvel</td>
						<td>8912355</td>
						<td align="center">01/01/2016</td>
						<td align="right">1.990,00</td>
						<td><b>Tablet</b> Apple - Air</td>

						<td align="center"><a href="" title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a>
						<td align="center"><a href="" title="Deletar"> <i class="glyphicon glyphicon-trash"></i></a></td>
					</tr>
				</tbody>
			</table>
	</div>
</div>
</div>
<jsp:include page="/template/foot.jsp"></jsp:include>
<!-- Initialize the plugin: -->
<script>
$(document).ready(function(){
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
