package com.bolsadeideas.ejemplos.controllers;

import java.beans.PropertyEditorSupport;
import com.bolsadeideas.ejemplos.models.services.IProductoService;

public class CategoriaPropertyEditor extends PropertyEditorSupport {

    private IProductoService productoService;

    public CategoriaPropertyEditor(IProductoService productoService) {
        this.productoService = productoService;
    }

    @Override
    public void setAsText(String idStr) throws IllegalArgumentException {

        setValue(productoService.findCategoriaById(Integer.parseInt(idStr)));

        /*
         * int id = Integer.parseInt(idStr);
         *
         * for(Categoria categoria: productoService.obtenerCategorias()){
         *
         * if(id == categoria.getId()){ setValue(categoria); break; } }
         */
    }
}
