/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bolsadeideas.ejemplos.models.services;

import java.util.List;

import com.bolsadeideas.ejemplos.models.entity.Categoria;
import com.bolsadeideas.ejemplos.models.entity.Producto;
/**
 *
 * @author Andres Guzman F
 */
public interface IProductoService {

    public List<Producto> findAll();

    public Producto findById(int productoId);

    public void save(Producto producto);

    public void delete(Producto producto);
    
    public List<Categoria> findAllCategorias();
    
    public Categoria findCategoriaById(int id);
}
