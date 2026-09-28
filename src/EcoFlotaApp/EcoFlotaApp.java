package EcoFlotaApp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EcoFlotaApp {
	// CREDENCIALES DE NEON.TECH (JDBC) NUMERO 6(HOJA)
	private static final String URL = "jdbc:postgresql://ep-falling-band-amt0134l-pooler.c-5.us-east-1.aws.neon.tech/neondb?sslmode=require&channelBinding=require";
	private static final String USUARIO = "neondb_owner";
	private static final String PASSWORD = "npg_Bs8OT4vbYNUl";

	public static void main(String[] args) {
		try {
			// Lectura del archivo SQL
			String contenidoSql = Files.readString(Paths.get("flota.sql"));

			// Conexión y ejecución en la nube
			try (Connection conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
					Statement sentencia = conexion.createStatement()) {

				System.out.println("Iniciando sistema EcoFlota...\n");

				// EJECUTAR SCRIPT en NEON TECH
				System.out.println("1. Ejecutando script de creación de base de datos...");
				sentencia.execute(contenidoSql);
				System.out.println("[OK] Base de datos inicializada.\n");

				// BAJA REGISTRO DEL PATINETE AVERIADO
				System.out.println("2. Procesando bajas de vehiculos...");
				
				// Usamos excuteUpdate() para ejecutar el DELETE
				contenidoSql = "DELETE FROM flota_vehiculos WHERE matricula = 'MAT-004'";
				
				int filasAfectadas = sentencia.executeUpdate(contenidoSql);
				
				//Hacemos un if-else para comprobar que si hemos borrado o no, la matricula correspondiente
				if (filasAfectadas > 0) {
					System.out.println("¡EXITO! Vehículo eliminado\n" + "->" + " MAT-004 (Baja procesada)\n");
	            } 
				//Imprimir por pantalla si no borra el vehiculo de la base de datos
				else {
					System.out.println("No se han guardado cambios\n");
				}
				
				// CONSULTA INCREMENTO DE KM
				System.out.println("3 y 4. Calculando el incremento de kilómetros y generando reporte...\n");
				
				String consultaSql = "SELECT id, matricula, tipo_vehiculo, (km_mes2 - km_mes1) AS incremento_kilometros FROM flota_vehiculos WHERE tipo_vehiculo = 'Bicicleta'";

				// Usamos excuteQuery() para ejecutar el SELECT
				ResultSet rs = sentencia.executeQuery(consultaSql);

				// MOSTRAR POR PANTALLA EL RESULTADO DE LA SELECT (FORMATEADA)
				System.out.println("REPORTE DE INCREMENTO ECOFLOTA (Solo Bicicletas)\n");

				System.out.printf("%-5s | %-15s | %-10s | %-12s", "ID", "MATRÍCULA", "TIPO VEHÍCULO",
						"INCREMENTO KILÓMETROS\n");
				
				System.out.println("---------------------------------------------------");
				
				// Hacemos un bucle para recorrer todas las variables del sql, las almacenamos
				// en variables
				while (rs.next()) {
					int id = rs.getInt("id");
					String matricula = rs.getString("Matricula");
					String tipo_vehiculo = rs.getString("Tipo_Vehiculo");
					Double Incremento = rs.getDouble("incremento_kilometros");

					// Imprimimos con formato para que quede con forma de tabla
					// Usamos el .2f para limitar dos decimales
					System.out.printf("%-4d | %-11s | %-17s | %-10.2f \n", id, matricula, tipo_vehiculo, Incremento);
					
					
				}
				
				System.out.println("---------------------------------------------------");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (java.nio.file.NoSuchFileException e) {
			System.err.println("ERROR CÍTICO: Fallo de conexión o archivo no encontrado.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
