package com.bolsadeideas.ejemplos;

import java.io.FileInputStream;
import java.util.Properties;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;

public class HolaMundoSpringConDI {

	public static void main(String[] args) throws Exception {

		// obtenemos el bean factory
		BeanFactory factory = getBeanFactory();

		ImprimeMensaje mr = (ImprimeMensaje) factory.getBean("renderer");
		mr.imprimir();
	}

	private static BeanFactory getBeanFactory() throws Exception {
		// obtenemos el bean factory
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

		// creamos la clase para leer el properties
		PropertiesBeanDefinitionReader rdr = new PropertiesBeanDefinitionReader(
				factory);

		Properties props = new Properties();
		props.load(new FileInputStream("beans.properties"));

		rdr.registerBeanDefinitions(props);

		return factory;
	}
}
