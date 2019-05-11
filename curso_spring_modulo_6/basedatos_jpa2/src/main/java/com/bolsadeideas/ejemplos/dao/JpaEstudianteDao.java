package com.bolsadeideas.ejemplos.dao;

import com.bolsadeideas.ejemplos.entity.Estudiante;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository("estudianteDao")
public class JpaEstudianteDao implements EstudianteDao {
	
	 @PersistenceContext
	 private EntityManager entityManager;

    @Transactional
    public void save(Estudiante estudiante) {
    	entityManager.merge(estudiante);
    }

    @Transactional
    public void delete(Estudiante estudiante) {
        Estudiante est = (Estudiante) findById(estudiante.getId());
        entityManager.remove(est);
    }

    @Transactional(readOnly = true)
    public Estudiante findById(Integer id) {
        return entityManager.find(Estudiante.class, id);
    }

    @SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
    public List<Estudiante> findAll() {
        Query query = entityManager.createQuery("from Estudiante");
        return query.getResultList();
    }
}
