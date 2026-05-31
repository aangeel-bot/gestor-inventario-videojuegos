package modelo;

/**
 * Interfaz que define el comportamiento común de los productos del inventario.
 * <p>
 * Todo producto debe poder indicar su nombre y calcular el precio final de venta.
 * </p>
 *
 * @author Angel
 * @version 1.0
 */
public interface Producto {

    /**
     * Obtiene el nombre del producto.
     *
     * @return el nombre del producto
     */
    String getNombre();

    /**
     * Calcula el precio final que pagará el cliente.
     *
     * @return el precio final en euros
     */
    double calcularPrecioFinal();
}
