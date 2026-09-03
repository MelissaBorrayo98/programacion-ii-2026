import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;

public class MainControlCompras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Colecciones obligatorias
        ArrayList<Producto> listaProductos = new ArrayList<>();
        HashSet<String> setCategorias = new HashSet<>();
        HashMap<String, Double> mapTotalesCategoria = new HashMap<>();

        System.out.println("=== REGISTRO DE COMPRAS DEL HOGAR ===");
        System.out.println("Debe registrar un mínimo de 5 productos válidos.\n");

        int productosValidos = 0;

        while (productosValidos < 5) {
            System.out.println("--- Registro de Producto #" + (productosValidos + 1) + " ---");

            System.out.print("Nombre del producto: ");
            String nombre = scanner.nextLine().trim();

            System.out.print("Categoría: ");
            String categoria = scanner.nextLine().trim();

            System.out.print("Precio unitario: ");
            double precio = 0;
            if (scanner.hasNextDouble()) {
                precio = scanner.nextDouble();
            } else {
                scanner.next(); // limpiar buffer
            }

            System.out.print("Cantidad: ");
            int cantidad = 0;
            if (scanner.hasNextInt()) {
                cantidad = scanner.nextInt();
            } else {
                scanner.next(); // limpiar buffer
            }
            scanner.nextLine(); // limpiar salto de línea pendiente

            // Validaciones lógicas
            if (nombre.isEmpty()) {
                System.out.println("\n[X] Producto no registrado: el nombre no puede estar vacío.\n");
                continue;
            }
            if (categoria.isEmpty()) {
                System.out.println("\n[X] Producto no registrado: la categoría no puede estar vacía.\n");
                continue;
            }
            if (precio <= 0) {
                System.out.println("\n[X] Producto no registrado: el precio debe ser mayor que cero.\n");
                continue;
            }
            if (cantidad <= 0) {
                System.out.println("\n[X] Producto no registrado: la cantidad debe ser mayor que cero.\n");
                continue;
            }

            // Si pasa las validaciones, creamos el objeto y alimentamos las colecciones
            Producto p = new Producto(nombre, categoria, precio, cantidad);
            listaProductos.add(p);
            setCategorias.add(categoria);

            // Acumular en el HashMap
            double subtotalActual = p.calcularSubtotal();
            if (mapTotalesCategoria.containsKey(categoria)) {
                double acumuladoPrevio = mapTotalesCategoria.get(categoria);
                mapTotalesCategoria.put(categoria, acumuladoPrevio + subtotalActual);
            } else {
                mapTotalesCategoria.put(categoria, subtotalActual);
            }

            productosValidos++;
            System.out.println("\n[V] ¡Producto registrado exitosamente!\n");
        }

        // ================= PART 4: PROCESAMIENTO DE LA INFORMACIÓN =================
        System.out.println("\n==========================================");
        System.out.println("===== RESUMEN DE COMPRAS =====");
        System.out.println("==========================================\n");

        double totalGeneral = 0.0;
        Producto productoMayorGasto = null;
        Producto productoMenorGasto = null;

        for (Producto p : listaProductos) {
            double subsub = p.calcularSubtotal();
            totalGeneral += subsub;

            System.out.printf("%s | %s | Q%.2f x %d | Subtotal: Q%.2f\n",
                    p.getNombre(), p.getCategoria(), p.getPrecioUnitario(), p.getCantidad(), subsub);

            // Determinar mayor y menor gasto
            if (productoMayorGasto == null || subsub > productoMayorGasto.calcularSubtotal()) {
                productoMayorGasto = p;
            }
            if (productoMenorGasto == null || subsub < productoMenorGasto.calcularSubtotal()) {
                productoMenorGasto = p;
            }
        }

        System.out.println("\nCategorías registradas:");
        System.out.println(setCategorias);

        System.out.println("\nTotal por categoría:");
        String categoriaMayorGasto = null;
        double mayorGastoCat = -1.0;

        for (String cat : setCategorias) {
            double totalCat = mapTotalesCategoria.get(cat);
            System.out.printf("%s: Q%.2f\n", cat, totalCat);

            if (totalCat > mayorGastoCat) {
                mayorGastoCat = totalCat;
                categoriaMayorGasto = cat;
            }
        }

        System.out.println("\nProductos registrados: " + listaProductos.size());
        System.out.printf("Total general: Q%.2f\n", totalGeneral);

        if (productoMayorGasto != null) {
            System.out.printf("\nProducto con mayor gasto:\n%s - Q%.2f\n",
                    productoMayorGasto.getNombre(), productoMayorGasto.calcularSubtotal());
        }

        if (productoMenorGasto != null) {
            System.out.printf("\nProducto con menor gasto:\n%s - Q%.2f\n",
                    productoMenorGasto.getNombre(), productoMenorGasto.calcularSubtotal());
        }

        if (categoriaMayorGasto != null) {
            System.out.printf("\nCategoría con mayor gasto:\n%s - Q%.2f\n",
                    categoriaMayorGasto, mayorGastoCat);
        }

        // ================= PART 5: CONSULTA DE INFORMACIÓN =================
        System.out.println("\n==========================================");
        System.out.println("===== CONSULTA DE CATEGORÍA =====");
        System.out.println("==========================================");
        System.out.print("Ingrese una categoría para consultar: ");
        String consultaCat = scanner.nextLine().trim();

        if (mapTotalesCategoria.containsKey(consultaCat)) {
            System.out.printf("Total gastado en %s: Q%.2f\n", consultaCat, mapTotalesCategoria.get(consultaCat));
        } else {
            System.out.println("La categoría ingresada no se encuentra registrada.");
        }

        scanner.close();
    }
}
