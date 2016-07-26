<%@page import="br.ages.crud.model.Funcao"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.Usuario"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<% 
	List<Funcao> funcoes = (List<Funcao>) request.getAttribute("funcoes"); %>
<jsp:include page="/template/head.jsp"></jsp:include>
<div class="panel panel-primary panel-add">
	<div class="panel-heading text-center">Cadastro de Usuario</div>
	<div class="panel-body">
		<form action="main?acao=registerUser" method="post">
		<jsp:include page="/template/msg.jsp"></jsp:include>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-6">
						<label class="form-label ages">Matricula: <span class="red">*</span></label> 
						<input class="form-control" id="matricula" name="matricula" type="text" required>
					</div>
					<div class="col-sm-6">
						<label class="form-label ages">CPF: <span class="red">*</span></label> 
						<input class="form-control" id="cpf" name="cpf"	type="text" required>
					</div>
				</div>

				<label class="form-label ages">Nome: <span class="red">*</span></label> 
				<input class="form-control" id="nome" name="nome" type="text" required>

				<label class="form-label ages">E-Mail: <span class="red">*</span></label> 
				<input class="form-control" id="email" name="email" type="text" required>

				<div class="row">
					<div class="col-sm-6">
						<label class="form-label ages">Usuário: <span class="red">*</span></label> 
						<input class="form-control" id="usuario" name="usuario" type="text" required>
					</div>
					<div class="col-sm-6">
						<label class="form-label ages">Senha: <span class="red">*</span></label> 
						<input class="form-control" id="senha" name="senha" type="text" required>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-6">
						<label class="form-label ages">Administrador: <span class="red">*</span></label> 
						<select class="form-control" id="adm" name="adm" required>
							<option value="0">Não</option>
							<option value="1">Sim</option>
						</select>
					</div>
					<div class="col-sm-6">
						<label class="form-label ages">Tipo: <span class="red">*</span></label> 
						<select class="form-control" id="tipo" name="tipo" required>
						<option value="">Selecione o Tipo</option>
						<% for (Funcao funcao : funcoes){ %>
							<option value="<%= funcao.getId() %>"><%= funcao.getNome() %></option>
						
						<% } %>
					</select>
					</div>
				</div>
			</div>
			<span><sup class="red">*</sup> campos obrigatórios</span><br>
			<div class="text-center">
				<input class="btn btn-warning btn-limpar pull-left" type="reset"  value="Limpar"  id="limpar" name="limpar" />
				<input class="btn btn-primary btn-add pull-right" type="submit" value="Cadastrar" />
			</div>
		</form>
	</div>
</div>
<jsp:include page="/template/foot.jsp"></jsp:include>

