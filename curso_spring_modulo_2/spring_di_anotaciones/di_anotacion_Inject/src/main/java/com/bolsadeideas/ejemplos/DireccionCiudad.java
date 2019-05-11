package com.bolsadeideas.ejemplos;

public class DireccionCiudad implements IDireccion {

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

	@Override
	public String getDireccionCompleta() {
		String direccionCompleta = "Direccion: " + getNumero() + " "
				+ getCalle() + " " + getCiudad() + " " + getPais();
		return direccionCompleta;
	}

}
