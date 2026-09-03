# Práctica Semana 08: Control de Compras del Hogar

Aplicación desarrollada en Java como parte de las actividades del curso de Programación II, utilizando Programación Orientada a Objetos (POO) y la API de Colecciones (`ArrayList`, `HashSet` y `HashMap`).

## Estructura del Repositorio
* **`src/`**: Contiene los archivos de código fuente en Java:
    * `Producto.java`: Clase que define los atributos, constructor, getters, setters y métodos del producto.
    * `MainControlCompras.java`: Clase principal que gestiona la lógica del menú, el ingreso de datos, las validaciones y el uso de las colecciones.
* **`Evidencias/`**: Contiene el documento en formato Word con las capturas de pantalla de la ejecución, pruebas de validación, cálculos manuales y la reflexión final.

## Características de la Aplicación
1. **Validación de datos**: Controla que los precios unitarios y las cantidades ingresadas sean mayores a cero.
2. **Uso de ArrayList**: Almacena dinámicamente la lista general de objetos de tipo `Producto`.
3. **Uso de HashSet**: Filtra y muestra el listado de categorías únicas sin duplicados.
4. **Uso de HashMap**: Asocia cada categoría con su respectivo subtotal acumulado para consultas y reportes rápidos.