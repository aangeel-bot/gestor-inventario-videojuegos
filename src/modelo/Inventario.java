package modelo;

import excepciones.StockAgotadoException;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona la colección de productos de la tienda de videojuegos.
 * <p>
 * Permite las operaciones básicas del negocio:
 * </p>
 * <ul>
 *   <li><b>agregar</b>: añadir productos al catálogo</li>
 *   <li><b>listar</b>: consultar el inventario actual</li>
 *   <li><b>vender</b>: registrar una venta y reducir stock</li>
 * </ul>
 *
 * @author Angel
 * @version 1.0
 */
public class Inventario {

    /** Lista de productos almacenados. */
    private List<Producto> productos;

    /**
     * Crea un inventario vacío.
     */
    public Inventario() {
        this.productos = new ArrayList<>();
    }

    /**
     * Añade un producto al inventario.
     * <p>
     * El producto se inserta al final de la lista interna y queda disponible
     * para consulta y venta inmediata.
     * </p>
     *
     * @param producto artículo a registrar; no debe ser {@code null}
     */
    public void agregar(Producto producto) {
        productos.add(producto);
    }

    /**
     * Devuelve la lista de productos actuales.
     *
     * @return copia de la lista interna de productos
     */
    public List<Producto> listar() {
        return new ArrayList<>(productos);
    }

    /**
     * Registra la venta de un producto por su índice en la lista.
     *
     * @param indice posición del producto (base 0)
     * @return precio final cobrado al cliente
     * @throws StockAgotadoException si no hay stock disponible
     * @throws IndexOutOfBoundsException si el índice no es válido
     */
    public double vender(int indice) throws StockAgotadoException {
        if (indice < 0 || indice >= productos.size()) {
            throw new IndexOutOfBoundsException("Indice de producto invalido: " + indice);
        }

        Producto producto = productos.get(indice);
        if (!(producto instanceof Item)) {
            throw new StockAgotadoException("Producto no vendible: " + producto.getNombre());
        }

        Item item = (Item) producto;
        if (item.getStock() <= 0) {
            throw new StockAgotadoException("Stock agotado para: " + item.getNombre());
        }

        double precio = item.calcularPrecioFinal();
        item.reducirStock();
        return precio;
    }
}
