package com.bolsadeideas.ejemplos;

public class HolaMundoDesacopladoInterface {

	public static void main(String[] args) {
		ImprimeMensaje mr = new ImprimeMensajeImpl();
		ProveedorMensaje mp = new HolaMundoProveedorMensaje();
		mr.setProveedorMensaje(mp);
		mr.imprimir();
	}
}
