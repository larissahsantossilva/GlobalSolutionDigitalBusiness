package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Usuario;
import br.com.fiap.util.EntityManagerFacade;

public class UsuarioDAO {
	EntityManager manager = EntityManagerFacade.getEntityManager();
		
	public void create(Usuario usuario) {
			
			manager.getTransaction().begin();
			manager.persist(usuario);
			manager.getTransaction().commit();
			
			manager.close();
		}

	public List<Usuario> getAll(){
		String jpql = "SELECT u FROM Usuario u";
		TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
		return query.getResultList();
	}
	
	
	public boolean exist(Usuario usuario) {
		TypedQuery<Usuario> query = manager.createQuery("SELECT u FROM Usuario u WHERE " + "u.email = :email AND "
				+ "u.senha = :senha", Usuario.class);
		
		query.setParameter("email", usuario.getEmail());
		query.setParameter("senha", usuario.getSenha());

		try {
			query.getSingleResult();
		} catch (NoResultException e) {
			return false;
		}
		return true;
	}
	
	
	public Usuario findById(Long id) {
		return manager.find(Usuario.class, id);
	}

	public void update(Usuario usuario) {
		manager.getTransaction().begin();
		manager.merge(usuario);
		manager.flush();
		manager.getTransaction().commit();
		
	}
	
    public void delete(Long id) {
    	manager.getTransaction().begin();
    	Usuario usuario = manager.find(Usuario.class, id);
    	usuario = manager.merge(usuario);
        manager.remove(usuario);
        manager.flush();
    	manager.getTransaction().commit();
    }

}
