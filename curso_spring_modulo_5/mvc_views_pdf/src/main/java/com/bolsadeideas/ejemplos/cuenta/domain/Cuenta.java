package com.bolsadeideas.ejemplos.cuenta.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class Cuenta {

	private Long id;

	private String nombre;

	@NumberFormat(style = Style.CURRENCY)
	private BigDecimal saldo = new BigDecimal("5500");

	@NumberFormat(style = Style.PERCENT)
	private BigDecimal nivelEndeudamiento = new BigDecimal(".05");

	@DateTimeFormat(style = "S-")
	private Date fechaRenovacion = new Date(new Date().getTime() + 21425000000L);

	public Cuenta() {
	}

	public Cuenta(Long id, String nombre, BigDecimal saldo,
			BigDecimal nivelEndeudamiento, Date fechaRenovacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.saldo = saldo;
		this.nivelEndeudamiento = nivelEndeudamiento;
		this.fechaRenovacion = fechaRenovacion;
	}
	
	public Long getId() {
		return id;
	}

	void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public BigDecimal getNivelEndeudamiento() {
		return nivelEndeudamiento;
	}

	public void setNivelEndeudamiento(BigDecimal nivelEndeudamiento) {
		this.nivelEndeudamiento = nivelEndeudamiento;
	}

	public Date getFechaRenovacion() {
		return fechaRenovacion;
	}

	public void setFechaRenovacion(Date fechaRenovacion) {
		this.fechaRenovacion = fechaRenovacion;
	}

	public Long asignarId() {
		this.id = idSequencia.incrementAndGet();
		return id;
	}

	private static final AtomicLong idSequencia = new AtomicLong();

}