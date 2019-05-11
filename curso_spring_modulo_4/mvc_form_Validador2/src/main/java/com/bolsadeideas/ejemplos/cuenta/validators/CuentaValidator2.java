package com.bolsadeideas.ejemplos.cuenta.validators;

import java.math.BigDecimal;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bolsadeideas.ejemplos.cuenta.domain.Cuenta;

//La interfaz "validator" de spring esta totalmente des-acoplada de cualquier capa o
//contexto, es decir ningun objeto esta acoplada a la validacion, me refiero a ninguno
//ni los objetos de la capa web, ni de acceso a datos o models, o del nivel que sea. 
//Como tal, es susceptible de ser utilizado en cualquier capa de la aplicacion 
public class CuentaValidator2 implements Validator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public boolean supports(Class<?> clazz) {
		// validamos que la instancia sea del tipo Cuenta
		return Cuenta.class.isAssignableFrom(clazz);

	}

	// sobre-escribimos el metodo para implementar nuestra logica de validacion.
	public void validate(Object target, Errors errors) {

		Cuenta account = (Cuenta) target;

		// Si el saldo es menor a 2000,
		// entonces resulta un error por ser muy bajo.
		if (account.getSaldo() != null && account.getSaldo().compareTo(new BigDecimal(2000)) < 0) {
			errors.rejectValue("saldo", // nombre del campo
					"required.saldoBajo"); // codigo de error
		}

		// Si la fecha Renovacion es anterior a la actual,
		// entonces resulta un error.
		if (account.getFechaRenovacion() != null && account.getFechaRenovacion().before(new Date())) {
			errors.rejectValue("fechaRenovacion", // nombre del campo
					"required.fechaRenovacion"); // codigo de error
		}

		if (!isEmail(account.getEmail())) {
			errors.rejectValue("email", "required.email", "email es invalido");
		}

	}

	public static Boolean isEmail(String emailString) {

		Pattern p = Pattern.compile(EMAIL_PATTERN);

		// Match the given string with the pattern
		Matcher m = p.matcher(emailString);

		if (!m.matches()) {
			return false;
		}
		return true;
	}

}