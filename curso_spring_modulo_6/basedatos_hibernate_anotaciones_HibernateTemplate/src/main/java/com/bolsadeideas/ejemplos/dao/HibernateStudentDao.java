package com.bolsadeideas.ejemplos.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.ejemplos.entity.Estudiante;

@Repository("estudianteDao")
public class HibernateStudentDao implements EstudianteDao {
	
	@Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public void save(Estudiante estudiante) {
        hibernateTemplate.saveOrUpdate(estudiante);
    }

    @Transactional
    public void delete(Estudiante estudiante) {
    	Estudiante est = (Estudiante) hibernateTemplate.get(Estudiante.class, estudiante.getId());
        hibernateTemplate.delete(est);
    }

    @Transactional(readOnly = true)
    public Estudiante findById(Integer id) {
        return (Estudiante) hibernateTemplate.get(Estudiante.class, id);
    }

    @SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
    public List<Estudiante> findAll() {
        return (List<Estudiante>) hibernateTemplate.find("from Estudiante");
    }
}
