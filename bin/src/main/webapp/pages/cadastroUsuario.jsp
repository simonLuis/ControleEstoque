<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src = BuscaCep.js></script>
<title>Cadastro de Usuário</title>
<link rel="stylesheet" type="text/css" href="cadastroUsuario.css"/>
</head>
<body>
	<div class="cadastro">
	
		<h1>Cadastro de Usuário</h1>
		
		<form method="POST" >
			Login* <input type="email" name="email"><br>
			Senha* <input type="password" name="senha"><br>
			confirma senha* <input type="password" name="confirmasenha"><br><br><br>
			<h2>Dados Pessoais</h2><br>
			Nome* <input type="text" name="NomeUsuario"><br>
			Data de Nascimento* <input type="date" name="dataNascimento" min="1889-01-01" max="2019-12-31">
			Idade <input type="number" name="Anos"><br>
			Sexo* <input type="radio" name="sexo" value="Masculino"> Masculino
			<input type="radio" name="sexo" value="Feminino"> Feminino
			<input type="radio" name="sexo" value="Outros"> Outros <br><br>

			<h2>Endereço</h2>

			Cep* <input name="cep" type="text" id="cep" value="" maxlength="9" onblur="pesquisacep(this.value);"><br>
			Rua <input type="text" id="rua" name="rua"><br>
			Número <input type="number" name="numero" min="0">
			Complemento <input type="text" name="complemento"><br>
			Bairro <input type="text" id="bairro" name="bairro"><br>
			Cidade <input type="text" id="cidade" name="cidade">
			UF <input type=text id="estado" name="estado">
				
			<input type="submit" value="enviar">
				
		</form>
		</div>
</body>
</html>