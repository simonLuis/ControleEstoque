<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="com.unisul.br.model.Endereco"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Usuário</title>
<link rel="stylesheet" type="text/css" href="cadastroUsuario.css" />
</head>
<body>
	<div class="cadastro">

		<h1>Cadastro de Usuário</h1>

		<form action="servletAjax" name="formCad">

			<input type="hidden" name="acao" value="salva" id="salva">
			<input type="hidden" name="idUsuario" id="idUsuario" value="<%=request.getParameter("idUsuario") != null ? request.getParameter("idUsuario") : ""%>">
			<input type="hidden" name="idCep" id="idCep" value="<%=request.getParameter("idCep") != null ? request.getParameter("idCep") : ""%>">

			Login* <input type="email" name="login" id="idEmail"><br>
			Senha* <input type="password" name="senha" id="senha"> <button type="button" id="mostra" >Mostra</button> <br>
			confirma Senha* <input type="password" name="confirmaSenha" id="confimaSenha"><br>
			<br>
			<br>
			<h2>Dados Pessoais</h2><br>
		    <label> Nome* </label> <input type="text" name="NomeUsuario" id="nome"><br>
			<label> Data de Nascimento* </label> <input type="date" name="dataNascimento" id="dataNascimento" min="1889-01-01" max="2019-12-31"> 
			<label> Idade </label> <input type="text" name="Anos" id="idade"><br> 
			<label> Sexo* </label> 
			<label> Masculino </label> <input type="radio" name="sexo" id="sexo" value="Masculino">
			<label> Feminino </label> <input type="radio" name="sexo" value="Feminino">
			<label> Outros </label> <input type="radio" name="sexo" value="Outros"> <br> <br>

			<h2>Endereço</h2>

			<label> Cep* </label> <input name="cep" type="text" id="cep" value="" maxlength="9"
				onblur="pesquisacep(this.value);"><br> 
			<label> Rua </label> <input type="text" id="rua" name="rua"><br> 
			<label> Número </label> <input type="number" name="numero" id="numero" min="0"> 
			<label> Complemento </label> <input type="text" name="complemento" id="complemento"><br>
			<label> Bairro </label> <input type="text" id="bairro" name="bairro"><br>
			<label> Cidade  </label> <input type="text" id="cidade" name="cidade"> UF <input type=text id="estado" name="estado"> 
				
				<input type="submit" value="Salvar" id="salvar">
				<input type="button" value="Voltar" id="voltar">

		</form>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src=BuscaCep.js></script>
	<script src=Validacao.js></script>
	
	<script>
	<!-- Esta função troca o tipo do atributo da senha para ser visivel e volta para **** -->

	$(document).ready(function(){
		$("#mostra").click(function(){
			var tipo = document.getElemetById("senha");
			if(tipo.type == "password"){
				tipo.type = "text";
			}else{
				tipo.type = "password";
			}
		});
	});
	
	
	</script>
	
	<script>
		<!--Função que vai para o botão voltar, e manda para Home.-->
		$(document).ready(function(){
			$("#voltar").click(function(){
				window.history.back(-1);
			});
		});

	<!--Requisição Ajax que manda o form para o Servlet-->

	$("#salvar").click(function(){
		
		$.ajax({
			url: "http://192.168.0.12/ControleEstoqueJavaWeb/cadastroNovoUser",
			type: "POST",
			data: {
				"idUsuario": $("idUsuario").val(),
				"login": $('#idEmail').val(),
				"senha": $('#senha').val(),
				"confirmaSenha": $('#confirmaSenha').val(),
				"NomeUsuario": $('#nome').val(),
				"dataNascimento": $('#dataNascimento').val(),
				"Anos": $('#idade').val(),
				"sexo": $('#sexo').val(),
				"idCep":$('#idCep').val,
				"cep": $("#cep").val(),
				"rua": $("#rua").val(),
				"numero": $('#numero').val(),
				"complemento": $('#complemento').val(),
				"bairro": $('#bairro').val(),
				"cidade": $('#cidade').val(),
				"estado": $('#estado').val()		
			},
			<!--Se a requisição for sucedida mostra mensagem-->
			success: function(data){
				alert("Usuário Cadastrado");
				
			},
			<!--Se a requisição der erro mostra mensagem.-->
			
			error: function(){
				alert ("Erro ao requisitar para o servidor, por favor tente novamente mais tarde.");
			}
		});
		
	});


</script>
</body>
</html>