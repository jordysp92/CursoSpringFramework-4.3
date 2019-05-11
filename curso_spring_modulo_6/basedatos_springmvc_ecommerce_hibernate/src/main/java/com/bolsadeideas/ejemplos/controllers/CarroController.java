package com.bolsadeideas.ejemplos.controllers;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bolsadeideas.ejemplos.models.entity.Producto;
import com.bolsadeideas.ejemplos.models.services.IProductoService;
import com.bolsadeideas.ejemplos.dominio.carro.ICarro;
import com.bolsadeideas.ejemplos.dominio.carro.ItemCarro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/carro")
public class CarroController {

	@Autowired
	private IProductoService productoService;

	@Autowired
	private ICarro carro;

	@RequestMapping(value = "/ver.htm", method = RequestMethod.GET)
	public String verCarro(ModelMap model) {
		model.addAttribute("carro", carro);
		model.addAttribute("titulo", "Carro de Compras");
		return "carro/ver";
	}

	@RequestMapping(value = "/agregar.htm", method = RequestMethod.GET)
	public String addCarro(
			@RequestParam("id") int id,
			@RequestParam(value = "cantidad", required = false, defaultValue = "1") int cantidad,
			ModelMap model) {

		// Llamamos al servicio y le pedimos un Producto Entity para el producto
		// elegido.
		Producto producto = productoService.findById(id);

		// Añadimos el producto al carrito.
		carro.addProducto(new ItemCarro(producto, cantidad));

		return "redirect:ver.htm";
	}

	@RequestMapping(value = "/actualizar.htm", method = RequestMethod.POST)
	public String updateCarro(HttpServletRequest request, ModelMap model) {

		updateProductos(request);
		updateCantidades(request);

		return "redirect:ver.htm";
	}

	private void updateProductos(HttpServletRequest request) {
		String[] deleteIds = request.getParameterValues("deleteProductos");

		if (deleteIds != null && deleteIds.length > 0) {
			int size = deleteIds.length;
			List<String> productoIds = new ArrayList<String>();

			for (int i = 0; i < size; i++) {
				productoIds.add(deleteIds[i]);
			}

			// Obtenemos el carrito del UserContainer y boramos los productos.
			carro.removeProductos(productoIds);
		}

	}

	private void updateCantidades(HttpServletRequest request) {

		Enumeration<?> enumer = request.getParameterNames();

		// Iteramos a traves de los parametros y buscamos los que empiezan con
		// "cant_". El campo cant en la vista fueron nombrados "cant_" +
		// productoId.
		// Obtenemos el id de cada producto y su correspondiente cantidad ;-).
		while (enumer.hasMoreElements()) {
			String paramName = (String) enumer.nextElement();
			if (paramName.startsWith("cant_")) {
				String id = paramName.substring(5, paramName.length());
				String qtyStr = request.getParameter(paramName);
				if (id != null && qtyStr != null) {
					carro.updateCantidad(id, Integer.parseInt(qtyStr));
				}
			}
		}
	}
}
