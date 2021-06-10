package br.com.fiap.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Avaliacao;
import br.com.fiap.util.EntityManagerFacade;

public class AvaliacaoDAO {

	EntityManager manager = EntityManagerFacade.getEntityManager();
	
	public void create(Avaliacao avaliacao) {
		
		manager.getTransaction().begin();
		manager.persist(avaliacao);
		manager.getTransaction().commit();
		
		manager.close();
	}

	

	public List<Avaliacao> getAll(){
		String jpql = "SELECT a FROM Avaliacao a";
		TypedQuery<Avaliacao> query = manager.createQuery(jpql, Avaliacao.class);
		return query.getResultList();
	}
	
	public Avaliacao findById(Long id) {
		return manager.find(Avaliacao.class, id);
	}

	public void update(Avaliacao avaliacao) {
		manager.getTransaction().begin();
		manager.merge(avaliacao);
		manager.flush();
		manager.getTransaction().commit();
		
	}
	
    public void delete(Avaliacao avaliacao) {
    	manager.getTransaction().begin();
        manager.remove(avaliacao);
    	manager.getTransaction().commit();
    }

}
