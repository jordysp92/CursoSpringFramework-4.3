package com.bolsadeideas.ejemplos.dominio.carro;

import java.io.Serializable;
import com.bolsadeideas.ejemplos.models.entity.Producto;

/**
 *
 * @author Andres Guzman
 */
public class ItemCarro implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4187788239797736767L;

	/**
     * Importe es el precio de unidad * cantidad.
     */
    private double importe;

    private Producto producto;

    /**
     * Cantidad por defecto a 1.
     */
    private int cantidad = 1;

    /**
     * Constructor por defecto.
     */
    public ItemCarro() {
    }

    /**
     * Constructor de linea a partir de un producto y su cantidad.
     */
    public ItemCarro(Producto producto, int cant) {
        this.producto = producto;
        this.cantidad = cant;
        calcularImporte();
    }

    public void setProducto(Producto newproducto) {
        producto = newproducto;
        calcularImporte();
    }

    public void setImporte(double newPrecio) {
        importe = newPrecio;
    }

    public int getId() {
        return producto.getId();
    }

    public String getNombre() {
        return producto.getNombre();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int newCantidad) {
        cantidad = newCantidad;
        calcularImporte();
    }

    public Producto getproducto() {
        return producto;
    }

    public double getBasePrecio() {
        return producto.getPrecio();
    }

    public double getImporte() {
        return importe;
    }

    private void calcularImporte() {
        if (producto.getPrecio() != 0) {
            importe = producto.getPrecio() * getCantidad();
        }
    }
}
