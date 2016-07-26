<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.Periferico"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="/template/head.jsp"></jsp:include>

<div class="panel panel-primary panel-add">

	<div class="panel-heading text-center">Cadastro de Periférico</div>
	
		<div class="panel-body">
	
			<form action="main?acao=add" method="post">
				<jsp:include page="/template/msg.jsp"></jsp:include>
				<div class="form-group">
					<div class="row">	
						<div class=" col-sm-6">
							<label class="form-label ages">Numero Patrimonio <span class="red">*</span></label> 
							<input class="form-control" id="numeroPatrimonio" name="numeroPatrimonio"	value="${param.numeroPatrimonio}" type="text" required>
						</div>
						<div class=" col-sm-6">
							<label class="form-label ages">Tipo <span class="red">*</span></label> <!-- sera buscado a lista em um enum -->
							<select class="form-control" id="tipo" name="tipo" required>
								<option value="" >Selecione o Tipo</option>
								<option value="" >Teclado</option>
								<option value="" >Mouse</option>
								<option value="" >Monitor</option>
								<option value="" >TV</option>
								<option value="" >Impressora</option>
								<option value="" >Hard drive</option>
								<option value="" >Switch</option>
								<option value="" >Outros</option>
							</select>
						</div>
					</div>
				
					<label class="form-label ages">Marca <span class="red">*</span></label> <!-- buscar a lista em uma classe -->
					<select class="form-control" id="marca" name="marca"	value="${param.marca}" type="text" required>
						<option value="" >Selecione a Marca</option>
						<option value="" >Dell</option>
						<option value="" >Hp</option>
						<option value="" >Sony</option>
					</select>

					<label class="form-label ages">Modelo </label> <!-- os modelos irão variar conforme a marca / buscar a lista em uma classe  -->
					<select class="form-control" id="modelo" name="modelo"	value="${param.modelo}" type="text" required>
					<option value="" >Selecione o Modelo</option>
						<option value="" >Vaio</option>
						<option value="" >Vaio F115</option>
						<option value="" >Nexus</option>
					</select>

				<div class="row">
					<div class=" col-sm-6">
						<label class="form-label ages">valor </label> 
						<input class="form-control" id="valor" name="valor"value="${param.modelo}" placeholder="663,15"  type="text" required>
					</div>
					<div class=" col-sm-6">
						<label class="form-label ages">Data Cadastro </label> 
						<input class="form-control" id="dataCadastro" name="dataCadstro"value="01/01/2016" disabled="disabled" type="text" required>
					</div>
				</div>
				
				<label class="form-label ages">Descrição: </label> 
				<textarea class="form-control"  rows="4" id="descricao" name="descricao" value="${param.descricao}"></textarea>
				
				<div class="row">
				<div class=" col-sm-6">
					<label class="form-label ages">Status <span class="red">*</span></label> 
					<select class="form-control" id="status" name="status" required>
						<option value="" >Selecione o Status</option>
						<option value="" >Ativo</option>
						<option value="" >Inativo</option>
					</select>
				</div>
				</div>
			</div>
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
<jsp:include page="/template/foot.jsp"></jsp:include>
