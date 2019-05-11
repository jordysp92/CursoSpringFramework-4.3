package com.bolsadeideas.ejemplos;

public class HolaMundoConArgumentosLineaComando {

	public static void main(String[] args) {
		if (args.length > 0) {
			System.out.println(args[0]);
		} else {
			System.out.println("Hola Mundo!");
		}
	}
}