package com.bolsadeideas.ejemplos.models.dao;

import java.util.List;

import com.bolsadeideas.ejemplos.models.entity.Producto;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

@Repository("productoDaoSessionFactory")
public class ProductoDaoSessionFactory implements IProductoDao {

	@Autowired
    private SessionFactory sessionFactory;
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Producto> findAll() {
        return (List<Producto>) sessionFactory.getCurrentSession()
        		.createQuery("from Producto").list();
    }

    @Override
    public Producto findById(int productoId) {
        return (Producto) sessionFactory.getCurrentSession()
        		.get(Producto.class, productoId);
    }

    @Override
    public void save(Producto producto) {
    	sessionFactory.getCurrentSession()
    	.saveOrUpdate(producto);
    }

    @Override
    public void delete(Producto producto) {
    	sessionFactory.getCurrentSession()
    	.delete(producto);
    } 
}
