-- 1. Limpieza de seguridad: Borramos la tabla si ya existe para evitar errores de duplicado
DROP TABLE IF EXISTS flota_vehiculos;

-- 2. Creación de la tabla con tipos de datos de PostgreSQL
CREATE TABLE flota_vehiculos (
    id SERIAL PRIMARY KEY,           -- ID autoincremental
    matricula VARCHAR(30) NOT NULL,   	
    tipo_vehiculo VARCHAR(50),				
    color VARCHAR(20),					
    km_mes1 DECIMAL(7, 2) NOT NULL,
    km_mes2 DECIMAL(7, 2) NOT NULL
);

-- 3. Carga inicial de datos 
INSERT INTO flota_vehiculos (matricula, tipo_vehiculo, color, km_mes1, km_mes2) 
VALUES ('MAT-001', 'Furgoneta', 'Blanco', 5000.00, 4500.00);

INSERT INTO flota_vehiculos (matricula, tipo_vehiculo, color, km_mes1, km_mes2) 
VALUES ('MAT-002', 'Furgoneta', 'Rojo', 30.00, 25.00);

INSERT INTO flota_vehiculos (matricula, tipo_vehiculo, color, km_mes1, km_mes2) 
VALUES ('MAT-003', 'Bicicleta', 'Azul', 400.00, 450.00);

INSERT INTO flota_vehiculos (matricula, tipo_vehiculo, color, km_mes1, km_mes2) 
VALUES ('MAT-004', 'Patinete', 'Negro', 150.00, 100.00);

INSERT INTO flota_vehiculos (matricula, tipo_vehiculo, color, km_mes1, km_mes2) 
VALUES ('MAT-005', 'Bicicleta', 'Rojo', 100.00, 120.00);