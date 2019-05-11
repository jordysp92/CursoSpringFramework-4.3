package com.bolsadeideas.ejemplos;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Direccion {

	private int numero = 111;
	private String calle = "Av. Apoquindo";
	private String ciudad = "Santiago";
	private String pais = "Chile";

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@PostConstruct
	public void hacerAlgoDespuesConstruct() {
		String ciudadAnterior = ciudad;
		ciudad = "Viña del Mar";
		System.out.println("--->Ciudad Anterior = " + ciudadAnterior
				+ ", Nueva Ciudad = " + ciudad);
	}

	@PreDestroy
	public void hacerAlgoAntesDestroy() {
		System.out
				.println("--->Hacer algo antes de que se destruya el objeto Direccion!!!");
	}
}
