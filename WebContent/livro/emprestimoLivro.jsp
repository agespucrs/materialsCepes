<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.Editora"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="/template/head.jsp"></jsp:include>

<div class="panel panel-primary panel-add-emprestimo">

	<div class="panel-heading text-center">Empréstimo Livro</div>
	
		<div class="panel-body">
			
			<form action="main?acao=" method="post">
				<jsp:include page="/template/msg.jsp"></jsp:include>
					
				<div class="form-group">
					<label class="form-label ages">Usuario <span class="red">*</span></label> 
					<select class="form-control" id="livro" name="livro"	value="${param.livro}" type="text" required>
						<option value="" >Selecione o Usuario</option>
						<option value="" >Castelo Branco</option>
						<option value="" >Afonso Pena</option>
						<option value="" >Getulio Vargas</option>
					</select>
					<div class="row">
						<div class="col-sm-6">
						<label class="form-label ages">Livro <span class="red">*</span></label> 
							<select class="form-control" id="livro" name="livro"	value="${param.livro}" type="text" required>
								<option value="" >Selecione o Livro</option>
								<option value="" >Brumas de Avalon</option>
								<option value="" >Ages of War</option>
								<option value="" >System of Down</option>
							</select>
						</div>
						<div class="col-sm-6">
							<label class="form-label ages">Numero Cópia Livro <span class="red">*</span></label> 
							<select class="form-control" id="livro" name="livro"	value="${param.livro}" type="text" required>
								<option value="" >Selecione o Numero</option>
								<option value="" >005.114 L3214u</option>
								<option value="" >005.133 A639a</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6">
							<label class="form-label ages">Data Empréstimo:<span class="red">*</span></label> 
							<div class='input-group date' id='dataEmprestimo'>
								<input type='text' class="form-control" id='dtEmprestimo' name="dtEmprestimo" value="${param.dtEmprestimo}"/>
								<span class="input-group-addon">
									<span class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
						</div>
						<div class="col-sm-6">
							<label class="form-label ages">Data Entrega:<span class="red">*</span></label> 
							<div class='input-group date' id='dataEntrega'>
								<input type='text' class="form-control" id='dtEntrega' name="dtEntrega" value="${param.dtEntrega}"/>
								<span class="input-group-addon">
									<span class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
						</div>
					</div>
					
					<label class="form-label ages">Observação <span class="red">*</span></label> 
					<textarea input class="form-control" cols="" rows="5" id="obs" name="obs" value="${param.obs}" ></textarea>
				
					<hr>
					<p>		
					<span><sup class="red">*</sup> campos obrigatórios</span><br>
					</p>
					<div class="text-center">
						<input class="btn btn-warning btn-limpar pull-left" type="reset"  value="Limpar"  id="limpar" name="limpar" />
						<input class="btn btn-primary btn-add pull-right" type="submit" value="Cadastrar" />
					</div>
				
				</div>
			</form>
		</div>
	</div>


<!-- Initialize the plugin: -->

<script type="text/javascript">
	$(function() {
		$('#dataEmprestimo').datetimepicker({
			locale : 'pt-br',
			showTodayButton: true
		});

		$('#dataEntrega').datetimepicker({
			locale : 'pt-br',
			showTodayButton: true
		});
	});
</script>
<jsp:include page="/template/foot.jsp"></jsp:include>
