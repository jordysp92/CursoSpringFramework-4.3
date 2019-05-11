package com.bolsadeideas.ejemplos.cuenta.controllers;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bolsadeideas.ejemplos.cuenta.domain.Cuenta;
import com.bolsadeideas.ejemplos.cuenta.validators.CuentaValidator;
import com.bolsadeideas.ejemplos.cuenta.validators.CuentaValidator2;

@Controller
@RequestMapping(value="/cuenta")
public class CuentaController {

    // Usamos otro validador CuentaValidator2
	@Autowired
	CuentaValidator2 cuentaValidator2;
	
	private Map<Long, Cuenta> cuentas = new ConcurrentHashMap<Long, Cuenta>();

	// Configuramos un validador "CuentaValidator" para el "WebDataBinder".
	// En el ejemplo, ejecutamos dos tipos diferente de validacion,
	// una usando anotaciones en la clase "Cuenta",
	// la segunda usando una clase validadora se spring con cierta logica en 
	// la clase "CuentaValidator".
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new CuentaValidator());
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
		
		// Ejecutamos la validacion directamente dentro del metodo
		cuentaValidator2.validate(cuenta, result);
				
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
