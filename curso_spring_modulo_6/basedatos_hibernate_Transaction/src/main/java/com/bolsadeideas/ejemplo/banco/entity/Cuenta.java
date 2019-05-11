package com.bolsadeideas.ejemplo.banco.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUENTA")
public class Cuenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "PERSONA", length = 50, nullable = false)
    private String persona;
	
	@Column(name = "SALDO")
    private int saldo;

    public Cuenta() {
    }

    public Cuenta(int id, String persona, int saldo) {
        this.id = id;
        this.persona = persona;
        this.saldo = saldo;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPersona() {
		return persona;
	}

	public void setPersona(String persona) {
		this.persona = persona;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public void debito(int monto) {
		saldo -= monto;
	}

	public void credito(int monto) {
		saldo += monto;
	}

}
