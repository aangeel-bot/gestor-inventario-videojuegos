package modelo;

/**
 * Representa un videojuego disponible en la tienda.
 * <p>
 * Extiende {@link Item} añadiendo la plataforma en la que se ejecuta el juego.
 * </p>
 *
 * @author Angel
 * @version 1.0
 */
public class Videojuego extends Item {

    /** Plataforma del videojuego (PC, PS5, Switch, etc.). */
    private String plataforma;

    /**
     * Crea un videojuego con los datos indicados.
     *
     * @param nombre     título del juego
     * @param precioBase precio de venta en euros
     * @param stock      unidades disponibles
     * @param plataforma plataforma compatible
     */
    public Videojuego(String nombre, double precioBase, int stock, String plataforma) {
        super(nombre, precioBase, stock);
        this.plataforma = plataforma;
    }

    /**
     * Obtiene la plataforma del videojuego.
     *
     * @return nombre de la plataforma
     */
    public String getPlataforma() {
        return plataforma;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Videojuego: " + nombre + " (" + plataforma + ") - "
                + calcularPrecioFinal() + " EUR - Stock: " + stock;
    }
}
