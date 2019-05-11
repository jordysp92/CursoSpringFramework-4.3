/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bolsadeideas.ejemplos.models.dao;

import java.util.List;

import com.bolsadeideas.ejemplos.models.entity.Usuario;

/**
 *
 * @author Andres Guzman F
 */
public interface IUserDao {

	public Usuario findByUsername(String username);
	
	public List<Usuario> findAll();

    public Usuario findById(Integer id);

    public void save(Usuario user);

    public void delete(Usuario user);
}
