<%@page import="br.ages.crud.model.Usuario"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.Editora"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>

<jsp:include page="/template/head.jsp"></jsp:include>

<div class="panel panel-primary panel-add">

	<div class="panel-heading text-center">Cadastro de Projetos</div>

	<div class="panel-body">

		<form action="main?acao=addProjeto" method="post">
			<jsp:include page="/template/msg.jsp"></jsp:include>

			<div class="form-group">
				<label class="form-label ages">Nome Projeto: <span
					class="red">*</span></label> <input class="form-control" id="nome"
					name="nome" type="text" required> <label
					class="form-label ages">Programa: <span class="red">*</span></label>
				<input class="form-control" id="programa" name="programa"  type="text" required> <label
					class="form-label ages">Origem: <span class="red">*</span></label>
				<input class="form-control" id="origem" name="origem" type="text" required>


				<div class="row">
					<div class="col-sm-6">
						<label class="form-label ages">Coordenador Projeto </label> <select
							class="form-control" id="coordenador"
							name="coordenador"
							type="text" required>
							<option value="">Selecione o Coordenador</option>
							<%
							List<Usuario> coordenadores = (List<Usuario>)request.getAttribute("listaCoordenadores");
							for (Usuario usuario : coordenadores){ %>
							<option value="<%=usuario.getIdUsuario() %>"><%=usuario.getNome() %></option>
							<%} %>
						</select>
					</div>
				</div>
			</div>
			<p>
				<span><sup class="red">*</sup> campos obrigatórios</span><br>
			</p>
			<div class="text-center">
				<input class="btn btn-warning btn-limpar pull-left" type="reset"
					value="Limpar" id="limpar" name="limpar" /> <input
					class="btn btn-primary btn-add pull-right" type="submit"
					value="Cadastrar" />
			</div>
		</form>
	</div>
</div>
<jsp:include page="/template/foot.jsp"></jsp:include>
