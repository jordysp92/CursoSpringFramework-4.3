package com.bolsadeideas.ejemplos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("direcciones")
public class MisDirecciones implements IDirecciones{

	@Autowired
	private List<Direccion> direcciones;

	public List<Direccion> getDirecciones() {
		return direcciones;
	}	
	
}
