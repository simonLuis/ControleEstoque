$(document).ready(function(){
			$("#salvar").click(function(){
				
				var login = formCad.login.value;
				var senha = formCad.senha.value;
				var confirmaSenha = formCad.confirmaSenha.value;
				var nomeUsuario = formCad.NomeUsuario.value;
				var dtaNasc = formCad.dataNascimento.value;
				var cep = formCad.cep.value;
				
			if(1>0){
				while (login == "" || senha == "" || confirmaSenha == ""
					|| nomeUsuario == "" || dtaNasc == "" || cep == "" ) {

				alert("Os campos com * são de preenchimento obrigatório.");

				return false;
			}

			while (senha.length < 8 || confirmaSenha.length < 8) {
				alert("As senhas devem conter pelo menos 8 caracteres.");
				if((senha.indexOf("@"||"."||"#") == -1) && (confirmaSenha.indexOf("@"||"."||"#") == -1)){
					alert("As senhas devem conter pelo menos um @, . ou #");
				}
				return false;
			}

			while (senha != confirmaSenha) {
				alert("As senhas não conferem, Você deve digitar senhas iguais nos campos Senha e Confirma Senha.");
				return false;
			}
			$.ajax({
				url: "http://192.168.0.3:8080/ControleEstoque/cadastroNovoUser",
				type: "POST",
				data: {
					"login": $('#idEmail').val(),
					"senha": $('#senha').val(),
					"confirmaSenha": $('#confirmaSenha').val(),
					"NomeUsuario": $('#nome').val(),
					"dataNascimento": $('#dataNascimento').val(),
					"Anos": $('#idade').val(),
					"sexo": $('#sexo').val(	), 
					"cep": $("#cep").val(),
					"rua": $("#rua").val(),
					"numero": $('#numero').val(),
					"complemento": $('#complemento').val(),
					"bairro": $('#bairro').val(),
					"cidade": $('#cidade').val(),
					"estado": $('#estado').val()		
				},
				success: function(data){
					alert("Usuário Cadastrado");
				},
				
				error: function(){
					alert ("Erro ao requisitar para o servidor, por favor tente novamente mais tarde.");
					}
			});
			
			}
			});
		});