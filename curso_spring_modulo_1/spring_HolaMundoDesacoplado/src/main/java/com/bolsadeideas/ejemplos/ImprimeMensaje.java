package com.bolsadeideas.ejemplos;

public class ImprimeMensaje {
    
    private HolaMundoProveedorMensaje proveedorMensaje = null;
    
	public void imprimir() {
        if (proveedorMensaje == null) {
            throw new RuntimeException(
                    "Debe establecer la propiedad de la clase ProveedorMensaje:"
                    + ImprimeMensaje.class.getName());
        }
        
        System.out.println(proveedorMensaje.getMensaje());
    }
    
    public void setProveedorMensaje(HolaMundoProveedorMensaje proveedor) {
        this.proveedorMensaje = proveedor;
    }
    
    public HolaMundoProveedorMensaje getProveedorMensaje() {
        return this.proveedorMensaje;
    }
    
}