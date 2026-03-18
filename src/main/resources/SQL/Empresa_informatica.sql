/*
================================================================
SISTEMA DE GESTIÓN IT (CONSULTORÍA) - SCRIPT PROFESIONAL
Data Engineer: Gemini v3 Flash
================================================================
*/

drop database if exists empresa_it_solutions;
CREATE DATABASE IF NOT EXISTS empresa_it_solutions;
USE empresa_it_solutions;

-- Limpieza de entorno
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS empleados;
DROP TABLE IF EXISTS departamentos;
SET FOREIGN_KEY_CHECKS = 1;

-- 1. Tabla: Departamentos
-- Estructura para organizar las áreas de especialización técnica.
CREATE TABLE departamentos (
    departamento_id INT AUTO_INCREMENT,
    nombre_depto VARCHAR(100) NOT NULL,
    codigo_interno VARCHAR(10) NOT NULL, -- Ej: 'DEV', 'CYBER', 'DATA'
    presupuesto_anual DECIMAL(15, 2) NOT NULL,
    ubicacion_oficina VARCHAR(50) DEFAULT 'Remoto',
    CONSTRAINT pk_depto PRIMARY KEY (departamento_id),
    CONSTRAINT uk_codigo UNIQUE (codigo_interno)
) ENGINE=InnoDB;

-- 2. Tabla: Empleados (Consultores)
-- Contiene la información del talento técnico y su vinculación departamental.
CREATE TABLE empleados (
    empleado_id INT AUTO_INCREMENT,
    departamento_id INT, -- FK
    nombre_completo VARCHAR(150) NOT NULL,
    email_corporativo VARCHAR(100) NOT NULL,
    rol_tecnico ENUM('Junior Developer', 'Senior Developer', 'Cloud Architect', 'Data Scientist', 'Project Manager') NOT NULL,
    salario_mensual DECIMAL(10, 2) NOT NULL,
    fecha_contratacion DATE NOT NULL,
    activo BOOLEAN DEFAULT TRUE,
    CONSTRAINT pk_empleado PRIMARY KEY (empleado_id),
    CONSTRAINT uk_email UNIQUE (email_corporativo),
    -- Regla de integridad: Si se borra un departamento, los empleados quedan sin asignar (SET NULL)
    CONSTRAINT fk_depto_empleado 
        FOREIGN KEY (departamento_id) 
        REFERENCES departamentos(departamento_id) 
        ON DELETE SET NULL 
        ON UPDATE CASCADE
) ENGINE=InnoDB;

-- 3. Datos de Prueba (Dataset IT)
INSERT INTO departamentos (nombre_depto, codigo_interno, presupuesto_anual, ubicacion_oficina) VALUES
('Desarrollo de Software', 'DEV', 500000.00, 'Planta 4 - Madrid'),
('Ciberseguridad', 'SEC', 350000.00, 'Planta 2 - Barcelona'),
('Inteligencia Artificial', 'AI', 600000.00, 'Remoto'),
('Infraestructura Cloud', 'OPS', 400000.00, 'Remoto'),
('Data & Analytics', 'DATA', 300000.00, 'Planta 4 - Madrid');

INSERT INTO empleados (departamento_id, nombre_completo, email_corporativo, rol_tecnico, salario_mensual, fecha_contratacion) VALUES
(1, 'Alejandro Tech', 'a.tech@it-solutions.com', 'Senior Developer', 4500.00, '2022-03-01'),
(3, 'Beatriz Data', 'b.data@it-solutions.com', 'Data Scientist', 5200.00, '2023-01-15'),
(2, 'Carlos Shield', 'c.shield@it-solutions.com', 'Cloud Architect', 5800.00, '2021-11-20'),
(1, 'Daniel Code', 'd.code@it-solutions.com', 'Junior Developer', 2800.00, '2024-02-10'),
(NULL, 'Elena Freelance', 'e.external@it-solutions.com', 'Project Manager', 6000.00, '2023-08-05');

-- 4. Consulta de Análisis de Talento (JOIN)
-- Visualiza los empleados, sus salarios y a qué departamento pertenecen.
SELECT 
    e.nombre_completo AS 'Consultor',
    e.rol_tecnico AS 'Especialidad',
    COALESCE(d.nombre_depto, 'Consultor Externo') AS 'Departamento',
    d.codigo_interno AS 'Cód.',
    CONCAT('$', FORMAT(e.salario_mensual, 2)) AS 'Sueldo Mensual'
FROM empleados e
LEFT JOIN departamentos d ON e.departamento_id = d.departamento_id
ORDER BY e.salario_mensual DESC;