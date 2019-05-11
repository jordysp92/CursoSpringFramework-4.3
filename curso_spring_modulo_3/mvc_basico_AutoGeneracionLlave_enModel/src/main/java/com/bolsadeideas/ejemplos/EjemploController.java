package com.bolsadeideas.ejemplos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/holamundo")
public class EjemploController {

	// Generacion automatica de llaves en atributos para ModelMap
	@RequestMapping(value = "/auto-generacion-llave-modelmap", method = RequestMethod.GET)
	public String handleRequest1(ModelMap modelMap) {

		// Tome nota de que carroCompras es un List del tipo Item
		List<Item> carroCompras = new ArrayList<Item>();
		carroCompras.add(new Item("Panasonic  Pantalla LCD", 259990.0));
		carroCompras.add(new Item("Sony  Camara digital DSC-W320B", 123490.0));

		Usuario usuario = new Usuario("Andres Guzman");

		// Esto es lo mismo que modelMap.addAttribute("itemList", carroCompras);
		modelMap.addAttribute(carroCompras); // "itemList" es generado
												// automaticamente
												// como una llave en el Map

		// Esto es lo mismo que modelMap.addAttribute("usuario", usuario);
		modelMap.addAttribute(usuario); // "usuario" es generado automaticamente
										// como una
										// llave en el Map

		return "verCarro";
	}

	// Generacion automatica de llaves en atributos para ModelAndView
	@RequestMapping(value = "/auto-generacion-llave-modelandview", method = RequestMethod.GET)
	// El tipo de retorno es ModelAndView
	// El objeto ModelAndView es creado dentro del metodo handler
	public ModelAndView handleRequest2() {

		List<Item> carroCompras = new ArrayList<Item>();
		carroCompras.add(new Item("Panasonic  Pantalla LCD", 259990.0));
		carroCompras.add(new Item("Sony  Camara digital DSC-W320B", 123490.0));

		Usuario usuario = new Usuario("Andres Guzman");

		// "verCarro2" la vista jsp
		ModelAndView mav = new ModelAndView("verCarro2");

		// Esto es lo mismo que mav.addObject("itemList", carroCompras);
		mav.addObject(carroCompras); // "itemList" es generado
										// automaticamente como una llave en
										// ModelAndView

		// Esto es lo mismo que mav.addObject("usuario", usuario);
		mav.addObject(usuario); // "usuario" es generado automaticamente como
								// una llave

		return mav;
	}

	// Generacion automatica de vista en ModelandView
	@RequestMapping(value = "/generacion-automatica-vista", method = RequestMethod.GET)
	// El tipo de retorno es ModelAndView
	// El objeto ModelAndView es creado dentro del metodo handler
	public ModelAndView handleRequest3() {

		List<Item> carroCompras = new ArrayList<Item>();
		carroCompras.add(new Item("Panasonic  Pantalla LCD", 259990.0));
		carroCompras.add(new Item("Sony  Camara digital DSC-W320B", 123490.0));

		Usuario usuario = new Usuario("Andres Guzman");

		// "generacion-automatica-vista.jsp" es la vista
		// ya que no se asigna de forma explicita
		ModelAndView mav = new ModelAndView();

		// Esto es lo mismo que mav.addObject("itemList", carroCompras);
		mav.addObject(carroCompras); // "itemList" es generado automaticamente
										// como una llave

		// Esto es lo mismo que as mav.addObject("usuario", usuario);
		mav.addObject(usuario); // "usuario" es generado automaticamente como
								// una llave

		return mav;
	}

	// Otra forma de crear atributos del model (hacia la vista)
	@ModelAttribute("itemList2")
	public List<Item> populateSubjectList() {

		List<Item> carroCompras = new ArrayList<Item>();
		carroCompras.add(new Item("Apple iPad", 350000.0));
		carroCompras.add(new Item("Samsung Galaxy S3", 490000.0));

		return carroCompras;
	}

}