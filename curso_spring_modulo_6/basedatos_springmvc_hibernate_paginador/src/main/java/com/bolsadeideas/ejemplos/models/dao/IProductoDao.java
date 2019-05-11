/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bolsadeideas.ejemplos.models.dao;

import java.util.List;

import com.bolsadeideas.ejemplos.models.entity.Producto;
import com.bolsadeideas.ejemplos.util.paginador.PageHibernate;

/**
 *
 * @author Andres Guzman F
 */
public interface IProductoDao {

    public List<Producto> findAll();

    public Producto findById(int productoId);

    public void save(Producto producto);

    public void delete(Producto producto);
    
    public PageHibernate findAllPager(String page, int resultsPerPage, String orderBy);
}
