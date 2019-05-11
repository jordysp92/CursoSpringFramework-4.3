/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bolsadeideas.ejemplos.models.dao;

import java.util.List;

import com.bolsadeideas.ejemplos.models.entity.Categoria;

/**
 *
 * @author Andres Guzman F
 */
public interface ICategoriaDao {
    
    public List<Categoria> findAll();
    
    public Categoria findById(int id);
}
