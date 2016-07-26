<%@page import="br.ages.crud.model.Autor"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	Autor autor = (Autor) request.getAttribute("autor");
%>

<jsp:include page="/template/head.jsp"></jsp:include>
<div class="panel panel-primary panel-add">
	<div class="panel-heading text-center">Edição de Autor</div>
	<div class="panel-body">
		<form action="main?acao=alterAutor&id_autor=<%=autor.getId_autor()%>" method="post">
			<div class="form-group">
				<jsp:include page="/template/msg.jsp"></jsp:include>
				
				<label class="form-label ages" for="nome">Nome</label> <sup class="red">*</sup>
				<input class="form-control"    type="text" id="nome" name="nome" maxlength="15" required="required" value="<%=autor.getNome()%>" />
				
				<label class="form-label ages" for="sobrenome">Sobrenome</label> <sup class="red">*</sup>
				<input class="form-control"    type="text" id="sobrenome" name="sobrenome" maxlength="15" required="required" value="<%=autor.getSobrenome()%>" />
				<span><sup class="red">*</sup> campos obrigatórios</span><br>
				<div class="text-center">
					<input class="btn btn-warning btn-limpar pull-left" type="reset"  value="Limpar"  id="limpar" name="limpar" />
					<input class="btn btn-primary btn-add pull-right" type="submit" value="Cadastrar" />
				</div>
			</div>
		</form>
	</div>
</div>
<jsp:include page="/template/foot.jsp"></jsp:include>
