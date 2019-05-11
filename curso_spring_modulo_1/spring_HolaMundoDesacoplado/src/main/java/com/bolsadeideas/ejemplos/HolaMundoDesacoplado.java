package com.bolsadeideas.ejemplos;

public class HolaMundoDesacoplado {

	public static void main(String[] args) {
		ImprimeMensaje mr = new ImprimeMensaje();
		HolaMundoProveedorMensaje mp = new HolaMundoProveedorMensaje();
		mr.setProveedorMensaje(mp);
		mr.imprimir();
	}
}
