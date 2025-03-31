package dao;

import util.CorreoUtil; 

public static void guardarReporte(String nombre, String correo, String asunto, String descripcion, String fecha) {
    Connection con = Conexion.getConexion();
    String sql = "INSERT INTO numero_reporte (nombre_cliente, correo_cliente, asunto, descripcion, fecha) VALUES (?, ?, ?, ?, ?)";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombre);
        ps.setString(2, correo);
        ps.setString(3, asunto);
        ps.setString(4, descripcion);
        ps.setString(5, fecha);
        ps.executeUpdate();
        System.out.println("Reporte guardado en la base de datos.");

        // Enviar correo a la empresa
        String correoEmpresa = "empresa@example.com"; // 
        String cuerpo = "Nuevo reporte:\n\n" +
                "Nombre: " + nombre + "\n" +
                "Correo: " + correo + "\n" +
                "Asunto: " + asunto + "\n" +
                "Descripción: " + descripcion + "\n" +
                "Fecha: " + fecha;

        CorreoUtil.enviarCorreo(correoEmpresa, "Nuevo Reporte de Soporte", cuerpo);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
