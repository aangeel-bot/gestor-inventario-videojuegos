import excepciones.StockAgotadoException;
import java.util.List;
import java.util.Scanner;
import modelo.Consola;
import modelo.Inventario;
import modelo.Producto;
import modelo.Videojuego;

/**
 * Punto de entrada de la aplicación de consola.
 * <p>
 * Muestra un menú sencillo para gestionar el inventario de la tienda:
 * </p>
 * <ul>
 *   <li><b>1</b> - Listar productos</li>
 *   <li><b>2</b> - Agregar producto de ejemplo</li>
 *   <li><b>3</b> - Vender producto</li>
 *   <li><b>0</b> - Salir</li>
 * </ul>
 *
 * @author Angel
 * @version 1.0
 */
public class Main {

    /**
     * Ejecuta la aplicación de consola.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        inventario.agregar(new Videojuego("Zelda", 59.99, 3, "Switch"));
        inventario.agregar(new Consola("PlayStation 5", 499.99, 2, "Gen 9"));

        Scanner scanner = new Scanner(System.in);
        boolean activo = true;

        while (activo) {
            mostrarMenu();
            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1" -> listarProductos(inventario);
                case "2" -> agregarEjemplo(inventario);
                case "3" -> venderProducto(inventario, scanner);
                case "0" -> activo = false;
                default -> System.out.println("Opcion no valida.");
            }
        }

        System.out.println("Hasta pronto.");
        scanner.close();
    }

    /**
     * Muestra las opciones del menú principal.
     */
    private static void mostrarMenu() {
        System.out.println();
        System.out.println("=== Gestor de Inventario - Tienda de Videojuegos ===");
        System.out.println("1. Listar productos");
        System.out.println("2. Agregar producto de ejemplo");
        System.out.println("3. Vender producto");
        System.out.println("0. Salir");
        System.out.print("Elige una opcion: ");
    }

    /**
     * Imprime todos los productos del inventario.
     *
     * @param inventario inventario a consultar
     */
    private static void listarProductos(Inventario inventario) {
        List<Producto> productos = inventario.listar();
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
            return;
        }
        for (int i = 0; i < productos.size(); i++) {
            System.out.println(i + ". " + productos.get(i));
        }
    }

    /**
     * Añade un videojuego de ejemplo al inventario.
     *
     * @param inventario inventario donde registrar el producto
     */
    private static void agregarEjemplo(Inventario inventario) {
        inventario.agregar(new Videojuego("Minecraft", 26.95, 5, "PC"));
        System.out.println("Producto de ejemplo agregado correctamente.");
    }

    /**
     * Procesa una venta solicitando el índice del producto.
     *
     * @param inventario inventario donde buscar el producto
     * @param scanner    lector de entrada del usuario
     */
    private static void venderProducto(Inventario inventario, Scanner scanner) {
        listarProductos(inventario);
        System.out.print("Indice del producto a vender: ");
        try {
            int indice = Integer.parseInt(scanner.nextLine().trim());
            double precio = inventario.vender(indice);
            System.out.println("Venta realizada. Precio cobrado: " + precio + " EUR");
        } catch (NumberFormatException e) {
            System.out.println("Debes introducir un numero entero.");
        } catch (StockAgotadoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
