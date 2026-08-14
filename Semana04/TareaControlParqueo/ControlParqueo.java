import java.util.Scanner;

public class ControlParqueo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Datos del estudiante
        String nombreEstudiante = "Melissa Borrayo";
        String carneEstudiante = "9941-25-28099";

        // Contadores y acumuladores para el resumen de la jornada
        int totalMotocicletas = 0;
        int totalAutomoviles = 0;
        int totalPickups = 0;
        int totalTicketsPerdidos = 0;
        double dineroRecaudadoTotal = 0.0;

        double pagoMasAlto = -1.0;
        String placaPagoMasAlto = "";

        System.out.println("========================================");
        System.out.println("   SISTEMA DE CONTROL DE PARQUEO        ");
        System.out.println("   Estudiante: " + nombreEstudiante);
        System.out.println("   Carné: " + carneEstudiante);
        System.out.println("========================================");

        int cantidadVehiculos = 0;

        // Validación: cantidad de vehículos mayor que cero
        while (true) {
            System.out.print("Ingrese la cantidad de vehículos a registrar: ");
            if (scanner.hasNextInt()) {
                cantidadVehiculos = scanner.nextInt();
                if (cantidadVehiculos > 0) {
                    break;
                } else {
                    System.out.println("Error: La cantidad debe ser mayor que cero.");
                }
            } else {
                System.out.println("Error: Ingrese un número entero válido.");
                scanner.next(); // Limpiar buffer
            }
        }

        // Ciclo para procesar cada vehículo
        for (int i = 1; i <= cantidadVehiculos; i++) {
            System.out.println("\n--- Registro del Vehículo " + i + " de " + cantidadVehiculos + " ---");

            // Solicitar Placa
            System.out.print("Ingrese el número de placa: ");
            String placa = scanner.next();

            // Solicitar Tipo de Vehículo con validación (1 a 3)
            int tipoVehiculo = 0;
            while (true) {
                System.out.print("Tipo de vehículo (1: Motocicleta, 2: Automóvil, 3: Pickup o camioneta): ");
                if (scanner.hasNextInt()) {
                    tipoVehiculo = scanner.nextInt();
                    if (tipoVehiculo >= 1 && tipoVehiculo <= 3) {
                        break;
                    } else {
                        System.out.println("Error: El tipo debe ser 1, 2 o 3.");
                    }
                } else {
                    System.out.println("Error: Ingrese un número válido.");
                    scanner.next();
                }
            }

            // --- RETO OPCIONAL: Control exacto del tiempo ---
            int horaEntrada = validarEnteroRango(scanner, "Hora de entrada (0-23): ", 0, 23);
            int minutoEntrada = validarEnteroRango(scanner, "Minuto de entrada (0-59): ", 0, 59);
            int horaSalida = validarEnteroRango(scanner, "Hora de salida (0-23): ", 0, 23);
            int minutoSalida = validarEnteroRango(scanner, "Minuto de salida (0-59): ", 0, 59);

            // Conversión a minutos totales desde la medianoche
            int minutosEntradaTotal = (horaEntrada * 60) + minutoEntrada;
            int minutosSalidaTotal = (horaSalida * 60) + minutoSalida;

            // Si la salida es menor o igual, significa que pasó al día siguiente (+ 24 horas en minutos)
            if (minutosSalidaTotal <= minutosEntradaTotal) {
                minutosSalidaTotal += 24 * 60;
            }

            int diferenciaMinutos = minutosSalidaTotal - minutosEntradaTotal;
            int horasExactas = diferenciaMinutos / 60;
            int minutosRestantes = diferenciaMinutos % 60;

            // Cobrar como hora completa cualquier fracción de hora
            int horasCobradas = horasExactas;
            if (minutosRestantes > 0) {
                horasCobradas++;
            }
            if (horasCobradas == 0) {
                horasCobradas = 1;
            }

            System.out.println(">> Tiempo estacionado: " + horasExactas + " horas y " + minutosRestantes + " minutos");
            System.out.println(">> Horas cobradas (con redondeo a favor de tarifa): " + horasCobradas);

            // Solicitar Ticket Perdido con validación (S o N)
            char perdioTicket = ' ';
            while (true) {
                System.out.print("¿Perdió el ticket? (S/N): ");
                String entradaTicket = scanner.next().toUpperCase();
                if (entradaTicket.length() == 1) {
                    perdioTicket = entradaTicket.charAt(0);
                    if (perdioTicket == 'S' || perdioTicket == 'N') {
                        break;
                    }
                }
                System.out.println("Error: Debe ingresar únicamente 'S' o 'N'.");
            }

            // Cálculos utilizando las horas cobradas por el reto opcional
            double tarifa = obtenerTarifa(tipoVehiculo);
            double subtotal = horasCobradas * tarifa;
            double descuento = calcularDescuento(subtotal, horasCobradas);
            double recargo = (perdioTicket == 'S') ? 50.0 : 0.0;

            double totalPagar;
            if (perdioTicket == 'S') {
                totalPagar = calcularPago(horasCobradas, tarifa, recargo);
            } else {
                totalPagar = calcularPago(horasCobradas, tarifa);
            }

            String nombreVehiculo = obtenerNombreVehiculo(tipoVehiculo);

            // Mostrar Comprobante Individual
            mostrarComprobante(placa, nombreVehiculo, horasCobradas, tarifa, subtotal, descuento, recargo, totalPagar);

            // Actualizar contadores y acumuladores de la jornada
            if (tipoVehiculo == 1) {
                totalMotocicletas++;
            } else if (tipoVehiculo == 2) {
                totalAutomoviles++;
            } else if (tipoVehiculo == 3) {
                totalPickups++;
            }

            if (perdioTicket == 'S') {
                totalTicketsPerdidos++;
            }

            dineroRecaudadoTotal += totalPagar;

            // Verificar si es el pago más alto
            if (totalPagar > pagoMasAlto) {
                pagoMasAlto = totalPagar;
                placaPagoMasAlto = placa;
            }
        }

        // Mostrar Resumen General de la Jornada
        System.out.println("\n========================================");
        System.out.println("       RESUMEN GENERAL DE LA JORNADA    ");
        System.out.println("   Estudiante: " + nombreEstudiante + " (" + carneEstudiante + ")");
        System.out.println("========================================");
        System.out.println("Cantidad de motocicletas: " + totalMotocicletas);
        System.out.println("Cantidad de automóviles: " + totalAutomoviles);
        System.out.println("Cantidad de pickups o camionetas: " + totalPickups);
        System.out.println("Cantidad de tickets perdidos: " + totalTicketsPerdidos);
        System.out.printf("Total de dinero recaudado: Q%.2f\n", dineroRecaudadoTotal);
        if (cantidadVehiculos > 0) {
            System.out.println("Pago más alto realizado: Q" + String.format("%.2f", pagoMasAlto) + " (Placa: " + placaPagoMasAlto + ")");
        }
        System.out.println("========================================");

        scanner.close();
    }

    // Método auxiliar reutilizable para validar enteros en un rango específico
    public static int validarEnteroRango(Scanner scanner, String mensaje, int min, int max) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                if (valor >= min && valor <= max) {
                    return valor;
                } else {
                    System.out.println("Error: El valor debe estar entre " + min + " y " + max + ".");
                }
            } else {
                System.out.println("Error: Ingrese un número entero válido.");
                scanner.next();
            }
        }
    }

    public static double obtenerTarifa(int tipoVehiculo) {
        switch (tipoVehiculo) {
            case 1:
                return 5.00;  // Motocicleta
            case 2:
                return 8.00;  // Automóvil
            case 3:
                return 12.00; // Pickup o camioneta
            default:
                return 0.00;
        }
    }

    public static String obtenerNombreVehiculo(int tipoVehiculo) {
        switch (tipoVehiculo) {
            case 1:
                return "Motocicleta";
            case 2:
                return "Automóvil";
            case 3:
                return "Pickup o camioneta";
            default:
                return "Desconocido";
        }
    }

    public static double calcularDescuento(double subtotal, int horas) {
        if (horas > 8) {
            return subtotal * 0.15;
        }
        return 0.00;
    }

    // Sobrecarga de método: calcularPago sin recargo
    public static double calcularPago(int horas, double tarifa) {
        double subtotal = horas * tarifa;
        double descuento = calcularDescuento(subtotal, horas);
        return subtotal - descuento;
    }

    // Sobrecarga de método: calcularPago con recargo por ticket perdido
    public static double calcularPago(int horas, double tarifa, double recargo) {
        double subtotal = horas * tarifa;
        double descuento = calcularDescuento(subtotal, horas);
        return (subtotal - descuento) + recargo;
    }

    public static void mostrarComprobante(String placa, String tipo, int horas, double tarifa,
                                          double subtotal, double descuento, double recargo, double total) {
        System.out.println("\n========== COMPROBANTE ==========");
        System.out.println("Placa: " + placa);
        System.out.println("Tipo: " + tipo);
        System.out.println("Horas cobradas (con fracciones): " + horas);
        System.out.printf("Tarifa por hora: Q%.2f\n", tarifa);
        System.out.printf("Subtotal: Q%.2f\n", subtotal);
        System.out.printf("Descuento: Q%.2f\n", descuento);
        System.out.printf("Recargo por ticket perdido: Q%.2f\n", recargo);
        System.out.printf("TOTAL: Q%.2f\n", total);
        System.out.println("=================================\n");
    }
}