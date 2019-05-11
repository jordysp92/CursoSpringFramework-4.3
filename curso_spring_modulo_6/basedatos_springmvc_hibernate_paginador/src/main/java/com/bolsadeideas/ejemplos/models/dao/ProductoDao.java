package com.bolsadeideas.ejemplos.models.dao;

import java.util.List;

import com.bolsadeideas.ejemplos.models.entity.Producto;
import com.bolsadeideas.ejemplos.util.paginador.PageHibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoDao implements IProductoDao {

	@Autowired
    private HibernateTemplate hibernateTemplate;
	
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
    
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

	public PageHibernate findAllPager(String page, int resultsPerPage, String orderBy){
	    PageHibernate paginador = new PageHibernate("from Producto order by id asc", page, resultsPerPage);

	    hibernateTemplate.execute(paginador);

	    List<?> count = hibernateTemplate.find("SELECT count(*) from Producto");

	    paginador.setTotalCount(Integer.parseInt(count.get(0).toString()));
	   
	    return paginador;
	}
}
