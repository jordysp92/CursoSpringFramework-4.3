package com.bolsadeideas.ejemplos.models.dao;

import java.util.List;

import com.bolsadeideas.ejemplos.models.entity.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("categoriaDao")
public class CategoriaDao implements ICategoriaDao {

	@Autowired
    private HibernateTemplate hibernateTemplate;
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Categoria> findAll() {
        return (List<Categoria>) hibernateTemplate.find("from Categoria");
    }

    @Override
    public Categoria findById(int id) {
        return hibernateTemplate.get(Categoria.class, id);
    }
}
