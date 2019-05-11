package com.bolsadeideas.ejemplos;

public class HolaMundoDesacopladoConFactory {

	public static void main(String[] args) {
		ImprimeMensaje mr = MensajeFactory.getInstance().getRendererMensaje();
		ProveedorMensaje mp = MensajeFactory.getInstance()
				.getProveedorMensaje();
		mr.setProveedorMensaje(mp);
		mr.imprimir();
	}
}