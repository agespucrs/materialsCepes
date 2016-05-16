<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.Livro"%>
<%@page import="br.ages.crud.model.Autor"%>
<%@page import="br.ages.crud.model.Editora"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	
<jsp:include page="/template/head.jsp"></jsp:include>
<div class="panel panel-primary panel-addLivro">
	<div class="panel-heading text-center">Cadastro de Livros</div>
		<div class="panel-body">
		<jsp:include page="/template/msg.jsp"></jsp:include>
		<!-- <div class="table-responsive">	 -->
			<form action="main?acao=addLivro" method="post" >
				<div class="form-group">
					
					<label class="form-label ages">Titulo: <span class="red">*</span></label> 
					<input class="form-control" id="titulo" name="titulo" value="${param.titulo}"	type="text" maxlength="120" required>
					
					<label class="form-label ages">Sub-Titulo: <span class="red">*</span></label> 
					<input class="form-control" id="subtitulo" name="subtitulo" value="${param.subtitulo}"	type="text" maxlength="120" required>
					
					<div class="row">
						<div class="col-sm-6">
							<label class="form-label ages">Autor: <span class="red">*</span></label> 
							<div class="input-group">
								<select class="form-control" id="autor" name="autor" required>
									<option value="" >Selecione Autor</option>
									<%
											List<Autor> listaAutores = (List<Autor>) request.getAttribute("autores");
											int sizeListaAutores = listaAutores.size();
											for (Autor autor: listaAutores) {
										%>
									<option value="<%=autor.getId_autor()%>" <%=(autor.getNome()+" "+autor.getSobrenome()).equals(request.getParameter("autor")) ? "selected" : "" %>><%=autor.getNome()+" "+autor.getSobrenome()%></option>
										<%
											}
										%>
								</select>
								<div class="input-group-btn">
								      <a class="btn btn-info" href="" data-toggle="tooltip" title="Click aqui para adicionar um Autor!"><span class="glyphicon glyphicon-plus"></span> Autor </a>
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<label class="form-label ages">Editora: <span class="red">*</span></label> 
							<div class="input-group">
								<select class="form-control" id="editora" name="editora" required>
									<option value="" >Selecione Editora</option>
									<%
										List<Editora> listaEditora = (List<Editora>) request.getAttribute("editoras");
										int sizeListaEditoras = listaEditora.size();
										for (Editora editora: listaEditora) {
									%>
									<option value="<%=editora.getIdEditora()%>" <%=(editora.getNome()).equals(request.getParameter("editora")) ? "selected" : "" %>><%=editora.getNome()%></option>
									<%
											}
										%>
								</select>
								<div class="input-group-btn">
									 <a class="btn btn-info" href="" data-toggle="tooltip" title="Click aqui para adicionar uma Editora!"><span class="glyphicon glyphicon-plus"></span> Editora</a>
								</div>
							</div>
						</div>
					</div>
				<div class="row">
					<div class="col-sm-4">
						<label class="form-label ages">Codigo Biblioteca: <span class="red">*</span></label> 
						<input class="form-control" id="isbn" name="isbn" value="${param.isbn}"	type="text" maxlength="120" required>
					</div>
					<div class="col-sm-4">
						<label class="form-label ages">Pre�o Aquisi��o: </label> 
						<div class="input-group">
							<div class="input-group-btn">
								 <a class="btn btn-default" >R$</a>
							</div>
							<input class="preco form-control" id="preco" name="preco" value="${param.preco}" type="text" style="text-align: right;">
						</div>
					</div>
					<div class="col-sm-4">
						<label class="form-label ages">Lingua: </label> 
						<select class="form-control" id="lingua" name="lingua" required>
								<option value="" >Selecione a Lingua</option>
								<option value="pt" <%="pt".equals(request.getParameter("lingua")) ? "selected" : ""%>>Portugu�s</option>
								<option value="en" <%="en".equals(request.getParameter("lingua")) ? "selected" : ""%>>Ingles</option>
						</select>					
					</div>
				</div>			
				<div class="row">
					<div class="col-sm-4">
						<label class="form-label ages">Edi��o: </label> 
						<input class="form-control" id="edicao" name="edicao" value="${param.edicao}" type="text">
					</div>
					<div class="col-sm-4">
						<label class="form-label ages">Data Entrada: </label> 
						<input class="form-control" id="ano" name="ano" value="${param.ano}" type="text" style="text-align: right;">
					</div>
					<div class="col-sm-4">
						<label class="form-label ages">Paginas: </label> 
						<input class="form-control" id="paginas" name="paginas" value="${param.paginas}" type="text">
					</div>
				</div>
				<div class="row">	
					<div class="col-sm-12">
						<label class="checkbox-inline ages"><input type="checkbox" name="bruxuraRevista" value="${param.bruxuraRevista}">Brochura</label>
						<label class="checkbox-inline ages"><input type="checkbox" name="video" value="${param.video}">Video</label>
						<label class="checkbox-inline ages"><input type="checkbox" name="cd_dvd" value="${param.cddvd}">CD/DVD</label>
						<label class="checkbox-inline ages"><input type="checkbox" name="ebook" value="${param.ebook}">E-Book</label>
						<label class="checkbox-inline ages"><input type="checkbox" name="capaDuara" value="">Capa Dura</label>
						<label class="checkbox-inline ages"><input type="checkbox" name="expiral" value="">Expiral</label>
						<label class="checkbox-inline ages"><input type="checkbox" name="revista" value="">Revista</label>
					</div>           
				</div>
				<label class="form-label ages">Observa��o: </label> 
				<textarea class="form-control" cols="80" rows="2" id="descricao" name="descricao" value="${param.descricao}"></textarea>
				<p>
					Campos que cont�m <span class="red">*</span> s�o obrigat�rios
				</p>
				</div>
				<div class="text-center">
					<input class="btn btn-warning btn-limpar pull-left" type="reset" value="Limpar" id="limpar" name="limpar" />
					<input class="btn btn-primary btn-add pull-right" type="submit"	value="Cadastrar">
				</div>		
			</form>
		</div>
	</div>
	<jsp:include page="/template/foot.jsp"></jsp:include>
<script type="text/javascript">
	$(document).ready(function() {
	    $('[data-toggle="tooltip"]').tooltip();   
		$('.preco').mask('#.##0,00', {
			reverse : true
		});
	});
</script>
