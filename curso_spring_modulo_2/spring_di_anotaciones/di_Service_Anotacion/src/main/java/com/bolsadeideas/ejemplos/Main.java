package com.bolsadeideas.ejemplos;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bolsadeideas.ejemplos.dao.ClienteDao;
import com.bolsadeideas.ejemplos.services.ClienteService;

public class Main {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "beans.xml" });

		ClienteService clienteService = (ClienteService) context
				.getBean("clienteService");
		System.out.println(clienteService.getSaludoCliente());
		
		/*ClienteDao clienteDao = (ClienteDao) context.getBean("clienteDao");
		System.out.println(clienteDao.getDetalleCliente());*/

	}
}
