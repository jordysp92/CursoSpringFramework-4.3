package com.bolsadeideas.ejemplos.models.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.bolsadeideas.ejemplos.models.entity.Producto;

public class ProductoDao extends HibernateDaoSupport implements IProductoDao {
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Producto> findAll() {
        return (List<Producto>) getHibernateTemplate().find("from Producto");
    }

    @Override
    public Producto findById(int productoId) {
        return (Producto) getHibernateTemplate().get(Producto.class, productoId);
    }

    @Override
    public void save(Producto producto) {
    	getHibernateTemplate().saveOrUpdate(producto);
    }

    @Override
    public void delete(Producto producto) {
    	getHibernateTemplate().delete(producto);
    } 
}
