<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.Editora"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

	<jsp:include page="/template/head.jsp"></jsp:include>
	
	<div class="panel panel-primary panel-add">
	
		<div class="panel-heading text-center">Alocação de Equipamento em Projeto</div>
		
			<div class="panel-body">
		
				<div class="table-responsive">
				
				<form action="main?acao=addEditora" method="post">
					<jsp:include page="/template/msg.jsp"></jsp:include>
					
					<label class="form-label ages">Projeto </label> 
					<select class="form-control" id="projeto" name="projeto" value="${param.projeto}" type="text" required>
						<option value="" >Selecione o Projeto</option>
						<option value="" >Kill DeathStar</option>
						<option value="" >Transposição Rio São Francisco</option>
						<option value="" >Tomada de Constantinopla</option>
					</select>
							
					<label class="form-label ages">Data Alocação:<span class="red">*</span></label> 
					<div class='input-group date' id='dataAlocacao'>
						<input type='text' class="form-control" id='dtAlocacao' name="dtAlocacao" value="${param.dtAlocacao}"/>
						<span class="input-group-addon">
							<span class="glyphicon glyphicon-calendar"></span>
						</span>
					</div>

					<div class="col-md-12">
						<select multiple="multiple" size="10" name="listaEquipe" class="listaEquipe" required>
							<option value="" >Castelo Branco</option>
							<option value="" >Afonso Pena</option>
							<option value="" >Getulio Vargas</option>
						</select>
					</div>
					<hr>
					<p>		
					<span><sup class="red">*</sup> campos obrigatórios</span><br>
					</p>
					<div class="text-center">
						<input class="btn btn-warning btn-limpar pull-left" type="reset"  value="Limpar"  id="limpar" name="limpar" />
						<input class="btn btn-primary btn-add pull-right" type="submit" value="Cadastrar" />
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="/template/foot.jsp"></jsp:include>
	
<script>
	var demo2 = $('.listaEquipe').bootstrapDualListbox({
		nonSelectedListLabel : 'Integrantes não associados a Equipe de um Projeto',
		selectedListLabel : 'Integrantes associados a Equipe de um Projeto',
		preserveSelectionOnMove : 'moved',
		moveOnSelect : false,
		nonSelectedFilter : '',
		filterTextClear : 'Mostrar Todos',
		infoTextEmpty : 'Sem Equipe '
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
<!-- Initialize the plugin: -->

<script type="text/javascript">
	$(function() {
		$('#dataAlocacao').datetimepicker({
			locale : 'pt-br',
			showTodayButton: true
		});
	});
</script>
