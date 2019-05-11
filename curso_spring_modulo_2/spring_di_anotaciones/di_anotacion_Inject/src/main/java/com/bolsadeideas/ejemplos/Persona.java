package com.bolsadeideas.ejemplos;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;

public class Persona {
	private String nombre = "Andres Guzman";
	private int edad = 34;
	private float peso = 1.99f;
	private boolean programador = true;

	// Usamos @JSR 330 @Inject en vez de @Autowired
    //@Autowired
    @Inject
	@Qualifier("direccionCiudad")
	private IDireccion direccion;

	public IDireccion getDireccion() {
		return direccion;
	}

	// public void setDireccion(IDireccion direccion) {
	// this.direccion = direccion;
	// }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public boolean isProgramador() {
		return programador;
	}

	public void setProgramador(boolean esProgramador) {
		this.programador = esProgramador;
	}

}
