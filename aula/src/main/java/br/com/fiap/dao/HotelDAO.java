package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Hotel;
import br.com.fiap.util.EntityManagerFacade;

public class HotelDAO {

	EntityManager manager = EntityManagerFacade.getEntityManager();
	
	public void create(Hotel hotel) {
			
			manager.getTransaction().begin();
			manager.persist(hotel);
			manager.getTransaction().commit();
			
			manager.close();
		}

	public List<Hotel> getAll(){
		String jpql = "SELECT h FROM Hotel h";
		TypedQuery<Hotel> query = manager.createQuery(jpql, Hotel.class);
		return query.getResultList();
	}
	

	public Hotel findById(Long id) {
		return manager.find(Hotel.class, id);
	}

	public void update(Hotel hotel) {
		manager.getTransaction().begin();
		manager.merge(hotel);
		manager.flush();
		manager.getTransaction().commit();
		
	}
	
	 public void delete(Hotel hotel) {
		 manager.getTransaction().begin();
	     manager.remove(hotel);
	     manager.getTransaction().commit();
	 }

}
