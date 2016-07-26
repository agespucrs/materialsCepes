<%@page import="br.ages.crud.model.Funcao"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.Usuario"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
	Usuario usuario = (Usuario) request.getAttribute("usuario");

	List<Funcao> funcoes = (List<Funcao>) request.getAttribute("funcoes");
%>
<script type="text/javascript">
	function alterar() {
		//chamar funcao de verificar campos
		var formCadastro = document.forms[0];
		formCadastro.action = "main?acao=alterUser&id_usuario=<%=usuario.getIdUsuario()%>";
		formCadastro.submit();
	}
</script>
<jsp:include page="/template/head.jsp"></jsp:include>
	<div class="panel panel-primary panel-add">
		<div class="panel-heading text-center">Edi��o de Usu�rio</div>
		<div class="panel-body">
			<form action="main?acao=alterUser&id_usuario=<%=usuario.getIdUsuario()%>" method="post">
			<jsp:include page="/template/msg.jsp"></jsp:include>
			<div class="form-group">
				
				<label class="form-label ages" for="matricula">Matricula</label> <sup class="red">*</sup>
				<input class="form-control"    type="text" id="matricula" name="matricula" maxlength="15" required="required" value="<%=usuario.getMatricula()%>" />
		
				<label class="form-label ages" for="nome">Nome</label> <sup class="red">*</sup>
				<input class="form-control"    type="text" id="nome" name="nome" maxlength="120" value="<%=usuario.getNome()%>" />
		
				<label class="form-label ages" for="email">Email</label> <sup class="red">*</sup> 
				<input class="form-control"    type="text" id="email" name="email" maxlength="120" value="<%=usuario.getEmail()%>" />
			
				<label class="form-label ages" for="usuario">Usu�rio</label> <sup class="red">*</sup> 
				<input class="form-control"    type="text" id="usuario" name="usuario" maxlength="150" value="<%=usuario.getUsuario()%>" />

				<label class="form-label ages" for="senha">Senha</label> <sup class="red">*</sup> 
				<input class="form-control"    type="password" id="senha" name="senha" maxlength="8" value="<%=usuario.getSenha()%>" />

				<label class="form-label ages">Tipo: <span class="red">*</span></label> 
				<select class="form-control" id="tipo" name="tipo" required> <!-- essa lista dever� vir de uma tabela -->
					<option value="">Selecione o Tipo</option>
					<% for (Funcao funcao : funcoes){ %>
						<option value="<%= funcao.getId() %>" <%=(funcao.getId() == usuario.getIdFuncao()) ? "selected" : "" %>><%= funcao.getNome() %></option>
						
					<% } %>
				</select>
				
				<label class="form-label ages">Administrador: <span class="red">*</span></label> 
						<select class="form-control" id="adm" name="adm" required>
							<option value="0" <%=0 == usuario.getAdministrador() ? "selected" : ""%>>N�o</option>
							<option value="1" <%=1 == usuario.getAdministrador() ? "selected" : ""%>>Sim</option>
						</select>
					
				<span><sup class="red">*</sup> campos obrigat�rios</span><br>
				<div class="text-center">
					<input class="btn btn-warning btn-limpar pull-left" type="reset"  value="Limpar"  id="limpar" name="limpar" />
					<input class="btn btn-primary btn-add pull-right" type="submit" value="Cadastrar" />
				</div>
			</div>
		</form>
	</div>
</div>

<jsp:include page="/template/foot.jsp"></jsp:include>
