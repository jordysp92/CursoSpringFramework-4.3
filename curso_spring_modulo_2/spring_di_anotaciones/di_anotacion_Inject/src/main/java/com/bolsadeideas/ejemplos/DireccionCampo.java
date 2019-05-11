package com.bolsadeideas.ejemplos;

public class DireccionCampo implements IDireccion {

	private int numero = 23;
	private String parcela = "Los Quillayes";
	private String comuna = "Pirque";
	private String region = "Region Metropolitana";
	private String pais = "Chile";

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getParcela() {
		return parcela;
	}

	public void setParcela(String parcela) {
		this.parcela = parcela;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
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
				+ getParcela() + " " + getComuna() + " " + getRegion() + " "
				+ getPais();
		return direccionCompleta;
	}

}
