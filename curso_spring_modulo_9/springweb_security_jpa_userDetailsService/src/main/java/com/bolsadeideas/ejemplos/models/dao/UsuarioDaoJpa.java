package com.bolsadeideas.ejemplos.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.bolsadeideas.ejemplos.models.entity.Usuario;

import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDaoJpa implements IUserDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Usuario findByUsername(String username) {
		
		Query query = entityManager.createQuery("from Usuario u where u.username = :username");
		query.setParameter("username", username);
		Usuario usuario =  (Usuario) query.getSingleResult();
		if (usuario!=null) {
			return usuario;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) entityManager.createQuery("from Usuario").getResultList();
	}

	@Override
	public Usuario findById(Integer id) {
		return (Usuario) entityManager.find(Usuario.class, id);
	}

	@Override
	public void save(Usuario user) {
		entityManager.merge(user);
	}

	@Override
	public void delete(Usuario user) {
		entityManager.remove(user);
	}

}
