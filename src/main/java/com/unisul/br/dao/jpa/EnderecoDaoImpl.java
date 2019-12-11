package com.unisul.br.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import com.unisul.br.dao.Connection;
import com.unisul.br.dao.EnderecoDAO;
import com.unisul.br.model.Endereco;

public class EnderecoDaoImpl implements EnderecoDAO{

	
    private EntityManager entityManager = Connection.getEntityManager();
    
    public boolean save (Endereco endereco) {
        entityManager.getTransaction().begin();
        entityManager.persist(endereco);
        entityManager.getTransaction().commit();
        return true;
    }

    public boolean delete(int id) {
        entityManager.getTransaction().begin();
        entityManager.remove(new Endereco(id));
        entityManager.getTransaction().commit();
        return true;
    }

    public Endereco findById(int id) {
        return entityManager.find(Endereco.class, id);
    }

    public List<Endereco> findAll() {
        return entityManager.createQuery("select p from Endereco p",Endereco.class).getResultList();
    }

    
    public void update(Endereco endereco) {

    }
}
