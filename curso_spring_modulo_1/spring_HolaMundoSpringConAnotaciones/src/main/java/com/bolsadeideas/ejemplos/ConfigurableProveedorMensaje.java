package com.bolsadeideas.ejemplos;

public class ConfigurableProveedorMensaje implements ProveedorMensaje {

	private String mensaje;

	public ConfigurableProveedorMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

}