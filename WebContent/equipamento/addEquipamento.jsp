<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.Editora"%>
<%@page import="br.ages.crud.model.Marca"%>
<%@page import="br.ages.crud.bo.MarcaBO"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="/template/head.jsp"></jsp:include>

<div class="panel panel-primary panel-add">

	<div class="panel-heading text-center">Cadastro de Equipamento</div>
	
		<div class="panel-body">
	
			<form action="main?acao=addEquipamentos" method="post">
				<jsp:include page="/template/msg.jsp"></jsp:include>
				<div class="form-group">
					<div class="row">	
						<div class=" col-sm-6">
							<label class="form-label ages">Numero Patrimonio <span class="red">*</span></label> 
							<input class="form-control" id="numeroPatrimonio" name="numeroPatrimonio"	value="${param.numeroPatrimonio}" type="text" required>
						</div>
				
						<div class=" col-sm-6">
							<label class="form-label ages">Status <span class="red">*</span></label> 
							<select class="form-control" id="status" name="status" required>
								<option value="" >Selecione o Status</option>
								<option value="1" >Ativo</option>
								<option value="3" >Manutenção</option>
								<option value="0" >Inativo</option>
								<option value="2" >Descartado</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class=" col-sm-6">
								<label class="form-label ages">Tipo Equipamento <span class="red">*</span></label> <!-- será buscado alista em um enum -->
								<select class="form-control" id="tipo" name="tipo" required >
									<option value="" >Selecione o Tipo de Equipamento</option>
									<option value="A" >Acessorio</option>
									<option value="C" >Computador</option>
									<option value="M" >Dispositivo Móvel</option>
									<option value="P" >Periférico</option>
								</select>
						</div>
						<div class="col-sm-6 hidden" id="tipoComputador" >
							<label class="form-label ages">Tipo de Computador<span class="red">*</span></label> <!-- será buscado alista em um enum -->
							<select class="form-control" id="tipoComputador" name="tipoComputador" required>
								<option value="" >Selecione o Tipo</option>
								<option value="1" >Desktop</option>
								<option value="2" >Notebook</option>
								<option value="3" >Servidor</option>
							</select>
						</div>
						<div class=" col-sm-6 hidden" id="tipoPeriferico" >
							<label class="form-label ages">Tipo de Periférico<span class="red">*</span></label> <!-- sera buscado a lista em um enum -->
							<select class="form-control" id="tipoPeriferico" name="tipoPeriferico" required>
								<option value="" >Selecione o Tipo</option>
								<option value="" >Monitor</option>
								<option value="" >TV</option>
								<option value="" >Impressora</option>
								<option value="" >Switch</option>
								<option value="" >Outros</option>
							</select>
						</div>
						<div class=" col-sm-6 hidden" id="tipoMovel">
							<label class="form-label ages">Tipo Dispositivo Móvel<span class="red">*</span></label> <!-- sera buscado a lista em um enum -->
							<select class="form-control" id="tipoMobile" name="tipoMobile" required>
								<option value="" >Selecione o Tipo</option>
								<option value="" >Celular</option>
								<option value="" >Tablet</option>
								<option value="" >Smartphone</option>
								<option value="" >Outros</option>
							</select>
						</div>
					</div>
					
					<div class="">
						<label class="form-label ages">Marca <span class="red">*</span></label> <!-- buscar a lista em uma classe -->
						<select class="form-control" id="marca" name="marca" value="${param.marca}" type="text" required>
							<option value="" >Selecione a Marca</option>
							<%
								MarcaBO marcaBO = new MarcaBO();
								List<Marca> lista = marcaBO.consultarMarcas();
								for (Marca marca : lista) {
							%>
							<option value="<%= marca.getId() %>>" ><%= marca.getNome() %></option>
							<%	} %>
						</select>
					</div>

				<label class="form-label ages">Modelo </label> <!-- os modelos irão variar conforme a marca / buscar a lista em uma classe  -->
				<input class="form-control" id="modelo" name="modelo" value="${param.numeroPatrimonio}" type="text" required>
				
				<div class="row">
					<div class=" col-sm-6">
						<label class="form-label ages">Valor </label> 
						<input class="form-control" id="valor" name="valor" value="${param.modelo}" placeholder="R$ 1.550,00"  type="text" style="text-align: right;" >
					</div>
					<div class=" col-sm-6">
						<label class="form-label ages">Data Cadastro </label> 
						<input class="form-control" id="dataCadastro" name="dataCadstro" value="01/01/2016" disabled="disabled" type="text" style="text-align: center;" required>
					</div>
				</div>
				<label class="form-label ages">Projeto <span class="red">*</span></label></label> 
				<select class="form-control" id="projeto" name="projeto" value="${param.projeto}" type="text" required>
					<option value="" >Selecione o Projeto</option>
					<option value="" >Kill DeathStar</option>
					<option value="" >Transposição Rio São Francisco</option>
					<option value="" >Tomada de Constantinopla</option>
				</select>
				<label class="form-label ages">Observação: </label> 
				<textarea class="form-control"  rows="2" id="descricao" name="descricao" value="${param.descricao}"></textarea>
				
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
<script>
$('#tipo').on('change', function() {
	var tipo =   $(this).val()
	switch (tipo) {
		case 'C':
			$('#tipoComputador').removeClass('hidden');
			$('#tipoPeriferico').addClass('hidden');
			$('#tipoMovel').addClass('hidden');
			break;
		case 'P':
			$('#tipoComputador').addClass('hidden');
			$('#tipoPeriferico').removeClass('hidden');
			$('#tipoMovel').addClass('hidden');
			break;
		case 'M':
			$('#tipoComputador').addClass('hidden');
			$('#tipoPeriferico').addClass('hidden');
			$('#tipoMovel').removeClass('hidden');
			break;
		default:
			break;
	} 
});
</script>
