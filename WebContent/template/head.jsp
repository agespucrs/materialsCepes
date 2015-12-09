
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'><link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>
<style>

* { font-family: 'Open Sans'; margin: 0; padding: 0;}
ul, li, div { border: 0px !important; }
.head { background: #000; }
.logo { font-weight: 600; font-size: 18px; padding-top: 10px;}
.logo a { color: white; margin-top: 20px; margin-left: 20px;   }
#logotipo { width: 140px; }

ul.menu, .menu li, .menu a{ margin:0; padding:0; list-style:none; text-decoration:none; }
ul.menu ul{ position:absolute; display:none; }

/* Configurações nivel 1*/
ul.menu{ float:left; font-size:15px;}
.menu li{ float:left; width:auto; position:relative;}
.menu li a{ display:block; padding:0 20px; line-height:30px; height:30px; float:left; transition:all 0.1s linear; }

/* Configurações nivel 2*/
.menu li:hover > ul.submenu-1{ display:block; top:30px; left:0; width:200px; }
.menu ul.submenu-1 a{  width:160px; padding:0 20px; }



/*Configurações de cores*/

a { text-decoration: none !important; }

/*nivel 1*/
.menu{background: #000A0D; }
.menu a{ color:#000; list-style: none; color: #198AB0;}
.menu li:hover > a{ background: #001117;  color: #25B7E8; }

/*nivel 2*/
.submenu-1{ background: #001117;}
.submenu-1 a{color: #25B7E8; font-size: 12px;}
.submenu-1 li:hover > a{ background: #000A0D; }



</style>


<div style="background: #000; height: 40px;  border: 0px;">
		<p style="color: white; font-size: 12px; line-height: 40px; float: right; margin-right: 25px;">Usuário: <b> ${sessionScope.usuario.usuario}</b><a href="main?acao=logout" style="color: white; font-style: none; margin-left: 10px;" class="${param.acao eq 'logout' ? 'selected' : ''}"><img src="img/exit.png" width="12px"/> Sair</a></p>
		
</div>
<div class="head">

	<div class="logo">
		<a href="index.jsp"><img src="img/logo.png" id="logotipo"/></a>
	</div>
	
	<ul class="menu" style="margin-top: 20px; margin-right: 20px; float: right;">
		<li><a href="index.jsp"  class="${param.acao eq 'index' ? 'selected' : ''}">Home</a></li>
		
		<li><a href="javascript: void(0)"><img src="img/books.png" width="12px"/> Livros</a>
			<ul class="submenu-1">
				<li><a href="main?acao=telaLivro&isEdit=nao"  class="${param.acao eq 'telaLivro' ? 'selected' : ''}">Cadastrar Livro</a></li>
				<li><a href="main?acao=listLivro" class="${param.acao eq 'listLivro' ? 'selected' : ''}">Listar Livros</a></li>
			</ul>	
		</li>
		<li><a href="javascript: void(0)"><img src="img/users.png" width="12px"/> Editoras</a>
			<ul class="submenu-1">
				<li><a href="main?acao=telaEditora&isEdit=nao"    class="${param.acao eq 'telaEditora' ? 'selected' : ''}">Cadastrar Editora</a></li>
				<li><a href="main?acao=listEditora"   class="${param.acao eq 'listEditora' ? 'selected' : ''}">Listar Editoras</a></li>
			</ul>
		</li>
		<li><a href="javascript: void(0)"><img src="img/users.png" width="12px"/> Autores</a>
			<ul class="submenu-1">
				<li><a href="main?acao=telaAutor&isEdit=nao"    class="${param.acao eq 'telaAutor' ? 'selected' : ''}">Cadastrar Autor</a></li>
				<li><a href="main?acao=listAutor"   class="${param.acao eq 'listAutor' ? 'selected' : ''}">Listar Autores</a></li>
			</ul>
		</li>
		<li><a href="javascript: void(0)"><img src="img/users.png" width="12px"/> Usuários</a>
			<ul class="submenu-1">
				<li><a href="main?acao=telaUser&isEdit=nao"    class="${param.acao eq 'telaUser' ? 'selected' : ''}">Cadastrar Usuario</a></li>
				<li><a href="main?acao=listUser"   class="${param.acao eq 'listUser' ? 'selected' : ''}">Listar Usuários</a></li>
			</ul>
		</li>	
	</ul>
</div>
