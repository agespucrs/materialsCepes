<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.Usuario"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:include page="/template/head.jsp"></jsp:include>
	<div class="panel panel-primary panel-add">
		<div class="panel-heading text-center">Cadastro de Usuario</div>
		<div class="panel-body">
			<div class="table-responsive">
			<form action="main?acao=registerUser" method="post">
			<jsp:include page="/template/msg.jsp"></jsp:include>
					<div class="form-group">
						<label class="form-label ages">Matricula: <span class="red">*</span></label> 
						<input class="form-control" id="matricula" name="matricula"	value="${param.matricula}" type="text" required>

						<label class="form-label ages">Nome: <span class="red">*</span></label> 
						<input class="form-control" id="nome" name="nome" value="${param.nome}" type="text" required>
			
						<label class="form-label ages">Usuário: <span class="red">*</span></label> 
						<input class="form-control" id="usuario" name="usuario" value="${param.nome}" type="text" required>
	
						<label class="form-label ages">Senha: <span class="red">*</span></label> 
						<input class="form-control" id="senha" name="senha" value="${param.senha}" type="text" required>

						<label class="form-label ages">E-Mail: <span class="red">*</span></label> 
						<input class="form-control" id="email" name="email" value="${param.email}" type="text" required>

						<label class="form-label ages">Administrador: <span class="red">*</span></label> 
						<select class="form-control" id="adm" name="adm" required>
							<option value="SIM" <%="SIM".equals(request.getParameter("adm")) ? "selected" : ""%>>SIM</option>
							<option value="NAO" <%="NAO".equals(request.getParameter("adm")) ? "selected" : ""%>>NAO</option>
						</select>
					</div>
						
					<span><sup class="red">*</sup> campos obrigatórios</span><br>
					<div class="text-center">
						<input class="btn btn-warning btn-limpar pull-left" type="reset"  value="Limpar"  id="limpar" name="limpar" />
						<input class="btn btn-primary btn-add pull-right" type="submit" value="Cadastrar" />
					</div>
			</form>
		</div>
	</div>
</div>
<jsp:include page="/template/foot.jsp"></jsp:include>
