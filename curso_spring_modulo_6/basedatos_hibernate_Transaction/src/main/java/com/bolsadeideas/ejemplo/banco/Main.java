package com.bolsadeideas.ejemplo.banco;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.bolsadeideas.ejemplo.banco.services.CuentaService;

public class Main {
	public static void main(String[] args) throws Throwable {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.xml");

		int numCuentaOrigen = 0001;
		int numCuentaDestino = 0002;
		int bancoId = 0001;

		CuentaService cuentaService = (CuentaService) context.getBean("cuentaService");
		
		int saldoOrigen = cuentaService.revisarSaldo(numCuentaOrigen);
		int saldoDestino = cuentaService.revisarSaldo(numCuentaDestino);
		System.out.println("Antes de la 1ra transferencia: Saldo de la cuenta origen = " + saldoOrigen + " Saldo de la cuenta destino = " + saldoDestino);
		System.out.println("Antes de la 1ra transferencia: Total de transferencias = " + cuentaService.revisarTotalTransferencias(bancoId));
		
		try {
			// Transferir 100 USD desde la cuenta de origen hacia la cuenta de destino.
			// La cuenta de origen tiene suficientes fondos, por lo tanto aceptará la transferencia.
			int monto = 100;
			cuentaService.transferir(numCuentaOrigen, numCuentaDestino, monto);
			
		} catch (DataAccessException dataAccessException) {
			System.out.println("--->Código de Error: " + dataAccessException.getCause());
			System.out.println("--->Mensaje de Error: " + dataAccessException.getMessage());
		}
		
		saldoOrigen = cuentaService.revisarSaldo(numCuentaOrigen);
		saldoDestino = cuentaService.revisarSaldo(numCuentaDestino);
		System.out.println("Después de la 1ra transferencia: Saldo origen = " + saldoOrigen + " Saldo cuenta destino = " + saldoDestino);
		System.out.println("Después de la 1ra transferencia: Total transferencias = " + cuentaService.revisarTotalTransferencias(bancoId));
		
		try {
			// Transferir 1200 USD desde la cuenta de origen hacia la cuenta de destino.
			// La cuenta de origen NO tiene fondos suficientes, por lo tanto NO aceptará la transferencia
			// y generará una excepción
			int monto = 1200;
			cuentaService.transferir(numCuentaOrigen, numCuentaDestino, monto);
		} catch (DataAccessException dataAccessException) {
			System.out.println("--->Código de Error: " + dataAccessException.getCause());
			System.out.println("--->Mensaje de Error: " + dataAccessException.getMessage());
		}
		
		saldoOrigen = cuentaService.revisarSaldo(numCuentaOrigen);
		saldoDestino = cuentaService.revisarSaldo(numCuentaDestino);
		System.out.println("Después de la 2da transferencia: Saldo cuenta origen = " + saldoOrigen + " Saldo cuenta destino  = " + saldoDestino);
		System.out.println("Después de la 2da transferencia: Total transferencias = " + cuentaService.revisarTotalTransferencias(bancoId));
		
		context.close();
	}
}
