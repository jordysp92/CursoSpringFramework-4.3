package com.bolsadeideas.ejemplos;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/holamundo")
public class EjemploController {

	@RequestMapping(value = "/hola/{holaId}", method = RequestMethod.GET)
	public String holaURI(@PathVariable int holaId, Model model) {

		model.addAttribute("mensaje" + holaId, "mensaje " + holaId
				+ " seleccionado!");
		return "miPagina" + holaId;
	}

	// Recivimos parametros del request
	@RequestMapping(value = "/hola/{holaId}", method = RequestMethod.GET, params = "miCiudad=Santiago")
	public String holaURIparams(@PathVariable int holaId,
			@RequestParam("miCiudad") String ciudad, Model model) {

		model.addAttribute("mensaje" + holaId, "Yo vivo en " + ciudad);
		return "miPagina" + holaId;
	}

	// Recive una instancia Locale y HttpServletRequest
	@RequestMapping(value = "/mi-locale", method = RequestMethod.GET)
	public String holaObjects(Model model, Locale locale,
			HttpServletRequest httpServletRequest) {

		model.addAttribute("pais", locale.getCountry());
		model.addAttribute("ContextPath", httpServletRequest.getContextPath());
		return "miLocale";

	}

	// Mostramos un request header con nombre explicito
	@RequestMapping(value = "requestHeader1")
	public @ResponseBody
	String conHeader1(@RequestHeader("Accept") String accept) {
		return "Obtenemos 'Accept' header '" + accept + "'";
	}

	// Mostramos un request header con nombre implicito
	@RequestMapping(value = "requestHeader2")
	public @ResponseBody
	String conHeader2(@RequestHeader String accept) {
		return "Obtenemos 'Accept' header '" + accept + "'";
	}

}