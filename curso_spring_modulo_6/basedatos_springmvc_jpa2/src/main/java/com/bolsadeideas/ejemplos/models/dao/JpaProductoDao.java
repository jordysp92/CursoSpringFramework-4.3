package com.bolsadeideas.ejemplos.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bolsadeideas.ejemplos.models.entity.Producto;

import org.springframework.stereotype.Repository;

@Repository
public class JpaProductoDao implements IProductoDao {

	@PersistenceContext
    private EntityManager entityManager;
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Producto> findAll() {
        return (List<Producto>) entityManager.createQuery("from Producto").getResultList();
    }

    @Override
    public Producto findById(int productoId) {
        return (Producto) entityManager.find(Producto.class, productoId);
    }

    @Override
    public void save(Producto producto) {
    	entityManager.merge(producto);
    }

    @Override
    public void delete(Producto producto) {
    	entityManager.remove(findById(producto.getId()));
    } 
}
