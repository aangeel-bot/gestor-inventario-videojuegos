package modelo;

/**
 * Clase abstracta base para los artículos de la tienda de videojuegos.
 * <p>
 * Contiene los datos comunes a cualquier producto:
 * </p>
 * <ul>
 *   <li><b>nombre</b>: identificador visible del artículo</li>
 *   <li><b>precioBase</b>: precio de catálogo sin recargos</li>
 *   <li><b>stock</b>: unidades disponibles en almacén</li>
 * </ul>
 *
 * @author Angel
 * @version 1.0
 */
public abstract class Item implements Producto {

    /** Nombre del producto. */
    protected String nombre;

    /** Precio base del producto en euros. */
    protected double precioBase;

    /** Cantidad de unidades disponibles. */
    protected int stock;

    /** Porcentaje de descuento aplicable (0-100). */
    protected double porcentajeDescuento;

    /**
     * Crea un nuevo item con los datos indicados.
     *
     * @param nombre    nombre del producto
     * @param precioBase precio de catálogo en euros
     * @param stock     unidades disponibles
     */
    public Item(String nombre, double precioBase, int stock) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.stock = stock;
        this.porcentajeDescuento = 0.0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el precio base del producto.
     *
     * @return precio de catálogo en euros
     */
    public double getPrecioBase() {
        return precioBase;
    }

    /**
     * Obtiene las unidades disponibles.
     *
     * @return cantidad en stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Obtiene el porcentaje de descuento configurado.
     *
     * @return descuento entre 0 y 100
     */
    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    /**
     * Reduce el stock en una unidad tras una venta.
     */
    public void reducirStock() {
        stock--;
    }

    /**
     * Calcula el precio final aplicando solo el precio base.
     * <p>
     * Las subclases pueden ampliar este comportamiento si el negocio lo requiere.
     * </p>
     *
     * @return precio final en euros, nunca negativo en condiciones normales
     */
    @Override
    public double calcularPrecioFinal() {
        return precioBase;
    }

    /**
     * Devuelve una descripción legible del producto.
     *
     * @return texto con nombre, precio y stock
     */
    @Override
    public abstract String toString();
}
