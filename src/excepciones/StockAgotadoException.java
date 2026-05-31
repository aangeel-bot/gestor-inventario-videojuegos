package excepciones;

/**
 * Excepción que indica que no hay unidades disponibles para vender un producto.
 * <p>
 * Se lanza cuando el stock del artículo es cero o inferior al solicitado.
 * </p>
 *
 * @author Angel
 * @version 1.0
 */
public class StockAgotadoException extends Exception {

    /**
     * Crea la excepción con un mensaje descriptivo.
     *
     * @param mensaje detalle del error de stock
     */
    public StockAgotadoException(String mensaje) {
        super(mensaje);
    }
}
