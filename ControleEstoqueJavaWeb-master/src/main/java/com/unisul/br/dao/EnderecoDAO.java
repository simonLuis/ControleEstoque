package com.unisul.br.dao;

import java.util.List;

import com.unisul.br.model.Endereco;

public interface EnderecoDAO {
	public boolean save(Endereco endereco);
    public List<Endereco> findAll();
    public void update(Endereco endereco);
    public boolean delete(int idEndereco);
    public Endereco findById(int idEndereco);
}
