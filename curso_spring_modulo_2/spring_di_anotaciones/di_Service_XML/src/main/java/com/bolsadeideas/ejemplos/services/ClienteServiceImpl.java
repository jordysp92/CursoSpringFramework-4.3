package com.bolsadeideas.ejemplos.services;

import com.bolsadeideas.ejemplos.dao.ClienteDao;

public class ClienteServiceImpl implements ClienteService {
	
	private ClienteDao clienteDao;

	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	public String getSaludoCliente() {
		String saludo = "Hola, " + clienteDao.getDetalleCliente();
		return saludo;
	}

}
