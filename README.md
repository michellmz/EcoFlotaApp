# 🚲 EcoFlotaApp - Sistema de Gestión de Vehículos Urbanos

Aplicación backend desarrollada en **Java** que permite administrar el inventario y las métricas de una flota de movilidad urbana (bicicletas y patinetes). El sistema se conecta a una base de datos **PostgreSQL** alojada en la nube (Neon.tech) mediante **JDBC**.

## 🛠️ Tecnologías y Stack
* **Lenguaje:** Java
* **Base de Datos:** PostgreSQL (Desplegada en Neon.tech)
* **Conectividad:** JDBC (Java Database Connectivity)[cite: 6]

## 🚀 Características Principales

Este proyecto demuestra el ciclo de vida completo de operaciones de base de datos desde código Java:

* **Inicialización Automatizada:** Lectura y ejecución automática del script `flota.sql` para construir y poblar la base de datos desde cero[cite: 6].
* **Operaciones CRUD (Bajas):** Procesamiento de eliminación de vehículos del sistema mediante sentencias `DELETE` (ej. retiro de vehículos averiados como `MAT-004`) y validación en Java de las filas afectadas[cite: 6].
* **Consultas Avanzadas y Lógica de Negocio:** Uso de álgebra relacional directamente en la consulta SQL para calcular dinámicamente el incremento de uso `(km_mes2 - km_mes1)` filtrando por tipo de vehículo (Bicicletas)[cite: 6].
* **Manejo Robusto de Excepciones:** Captura específica y controlada de errores como `SQLException` para la base de datos, y `NoSuchFileException` / `IOException` para el manejo de archivos locales[cite: 6].
* **Interfaz de Consola (CLI):** Salida de datos tabulada y formateada para una correcta visualización de los reportes[cite: 6].

## ⚙️ Cómo ejecutar el proyecto

1. Clona este repositorio: `git clone [tu-enlace-de-github]`
2. Asegúrate de tener el archivo `flota.sql` en la raíz del directorio del proyecto[cite: 6].
3. Compila y ejecuta la clase principal `EcoFlotaApp.java`[cite: 6].
*(Nota: La aplicación requiere conexión a internet para conectar con el clúster de Neon.tech).*

## 💡 Sobre este proyecto
Este desarrollo forma parte de mi formación como estudiante de **Desarrollo de Aplicaciones Web (DAW)**, enfocado en afianzar los conceptos de Programación Orientada a Objetos, persistencia de datos y buenas prácticas de conexión a bases de datos relacionales en la nube.
