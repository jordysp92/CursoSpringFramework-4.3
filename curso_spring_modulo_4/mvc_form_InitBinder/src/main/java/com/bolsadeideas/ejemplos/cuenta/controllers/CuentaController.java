package com.bolsadeideas.ejemplos.cuenta.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bolsadeideas.ejemplos.cuenta.binders.NombreMayusculaEditor;
import com.bolsadeideas.ejemplos.cuenta.domain.Cuenta;

@Controller
@RequestMapping(value = "/cuenta")
public class CuentaController {
	private Map<Long, Cuenta> cuentas = new ConcurrentHashMap<Long, Cuenta>();

	// La anotacion "@InitBinder" identifica el metodo que
	// va a iniciar el "WebDataBinder", quien se encarga de registar
	// validadores, editores y de poblar el objeto comando con los datos
	// del formulario. Los editores se encargan de convertir los datos del
	// formulario a cierto tipo o formato antes de que se pasen o pueblen
	// al objeto comando. Luego el comando sera pasado por
	// argumento en los metodos anotados (handler) del controlador.
	@InitBinder
	protected void initBinder(WebDataBinder binder) {

		// Registramos los editores. "CustomDateEditor" y
		// "NombreMayusculaEditor".
		// "CustomDateEditor" es propio de Spring framework para validar la
		// fecha a un formato especifico y convertir a Date de java, mientras
		// que el "NombreMayusculaEditor" es escrito por nosotros para convertir
		// el nombre ingresado a mayuscula.
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class, "nombre", new NombreMayusculaEditor());
	}

	// Metodo handler formulario, para crear la cuenta
	@RequestMapping(method = RequestMethod.GET)
	public String crearCuentaForm(Model model) {
		// La instancia de "Cuenta" es creada y guardada como atributo "cuenta"
		// en el objeto "model", el cual es accesible desde
		// la vista, "cuenta/crearForm.jsp".
		model.addAttribute("cuenta", new Cuenta());
		return "cuenta/crearForm";
	}

	// Metodo handler que procesa el envio de datos del form
	@RequestMapping(method = RequestMethod.POST)
	public String crearCuenta(@Valid Cuenta cuenta, BindingResult result) {
		// Si ocurre un error en la validacion aparecera el formulario
		// "cuenta/crearForm.jsp" con los mensajes.
		if (result.hasErrors()) {
			return "cuenta/crearForm";
		}

		// Si todo esta bien, crea la cuenta y la agrega a la lista
		// "cuentas", luego redirige hacia el detalle /cuenta/{id},
		// controlado por el metodo handler "verDetalle(..) de mas abajo.
		this.cuentas.put(cuenta.asignarId(), cuenta);
		return "redirect:/cuenta/" + cuenta.getId();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String verDetalle(@PathVariable Long id, Model model) {
		Cuenta cuenta = this.cuentas.get(id);
		if (cuenta == null) {
			throw new RecursoNoEncontradoException(id);
		}
		model.addAttribute("cuenta", cuenta);
		// return "cuenta/detalle"; // Muestra el detalle de la cuenta en
		// formato formulario
		return "cuenta/detalle2"; // Muestra el detalle de la cuenta en formato
									// tabla html
	}

}
