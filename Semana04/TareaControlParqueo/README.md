# Tarea Control de Parqueo

Estudiante: Melissa Borrayo
Carné: 9941-25-28099
Ingeniería en Sistemas

Descripcion del programa
El proyecto es una aplicación en Java para consola que sirve para llevar el control de un parqueo. Permite registrar varios carros o motos, calcula las horas que estuvieron estacionados, aplica descuentos si pasan de 8 horas, cobra si perdieron el ticket y al final muestra un resumen con lo recaudado y el pago más alto.

Métodos que utilicé
- main: Es el método principal donde se ejecuta todo el menú y se piden los datos.
- validarEnteroRango: Lo hice para que no truene el programa si ingresan letras o números malos en las horas y minutos.
- obtenerTarifa y obtenerNombreVehiculo: Devuelven el precio y el nombre dependiendo de si es moto, carro o pick-up.
- calcularDescuento: Revisa si se pasa de 8 horas para quitarle el 15 por ciento.
- calcularPago (los dos métodos con sobrecarga): Sirven para sacar el total a pagar, uno normal y otro cuando se le suma el recargo del ticket perdido.
- mostrarComprobante: Imprime todo el detalle del ticket del carro.

Dónde apliqué la sobrecarga
La sobrecarga la usé en calcularPago porque tengo dos métodos que se llaman igual pero reciben parámetros diferentes:
1. Uno recibe solo las horas y la tarifa para cuando el cliente trae su ticket.
2. El otro recibe las horas, la tarifa y el recargo para cuando el usuario perdió el ticket y hay que sumarle los 50 quetzales.

Casos de prueba
- Caso normal: Un carro que estuvo 3 horas y media.
- Caso con descuento: Un carro que estuvo más de 8 horas para probar el 15 por ciento de descuento.
- Caso con ticket perdido y cambio de día: Una moto que entró en la noche y salió al día siguiente, marcando que perdió el ticket.

Reto opcional
Sí hice el reto opcional. Calculé las horas y minutos exactos, le puse validación para cuando cruza la medianoche (cambio de día) y redondea a favor de la tarifa las fracciones de tiempo.
