package com.bolsadeideas.ejemplo.banco.services;

public interface CuentaService {
	public int revisarTotalTransferencias(int bancoId);
	public int revisarSaldo(int numCuenta);
	public void transferir(int numCuentaOrigen, int numCuentaDestino, int monto);
}
