package com.bolsadeideas.ejemplos;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/holamundo")
public class EjemploController {

	@RequestMapping(method = RequestMethod.GET)
	public String helloWorld(ModelMap modelMap) {

		modelMap.addAttribute("mensaje", "Hola Mundo Spring Framework!");
		return "mivista";
	}

	@RequestMapping(value = "/spring", method = RequestMethod.GET)
	public String helloWorld(Map<String, Object> map) {

		map.put("mensaje2", "Spring!");
		return "mivista2";
	}

	@RequestMapping(value = "/springmvc", method = RequestMethod.GET)
	public ModelAndView helloWorld() {

		ModelAndView modelAndView = new ModelAndView("mivista3");
		modelAndView.addObject("mensaje3", "Spring MVC!");

		return modelAndView;
	}
}
