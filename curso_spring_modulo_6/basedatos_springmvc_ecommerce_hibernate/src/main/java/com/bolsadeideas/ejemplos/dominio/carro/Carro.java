package com.bolsadeideas.ejemplos.dominio.carro;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Andres Guzman
 */
public class Carro implements ICarro, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ItemCarro> items = new LinkedList<ItemCarro>();

    /**
     * Constructor por defecto.
     */
    public Carro() {
    }

    /**
     * Miramos si este producto ya esta en el carrito.
     * Si ya esta simplemente incrementamos su cantidad.
     * Si es un producto que no estaba; lo a�adimos al carrito.
     */
    @Override
    public void addProducto(ItemCarro newProducto) {

        ItemCarro carroProducto = findProducto(Integer.toString(newProducto.getId()));

        if (carroProducto != null) {
            carroProducto.setCantidad(carroProducto.getCantidad()
                    + newProducto.getCantidad());
        } else {
            items.add(newProducto);
        }
    }

    /**
     * A�adimos una lista de products.
     */
    @Override
    public void setItems(List<ItemCarro> otrosProductos) {
        items.addAll(otrosProductos);
    }

    /**
     * El tamaño es el de la lista enlazada.
     * Pero hay que implementar este metodo al tratarse de un JavaBean.
     */
    @Override
    public void setSize(int size) {
    }

    @Override
    public int getSize() {
        return items.size();
    }

    @Override
    public void empty() {
        items.clear();
    }

    @Override
    public double getTotalPrecio() {
        double total = 0.0;
        int size = items.size();

        for (int i = 0; i < size; i++) {
            total += ((ItemCarro) items.get(i)).getImporte();
        }

        return total;
    }

    @Override
    public void removeProducto(String productoId) {
        ItemCarro producto = findProducto(productoId);

        if (producto != null) {
            items.remove(producto);
        }
    }

    @Override
    public void removeProductos(List<String> productoIds) {
        if (productoIds != null) {
            int size = productoIds.size();

            for (int i = 0; i < size; i++) {
                removeProducto((String) productoIds.get(i));
            }
        }
    }

    @Override
    public void updateCantidad(String productoId, int cantidad) {
        ItemCarro producto = findProducto(productoId);

        if (producto != null) {
            producto.setCantidad(cantidad);
        }
    }

    @Override
    public List<ItemCarro> getItems() {
        return items;
    }

    private ItemCarro findProducto(String productoId) {
        ItemCarro producto = null;
        int size = getSize();

        for (int i = 0; i < size; i++) {
            ItemCarro carroProducto = (ItemCarro) items.get(i);

            if (productoId.equals(Integer.toString(carroProducto.getId()))) {
                producto = carroProducto;
                break;
            }
        }

        return producto;
    }
}
