/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

/**
 *
 * @author josue
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/farmacia";
    private static final String USER = "root"; 
    private static final String PASSWORD = "";  

    public static Connection conectar() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el driver
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión exitosa a MySQL.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("❌ Error en la conexión: " + e.getMessage());
        }
        return conexion;
    }

    public static Connection getConexion() {
        return conectar(); // Devuelve la conexión en lugar de lanzar una excepción.
    }

    public static void main(String[] args) {
        conectar(); // Prueba de conexión
    }
}

