package com.unisul.br.dao;

import java.util.List;

import com.unisul.br.model.NovoUsuario;

public interface NovoUsuarioDAO {
	public boolean save(NovoUsuario usuario);
    public List<NovoUsuario> findAll();
    public void update(NovoUsuario participante);
    public boolean delete(int idParticipante);
    public NovoUsuario findById(int idParticipante);
}
