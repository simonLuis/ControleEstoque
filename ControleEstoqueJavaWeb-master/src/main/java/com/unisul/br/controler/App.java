package com.unisul.br.controler;

import com.unisul.br.dao.jpa.NovoUsuarioDaoImpl;
import com.unisul.br.model.NovoUsuario;

public class App {
	public static void main(String[] args) {
		NovoUsuarioDaoImpl dao = new NovoUsuarioDaoImpl();
		for (NovoUsuario p : dao.findAll()) {
			System.out.println("teste: " p.getEmail());
		}
	}
}
