<%@page import="br.ages.crud.model.Editora"%>
<%@page import="br.ages.crud.util.Util"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/template/head.jsp"%>
<div class="panel panel-primary panel-add-listaProjetos">

	<div class="panel-heading text-center">Lista de Projetos</div>

	<div class="panel-body">

		<jsp:include page="/template/msg.jsp"></jsp:include>

		<div class="table-responsive">

			<table id="listaProjetos" class="table table-responsive table-striped table-hover table-condensed table-bordered">

				<thead>
					<tr>
						<th style="text-align: center;"></th>
						<th style="text-align: center;">Projeto</th>
						<th style="text-align: center;">Programa</th>
						<th style="text-align: center;">Origem</th>
						<th style="text-align: center;">Coordenador</th>
						<th style="text-align: center;">Participantes</th>
						<th data-sortable="false" style="text-align: center; width:10px"></th>
						<th data-sortable="false" style="text-align: center; width:10px"></th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td><input type="checkbox" /></td>
						<td>Kill DeathStar</td>
						<td>Nova Repúlica</td>
						<td>DELL</td>
						<td>Professor 1</td>
						<td align="center">
							<button data-toggle="collapse" data-target="#usuarios1">3</button>
							<div id="usuarios1" class="collapse">
								<div class="row">
									<div align="left" class="col-sm-12" >* Gen Akbar</div>
									<div align="left" class="col-sm-12" >* Han Solo</div>
									<div align="left" class="col-sm-12" >* Princesa Leia</div>
								</div>
							</div>
						</td>
						<td align="center"><a href="" title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a></td>
						<td align="center"><a href="" title="Deletar"> <i class="glyphicon glyphicon-trash"></i></a></td>
					</tr>
					
					<tr>
						<td><input type="checkbox" /></td>
						<td>Transposição Rio São Francisco</td>
						<td>PAC</td>
						<td>Povo</td>
						<td>Professor 2</td>
						<td align="center">
							<button data-toggle="collapse" data-target="#usuarios2">4</button>
							<div id="usuarios2" class="collapse">
								<div class="row">
									<div align="left" class="col-sm-12" >* JK</div>
									<div align="left" class="col-sm-12" >* Ranieri Mazzilli</div>
									<div align="left" class="col-sm-12" >* Janio Quadros</div>
									<div align="left" class="col-sm-12" >* Jango</div>
								</div>
							</div>
						</td>
						<td align="center"><a href="" title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a></td>
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
	$('#listaProjetos').dataTable({
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