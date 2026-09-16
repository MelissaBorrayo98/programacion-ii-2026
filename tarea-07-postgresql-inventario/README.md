# Tarea 07 - PostgreSQL y Control de Inventario

## Descripción del problema
Práctica de diseño, creación y gestión de una base de datos relacional para el control de inventarios, implementando restricciones de integridad (como claves únicas y validaciones de stock positivo) y consultas de manipulación de datos en PostgreSQL.

## Datos del Estudiante
- **Nombre completo:** Melissa Betzabeh Borrayo Mejía
- Carné: 9941-25-28099

## Base de Datos
- **Nombre de la base de datos:** `control_inventario`

## Requisitos para ejecutar los scripts
1. Tener instalado **PostgreSQL** y **pgAdmin 4**.
2. Crear previamente una base de datos vacía llamada `control_inventario` en pgAdmin.
3. Ejecutar los scripts en el orden indicado a continuación.

## Orden de ejecución de los archivos SQL
Los scripts ubicados en la carpeta `database/` deben ejecutarse en el siguiente orden secuencial:
1. **`database/01_creacion.sql`**: Creación de la tabla `producto` con sus respectivas restricciones de tipo, `UNIQUE` y `CHECK`.
2. **`database/02_datos_prueba.sql`**: Inserción de los registros iniciales y productos de prueba en el inventario.
3. **`database/03_operaciones.sql`**: Ejecución de consultas obligatorias, simulación de ventas, actualización de estados de stock y manejo de errores por restricciones.

## Estructura del Repositorio
- **`database/`**: Contiene los códigos fuente en SQL estructurados por fases de ejecución.
- **`Evidencias/`**: Contiene el documento de Word con portada, enlace al repositorio, capturas de pantalla de pgAdmin, respuestas de análisis y reflexión final.
