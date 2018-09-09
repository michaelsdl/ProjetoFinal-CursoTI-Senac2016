<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<% String logout = (String) session.getAttribute("logout"); String msg = (String) session.getAttribute("msg"); %>

<!DOCTYPE html>
<html lang="pt-br">

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta name="author" content="Michael Silva" />
		<title>Pet Mania | Sobre</title>
		
		<link href="css/bootstrap.min.css" rel="stylesheet" />
		<link href="css/estilo.css" rel="stylesheet" />
		<link rel="stylesheet" href="js/jquery-ui.min.css">
		
		<script type = "text/javascript" src="js/loja.js"></script>
		<script src="js/jquery-3.1.0.min.js"></script>
		<script src="js/jquery-ui.min.js"></script>
		
	</head>
	
	<body onLoad="listaCategs()">
		<!-- Início da barra de navegação -->
		<div class="navbar-wrapper">
			<div class="container">
				<nav class="navbar navbar-inverse navbar-static-top" id="menunav">
					<div class="container">
	
						<!-- Início do espaço para logo -->
						<div class="navbar-header" style="float: left">
							<a class="navbar-brand" id="petmania" href="#">Pet mania</a>
						</div>
						<!-- Fim do espaço para logo -->
	
						<!-- Início do menu para mobile -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed"
								data-toggle="collapse" data-target="#navbar"
								aria-expanded="false" aria-controls="navbar">
								<span class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
						</div>
						<!-- Fim do menu para mobile -->
	
						<!-- Início do menu dropdown -->
						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav">
								<li><a href="index.jsp">Home</a></li>
								<li><a href="sobre.jsp">Sobre</a></li>
								<li><a href="contato.jsp">Contato</a></li>
								<li><a href="#" data-toggle="modal" data-target="#modalCadastro" <%if(logout!=null)out.println("style='display:none;'");%>>Cadastrar</a></li>
								<li><a href="#" onClick="encerrarConta()" <%if(logout==null)out.println("style='display:none;'");%>>Encerrar Conta</a></li>
								<li><a href="#" onClick="consultarDados()" data-toggle="modal" data-target="#modalAlterar" <%if(logout==null)out.println("style='display:none;'");%>>Alterar Dados</a></li>
							</ul>
	
							<!-- Botão do modal de Login -->
							<button id="btnModalLogin" <%if(logout!=null)out.println("style='display:none;'");%> type="button" class="btn btn-primary" data-toggle="modal" data-target="#loginModal">
								Login
							</button>
							
							<!-- Botão para deslogar -->
							<%if(logout!=null)out.println(logout);%>
							
							<!-- Início da barra de busca -->
							<form name = "formBusca" id = "formBusca" method = "get">
								<input type = "search" name = "txtBusca" id = "txtBusca" />
								<input type = "button" onClick="buscaProds()" name = "btnBusca" id = "btnBusca" value = "Buscar" />
							</form>
							<!-- Fim da Barra de busca -->
							
						</div>
						<!-- Fim do menu dropdown -->
						
						<!-- Início do menu de categorias -->
						<ul class="nav navbar-nav" id="categorias"></ul>
						<!-- Fim do menu de categorias -->
						
					</div>
				</nav>
			</div>
		</div>
		<!-- Fim da barra de navegação -->
		
		<!-- Mensagem de Bem-vindo quando o usuário estiver logado -->
		<%if(msg!=null)out.println(msg);%>	
		
		<!-- Início do modal de Cadastro -->
		<div id = "modalCadastro" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
			<div class="modal-dialog modal-lg" role="document">    
		      	
				<div class="modal-content" id="cadastroModal">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					
					<form action="CadastrarUsuario" id = "formCadastrar" method = "post">
					
						<h1>Cadastro</h1>
						
						<p>
							<label for="txtNomeUsuario">Nome:</label>
							<input type="text" class="formAlt" name="txtNomeUsuario" id="txtNomeUsuario" pattern="[A-Za-z ]+$" title="Somente letras!" required />
						</p>
						
						<p>
							<label for = "txtNascimento">Nascimento:</label>
							<input type="date" class="formAlt" min="1970-01-01" name="txtNascimento" id="txtNascimento" pattern="(0[1-9]|1[0-9]|2[0-9]|3[01]).(0[1-9]|1[012]).[0-9]{4}" title="ex: dd/mm/aaaa" required />
						</p>
						
						<p>
							<label for = "txtCpf">CPF:</label>
							<input type = "text" class="formAlt" name = "txtCpf" id = "txtCpf" pattern="[0-9].{10}" title="Digite 11 dígitos!" maxlength="11" required />
						</p>
						
						<p>
							<label for = "txtRg">RG:</label>
							<input type = "text" class="formAlt" name = "txtRg" id = "txtRg" pattern="[0-9].{8}" title="9 dígitos!" maxlength="9" required />
						</p>								
						
												
						<p>
							<label for = "btnSexo">Sexo:</label>
							<input type = "radio" class="formAlt" name = "btnSexo" id = "btnSexo" value="m" />Masculino
							
							<input type = "radio" class="formAlt" name = "btnSexo" id = "btnSexo" value="f" />Feminino
							
						</p>
						
						<p>
							<label for = "txtEmail">E-mail:</label>
							<input type = "email" class="formAlt" name = "txtEmail" id = "txtEmail" required />
						</p>
												
						<p>
							<label for = "txtEndereco">Endereço:</label>
							<input type = "text" class="formAlt" name = "txtEndereco" id = "txtEndereco" required />
						</p>
						
						<p>
							<label for = "txtBairro">Bairro:</label>
							<input type = "text" class="formAlt" name = "txtBairro" id = "txtBairro" required />
						</p>
						
						<p>
							<label for = "txtCidade">Cidade:</label>
							<input type = "text" class="formAlt" name = "txtCidade" id = "txtCidade" required />
						</p>
						
						<p>
							<label for = "txtEstado">Estado (UF):</label>
							<input type = "text" class="formAlt" name = "txtEstado" id = "txtEstado" maxlength="2" required />
						</p>
						
						<p>
							<label for = "txtUsuario">Usuario:</label>
							<input type = "text" class="formAlt" name = "txtUsuario" id = "txtUsuario" pattern=".{4,}" title="No mínimo 4 caracteres!" required />
						</p>										
											
						<p>
							<label for = "txtSenha">Senha:</label>
							<input type = "password" class="formAlt" name = "txtSenha" id = "txtSenha" pattern=".{6,}" title="No mínimo 6 caracteres!" required />
						</p>					
																	
							<input type = "reset" id = "btnLimpar" value = "Limpar" />
							<input type = "submit" id = "btnCadastrar" value = "Cadastrar" />
																												
					</form>
				</div>
			</div>
		</div>	
		<!-- Fim do modal de Cadastro -->
		
		<!-- Início do modal de Alteração de dados -->
		<div id = "modalAlterar" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
			<div class="modal-dialog modal-lg" role="document">    
		      	
				<div class="modal-content" id="cadastroModal">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					
					<form action="AlterarDados" id = "formAlterar" method = "post">
					
						<h1>Alterar Dados</h1>
						
						<p>
							<label for="txtNomeUsuario">Nome:</label>
							<input type="text" name="txtNomeUsuario" id="txtNomeUsuario" pattern="[A-Za-z ]+$" title="Somente letras!" 
							value="<%String nome = (String)session.getAttribute("nome");if(nome!=null) out.println(nome); %>" required />
						</p>
						
						<p>
							<label for = "txtNascimento">Nascimento:</label>
							<input type="date" min="1970-01-01" name="txtNascimento" id="txtNascimento" pattern="(0[1-9]|1[0-9]|2[0-9]|3[01]).(0[1-9]|1[012]).[0-9]{4}" title="ex: dd/mm/aaaa" 
							value="<%String nascimento = (String)session.getAttribute("nascimento");if(nascimento!=null) out.println(nascimento); %>" required />
						</p>
						
						<p>
							<label for = "txtCpf">CPF:</label>
							<input type = "text" name = "txtCpf" id = "txtCpf" pattern="[0-9].{10}" title="Digite 11 dígitos!" maxlength="11" 
							value="<%String cpf = (String)session.getAttribute("cpf");if(cpf!=null) out.println(cpf); %>" required />
						</p>
						
						<p>
							<label for = "txtRg">RG:</label>
							<input type = "text" name = "txtRg" id = "txtRg" pattern="[0-9].{8}" title="9 dígitos!" maxlength="9" 
							value="<%String rg = (String)session.getAttribute("rg");if(rg!=null) out.println(rg); %>" required />
							
						</p>								
						
												
						<p>
							<label for = "btnSexo">Sexo:</label>
							<input type = "radio" name = "btnSexo" id = "btnSexo" value="m" 
							Checked />Masculino
							
							<input type = "radio" name = "btnSexo" id = "btnSexo" value="f" 
							 />Feminino
							
						</p>
						
						<p>
							<label for = "txtEmail">E-mail:</label>
							<input type = "email" name = "txtEmail" id = "txtEmail" 
							value="<%String email = (String)session.getAttribute("email");if(email!=null) out.println(email); %>" required />
						</p>
												
						<p>
							<label for = "txtEndereco">Endereço:</label>
							<input type = "text" name = "txtEndereco" id = "txtEndereco" 
							value="<%String endereco = (String)session.getAttribute("endereco");if(endereco!=null) out.println(endereco); %>" required />
						</p>
						
						<p>
							<label for = "txtBairro">Bairro:</label>
							<input type = "text" name = "txtBairro" id = "txtBairro" 
							value="<%String bairro = (String)session.getAttribute("bairro");if(bairro!=null) out.println(bairro); %>" required />
						</p>
						
						<p>
							<label for = "txtCidade">Cidade:</label>
							<input type = "text" name = "txtCidade" id = "txtCidade" 
							value="<%String cidade = (String)session.getAttribute("cidade");if(cidade!=null) out.println(cidade); %>" required />
						</p>
						
						<p>
							<label for = "txtEstado">Estado (UF):</label>
							<input type = "text" name = "txtEstado" id = "txtEstado" maxlength="2" 
							value="<%String estado = (String)session.getAttribute("estado");if(email!=null) out.println(estado); %>" required />
						</p>
						
						<p>
							<label for = "txtUsuario">Usuario:</label>
							<input type = "text" name = "txtUsuario" id = "txtUsuario" pattern=".{4,}" title="No mínimo 4 caracteres!" 
							value="<%String usuario = (String)session.getAttribute("usuario");if(usuario!=null) out.println(usuario); %>" required />
						</p>										
											
						<p>
							<label for = "txtSenha">Senha:</label>
							<input type = "password" name = "txtSenha" id = "txtSenha" pattern=".{6,}" title="No mínimo 6 caracteres!" 
							value="<%String senha = (String)session.getAttribute("senha");if(senha!=null) out.println(senha); %>" required />
						</p>					
																	
							<input type = "reset" id = "btnLimpar" value = "Limpar" />
							<input type = "submit" id = "btnCadastrar" value = "Alterar" />
																												
					</form>
					
				</div>
			</div>
		</div>	
		<!-- Fim do modal de Alteração de dados -->
	
		<!-- Início do modal de Login -->
		<div id="loginModal" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content" id = "modalLogin">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					
					<form action="Login" id = "formLogar" method = "post">
					
						<h1>Login</h1>
						
						<p>
							<label for = "txtUsuario">Usuário:</label>
							<input type = "text" name = "txtUsuario" id = "txtUsuario" required />
						</p>
						
						<br />
						
						<p>
							<label for = "txtSenha">Senha:</label>
							<input type = "password" name = "txtSenha" id = "txtSenha" required />
						</p>
						
						<br />
						
						<input type = "reset" id = "btnLimpar" value = "Limpar" />
						<input type = "submit" id = "btnLogar" value = "Logar" />
						<br />
						
						<a href = "recuperarSenha.jsp" id = "recSenha" >Esqueci minha senha</a>
						
					</form>
				</div>
			</div>
		</div>	
		<!-- Fim do modal de Login -->
		
		<!-- Início do conteúdo da página -->
		<div class="container marketing" id="conteudo">
		
			<!-- Início do formulário -->
			<form class="form-horizontal" id="contatoform" method="post" action="EnviaMensagemContato">
				
				<h3>Contato</h3>
				
				<div class="form-group">
					<label for="txtNome" class="col-sm-2 control-label">Nome:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="txtNome" id="txtNome" pattern="[A-Za-z ]+$" title="Somente letras!" placeholder="Nome" required />
					</div>
				</div>
		
				<div class="form-group">
					<label for="txtEmail" class="col-sm-2 control-label">Email:</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" name="txtEmail" id="txtEmail"	placeholder="Email" />
					</div>
				</div>
		
				<div class="form-group">
					<label for="txtNascimento" class="col-sm-2 control-label">Nascimento:</label>
					<div class="col-sm-10">
						<input type="date" class="form-control" name="txtNascimento" id="txtNascimento" pattern="(0[1-9]|1[0-9]|2[0-9]|3[01]).(0[1-9]|1[012]).[0-9]{4}" title="ex: dd/mm/aaaa"
							placeholder="Nascimento" required />
					</div>
				</div>
		
				<div class="form-group">
					<label for="txtMensagem" class="col-sm-2 control-label">Mensagem:</label>
					<div class="col-sm-10">
						<textarea class="form-control" name="txtMensagem" id="txtMensagem" placeholder="Escreva sua mensagem aqui..." required></textarea>
					</div>
				</div>
		
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default" id="botao">Enviar</button>
						<button type="reset" class="btn btn-default" id="botao">Limpar</button>
					</div>
				</div>
			</form>
			<!-- Fim do formulário -->
		</div>
		<!-- Fim do conteúdo da página -->
		<br />
		<img src="img/dog6.jpg" id="imgcontato" class="img-responsive"
			alt="Imagem responsiva" />
	
		<hr class="featurette-divider" />
	
		<footer>
			<p class="pull-right">
				<a href="#">Voltar para o topo</a>
			</p>
			<p>
				&copy; 2016 PetMania, Inc. &middot; <a href="#">Privacidade</a>
				&middot; <a href="#">Termos</a>
			</p>
		</footer>
	
		<!-- Bootstrap  JavaScript
			================================================== -->
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	
	</body>

</html>
