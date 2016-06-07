<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.Usuario"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
						<input class="form-control" id="matricula" name="matricula"	value="${param.matricula}" type="text" required>
					</div>
					<div class="col-sm-6">
						<label class="form-label ages">CPF: <span class="red">*</span></label> 
						<input class="form-control" id="cpf" name="cpf"	value="${param.matricula}" type="text" required>
					</div>
				</div>

				<label class="form-label ages">Nome: <span class="red">*</span></label> 
				<input class="form-control" id="nome" name="nome" value="${param.nome}" type="text" required>

				<label class="form-label ages">E-Mail: <span class="red">*</span></label> 
				<input class="form-control" id="email" name="email" value="${param.email}" type="text" required>

				<div class="row">
					<div class="col-sm-6">
						<label class="form-label ages">Usu�rio: <span class="red">*</span></label> 
						<input class="form-control" id="usuario" name="usuario" value="${param.nome}" type="text" required>
					</div>
					<div class="col-sm-6">
						<label class="form-label ages">Senha: <span class="red">*</span></label> 
						<input class="form-control" id="senha" name="senha" value="${param.senha}" type="text" required>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-6">
						<label class="form-label ages">Administrador: <span class="red">*</span></label> 
						<select class="form-control" id="adm" name="adm" required>
							<option value="N" <%="N".equals(request.getParameter("adm")) ? "selected" : ""%>>NAO</option>
							<option value="S" <%="S".equals(request.getParameter("adm")) ? "selected" : ""%>>SIM</option>
						</select>
					</div>
					<div class="col-sm-6">
						<label class="form-label ages">Tipo: <span class="red">*</span></label> 
						<select class="form-control" id="tipo" name="tipo" required> <!-- essa lista dever� vir de uma tabela -->
							<option value="">Selecione o Tipo</option>
							<option value="1">Professor Coordenador</option>
							<option value="2">Professor Colaborador</option>
							<option value="3">Aluno Doutorando</option>
							<option value="4">Aluno Mestrando</option>
							<option value="5">Aluno Graduando</option>
							<option value="6">Aluno Especializa��o</option>
							<option value="7">T�cnico Administrativo</option>
						</select>
					</div>
				</div>
			</div>
			<span><sup class="red">*</sup> campos obrigat�rios</span><br>
			<div class="text-center">
				<input class="btn btn-warning btn-limpar pull-left" type="reset"  value="Limpar"  id="limpar" name="limpar" />
				<input class="btn btn-primary btn-add pull-right" type="submit" value="Cadastrar" />
			</div>
		</form>
	</div>
</div>
<jsp:include page="/template/foot.jsp"></jsp:include>

