package com.bolsadeideas.ejemplos;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("/beans.xml");
		Persona persona = (Persona) factory.getBean("persona");
		System.out.println(getInfoPersona(persona));
		factory.close();
	}

	public static String getInfoPersona(Persona persona) {
		return "Nombre:" + persona.getNombre() + "\n" + "Edad:"
				+ persona.getEdad() + "\n" + "Peso: " + persona.getPeso()
				+ "\n" + "Es Programador?: " + persona.isProgramador() + "\n"
				+ persona.getDirecciones();
	}
}