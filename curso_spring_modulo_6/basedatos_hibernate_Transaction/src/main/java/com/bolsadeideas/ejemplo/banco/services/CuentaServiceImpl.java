package com.bolsadeideas.ejemplo.banco.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.ejemplo.banco.dao.CuentaDao;
import com.bolsadeideas.ejemplo.banco.dao.BancoDao;
import com.bolsadeideas.ejemplo.banco.entity.Cuenta;
import com.bolsadeideas.ejemplo.banco.entity.Banco;

@Service("cuentaService")
public class CuentaServiceImpl implements CuentaService {
	
	@Autowired
	private CuentaDao cuentaDao;
	
	@Autowired
	private BancoDao bancoDao;	
	
	public int revisarTotalTransferencias(int bancoId) {		
		Banco banco = bancoDao.findById(bancoId);
		return banco.getTotalTransferencias();				
	}		
	
	public int revisarSaldo(int numCuenta) {		
		Cuenta cuenta = cuentaDao.findById(numCuenta);
		return cuenta.getSaldo();				
	}	

	@Transactional
	public void transferir(int numCuentaOrigen, int numCuentaDestino, int monto) {
		
		// Incrementamos el numero total de transferencias del banco
		Banco banco = bancoDao.findById(0001);
		int totalTransferencias = banco.getTotalTransferencias();
		banco.setTotalTransferencias(++totalTransferencias);		
		bancoDao.update(banco);
		
		// Retirar la cantidad a ser transferida de la cuenta de origen
		Cuenta cuentaOrigen = cuentaDao.findById(numCuentaOrigen);
		cuentaOrigen.debito(monto);		
		cuentaDao.update(cuentaOrigen);
		
		// Depositar la cantidad a la cuenta de destino
		Cuenta cuentaDestino = cuentaDao.findById(numCuentaDestino);
		cuentaDestino.credito(monto);
		cuentaDao.update(cuentaDestino);
				
	}		
		
}
