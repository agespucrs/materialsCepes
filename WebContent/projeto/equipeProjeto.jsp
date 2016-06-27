<%@page import="br.ages.crud.model.UsuarioProjeto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.ages.crud.model.Usuario"%>
<%@page import="br.ages.crud.model.Projeto"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.Editora"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

	<jsp:include page="/template/head.jsp"></jsp:include>
	
	<div class="panel panel-primary panel-add">
	
		<div class="panel-heading text-center">Aloca��o de Equipe em Projeto</div>
		
			<div class="panel-body">
		
				<div class="table-responsive">
				
				<form action="main?acao=addEquipeProjeto" method="post">
					<jsp:include page="/template/msg.jsp"></jsp:include>
					
					<label class="form-label ages">Projeto </label>
					<select class="form-control" id="projeto" name="projeto" value="${param.projeto}" type="text" required>
						<option value="" >Selecione o Projeto</option>
						<%
						Integer projetoSelecionado = null;
						if (null != request.getParameter("idProjeto")){
							projetoSelecionado = Integer.parseInt(request.getAttribute("idProjeto").toString());
						}
						List<Projeto> projetos = (List<Projeto>)request.getAttribute("projetos");
						for (Projeto projeto : projetos) {%>
						<option value="<%=projeto.getId() %>" <%= (null != projetoSelecionado && projetoSelecionado == projeto.getId()) ? "selected" : "" %>><%=projeto.getNomeProjeto() %></option>
						<%} %>
					</select>
							
					<label class="form-label ages">Data Aloca��o:<span class="red">*</span></label> 
					<div class='input-group date' id='dataAlocacao'>
						<input type='text' class="form-control" id='dtAlocacao' name="dtAlocacao" value="${param.dtAlocacao}"/>
						<span class="input-group-addon">
							<span class="glyphicon glyphicon-calendar"></span>
						</span>
					</div>

					<div class="col-md-12">
						<select multiple="multiple" size="10" id="listaEquipe" name="listaEquipe" class="listaEquipe" required>
						
							<% 
							List<Usuario> usuarios = new ArrayList<>();
							List<UsuarioProjeto> integrantes = new ArrayList<>();
							
							if (null != request.getAttribute("usuarios")){
								usuarios = (List<Usuario>)request.getAttribute("usuarios");
							}
							
							if (null != request.getAttribute("integrantes")){
								integrantes = (List<UsuarioProjeto>) request.getAttribute("integrantes");
							}
							
							for (Usuario usr : usuarios) { %>
							<option value="<%=usr.getIdUsuario()%>" ><%=usr.getNome()%></option>
							
							<%}
							
							for (UsuarioProjeto usrProjeto : integrantes) { %>
							<option value="<%=usrProjeto.getIdUsuario()%>" selected><%=usrProjeto.getNomeUsuario()%></option>
							
							<%} %>
							</select>
					</div>
					<hr>
					<p>		
					<span><sup class="red">*</sup> campos obrigat�rios</span><br>
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
		nonSelectedListLabel : 'Integrantes n�o associados a Equipe de um Projeto',
		selectedListLabel : 'Integrantes associados a Equipe de um Projeto',
		preserveSelectionOnMove : 'moved',
		moveOnSelect : false,
		nonSelectedFilter : '',
		filterTextClear : 'Mostrar Todos',
		infoTextEmpty : 'Sem Equipe ',
		filterPlaceHolder:'Filtro',
		infoText: 'Mostrando {0}',
		infoTextFiltered:'<span class="label label-warning">Mostrando</span> {0} de {1}',
		infoTextEmpty:'Lista vazia'
	});
</script>
<script>
	//P�e cor laranja nos titulos
	$('div[class*="box"]').find('label').css('color', '#F89406');
	
	//D� espa�amento no grupo usu�rios
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
		
		$('#projeto').on('change', function () {
	          var url = "main?acao=equipeProjeto&idProjeto="+$(this).val(); // get selected value
	          if (url) { // require a URL
	              window.location = url; // redirect
	          }
	          return false;
	      });
	});
</script>
