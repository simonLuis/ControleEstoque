package com.unisul.br.controler;

import com.unisul.br.dao.jpa.NovoUsuarioDaoImpl;
import com.unisul.br.model.NovoUsuario;

public class App {
	public static void main(String[] args) {
		NovoUsuario novo = new NovoUsuario();
		novo.setEmail("rafael.bergmann@hotmaila.com");
		novo.setSenha("rafael.123");
		novo.setConfirmaSenha("rafael.bergmann123");

		NovoUsuarioDaoImpl novoImpl = new NovoUsuarioDaoImpl();
		novoImpl.save(novo);
	}
}
