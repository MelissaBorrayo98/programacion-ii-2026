import java.util.Scanner;

public class CalculadoraEdad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Encabezado del programa
        System.out.println("==========================================");
        System.out.println("        CALCULADORA DE EDAD");
        System.out.println("==========================================");
        System.out.println("Estudiante: Melissa Borrayo");
        System.out.println("Curso: Programación 2 - 4to Semestre");
        System.out.println("Carné: 99412528099");
        System.out.println("Sede: Portales - Domingo Sección C");
        System.out.println("==========================================");
        System.out.println();

        // Solicitar datos del estudiante
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su carné: ");
        String carnet = scanner.nextLine();

        System.out.print("Ingrese su año de nacimiento: ");
        int anioNacimiento = scanner.nextInt();

        System.out.print("Ingrese el año actual: ");
        int anioActual = scanner.nextInt();

        // La edad es aproximada porque no se considera el mes y día exacto de nacimiento
        int edadAproximada = anioActual - anioNacimiento;

        // Los meses se calculan multiplicando los años por 12 meses
        int edadEnMeses = edadAproximada * 12;

        // Se compara la edad con 18 para saber si es mayor de edad legalmente
        boolean esMayorDeEdad = edadAproximada >= 18;

        // Mostrar todos los resultados con formato bonito
        System.out.println("\n==========================================");
        System.out.println("              RESULTADOS");
        System.out.println("==========================================");
        System.out.println("Nombre: " + nombre);
        System.out.println("Carné: " + carnet);
        System.out.println("Edad aproximada: " + edadAproximada + " años");
        System.out.println("Edad aproximada en meses: " + edadEnMeses + " meses");

        // Mostrar "Sí" o "No" en español
        String mayorDeEdadTexto = esMayorDeEdad ? "Sí" : "No";
        System.out.println("¿Es mayor de edad?: " + mayorDeEdadTexto);

        System.out.println("==========================================");
        System.out.println("        ¡Gracias por usar la calculadora!");

        scanner.close();
    }
}
