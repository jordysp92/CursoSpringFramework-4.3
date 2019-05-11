package com.bolsadeideas.ejemplos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("persona")
public class Persona {
	private String nombre = "Andres Guzman";
	private int edad = 34;
	private float peso = 1.99f;
	private boolean programador = true;
	
	@Autowired
	private IDirecciones direcciones;

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

	public String getDirecciones() {

		StringBuilder sb = new StringBuilder("Mis Direcciones: ");
		for(Direccion direccion: direcciones.getDirecciones()){
				sb.append(direccion.getCalle())
				.append(" ")
				.append(direccion.getNumero())
				.append(" ")
				.append(direccion.getCiudad())
				.append(" ")
				.append(direccion.getPais())
				.append("\n");
		}
		
		return sb.toString();
	}

}
