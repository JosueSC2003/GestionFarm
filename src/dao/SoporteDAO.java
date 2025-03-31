/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author josue
 */
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SoporteDAO {
    public static void obtenerSoporte() {
        Connection conexion = Conexion.conectar();
        String sql = "SELECT * FROM soporte";

        try {
            PreparedStatement stmt = conexion.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Datos de Soporte:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("correo");
                String asunto = rs.getString("asunto");
                String mensaje = rs.getString("mensaje");
                String fecha = rs.getString("fecha");

                System.out.println("ID: " + id + " | Nombre: " + nombre + " | Email: " + email + " | Asunto " + asunto +" | Mensaje: " + mensaje + " | Fecha " + fecha);
            }

            rs.close();
            stmt.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("❌ Error al obtener datos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        obtenerSoporte(); // Ejecutar la consulta y mostrar los datos
    }
}
