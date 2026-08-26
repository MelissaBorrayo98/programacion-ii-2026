public class Main {
    public static void main(String[] args) {
        // Crear un arreglo de tipo Figura[] con objetos de cada clase derivada
        Figura[] figuras = new Figura[] {
                new Circulo("Círculo", 5.0),
                new Rectangulo("Rectángulo", 4.0, 6.0),
                new Triangulo("Triángulo", 3.0, 8.0)
        };

        // Recorrer el arreglo mediante un ciclo for-each aplicando polimorfismo
        for (Figura figura : figuras) {
            figura.mostrarInformacion();
            // Presentar el resultado con dos posiciones decimales usando printf
            System.out.printf("Área: %.2f%n", figura.calcularArea());
            System.out.println("-----------------------------------");
        }
    }
}
