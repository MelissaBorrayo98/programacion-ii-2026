# 🏧 Sistema de Cajero Automático Virtual - Programación II

## 📌 Datos Académicos
* **Universidad:** Universidad Mariano Gálvez de Guatemala (UMG)
* **Curso:** Programación II
* **Sección:** C
* **Estudiante:** Melissa Betzabeh Borrayo Mejia
* **Carné:** 9941-25-28099
* **Sede:** Portales

---

## 📋 Descripción del Proyecto
Proyecto académico desarrollado en **Java** que simula las operaciones esenciales y seguras de un cajero automático utilizando estructuras de control condicionales y cíclicas.

### Características Principales:
1. **Módulo de Autenticación:** Validación de PIN (`2026`) con un límite de seguridad de 3 intentos fallidos y mensajes dinámicos.
2. **Menú Principal Interactivo:** Opciones numeradas del 1 al 6 con manejo de excepciones para entradas fuera de rango.
3. **Operaciones del Sistema:**
    * **Consulta de Saldo:** Despliega titular, cuenta (`****8099`) y saldo disponible.
    * **Depósito de Dinero:** Valida montos positivos (hasta Q5,000.00) y actualiza el saldo.
    * **Retiro Normal:** Valida que el monto sea múltiplo exacto de Q20.00.
    * **Retiro con Comisión:** Aplica un cargo fijo de Q10.00 por uso de otra red interbancaria.
4. **Resumen y Cierre de Sesión:** Reporte detallado al finalizar que incluye saldo inicial/final, contadores de operaciones exitosas y rechazadas, y comisiones cobradas.

## 🚀 Tecnologías Utilizadas
* **Lenguaje:** Java
* **Entorno:** IntelliJ IDEA / VS Code
* **Control de Versiones:** Git / GitHub
