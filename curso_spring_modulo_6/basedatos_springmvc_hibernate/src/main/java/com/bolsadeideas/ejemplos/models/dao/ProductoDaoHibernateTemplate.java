package com.bolsadeideas.ejemplos.models.dao;

import java.util.List;

import com.bolsadeideas.ejemplos.models.entity.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("productoDaoHibernateTemplate")
public class ProductoDaoHibernateTemplate implements IProductoDao {

	@Autowired
    private HibernateTemplate hibernateTemplate;
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Producto> findAll() {
        return (List<Producto>) hibernateTemplate.find("from Producto");
    }

    @Override
    public Producto findById(int productoId) {
        return (Producto) hibernateTemplate.get(Producto.class, productoId);
    }

    @Override
    public void save(Producto producto) {
    	hibernateTemplate.saveOrUpdate(producto);
    }

    @Override
    public void delete(Producto producto) {
    	hibernateTemplate.delete(producto);
    } 
}
