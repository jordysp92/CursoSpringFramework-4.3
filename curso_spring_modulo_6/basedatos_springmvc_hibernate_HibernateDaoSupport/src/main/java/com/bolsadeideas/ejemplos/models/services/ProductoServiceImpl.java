package com.bolsadeideas.ejemplos.models.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.ejemplos.models.dao.IProductoDao;
import com.bolsadeideas.ejemplos.models.entity.Producto;

public class ProductoServiceImpl implements IProductoService {

	private IProductoDao productoDao;
	
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

	public void setProductoDao(IProductoDao productoDao) {
		this.productoDao = productoDao;
	}
	
	
}
