<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="br.ages.crud.model.Editora"%>
<%@page import="br.ages.crud.model.Marca"%>
<%@page import="br.ages.crud.model.Projeto"%>
<%@page import="br.ages.crud.model.Tipo"%>
<%@page import="br.ages.crud.model.TipoEquipamento"%>
<%@page import="br.ages.crud.bo.MarcaBO"%>
<%@page import="br.ages.crud.bo.ProjetoBO"%>
<%@page import="br.ages.crud.bo.TipoBO"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="/template/head.jsp"></jsp:include>

<div class="panel panel-primary panel-add">

	<div class="panel-heading text-center">Cadastro de Equipamento</div>
	
		<div class="panel-body">
	
			<form action="main?acao=addEquipamento" method="post">
				<jsp:include page="/template/msg.jsp"></jsp:include>
				<div class="form-group">
					<div class="row">	
						<div class=" col-sm-6" id="numeroPatrimonio">
							<label class="form-label ages">Numero Patrimonio <span class="red">*</span></label> 
							<input class="form-control" id="inputNumeroPatrimonio" name="numeroPatrimonio"	value="${param.numeroPatrimonio}" type="text" required>
						</div>
						
						<div class="col-sm-6 hidden" id="quantidade">
							<label class="form-label ages">Quantidade <span class="red">*</span></label> 
							<input class="form-control" id="inputQuantidade" name="quantidade" value="${param.quantidade}" type="text" required>
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
						
						<div class=" col-sm-6">
								<label class="form-label ages">Tipo Equipamento <span class="red">*</span></label> <!-- será buscado alista em um enum -->
								<select class="form-control" id="tipoEquipamento" name="tipoEquipamento" required >
									<option value="" >Selecione o Tipo de Equipamento</option>
									<option value="A" >Acessorio</option>
									<option value="C" >Computador</option>
									<option value="M" >Dispositivo Móvel</option>
									<option value="P" >Periférico</option>
								</select>
						</div>
						<div class="col-sm-6 hidden" id="tipoAcessorio" >
							<label class="form-label ages">Tipo de Acessório<span class="red">*</span></label>
							<input class="form-control" id="inputTipoAcessorio" name="tipoAcessorio" value="${param.tipoAcessorio}" type="text" required>
						</div>
						<div class="col-sm-6 hidden" id="tipoComputador" >
							<label class="form-label ages">Tipo de Computador<span class="red">*</span></label>
							<select class="form-control" id="selectComputador" name="tipoComputador" required>
								<option value="" >Selecione o Tipo</option>
								<%
									TipoBO tipoBO = new TipoBO();
									List<Tipo> listaDeTipos = tipoBO.consultarPeloTipo(TipoEquipamento.COMPUTADOR);
									for (Tipo tipo : listaDeTipos) {
								%>
								<option value="<%= tipo.getId() %>" ><%= tipo.getNome() %></option>
								<%	} %>
							</select>
						</div>
						<div class=" col-sm-6 hidden" id="tipoPeriferico" >
							<label class="form-label ages">Tipo de Periférico<span class="red">*</span></label>
							<select class="form-control" id="selectPeriferico" name="tipoPeriferico" required>
								<option value="" >Selecione o Tipo</option>
								<%
									listaDeTipos = tipoBO.consultarPeloTipo(TipoEquipamento.PERIFERICO);
									for (Tipo tipo : listaDeTipos) {
								%>
								<option value="<%= tipo.getId() %>" ><%= tipo.getNome() %></option>
								<%	} %>
							</select>
						</div>
						<div class=" col-sm-6 hidden" id="tipoMovel">
							<label class="form-label ages">Tipo Dispositivo Móvel<span class="red">*</span></label>
							<select class="form-control" id="selectMobile" name="tipoMobile" required>
								<option value="" >Selecione o Tipo</option>
								<%
									listaDeTipos = tipoBO.consultarPeloTipo(TipoEquipamento.DISPOSITIVO_MOVEL);
									for (Tipo tipo : listaDeTipos) {
								%>
								<option value="<%= tipo.getId() %>" ><%= tipo.getNome() %></option>
								<%	} %>
							</select>
						</div>
					</div>
					
					<div class="">
						<label class="form-label ages">Marca <span class="red">*</span></label>
						<select class="form-control" id="marca" name="marca" value="${param.marca}" type="text" required>
							<option value="" >Selecione a Marca</option>
							<%
								MarcaBO marcaBO = new MarcaBO();
								List<Marca> lista = marcaBO.consultarMarcas();
								for (Marca marca : lista) {
							%>
							<option value="<%= marca.getId() %>" ><%= marca.getNome() %></option>
							<%	} %>
						</select>
					</div>

				<label class="form-label ages">Modelo </label>
				<input class="form-control" id="modelo" name="modelo" value="${param.modelo}" type="text" required>
				
				<div class="row">
					<div class=" col-sm-6">
						<label class="form-label ages">Valor </label> 
						<input class="form-control" id="valor" name="valor" value="${param.valor}" placeholder="R$ 1.550,00"  type="text" style="text-align: right;" >
					</div>
					
					<div class="col-sm-6">
							<label class="form-label ages">Data Cadastro:<span class="red">*</span></label> 
							<div class='input-group date' id='dataCadastro'>
								<input type='text' class="form-control" name="dataCadastro" value="${param.dataCadastro}"/>
								<span class="input-group-addon">
									<span class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
						</div>
						
						
						
				</div>
				<label class="form-label ages">Projeto <span class="red">*</span></label></label> 
				<select class="form-control" id="projeto" name="projeto" value="${param.projeto}" type="text" required>
					<option value="" >Selecione o Projeto</option>
					<%
						ProjetoBO projetoBO = new ProjetoBO();
						List<Projeto> listaDeProjetos = projetoBO.listarProjetos();
						for (Projeto projeto : listaDeProjetos) {
					%>
					<option value="<%= projeto.getId() %>"><%= projeto.getNomeProjeto() %></option>
					<%
						}
					%>
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
$('#tipoEquipamento').on('change', function() {
	var tipo =   $(this).val()
	switch (tipo) {
		case 'C':
			escondeElementos();
			$('#tipoComputador').removeClass('hidden');
			$('#numeroPatrimonio').removeClass('hidden');
			
			$('#selectComputador').attr("required");
			$('#selectPeriferico').removeAttr("required");
			$('#selectMobile').removeAttr("required");
			$('#inputQuantidade').removeAttr("required");
			$('#inputTipoAcessorio').removeAttr("required");
			break;
		case 'P':
			escondeElementos();
			$('#tipoPeriferico').removeClass('hidden');
			$('#numeroPatrimonio').removeClass('hidden');
			
			$('#selectComputador').removeAttr("required");
			$('#selectPeriferico').attr("required");
			$('#selectMobile').removeAttr("required");
			$('#inputQuantidade').removeAttr("required");
			$('#inputTipoAcessorio').removeAttr("required");
			break;
		case 'M':
			escondeElementos();
			$('#tipoMovel').removeClass('hidden');
			$('#numeroPatrimonio').removeClass('hidden');
			
			$('#selectComputador').removeAttr("required");
			$('#selectPeriferico').removeAttr("required");
			$('#selectMobile').attr("required");
			$('#inputQuantidade').removeAttr("required");
			$('#inputTipoAcessorio').removeAttr("required");
			break;
		case 'A':
			escondeElementos();
			$('#tipoAcessorio').removeClass('hidden');
			$('#quantidade').removeClass('hidden');
			
			$('#selectComputador').removeAttr("required");
			$('#selectPeriferico').removeAttr("required");
			$('#selectMobile').removeAttr("required");
			$('#inputNumeroPatrimonio').removeAttr("required");
		default:
			break;
	} 
});

function escondeElementos() {
	$('#tipoComputador').addClass('hidden');
	$('#tipoPeriferico').addClass('hidden');
	$('#tipoMovel').addClass('hidden');
	$('#tipoAcessorio').addClass('hidden');
	
	$('#numeroPatrimonio').addClass('hidden');
	$('#quantidade').addClass('hidden');
}

$(function() {
	$('#dataCadastro').datetimepicker({
		locale : 'pt-br',
		showTodayButton: true,
		format: 'DD/MM/YYYY'
	});
});
</script>
