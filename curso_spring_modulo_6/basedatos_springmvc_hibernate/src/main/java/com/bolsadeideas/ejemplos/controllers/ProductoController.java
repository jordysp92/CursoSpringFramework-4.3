package com.bolsadeideas.ejemplos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.ejemplos.models.entity.Producto;
import com.bolsadeideas.ejemplos.models.services.IProductoService;

@Controller
@RequestMapping("/catalogo")
@SessionAttributes("producto")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @RequestMapping(value = "/listado.htm", method = RequestMethod.GET)
    @ModelAttribute("productos")
    public List<Producto> listado(Model modelo) throws Exception {
        modelo.addAttribute("titulo", "Listado de Productos");
        return productoService.findAll();
    }

    @RequestMapping(value = "/form.htm", method = RequestMethod.GET)
    @ModelAttribute("producto")
    public Producto setupForm(@RequestParam(value = "id", required = false, defaultValue = "0") int id, Model model) {
        Producto producto = null;
        if (id > 0) {
            producto = productoService.findById(id);
        } else {
            producto = new Producto();
        }

        return producto;
    }

    @RequestMapping(value = "/form.htm", method = RequestMethod.POST)
    public String processSubmit(@Valid Producto producto,
            BindingResult result, SessionStatus status) {

        if (result.hasErrors()) {
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
        return "Formulario Productos";
    }
}
