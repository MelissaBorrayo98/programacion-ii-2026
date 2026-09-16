-- Consultas obligatorias
SELECT codigo, nombre, categoria, precio, stock FROM producto;
SELECT codigo, nombre, categoria, precio, stock FROM producto WHERE categoria = 'Tecnología';
SELECT codigo, nombre, categoria, precio, stock FROM producto ORDER BY precio DESC;
SELECT codigo, nombre, categoria, precio, stock FROM producto WHERE stock <= 3;
SELECT codigo, nombre, categoria, precio, stock FROM producto WHERE activo = TRUE AND stock > 0;
SELECT codigo, nombre, categoria, precio, stock FROM producto WHERE codigo = 'PROD-003';

-- Actualizaciones y eliminaciones
SELECT codigo, nombre, stock FROM producto WHERE codigo = 'PROD-002';
UPDATE producto SET stock = stock - 2 WHERE codigo = 'PROD-002';
SELECT codigo, nombre, stock FROM producto WHERE codigo = 'PROD-002';

SELECT codigo, nombre, stock, activo FROM producto WHERE stock = 0;
UPDATE producto SET activo = FALSE WHERE stock = 0;
SELECT codigo, nombre, stock, activo FROM producto WHERE activo = FALSE;

SELECT codigo, nombre FROM producto WHERE codigo = 'TEMP-001';
DELETE FROM producto WHERE codigo = 'TEMP-001';
SELECT codigo, nombre FROM producto WHERE codigo = 'TEMP-001';
-- 1. Consultar el producto ANTES de la actualización
SELECT codigo, nombre, categoria, precio, stock
FROM producto
WHERE codigo = 'PROD-002';

-- 2. Disminuir la existencia en dos unidades usando el stock actual (sin calcular manualmente)
UPDATE producto
SET stock = stock - 2
WHERE codigo = 'PROD-002';

-- 3. Consultar el producto DESPUÉS de la actualización para demostrar el cambio
SELECT codigo, nombre, categoria, precio, stock
FROM producto
WHERE codigo = 'PROD-002';
-- ==========================================
-- 4. DESACTIVAR PRODUCTOS CON STOCK EN CERO
-- ==========================================

-- Paso A: Verificar con SELECT cuáles registros serán afectados antes del UPDATE
SELECT codigo, nombre, stock, activo
FROM producto
WHERE stock = 0;

-- Paso B: Cambiar el estado a false para los que tienen stock 0
UPDATE producto
SET activo = FALSE
WHERE stock = 0;

-- Paso C: Consultar los productos inactivos para comprobar el cambio
SELECT codigo, nombre, stock, activo
FROM producto
WHERE activo = FALSE;


-- ==========================================
-- 5. PRUEBA DE INSERCIÓN Y ELIMINACIÓN (DELETE)
-- ==========================================

-- Paso A: Registrar un producto de prueba temporal
INSERT INTO producto (codigo, nombre, categoria, precio, stock, activo)
VALUES ('TEMP-001', 'Producto Temporal de Prueba', 'Temporal', 10.00, 5, TRUE);

-- Paso B: Comprobar mediante un SELECT que el producto existe antes de borrarlo
SELECT codigo, nombre, categoria, precio, stock
FROM producto
WHERE codigo = 'TEMP-001';

-- Paso C: Eliminar únicamente ese registro de prueba
DELETE FROM producto
WHERE codigo = 'TEMP-001';

-- Paso D: Comprobar mediante un SELECT que ya no se encuentra almacenado
SELECT codigo, nombre, categoria, precio, stock
FROM producto
WHERE codigo = 'TEMP-001';
-- ==========================================
-- 6. COMPROBACIÓN DE RESTRICCIONES
-- ==========================================

-- A. Prueba de Código Duplicado (Restricción UNIQUE)
-- 1. Intento fallido (Debe dar error porque 'PROD-001' ya existe)
INSERT INTO producto (codigo, nombre, categoria, precio, stock, activo)
VALUES ('PROD-001', 'Teclado Duplicado', 'Tecnología', 15.00, 10, TRUE);

-- 2. Corrección (Usando un código nuevo y único como 'PROD-010')
INSERT INTO producto (codigo, nombre, categoria, precio, stock, activo)
VALUES ('PROD-010', 'Teclado Nuevo', 'Tecnología', 15.00, 10, TRUE);


-- B. Prueba de Stock Inválido (Restricción CHECK)
-- 1. Intento fallido (Debe dar error por stock negativo -5)
INSERT INTO producto (codigo, nombre, categoria, precio, stock, activo)
VALUES ('PROD-011', 'Mouse Rota', 'Tecnología', 10.00, -5, TRUE);

-- 2. Corrección (Usando un stock válido mayor o igual a cero, como 5)
INSERT INTO producto (codigo, nombre, categoria, precio, stock, activo)
VALUES ('PROD-011', 'Mouse Rota', 'Tecnología', 10.00, 5, TRUE);