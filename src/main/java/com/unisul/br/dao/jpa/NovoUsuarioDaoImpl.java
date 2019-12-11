package com.unisul.br.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import com.unisul.br.dao.Connection;
import com.unisul.br.dao.NovoUsuarioDAO;
import com.unisul.br.model.NovoUsuario;

public class NovoUsuarioDaoImpl implements NovoUsuarioDAO{

private EntityManager entityManager = Connection.getEntityManager();
    
    public boolean save (NovoUsuario NovoUsuario) {
        entityManager.getTransaction().begin();
        entityManager.persist(NovoUsuario);
        entityManager.getTransaction().commit();
        return true;
    }

    public boolean delete(int id) {
        entityManager.getTransaction().begin();
        entityManager.remove(new NovoUsuario(id));
        entityManager.getTransaction().commit();
        return true;
    }

    public NovoUsuario findById(int id) {
        return entityManager.find(NovoUsuario.class, id);
    }

    public List<NovoUsuario> findAll() {
        return entityManager.createQuery("select p from Usuario p",NovoUsuario.class).getResultList();
    }

    
    public void update(NovoUsuario novoUsuario) {

    }
	
}
