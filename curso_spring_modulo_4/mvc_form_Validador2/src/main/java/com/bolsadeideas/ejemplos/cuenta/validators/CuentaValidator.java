package com.bolsadeideas.ejemplos.cuenta.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bolsadeideas.ejemplos.cuenta.domain.Cuenta;

//La interfaz "validator" de spring está totalmente des-acoplada de cualquier capa o
//contexto, es decir ningún objeto está acoplada a la validación, me refiero a ninguno
//ni los objetos de la capa web, ni de acceso a datos o models, o del nivel que sea. 
//Como tal, es susceptible de ser utilizado en cualquier capa de la aplicación
public class CuentaValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		// validamos que la instancia sea del tipo Cuenta
		return Cuenta.class.isAssignableFrom(clazz);
	}

	// sobre-escribimos el metodo para implementar nuestra logica de validacion.
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre",
				"required.nombre", "nombre es requerido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "saldo",
				"required.saldo", "saldo es requerido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nivelEndeudamiento",
				"required.nivelEndeudamiento", "nivelEndeudamiento es requerido");

	}

}