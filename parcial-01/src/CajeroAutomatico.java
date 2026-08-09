import java.util.Scanner;

/**
 * Simulador de Cajero Automático - Serie IV
 * Universidad Mariano Gálvez de Guatemala - Programación II
 * Estudiante: Melissa Betzabeh Borrayo Mejia (Carné: 8099, Sección: C)
 */
public class CajeroAutomatico {

    // Datos iniciales obligatorios con la información de la estudiante
    private static final String TITULAR = "Melissa Betzabeh Borrayo Mejia";
    private static final String NUMERO_CUENTA = "8099";
    private static final String PIN_CORRECTO = "2026";
    private static final double COMISION_RETIRO_OTRA_RED = 10.00;

    private static double saldoActual = 1000.00;
    private static double saldoInicialSesion = 1000.00;

    // Contadores y acumuladores para el resumen de la sesión
    private static int contadorDepositosExitosos = 0;
    private static double totalDepositado = 0.00;

    private static int contadorRetirosExitosos = 0;
    private static double totalEntregadoRetiros = 0.00;

    private static double totalComisionesCobradas = 0.00;
    private static int contadorOperacionesRechazadas = 0;
    private static int contadorOpcionesInvalidas = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Despliegue de los datos iniciales requeridos al arrancar
        System.out.println("==================================================");
        System.out.println("      SISTEMA DE CAJERO AUTOMÁTICO VIRTUAL      ");
        System.out.println("==================================================");
        System.out.println("Titular: " + TITULAR);
        System.out.println("Número de cuenta: ****" + NUMERO_CUENTA);
        System.out.println("PIN configurado: " + PIN_CORRECTO);
        System.out.printf("Saldo inicial: Q%.2f\n", saldoActual);
        System.out.printf("Comisión por retiro de otra red: Q%.2f\n", COMISION_RETIRO_OTRA_RED);
        System.out.println("Máximo de intentos para ingresar: 3");
        System.out.println("==================================================");

        // 1. Control de acceso (Ciclo for obligatorio con break)
        boolean accesoConcedido = validarAcceso(scanner);

        if (!accesoConcedido) {
            System.out.println("\n[AVISO] Cuenta bloqueada durante la sesión por seguridad.");
            System.out.println("El programa ha finalizado.");
            scanner.close();
            return;
        }

        System.out.println("\n¡Bienvenido al sistema, " + TITULAR + "!");

