package Conexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReporteDAO {

    public boolean insertarReporte(int idUsuario, String tipoReporte, String descripcion) {
        String sql = "INSERT INTO reportes (id_usuario, tipo_reporte, descripcion, fecha) VALUES (?, ?, ?, NOW())";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement pst = conexion.prepareStatement(sql)) {

            pst.setInt(1, idUsuario);
            pst.setString(2, tipoReporte);
            pst.setString(3, descripcion);

            int filasAfectadas = pst.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar reporte: " + e.getMessage());
            return false;
        }
    }
}
