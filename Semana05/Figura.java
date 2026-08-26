public abstract class Figura {
    private String nombre;

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarInformacion() {
        System.out.println("Figura: " + nombre);
    }

    // Método abstracto que será implementado en las clases derivadas
    public abstract double calcularArea();
}