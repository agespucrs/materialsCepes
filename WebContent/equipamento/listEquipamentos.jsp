<%@page import="br.ages.crud.model.Editora"%>
<%@page import="br.ages.crud.util.Util"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/template/head.jsp"%>
<div class="panel panel-primary panel-list-equipamanto">

	<div class="panel-heading text-center">Lista Equipamentos</div>

	<div class="panel-body">

		<jsp:include page="/template/msg.jsp"></jsp:include>

			<div class="form-group"> <!-- a busca devera utilizar uma classe java para gerar o recordset -->
				<div class="row">
					<div class=" col-sm-4">
						<label class="form-label ages">Numero Patrimonio</label> 
						<input class="form-control" id="numeroPatrimonio" name="numeroPatrimonio"	value="${param.numeroPatrimonio}" type="text" required>
					</div>
					<div class=" col-sm-4">
						<label class="form-label ages">Tipo Equipamento </label> 
						<select class="form-control" id="tipoEquipamento" name="tipoEquipamento"value="${param.modelo}" placeholder="663,15"  type="text" required>
							<option value="" >Selecione o Tipo</option>
							<option value="" >Computador</option>
							<option value="" >Periférico</option>
							<option value="" >Dispositivo Móvekl</option>
						</select>
					</div>
					<div class=" col-sm-4">
						<label class="form-label ages">Marca</label> <!-- buscar a lista em uma classe -->
						<select class="form-control" id="marca" name="marca"	value="${param.marca}" type="text" required>
							<option value="" >Selecione a Marca</option>
							<option value="" >Dell</option>
							<option value="" >Hp</option>
							<option value="" >Sony</option>
						</select>
					</div>
					<div class=" col-sm-4">
						<label class="form-label ages">Modelo </label> <!-- os modelos irão variar conforme a marca / buscar a lista em uma classe  -->
						<select class="form-control" id="modelo" name="modelo"	value="${param.modelo}" type="text" required>
						<option value="" >Selecione o Modelo</option>
							<option value="" >Vaio</option>
							<option value="" >Vaio F115</option>
							<option value="" >Nexus</option>
						</select>
					</div>
					<div class=" col-sm-4">
						<label class="form-label ages">valor </label> 
						<input class="form-control" id="valor" name="valor"value="${param.valor}" placeholder="663,15"  type="value" required>
					</div>
					<div class=" col-sm-4">
						<label class="form-label ages">Data Cadastro </label> 
						<input class="form-control" id="dataCadastro" name="dataCadstro"value="01/01/2016"  type="text" required>
					</div>
					<div class=" col-sm-12">
						<br>
						<input class="btn btn-primary pull-right" type="submit" onclick="" value="Buscar Equipamento" />
					</div>
				</div>
			</div>
		</div>
		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">

				<thead>
					<tr>
						<th style="text-align: center;"></th>
						<th style="text-align: center;">Tipo Equipamento</th>
						<th style="text-align: center;">Numero Patrimônio</th>
						<th style="text-align: center;">Data Cadastro</th>
						<th style="text-align: center;">Valor</th>
						<th style="text-align: center;">Detalhamento</th>
						<th colspan="2" style="text-align: center;">Ações</th>
					</tr>
				</thead>

				<tbody>
					<!-- **** essas linhas abaixo  serão montadas por um array-->
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
					<!-- ***********************  -->
				</tbody>
			</table>

			<div id="totalRegistros" class="total">
				
				<p hidden="">Nenhum livro encontrado.</p>

				<p style="color: white;">Total de registros: 3  <!-- atualizado pelo total do recordset -->
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