        // 2. Menú principal (Ciclo do-while, switch y continue)
        int opcion = 0;
        do {
            mostrarMenuTexto();
            System.out.print("Seleccione una opción (1-6): ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        consultarSaldo();
                        break;
                    case 2:
                        procesarDeposito(scanner);
                        break;
                    case 3:
                        // Retiro normal (Llama a la primera versión del método sobrecargado)
                        procesarRetiro(scanner, false);
                        break;
                    case 4:
                        // Retiro con comisión (Llama a la segunda versión del método sobrecargado)
                        procesarRetiro(scanner, COMISION_RETIRO_OTRA_RED);
                        break;
                    case 5:
                        mostrarResumenSesion();
                        break;
                    case 6:
                        // 9. Salida del sistema con resumen automático
                        System.out.println("\n--- GENERANDO RESUMEN FINAL ---");
                        mostrarResumenSesion();
                        System.out.println("\nGracias por utilizar nuestros servicios. ¡Hasta pronto!");
                        break;
                    default:
                        contadorOpcionesInvalidas++;
                        System.out.println("\n[ERROR] La opción ingresada no existe. Intente de nuevo.");
                        continue;
                }
            } else {
                contadorOpcionesInvalidas++;
                System.out.println("\n[ERROR] Por favor, ingrese un número válido.");
                scanner.nextLine(); // Limpiar entrada incorrecta
            }

        } while (opcion != 6);

        scanner.close();
    }

    /**
     * Valida el acceso mediante PIN utilizando un ciclo for (máximo 3 intentos).
     */
    public static boolean validarAcceso(Scanner scanner) {
        int maxIntentos = 3;
        for (int intento = 1; intento <= maxIntentos; intento++) {
            System.out.print("Ingrese su PIN de acceso: ");
            String pinIngresado = scanner.nextLine();

            if (pinIngresado.equals(PIN_CORRECTO)) {
                return true;
            } else {
                int intentosRestantes = maxIntentos - intento;
                System.out.println("[ERROR] PIN incorrecto. Le quedan " + intentosRestantes + " intentos.");
            }
        }
        return false;
    }

    /**
     * Despliega las opciones del menú principal en consola.
     */
    public static void mostrarMenuTexto() {
        System.out.println("\n================ MENÚ PRINCIPAL ================");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Depositar dinero");
        System.out.println("3. Realizar retiro normal");
        System.out.println("4. Realizar retiro con comisión");
        System.out.println("5. Mostrar resumen de la sesión");
        System.out.println("6. Salir");
        System.out.println("================================================");
    }

    /**
     * Muestra la información de la cuenta y el saldo disponible.
     */
    public static void consultarSaldo() {
        System.out.println("\n--- CONSULTA DE SALDO ---");
        System.out.println("Titular: " + TITULAR);
        System.out.println("Número de cuenta: ****" + NUMERO_CUENTA);
        System.out.printf("Saldo disponible: Q%.2f\n", saldoActual);
    }

    /**
     * Procesa el depósito de dinero con validaciones mediante ciclo while.
     */
    public static void procesarDeposito(Scanner scanner) {
        System.out.println("\n--- DEPÓSITO DE DINERO ---");
        double monto = 0;
        boolean montoValido = false;

        while (!montoValido) {
            System.out.print("Ingrese el monto a depositar (Máximo Q5,000.00): Q");
            if (scanner.hasNextDouble()) {
                monto = scanner.nextDouble();
                scanner.nextLine();

                if (monto <= 0.00) {
                    System.out.println("[MOTIVO] El monto debe ser mayor a Q0.00. Intente nuevamente.");
                } else if (monto > 5000.00) {
                    System.out.println("[MOTIVO] El monto supera el límite máximo permitido por operación (Q5,000.00).");
                } else {
                    montoValido = true;
                }
            } else {
                System.out.println("[MOTIVO] Entrada inválida. Ingrese un valor numérico correcto.");
                scanner.nextLine();
            }
        }

        double saldoAnterior = saldoActual;
        saldoActual += monto;

        contadorDepositosExitosos++;
        totalDepositado += monto;

        System.out.println("\n--- DEPÓSITO EXITOSO ---");
        System.out.printf("Monto depositado: Q%.2f\n", monto);
        System.out.printf("Saldo anterior: Q%.2f\n", saldoAnterior);
        System.out.printf("Saldo actualizado: Q%.2f\n", saldoActual);
    }

    // =========================================================================
    // SOBRECARGA OBLIGATORIA DE MÉTODOS PARA RETIROS
    // =========================================================================

    /**
     * Método Sobrecargado 1: Procesa el retiro normal.
     */
    public static void procesarRetiro(Scanner scanner, boolean esConComision) {
        if (!esConComision) {
            System.out.println("\n--- RETIRO NORMAL ---");
            System.out.print("Ingrese el monto a retirar (Máximo Q2,000.00, múltiplos de Q20.00): Q");

            if (scanner.hasNextDouble()) {
                double monto = scanner.nextDouble();
                scanner.nextLine();

                if (monto <= 0.00) {
                    contadorOperacionesRechazadas++;
                    System.out.println("[RECHAZADO] Causa: El monto debe ser mayor a Q0.00.");
                } else if (monto % 20.00 != 0) {
                    contadorOperacionesRechazadas++;
                    System.out.println("[RECHAZADO] Causa: El monto debe ser múltiplo exacto de Q20.00.");
                } else if (monto > 2000.00) {
                    contadorOperacionesRechazadas++;
                    System.out.println("[RECHAZADO] Causa: El monto supera el límite por operación de Q2,000.00.");
                } else if (monto > saldoActual) {
                    contadorOperacionesRechazadas++;
                    System.out.println("[RECHAZADO] Causa: Fondos insuficientes para realizar el retiro.");
                } else {
                    double saldoAnterior = saldoActual;
                    saldoActual -= monto;

                    contadorRetirosExitosos++;
                    totalEntregadoRetiros += monto;

                    System.out.println("\n--- RETIRO NORMAL APROBADO ---");
                    System.out.printf("Monto solicitado: Q%.2f\n", monto);
                    System.out.printf("Saldo anterior: Q%.2f\n", saldoAnterior);
                    System.out.printf("Total debitado: Q%.2f\n", monto);
                    System.out.printf("Saldo actualizado: Q%.2f\n", saldoActual);
                }
            } else {
                contadorOperacionesRechazadas++;
                System.out.println("[RECHAZADO] Causa: Entrada de datos no numérica.");
                scanner.nextLine();
            }
        }
    }

    /**
     * Método Sobrecargado 2: Procesa el retiro con comisión (otra red).
     */
    public static void procesarRetiro(Scanner scanner, double comision) {
        System.out.println("\n--- RETIRO CON COMISIÓN (OTRA RED) ---");
        System.out.println("Comisión fija aplicada: Q" + comision);
        System.out.print("Ingrese el monto a retirar (Máximo Q2,000.00, múltiplos de Q20.00): Q");

        if (scanner.hasNextDouble()) {
            double monto = scanner.nextDouble();
            scanner.nextLine();

            double totalDebito = monto + comision;

            if (monto <= 0.00) {
                contadorOperacionesRechazadas++;
                System.out.println("[RECHAZADO] Causa: El monto debe ser mayor a Q0.00.");
            } else if (monto % 20.00 != 0) {
                contadorOperacionesRechazadas++;
                System.out.println("[RECHAZADO] Causa: El monto debe ser múltiplo exacto de Q20.00.");
            } else if (monto > 2000.00) {
                contadorOperacionesRechazadas++;
                System.out.println("[RECHAZADO] Causa: El monto supera el límite por operación de Q2,000.00.");
            } else if (totalDebito > saldoActual) {
                contadorOperacionesRechazadas++;
                System.out.println("[RECHAZADO] Causa: El saldo disponible no cubre el monto solicitado más la comisión de Q" + comision + ".");
            } else {
                double saldoAnterior = saldoActual;
                saldoActual -= totalDebito;

                contadorRetirosExitosos++;
                totalEntregadoRetiros += monto;
                totalComisionesCobradas += comision;

                System.out.println("\n--- RETIRO CON COMISIÓN APROBADO ---");
                System.out.printf("Monto solicitado: Q%.2f\n", monto);
                System.out.printf("Comisión: Q%.2f\n", comision);
                System.out.printf("Total debitado: Q%.2f\n", totalDebito);
                System.out.printf("Saldo anterior: Q%.2f\n", saldoAnterior);
                System.out.printf("Saldo actualizado: Q%.2f\n", saldoActual);
            }
        } else {
            contadorOperacionesRechazadas++;
            System.out.println("[RECHAZADO] Causa: Entrada de datos no numérica.");
            scanner.nextLine();
        }
    }

    /**
     * Muestra el resumen completo de la sesión y contadores acumulados.
     */
    public static void mostrarResumenSesion() {
        System.out.println("\n==================================================");
        System.out.println("            RESUMEN GENERAL DE LA SESIÓN          ");
        System.out.println("==================================================");
        System.out.println("Titular: " + TITULAR);
        System.out.println("Número de cuenta: ****" + NUMERO_CUENTA);
        System.out.printf("Saldo inicial de la sesión: Q%.2f\n", saldoInicialSesion);
        System.out.println("--------------------------------------------------");
        System.out.println("Cantidad de depósitos exitosos: " + contadorDepositosExitosos);
        System.out.printf("Total depositado: Q%.2f\n", totalDepositado);
        System.out.println("Cantidad de retiros exitosos: " + contadorRetirosExitosos);
        System.out.printf("Total entregado en retiros: Q%.2f\n", totalEntregadoRetiros);
        System.out.printf("Total cobrado en comisiones: Q%.2f\n", totalComisionesCobradas);
        System.out.println("Cantidad de operaciones rechazadas: " + contadorOperacionesRechazadas);
        System.out.println("Cantidad de opciones inválidas: " + contadorOpcionesInvalidas);
        System.out.println("--------------------------------------------------");
        System.out.printf("Saldo actual disponible: Q%.2f\n", saldoActual);
        System.out.println("==================================================");
    }
}