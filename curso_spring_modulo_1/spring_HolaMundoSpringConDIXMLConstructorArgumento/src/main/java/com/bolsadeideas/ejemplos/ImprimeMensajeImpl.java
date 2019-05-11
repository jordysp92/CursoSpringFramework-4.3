package com.bolsadeideas.ejemplos;

public class ImprimeMensajeImpl implements ImprimeMensaje {

	private ProveedorMensaje proveedorMensaje = null;

	public void imprimir() {
		if (proveedorMensaje == null) {
			throw new RuntimeException(
					"Debe establecer la propiedad de la clase ProveedorMensaje:"
							+ ImprimeMensajeImpl.class.getName());
		}

		System.out.println(proveedorMensaje.getMensaje());
	}

	public void setProveedorMensaje(ProveedorMensaje proveedor) {
		this.proveedorMensaje = proveedor;
	}

	public ProveedorMensaje getProveedorMensaje() {
		return this.proveedorMensaje;
	}
}