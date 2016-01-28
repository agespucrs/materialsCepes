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

			<table class="table table-hover table-striped table-bordered">

				<thead>
					<tr>
						<th style="text-align: center;"></th>
						<th style="text-align: center;">Projeto</th>
						<th style="text-align: center;">Programa</th>
						<th style="text-align: center;">Origem</th>
						<th style="text-align: center;">Participantes</th>
						<th colspan="2" style="text-align: center;">Ações</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td><input type="checkbox" /></td>
						<td>Kill DeathStar</td>
						<td>Nova Repúlica</td>
						<td>DELL</td>
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

			<div id="totalRegistros"
				style="background: rgba(0, 0, 0, 1) height: 40px; background: black; width: 100%; text-align: right; padding-right: 30px; line-height: 40px;">
				
				<p hidden="">Nenhum livro encontrado.</p>

				<p style="color: white;">
					Total de registros: n

			</div>

		</div>
	</div>
</div>

<jsp:include page="/template/foot.jsp"></jsp:include>
