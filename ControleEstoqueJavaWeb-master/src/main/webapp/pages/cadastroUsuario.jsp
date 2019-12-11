	<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
		
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>Cadastro de Usuário</title>
	<link rel="stylesheet" type="text/css" href="cadastroUsuario.css"/>
	</head>
	<body>
		<div class="cadastro">
	
			<h1>Cadastro de Usuário</h1>
	
			<form name="formCad">
	
				<input type="hidden" name="acao" value="salva" id="salva">
				<input type="hidden" name="idUsuario" id="idUsuario" value="<%=request.getParameter("idUsuario") != null ? request.getParameter("idUsuario") : ""%>">
				<input type="hidden" name="idCep" id="idCep" value="<%=request.getParameter("idCep") != null ? request.getParameter("idCep") : ""%>">
	
				<label> Login </label> <strong>*</strong> <input type="email" name="login" id="idEmail"><br>
				<label> Senha </label> <strong>*</strong> <input type="password" name="senha" id="senha"> <button type="button" id="mostra">Mostra</button> <br>
				<label> confirma Senha </label><strong>*</strong>  <input type="password" name="confirmaSenha" id="confirmaSenha"><br>
				<br>
				<br>
				<h2>Dados Pessoais</h2><br>
			    <label> Nome </label> <strong>*</strong> <input type="text" name="NomeUsuario" id="nome"><br>
				<label> Data de Nascimento </label><strong>*</strong> <input type="date" name="dataNascimento" id="dataNascimento" min="1889-01-01" max="2019-12-31"> 
				<label> Idade </label> <input type="text" name="Anos" id="idade"><br> 
				<label> Sexo </label><strong>*</strong> 
				<select name="sexo" id="sexo">
				<option>Selecione o Sexo</option>
				<option>Masculino</option>
				<option>Feminino</option>
				<option>Outros</option>
				</select>
				<h2>Endereço</h2>
	
				<label> Cep </label> <strong>*</strong> <input name="cep" type="text" id="cep" value="" maxlength="9"
					onblur="pesquisacep(this.value);"><br> 
				<label> Rua </label> <input type="text" id="rua" name="rua" disabled><br> 
				<label> Número </label> <input type="number" name="numero" id="numero" min="0"> 
				<label> Complemento </label> <input type="text" name="complemento" id="complemento"><br>
				<label> Bairro </label> <input type="text" id="bairro" name="bairro" disabled><br>
				<label> Cidade  </label> <input type="text" id="cidade" name="cidade" disabled> UF <input type=text id="estado" name="estado" disabled> 
					
					<input type="button" value="Salvar" id="salvar">
					<input type="button" value="Voltar" id="voltar">
	
			</form>
		</div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src=BuscaCep.js></script>
		<script src=Validacao.js></script>
		
		<script>
		$(document).ready(function(){
			$("#mostra").click(function(){
				var tipo = document.getElementById("senha");
				if(tipo.type == "password"){
					tipo.type = "text";
				}else{
					tipo.type = "password";
				}
			});
		});
		</script>
		
		<script>	
			$(document).ready(function(){
			$("#voltar").click(function(){
				window.history.back(-1);
		});
	});
		</script>
		
		
	</body>
	</html>