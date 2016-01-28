<%@page import="br.ages.crud.model.Livro"%>
<%@page import="br.ages.crud.model.Autor"%>
<%@page import="br.ages.crud.model.Editora"%>
<%@page import="br.ages.crud.util.Util"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>

<%
	Livro livro = (Livro) request.getAttribute("livro");
%>
<script type="text/javascript">
	function alterar() {
		//chamar funcao de verificar campos
		var formCadastro = document.forms[0];
		formCadastro.action = "main?acao=alterLivro&id_livro=<%=livro.getIdLivro()%>";
		formCadastro.submit();
	}
</script>
<jsp:include page="/template/head.jsp"></jsp:include>
	<div class="panel panel-primary panel-addLivro">
		<div class="panel-heading text-center">Edi��o de Livro</div>
		<div class="panel-body"><jsp:include page="/template/msg.jsp"></jsp:include>
	
		<form action="main?acao=alterLivro&id_livro=<%=livro.getIdLivro()%>" method="post">
			<jsp:include page="/template/msg.jsp"></jsp:include>
			<div class="form-group">
					<label class="form-label ages">Titulo: <span class="red">*</span></label> 
					<input class="form-control" id="titulo" name="titulo" value="<%=livro.getTitulo()%>" type="text" maxlength="120" required />
					
					<label class="form-label ages">Sub-Titulo: <span class="red">*</span></label> 
					<input class="form-control" id="subtitulo" name="subtitulo" value="<%=livro.getSubtitulo()%>" type="text" maxlength="120" required>
			
					<div class="row">
						<div class="col-sm-6">
							<%int livroIdAutor = livro.getAutores().get(0).getId_autor();%>
							<%String livroNomeAutor = livro.getAutores().get(0).getNome();%>
							<label class="form-label ages">Autor: <span class="red">*</span></label> 
							<div class="input-group">
								<select class="form-control" id="autor" name="autor"  required>
									<option value="<%=livroIdAutor%>" ><%=livroNomeAutor%></option>
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
									<option value="<%=livro.getEditora().getIdEditora()%>" ><%=livro.getEditora().getNome()%></option>
									<%
										List<Editora> listaEditora = (List<Editora>) request.getAttribute("editoras");
										int sizeListaEditoras = listaEditora.size();
										for (Editora editora: listaEditora) {
									%>
									<option value="<%=editora.getIdEditora()%>" <%=editora.getNome().equals(request.getParameter("editora")) ? "selected" : "" %>><%=editora.getNome()%></option>
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
						<label class="form-label ages">Codigo ISBN: <span class="red">*</span></label> 
						<input class="form-control" id="isbn" name="isbn" value="<%=livro.getCodigoISBN()%>"	type="text" maxlength="120" required>
					</div>
					<div class="col-sm-4">
						<label class="form-label ages">Pre�o: </label> 
						<input class="form-control" id="preco" name="preco" value="<%=livro.getPreco()%>"	type="text">
					</div>
					<div class="col-sm-4">
						<label class="form-label ages">Lingua: </label> 
						<select class="form-control" id="lingua" name="lingua"  required>
								<option value="" >Selecione a Lingua</option>
								<option value="pt" <%="pt".equals(request.getParameter("lingua")) ? "selected" : ""%>>Protugu�s</option>
								<option value="en" <%="en".equals(request.getParameter("lingua")) ? "selected" : ""%>>Ingles</option>
						</select>					
					</div>
				</div>	
				<div class="row">
					<div class="col-sm-4">
						<label class="form-label ages">Edi��o: </label> 
						<input class="form-control" id="edicao" name="edicao" value="<%=livro.getEdicao()%>" type="text">
					</div>
					<div class="col-sm-4">
						<label class="form-label ages">Ano: </label> 
						<input class="form-control" id="ano" name="ano" value="<%=livro.getAno()%>" type="text">
					</div>
					<div class="col-sm-4">
						<label class="form-label ages">Paginas: </label> 
						<input class="form-control" id="paginas" name="paginas" value="<%=livro.getPaginas()%>" type="text">
					</div>
				</div>	
				<div class="row">	
					<div class="col-sm-12">
						<label class="checkbox-inline ages"><input type="checkbox" name="bruxuraRevista" value="<%=livro.getBruxura_revista()%>">Bruxura</label>
						<label class="checkbox-inline ages"><input type="checkbox" name="video" value="<%=livro.isVideo()%>">Video</label>
						<label class="checkbox-inline ages"><input type="checkbox" name="cd_dvd" value="<%=livro.isCd_dvd()%>">CD/DVD</label>
						<label class="checkbox-inline ages"><input type="checkbox" name="ebook" value="<%=livro.isE_book()%>">E-Book</label>
					</div>           
				</div>
				<label class="form-label ages">Descri��o: </label> 
				<textarea class="form-control" cols="80" rows="4" id="descricao" name="descricao" value="${param.descricao}"></textarea>
			</div>
			<p>Campos que cont�m <span class="red">*</span> s�o obrigat�rios</p>

			<div class="text-center">
				<input class="btn btn-warning btn-limpar pull-left" type="reset" value="Limpar"> 
				<input class="btn btn-primary btn-add pull-right" type="submit"	value="Cadastrar">
			</div>		
		</form>
	</div>
</div>
<jsp:include page="/template/foot.jsp"></jsp:include>
<script>
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();   
});
</script>