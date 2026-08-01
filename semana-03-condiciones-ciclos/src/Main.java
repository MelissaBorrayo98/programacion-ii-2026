import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Objeto Scanner para lectura de datos por consola
        Scanner teclado = new Scanner(System.in);

        // Variable para controlar la opción del menú
        int opcion = 0;

        // Personalización obligatoria al iniciar el programa
        System.out.println("=========================================");
        System.out.println("Estudiante: Melissa Betzabeh Borrayo Mejia");
        System.out.println("Carné: 9941-25-28099");
        System.out.println("Semana 3 — Condiciones y ciclos");
        System.out.println("=========================================\n");

        // Ciclo do-while para mantener el menú activo hasta seleccionar la opción 6 (Salir)
        do {
            System.out.println("========= DESAFÍOS LÓGICOS =========");
            System.out.println("1. Generar una secuencia");
            System.out.println("2. Realizar un conteo regresivo");
            System.out.println("3. Analizar números");
            System.out.println("4. Dibujar una pirámide");
            System.out.println("5. Validar palabra secreta");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            // Validación de entrada para evitar fallos si no ingresan un entero
            if (teclado.hasNextInt()) {
                opcion = teclado.nextInt();
                teclado.nextLine(); // Limpiar el búfer del Scanner
            } else {
                System.out.println("\n[ERROR] Debe ingresar un número válido.\n");
                teclado.nextLine(); // Limpiar la entrada incorrecta
                continue; // Vuelve al inicio del menú sin evaluar el switch
            }

            // Estructura switch para dirigir la ejecución según la opción elegida
            switch (opcion) {

                // ========================================================
                // OPCIÓN 1: GENERAR UNA SECUENCIA (Utiliza ciclo for)
                // ========================================================
                case 1:
                    System.out.println("\n--- OPCIÓN 1: GENERAR SECUENCIA ---");
                    System.out.print("Número inicial: ");
                    int numInicial = teclado.nextInt();

                    System.out.print("Número final: ");
                    int numFinal = teclado.nextInt();

                    System.out.print("Incremento: ");
                    int incremento = teclado.nextInt();
                    teclado.nextLine(); // Limpiar búfer

                    // Validaciones mediante condiciones if / else if / else
                    if (incremento <= 0) {
                        System.out.println("\n[ERROR] El incremento debe ser mayor que cero.");
                    } else if (numFinal <= numInicial) {
                        System.out.println("\n[ERROR] El número final debe ser mayor que el inicial.");
                    } else {
                        System.out.print("Resultado: ");
                        // Ciclo for para generar la secuencia
                        for (int i = numInicial; i <= numFinal; i += incremento) {
                            System.out.print(i + " ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    break;

                // ========================================================
                // OPCIÓN 2: CONTEO REGRESIVO (Utiliza ciclo while)
                // ========================================================
                case 2:
                    System.out.println("\n--- OPCIÓN 2: CONTEO REGRESIVO ---");
                    int conteoInicial = 0;

                    // Ciclo while para solicitar el número hasta que esté dentro del rango [10, 50]
                    while (conteoInicial < 10 || conteoInicial > 50) {
                        System.out.print("Ingrese el número inicial (entre 10 y 50): ");
                        conteoInicial = teclado.nextInt();
                        teclado.nextLine(); // Limpiar búfer

                        if (conteoInicial < 10 || conteoInicial > 50) {
                            System.out.println("[ERROR] El número debe estar entre 10 y 50.");
                        }
                    }

                    // Ciclo while para realizar el conteo regresivo
                    System.out.print("Resultado: ");
                    int contadorRegresivo = conteoInicial;
                    while (contadorRegresivo >= 0) {
                        System.out.print(contadorRegresivo + " ");
                        contadorRegresivo--;
                    }
                    System.out.println("\n¡Despegue!\n");
                    break;

                // ========================================================
                // OPCIÓN 3: ANALIZAR NÚMEROS (Utiliza while, break y continue)
                // ========================================================
                case 3:
                    System.out.println("\n--- OPCIÓN 3: ANALIZAR NÚMEROS ---");
                    int positivos = 0;
                    int negativos = 0;
                    int sumaValida = 0;
                    int ignorados = 0;

                    // Ciclo while para solicitar números hasta que se ingrese 0
                    while (true) {
                        System.out.print("Ingrese un número: ");
                        int num = teclado.nextInt();

                        // 1. El 0 únicamente finaliza el ingreso y no debe contabilizarse
                        if (num == 0) {
                            break;
                        }

                        // 2. Conteo de positivos y negativos (se cuentan TODOS los números ingresados)
                        if (num > 0) {
                            positivos++;
                        } else {
                            negativos++;
                        }

                        // 3. Regla especial: Múltiplos de 5 no deben sumarse (usar continue)
                        if (num % 5 == 0) {
                            System.out.println("El número " + num + " fue ignorado.");
                            ignorados++;
                            continue; // Salta el acumulador de la suma
                        }

                        // 4. Acumulador de suma (solo para números NO múltiplos de 5)
                        sumaValida += num;
                    }

                    teclado.nextLine(); // Limpiar búfer

                    // Mostrar resultados
                    System.out.println("Resultado:");
                    System.out.println("Positivos: " + positivos);
                    System.out.println("Negativos: " + negativos);
                    System.out.println("Suma válida: " + sumaValida);
                    System.out.println("Números ignorados: " + ignorados + "\n");
                    break;


                // ========================================================
                // OPCIÓN 4: DIBUJAR UNA PIRÁMIDE (Ciclos for anidados)
                // ========================================================
                case 4:
                    System.out.println("\n--- OPCIÓN 4: DIBUJAR PIRÁMIDE ---");
                    int altura = 0;

                    // Solicitar altura hasta que esté en el rango válido [3, 10]
                    while (altura < 3 || altura > 10) {
                        System.out.print("Ingrese la altura de la pirámide (entre 3 y 10): ");
                        altura = teclado.nextInt();
                        teclado.nextLine(); // Limpiar búfer

                        if (altura < 3 || altura > 10) {
                            System.out.println("[ERROR] La altura debe estar entre 3 y 10.");
                        }
                    }

                    System.out.println("Resultado:");
                    // Ciclos for anidados para construir la estructura
                    for (int i = 1; i <= altura; i++) {
                        // Ciclo interno 1: Imprimir espacios para centrar las estrellas
                        for (int j = 1; j <= altura - i; j++) {
                            System.out.print(" ");
                        }
                        // Ciclo interno 2: Imprimir asteriscos (formula: 2*i - 1)
                        for (int k = 1; k <= (2 * i - 1); k++) {
                            System.out.print("*");
                        }
                        System.out.println(); // Salto de línea por cada fila
                    }
                    System.out.println();
                    break;

                // ========================================================
                // OPCIÓN 5: VALIDAR PALABRA SECRETA (do-while, trim, equalsIgnoreCase)
                // ========================================================
                case 5:
                    System.out.println("\n--- OPCIÓN 5: VALIDAR PALABRA SECRETA ---");
                    String entrada = "";
                    String palabraSecreta = "Guatemala";

                    // Ciclo do-while que repetirá la solicitud hasta que la palabra coincida
                    do {
                        System.out.print("Ingrese la palabra secreta: ");
                        entrada = teclado.nextLine();

                        // Limpiar espacios con trim() y comparar ignorando mayúsculas con equalsIgnoreCase()
                        if (entrada.trim().equalsIgnoreCase(palabraSecreta)) {
                            System.out.println("Palabra correcta.\n");
                            break; // Se confirma coincidencia y sale del bucle
                        } else {
                            System.out.println("Palabra incorrecta. Intente nuevamente.\n");
                        }
                    } while (true);
                    break;

                // ========================================================
                // OPCIÓN 6: SALIR
                // ========================================================
                case 6:
                    System.out.println("\nPrograma finalizado correctamente.");
                    break;

                // ========================================================
                // OPCIÓN INEXISTENTE
                // ========================================================
                default:
                    System.out.println("\n[ERROR] Opción no válida. Por favor, seleccione un número entre 1 y 6.\n");
                    break;
            }

        } while (opcion != 6);

        teclado.close(); // Cerrar la instancia del Scanner al finalizar
    }
}
