package com.bolsadeideas.ejemplos.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "ESTUDIANTE")
public class Estudiante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "NOMBRE", length = 20, nullable = false)
	private String nombre;
	@Column(name = "FECHA_NACIMIENTO")
	private Date fechaNacimiento;
	@Column(name = "PROMEDIO")
	private int promedio;

	public Estudiante() {
	}

	public Estudiante(int id, String nombre, Date fechaNacimiento, int promedio) {
		this.id = id;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.promedio = promedio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getPromedio() {
		return promedio;
	}

	public void setPromedio(int promedio) {
		this.promedio = promedio;
	}
}
