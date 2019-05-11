package com.bolsadeideas.ejemplos;

import org.springframework.beans.factory.annotation.Autowired;

public class ImprimeMensajeImpl implements ImprimeMensaje {

	@Autowired
	private ProveedorMensaje proveedorMensaje = null;

	public void imprimir() {
		if (proveedorMensaje == null) {
			throw new RuntimeException(
					"Debe establecer la propiedad de la clase ProveedorMensaje:"
							+ ImprimeMensajeImpl.class.getName());
		}

		System.out.println(proveedorMensaje.getMensaje());
	}

	// Ya no es necesario, ya que se inyecta mediante anotacion Autowired
	//public void setProveedorMensaje(ProveedorMensaje proveedor) {
		//this.proveedorMensaje = proveedor;
	//}

	public ProveedorMensaje getProveedorMensaje() {
		return this.proveedorMensaje;
	}
}