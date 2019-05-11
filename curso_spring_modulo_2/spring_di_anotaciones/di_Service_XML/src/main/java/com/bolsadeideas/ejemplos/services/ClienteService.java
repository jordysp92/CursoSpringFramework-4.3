package com.bolsadeideas.ejemplos.services;

import com.bolsadeideas.ejemplos.dao.ClienteDao;

public interface ClienteService {
	public void setClienteDao(ClienteDao clienteDao);
	public String getSaludoCliente();
}
