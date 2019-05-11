package com.bolsadeideas.ejemplos.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.ejemplos.models.dao.ICategoriaDao;
import com.bolsadeideas.ejemplos.models.dao.IProductoDao;
import com.bolsadeideas.ejemplos.models.entity.Categoria;
import com.bolsadeideas.ejemplos.models.entity.Producto;
import com.bolsadeideas.ejemplos.util.paginador.PageHibernate;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoDao productoDao;
	
	@Autowired
	private ICategoriaDao categoriaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return productoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(int productoId) {
		return productoDao.findById(productoId);
	}

	@Override
	@Transactional
	public void save(Producto producto) {
		productoDao.save(producto);
	}

	@Override
	@Transactional
	public void delete(Producto producto) {
		productoDao.delete(producto);
	}
	
	@Override
    @Transactional(readOnly = true)
    public List<Categoria> findAllCategorias() {
        return categoriaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria findCategoriaById(int id) {
        return categoriaDao.findById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public PageHibernate findAllPager(String page, int resultsPerPage, String orderBy){
    	return productoDao.findAllPager(page, resultsPerPage, orderBy);
    }
}
