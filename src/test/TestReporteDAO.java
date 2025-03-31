/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author josue
 */

import dao.ReporteDAO;

public class TestReporteDAO {
    public static void main(String[] args) {
        // Datos de prueba
        String nombre = "Juan Pérez";
        String correo = "juan@example.com";
        String asunto = "Consulta de medicamento";
        String descripcion = "Quisiera saber si tienen paracetamol.";
        String fecha = "2025-03-14"; // Formato YYYY-MM-DD

        // Llamada al método
        ReporteDAO.guardarReporte(nombre, correo, asunto, descripcion, fecha);
    }
}
