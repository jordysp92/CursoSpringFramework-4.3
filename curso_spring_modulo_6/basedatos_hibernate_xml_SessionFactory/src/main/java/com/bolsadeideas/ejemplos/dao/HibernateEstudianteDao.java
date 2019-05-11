package com.bolsadeideas.ejemplos.dao;

import com.bolsadeideas.ejemplos.entity.Estudiante;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("estudianteDao")
public class HibernateEstudianteDao implements EstudianteDao {
	
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void save(Estudiante estudiante) {
        sessionFactory.getCurrentSession().saveOrUpdate(estudiante);
    }

    @Transactional
    public void delete(Estudiante estudiante) {
        Estudiante est = (Estudiante) sessionFactory.getCurrentSession().get(Estudiante.class, estudiante.getId());
        sessionFactory.getCurrentSession().delete(est);
    }

    @Transactional(readOnly = true)
    public Estudiante findById(Integer id) {
        return (Estudiante) sessionFactory.getCurrentSession().get(Estudiante.class, id);
    }

    @SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
    public List<Estudiante> findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Estudiante");
        return query.list();
    }
}
