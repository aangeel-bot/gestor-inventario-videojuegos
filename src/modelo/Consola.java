package modelo;

/**
 * Representa una consola de videojuegos en el inventario.
 * <p>
 * Extiende {@link Item} e incluye la generación de la consola.
 * </p>
 *
 * @author Angel
 * @version 1.0
 */
public class Consola extends Item {

    /** Generación de la consola (PS5, Xbox Series X, etc.). */
    private String generacion;

    /**
     * Crea una consola con los datos indicados.
     *
     * @param nombre     modelo de la consola
     * @param precioBase precio de venta en euros
     * @param stock      unidades disponibles
     * @param generacion generación o familia del hardware
     */
    public Consola(String nombre, double precioBase, int stock, String generacion) {
        super(nombre, precioBase, stock);
        this.generacion = generacion;
    }

    /**
     * Obtiene la generación de la consola.
     *
     * @return generación del hardware
     */
    public String getGeneracion() {
        return generacion;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Consola: " + nombre + " (" + generacion + ") - "
                + calcularPrecioFinal() + " EUR - Stock: " + stock;
    }
}
