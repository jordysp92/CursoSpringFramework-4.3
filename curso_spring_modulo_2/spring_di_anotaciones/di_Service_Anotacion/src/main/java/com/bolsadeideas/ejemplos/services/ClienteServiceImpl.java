package com.bolsadeideas.ejemplos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bolsadeideas.ejemplos.dao.ClienteDao;

@Service("clienteService")
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	@Qualifier("clienteDao")
	ClienteDao clienteDao;

	public String getSaludoCliente() {
		String saludo = "Hola, " + clienteDao.getDetalleCliente();
		return saludo;
	}

}
