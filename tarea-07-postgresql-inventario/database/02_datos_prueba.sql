-- Registro de productos válidos y pruebas de restricciones
INSERT INTO producto (codigo, nombre, categoria, precio, stock, activo)
VALUES ('PROD-001', 'Laptop Gamer X1', 'Tecnología', 1200.50, 5, TRUE);

INSERT INTO producto (codigo, nombre, categoria, precio, stock, activo)
VALUES ('PROD-002', 'Mouse Inalámbrico', 'Tecnología', 25.99, 15, TRUE);

INSERT INTO producto (codigo, nombre, categoria, precio, stock, activo)
VALUES ('PROD-003', 'Teclado Mecánico RGB', 'Tecnología', 75.00, 2, TRUE);

INSERT INTO producto (codigo, nombre, categoria, precio, stock, activo)
VALUES ('PROD-004', 'Silla de Oficina Ergonómica', 'Muebles', 210.00, 0, TRUE);

INSERT INTO producto (codigo, nombre, categoria, precio, stock, activo)
VALUES ('PROD-005', 'Escritorio Minimalista', 'Muebles', 150.00, 4, TRUE);

INSERT INTO producto (codigo, nombre, categoria, precio, stock, activo)
VALUES ('PROD-006', 'Cafetera Automática', 'Hogar', 85.50, 8, TRUE);

INSERT INTO producto (codigo, nombre, categoria, precio, stock)
VALUES ('PROD-007', 'Licuadora de Alta Potencia', 'Hogar', 45.00, 10);

INSERT INTO producto (codigo, nombre, categoria, precio, stock, activo)
VALUES ('PROD-008', 'Juego de Ollas Acero', 'Hogar', 120.00, 6, TRUE);

INSERT INTO producto (codigo, nombre, categoria, precio, stock, activo)
VALUES ('TEMP-001', 'Producto Temporal', 'Pruebas', 10.00, 5, TRUE);

-- Inserciones corregidas
INSERT INTO producto (codigo, nombre, categoria, precio, stock)
VALUES ('PROD-099', 'Laptop Corregida', 'Tecnología', 900.00, 3);

INSERT INTO producto (codigo, nombre, categoria, precio, stock)
VALUES ('PROD-010', 'Stock Corregido', 'Hogar', 50.00, 5);