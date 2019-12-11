function Validacao() {

	if (document.form.login.value == "" && document.form.senha.value == ""
			&& document.form.confirmaSenha == ""
			&& document.form.NomeUsuario == ""
			&& document.form.dataNascimento == "" && document.form.cep == "") {

		alert("Os campos com * são de preenchimento obrigatório.");
		document.form.login.value.focus();
		document.form.senha.value.focus();
		document.form.confirmaSenha.focus();
		document.form.NomeUsuario.focus();
		document.form.dataNascimento.focus();
		document.form.cep.focus();
		return false;
	}

	if (document.form.senha.value.length < 8
			&& document.form.confirmaSenha.value.length < 8) {
		alert("As senhas devem conter pelo menos 8 caracteres."
				+ "As senhas devem conter pelo menos uma letra Maiúscula, um @, . ou # e números");
		return false;
	}

	if (document.form.senha.value != document.form.confirmaSenha.value) {
		alert("As senhas não conferem, Você deve digitar senhas iguais nos campos Senha e Confirma Senha.");
		return false;
	}
}