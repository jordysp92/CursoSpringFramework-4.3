package com.bolsadeideas.ejemplos.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/holamundo")
public class EjemploController {

	// Mapeada a la URL /holamundo
	// Retorna un tipo String
	// Como argumento recibe el objeto model del tipo ModelMap
	@RequestMapping(method = RequestMethod.GET)
	public String holaMundo(ModelMap modelMap) {

		modelMap.addAttribute("mensaje1", "Hola Mundo!");
		return "mivista1";
	}

	// Mapeada a la URL /holamundo/hola-spring
	// Retorna un tipo String
	// Como argumento recibe el objeto model del tipo Map
	@RequestMapping(value = "/hola-spring", method = RequestMethod.GET)
	public String holaMundo(Map<String, String> map) {

		map.put("mensaje2", "Spring!");
		return "mivista2";
	}

	// Mapeada a la URL /holamundo/hola-springmvc
	// Retorna un tipo ModelAndView
	// Se crea el objeto ModelAndView dentro del método
	@RequestMapping(value = "/hola-springmvc", method = RequestMethod.GET)
	public ModelAndView holaMundo() {

		ModelAndView modelAndView = new ModelAndView("mivista3");
		modelAndView.addObject("mensaje3", "Spring MVC!");

		return modelAndView;
	}

	// Mapeada a la URL /holamundo/hola-springcore
	// Retorna un tipo String
	// Como argumento recibe el objeto model del tipo Model
	@RequestMapping(value = "/hola-springcore", method = RequestMethod.GET)
	public String holaMundo(Model model) {

		model.addAttribute("mensaje4", "Spring Core!");
		return "mivista4";
	}

	// Mapeada a la URL holamundo/hola-springbatch
	// No Retorna nada, es void,
	// "/holamundo/hola-springbatch" define el nombre y ubicación de la vista,
	// por lo tanto la vista que ejecutará será
	// "/holamundo/hola-springbatch.jsp".
	// Como argumento recibe el objeto model del tipo Model
	@RequestMapping(value = "/hola-springbatch", method = RequestMethod.GET)
	public void holaMundo2(Model model) {
		model.addAttribute("mensaje5", "Spring Batch!");
	}

}