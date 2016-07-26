<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="utf-8">
        <title>AGES - Ag�ncia Experimental de Engenharia de Software</title><!-- T�tulo da p�gina -->
        <link rel="icon" href="./img/favicon.ico">

		
		<!-- BOOTSTRAP -->
		<link rel="stylesheet" href="./css/bootstrap.min.css">
		<link rel="stylesheet" href="./css/bootstrap-theme.min.css">
		<script src="./js/bootstrap.min.js"></script>
		
		<!-- STYLE -->
		<link rel="stylesheet" href="./css/style.css">

    </head>
    
    <body>
    	<div class="container">
    		
    		<br>
    		<div class="text-center">
    			<img class="logo" src="./img/CePES_Materials.png" alt="AGES - Ag�ncia Experimental de Engenharia de Software">
    		</div>
    		<br>
   		
    		<div class="panel panel-primary panel-login">
    		
    			<div class="panel-heading text-center">
    				<h1 class="welcome">Bem <span class="ages">v</span>indo!</h1>
    			</div>
		         
		                
                <div class="panel-body">
    
    				<jsp:include page="/template/msg.jsp"></jsp:include>
                    
			         <form method="post" action="main?acao=login">
			         	
			         	
			         	<div class="form-group">
			            	<label class="form-label ages">Usu�rio:</label>
			            	<input class="form-control" id="login" name="login" value="${param.login}" type="text" maxlength="120" required>
		             	</div>
		             	
		             	<div class="form-group">
			            	<label class="form-label ages">Senha:</label>
			            	<input class="form-control" id="senha" name="senha" value="${param.senha}" type="password" maxlength="15" required>
		            	</div>
		            	
		            	<div class="text-center">
		            		<a href="#">Esqueci minha senha</a>
		             	</div>
		             	
		             	<hr>
		             	
			            <div class="text-center">
			             	<input class="btn btn-primary login pull-center" type="submit" value="Entrar">
			         	</div>
			         </form>
			         
		         </div>
		         
	         </div>
        </div>
    </body>
</html>