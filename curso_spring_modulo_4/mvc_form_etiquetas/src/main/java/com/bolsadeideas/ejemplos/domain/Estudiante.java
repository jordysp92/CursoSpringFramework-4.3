package com.bolsadeideas.ejemplos.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Estudiante{
	
	@Size(message="El campo nombre es requerido!", min = 4, max = 12)
	private String userName;
	
	@NotEmpty(message="El campo direccion es requerido!")
	private String direccion;
	
	@Size(message="El password es requerido!", min = 4, max = 6)
	private String password;
	
	private boolean recibeNewsletter;
	
	@NotEmpty(message="Seleccione temas!")
	private String[] temas;
	
	@NotEmpty(message="Seleccione un número favorito!")
	private String numeroFavorito;
	
	@NotEmpty(message="Seleccione un genero!")
	private String genero;

	@NotEmpty(message="Seleccione un pais!")
	private String pais;
	
	@NotEmpty(message="Seleccione habilidades de Spring!")
	private String experienciaSpring;
	
	//valor oculto
	private String valorSecreto;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isRecibeNewsletter() {
		return recibeNewsletter;
	}

	public void setRecibeNewsletter(boolean reciveNewsletter) {
		this.recibeNewsletter = reciveNewsletter;
	}

	public String[] getTemas() {
		return temas;
	}

	public void setTemas(String[] temas) {
		this.temas = temas;
	}

	public String getNumeroFavorito() {
		return numeroFavorito;
	}

	public void setNumeroFavorito(String numeroFavorito) {
		this.numeroFavorito = numeroFavorito;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getExperienciaSpring() {
		return experienciaSpring;
	}

	public void setExperienciaSpring(String experienciaSpring) {
		this.experienciaSpring = experienciaSpring;
	}

	public String getValorSecreto() {
		return valorSecreto;
	}

	public void setValorSecreto(String valorSecreto) {
		this.valorSecreto = valorSecreto;
	}
	
	
}