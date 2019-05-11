package com.bolsadeideas.ejemplos;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/holamundo")
public class EjemploController {

	// Handle URI template, parametro holaId es recibido como tipo String
	@RequestMapping(value = "/holaString/{holaId}", method = RequestMethod.GET)
	public String holaURITemplate(@PathVariable String holaId, Model model) {

		model.addAttribute("mensaje" + holaId, "El mensaje: " + holaId + " seleccionado!");
		return "miPagina" + holaId;
	}

	// Handle URI template, parametro holaId es recibido como tipo int
	@RequestMapping(value = "/holaInteger/{holaId}", method = RequestMethod.GET)
	public String holaURITemplate2(@PathVariable int holaId, Model model) {

		model.addAttribute("mensaje" + holaId, "El mensaje: " + holaId + " seleccionado!");
		return "miPagina" + holaId;
	}

	// Handle URI template, parametro holaId es recibido como tipo int
	@RequestMapping(value = "/holaInteger/{holaId}/{numero}", method = RequestMethod.GET)
	public String holaURITemplate3(@PathVariable int holaId, @PathVariable int numero, Model model) {
		model.addAttribute("mensaje" + holaId, "El mensaje: " + holaId + " seleccionado!");
		model.addAttribute("miNumero", "mi numero es " + numero);
		return "miPagina" + holaId;
	}

	// Handle URI template, parametro holaId es recibido como tipo int y un
	// parametro saludo String
	@RequestMapping(value = "/holaIntegerString/{holaId}/{saludo}", method = RequestMethod.GET)
	public String holaURITemplate4(@PathVariable int holaId, @PathVariable String saludo, Model model) {
		model.addAttribute("mensaje" + holaId,
				"mensaje: " + holaId + " seleccionado!" + " <br> El mensaje de saludo es: " + saludo);
		return "miPagina" + holaId;
	}
}