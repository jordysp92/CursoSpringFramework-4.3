package com.bolsadeideas.ejemplos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigurableProveedorMensaje implements ProveedorMensaje {

	@Value("Hola Mundo Spring!") 
	private String mensaje;

	public ConfigurableProveedorMensaje() {}
	
	public ConfigurableProveedorMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

}