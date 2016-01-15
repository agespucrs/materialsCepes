<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.Editora"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

	<jsp:include page="/template/head.jsp"></jsp:include>
	
	<div class="panel panel-primary panel-add-marcaModelo">
	
		<div class="panel-heading text-center">Cadastro de Marca e Modelo</div>
		
			<div class="panel-body">
				
				<form action="main?acao=addEditora" method="post">
					<jsp:include page="/template/msg.jsp"></jsp:include>
						
					<div class="form-group">
					<div class="row">
						<div class="col-md-12">
							<label class="form-label ages">Marca <span class="red">*</span></label> 
							<div class="input-group">
							    <input class="form-control" type="text" placeholder="" name="marca"	value="${param.marca}" />
							    <div class="input-group-btn">
							        <a class="btn btn-info" href=""  data-toggle="tooltip" title="Digite a Marca e click aqui para adicionar!"><span class="glyphicon glyphicon-plus" ></span> Marca </a>
							    </div>
							</div>
						</div>
					</div>
				
					<div class="row">
						<div class="col-md-12">
							<label class="form-label ages">Modelo</label> 
							<div class="input-group">
							    <input class="form-control" type="text" placeholder="" name="modelo"	value="${param.modelo}" />
							    <div class="input-group-btn">
							        <a class="btn btn-info" href="" data-toggle="tooltip" title="Digite um Modelo e click aqui para adicionar!"><span class="glyphicon glyphicon-plus"></span> Modelo </a>
							    </div>
							</div>
						</div>
					</div>
				
					<hr>
					 <div class="form-group">
						  <label class="form-label ages" for="sel1">Selecione a Marca para associar o Modelo:</label>
						  <select class="form-control" id="sel1">
						    <option>DELL</option>
						    <option>HP</option>
						    <option>Sony</option>
						    <option>Samsung</option>
						  </select>
					</div>
						
					<!-- http://www.virtuosoft.eu/code/bootstrap-duallistbox/ -->
						<div class="col-md-12">
						<select multiple="multiple" size="10" name="listaModelos" class="listaModelos" required>
							<option value="1">Vaio F151</option>
							<option value="2">Optplex</option>
							<option value="3">Air Book</option>
							<option value="4">Doger</option>
						</select>
						</div>
					</div>
					<span><sup class="red">*</sup> campos obrigatórios</span><br>
					<div class="text-center">
						<a class="btn btn-primary  pull-right" href="#" data-toggle="tooltip" title="Click aqui para associar a Marca a um Modelo!"> Associar</a>
					</div>
				</form>
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
	//Põe cor laranja nos titulos
	$('div[class*="box"]').find('label').css('color', '#F89406');
	
	//Dá espaçamento no grupo usuários
	$('div[class*="bootstrap-duallistbox-container"]').eq(1).addClass('margin-top');

	$(document).ready(function(){
	    $('[data-toggle="tooltip"]').tooltip();   
	});
</script>
