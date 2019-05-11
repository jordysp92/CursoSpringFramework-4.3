package com.bolsadeideas.ejemplos;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HolaMundoSpringConDIXML {

	public static void main(String[] args) throws Exception {

		// obtenemos el bean factory
		BeanFactory factory = getBeanFactory();

		ImprimeMensaje mr = (ImprimeMensaje) factory.getBean("renderer");
		mr.imprimir();
	}

	private static BeanFactory getBeanFactory() throws Exception {
		// obtenemos el bean factory
		BeanFactory factory = new ClassPathXmlApplicationContext("/beans.xml");
        return factory;
	}
}
