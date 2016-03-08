<%@page import="br.ages.crud.model.Usuario"%>
<%@page import="br.ages.crud.util.Util"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/template/head.jsp"%>
<div class="panel panel-primary panel-list">

	<div class="panel-heading text-center">Lista Usuários</div>

	<div class="panel-body">

		<jsp:include page="/template/msg.jsp"></jsp:include>

		<div class="table-responsive">

			<table id="listaUsuarios" class="table table-responsive table-striped table-hover table-condensed table-bordered">

				<thead>
				<tr>
					<th style="text-align: center;"></th>
					<th style="text-align: center;">Matricula</th>
					<th style="text-align: center;">Nome</th>
					<th style="text-align: center;">E-Mail</th>
					<th style="text-align: center;">Usuário</th>
					<th style="text-align: center;">ADM</th>
					<th data-sortable="false" style="text-align: center; width:10px"></th>
					<th data-sortable="false" style="text-align: center; width:10px"></th>
				</tr>
				</thead>
			<%
				List<Usuario> listaUsuarios = (List<Usuario>) request.getAttribute("listaUsuarios");
				int sizeListaUsuarios = listaUsuarios.size();
				
				for (Usuario usuario : listaUsuarios) {
			%>
				<tr>
					<td><input type="checkbox" /></td>
					<td class="alignCenter"><%=usuario.getMatricula()%></td>
					<td class="alignLeft"><%=usuario.getNome()%></td>
					<td class="alignLeft"><%=usuario.getEmail()%></td>
					<td class="alignLeft"><%=usuario.getUsuario()%></td>
					<td class="alignCenter"><%=usuario.getAdministrador()%></td>
					<td align="center"><a href="/CePESMaterials/main?acao=telaUser&id_usuario=<%=usuario.getIdUsuario()%>&isEdit=sim" title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a></td>
					<td align="center"><a href="/CePESMaterials/main?acao=removerUser&id_usuario=<%=usuario.getIdUsuario()%>" title="Deletar"> <i class="glyphicon glyphicon-trash"></i></a></td>
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
	$('#listaUsuarios').dataTable({
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




