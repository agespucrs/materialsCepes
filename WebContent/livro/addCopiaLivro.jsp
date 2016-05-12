<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.Editora"%>
<%@page import="br.ages.crud.model.Livro"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="/template/head.jsp"></jsp:include>

<div class="panel panel-primary panel-add">

	<div class="panel-heading text-center">Cadastro de Copia Livros</div>

	<div class="panel-body">

		<div class="table-responsive">

			<form action="main?acao=addCopia" method="post">
				<jsp:include page="/template/msg.jsp"></jsp:include>

				<div class="form-group">
					<label class="form-label ages">Livro <span class="red">*</span></label>

					<select class="form-control" id="livro" name="livro"
						value="${param.livro}" type="text" required>
						<option value="">Selecione o Livro</option>
						<%
							List<Livro> lista = (List<Livro>) request.getAttribute("listaLivros");

							for (Livro livro : lista) {
						%>
						<option value="<%=livro.getIdLivro()%>"><%=livro.getTitulo()%></option>
						<%
							}
						%>
					</select> <label class="form-label ages">Numero Copia <span
						class="red">*</span></label> <input class="form-control" id="copia"
						name="copia" value="${param.copia}" type="text" required>
				</div>
				<hr>
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
</div>
<jsp:include page="/template/foot.jsp"></jsp:include>
