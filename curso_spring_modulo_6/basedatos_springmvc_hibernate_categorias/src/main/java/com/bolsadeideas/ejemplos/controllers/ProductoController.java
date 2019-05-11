package com.bolsadeideas.ejemplos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.ejemplos.models.entity.Categoria;
import com.bolsadeideas.ejemplos.models.entity.Producto;
import com.bolsadeideas.ejemplos.models.services.IProductoService;

@Controller
@RequestMapping("/catalogo")
@SessionAttributes("producto")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

	@InitBinder
	protected void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Categoria.class,
				new CategoriaPropertyEditor(productoService));
	}

    @RequestMapping(value = "/listado.htm", method = RequestMethod.GET)
    @ModelAttribute("productos")
    public List<Producto> listado(Model modelo) throws Exception {
        modelo.addAttribute("titulo", "Listado de Productos con Categoría");
        return productoService.findAll();
    }

	@RequestMapping(value = "/form.htm", method = RequestMethod.GET)
	public String setupForm(
			@RequestParam(value = "id", required = false, defaultValue = "0") int id,
			Model model) {
		Producto producto = null;
		if (id > 0) {
			producto = productoService.findById(id);
		} else {
			producto = new Producto();
		}

		model.addAttribute("categorias", productoService.findAllCategorias());
		model.addAttribute("producto", producto);
		return "catalogo/form";
	}

	@RequestMapping(value = "/form.htm", method = RequestMethod.POST)
	public String processSubmit(Model model, @Valid Producto producto, BindingResult result, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("categorias", productoService.findAllCategorias());
			return "catalogo/form";
		} else {
			productoService.save(producto);
			status.setComplete();
			return "redirect:listado.htm";
		}
	}

	@RequestMapping(value = "/eliminar.htm", method = RequestMethod.GET)
	public String eliminar(@RequestParam("id") int id) {
		Producto producto = productoService.findById(id);

		if (null != producto) {
			productoService.delete(producto);
		}

		return "redirect:listado.htm";
	}

	@ModelAttribute("titulo")
	public String populateTitulo() {
		return "Formulario Producto con Categoría";
	}
}
