<%@page import="br.ages.crud.model.Usuario"%>
<%@page import="br.ages.crud.util.Util"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/template/head.jsp"%>
<div class="panel panel-primary panel-list">

	<div class="panel-heading text-center">Lista Usuarios</div>

	<div class="panel-body">

		<jsp:include page="/template/msg.jsp"></jsp:include>

		<div class="table-responsive">

			<table class="table table-hover table-striped table-bordered">

				<thead>
				<tr>
					<th style="text-align: center;"></th>
					<th style="text-align: center;">Matricula</th>
					<th style="text-align: center;">Nome</th>
					<th style="text-align: center;">E-Mail</th>
					<th style="text-align: center;">Usuário</th>
					<th style="text-align: center;">ADM</th>
					<th colspan="2" style="text-align: center;">Ações</th>
				</tr>
				</thead>

			
			<%
				List<Usuario> listaUsuarios = (List<Usuario>) request.getAttribute("listaUsuarios");
				int sizeListaUsuarios = listaUsuarios.size();
				int tdChangeColor = 0;
				
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
			
			<div id="totalRegistros" style="background: rgba(0,0,0,1)height: 40px;background: black;width: 100%;text-align: right;padding-right: 30px;line-height: 40px;"><%
				if(sizeListaUsuarios == 0)
				{
					%> <p>Nenhum usuário encontrado.</p> <%	
				}
				%>	 
				<p style="color: white;">Total de registros: <%= sizeListaUsuarios %></p>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/template/foot.jsp"></jsp:include>






