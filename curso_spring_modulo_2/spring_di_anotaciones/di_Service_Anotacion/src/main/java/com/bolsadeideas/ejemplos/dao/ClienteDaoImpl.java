package com.bolsadeideas.ejemplos.dao;

import org.springframework.stereotype.Repository;

/*
 * @Repository Esta es una anotacion de Spring es para marcar 
 * a la clase DAO como un Component de Spring, indicando que esta es una 
 * clase relacionada con la capa de persistencia, por lo tanto 
 * cualquier error que ocurra se traducira en DataAccessException
 * org.springframework.dao.DataAccessException.
 * 
 * A partir de Spring de 2.5, esta anotacion sirve tambien 
 * como una especializacion o tipo de @Componente, tambien 
 * son auto detectadas a traves de scann de componentes.
 * 
 * Ademas @Repository indica que debe ser un Singleton 
 * (solo habra una instancia de la clase DAO , 
 * y todos los Threads de la aplicacion la compartiron).
 */
@Repository("clienteDao")
public class ClienteDaoImpl implements ClienteDao {

	public String getDetalleCliente() {
		// Para simplicidad del ejemplo, retornamos un String con el nombre.
		return "Bruce Lee";
	}
}
