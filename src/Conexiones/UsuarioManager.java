package Conexiones;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.*;
import java.time.LocalDate;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class UsuarioManager {

    // Método para registrar un nuevo usuario
    public static boolean registrarUsuario(String nombreUsuario, String nombreCompleto, char[] passwordChars, String rol) {
        if (nombreUsuario == null || nombreUsuario.trim().isEmpty() ||
            nombreCompleto == null || nombreCompleto.trim().isEmpty() ||
            passwordChars == null || passwordChars.length < 6 ||
            rol == null || rol.trim().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios y la contraseña debe tener al menos 6 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String contraseña = new String(passwordChars).trim();
        Arrays.fill(passwordChars, '\0'); // Limpia el arreglo por seguridad

        // Verificamos si el usuario ya existe en la base de datos
        if (usuarioExiste(nombreUsuario)) {
            JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(
                 "INSERT INTO usuarios (nombre_usuario, nombre_completo, contraseña, rol, fecha_registro) VALUES (?, ?, ?, ?, ?)")) {

            // Cifra la contraseña con BCrypt
            String contraseñaCifrada = BCrypt.hashpw(contraseña, BCrypt.gensalt());

            // Inserta los datos en la base de datos
            pst.setString(1, nombreUsuario.trim());
            pst.setString(2, nombreCompleto.trim());
            pst.setString(3, contraseñaCifrada);
            pst.setString(4, rol.trim());
            pst.setString(5, LocalDate.now().toString());

            pst.executeUpdate();
            return true;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar usuario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Verifica si un usuario ya existe en la base de datos
    public static boolean usuarioExiste(String nombreUsuario) {
        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement("SELECT id_usuario FROM usuarios WHERE nombre_usuario = ?")) {

            pst.setString(1, nombreUsuario.trim());
            ResultSet rs = pst.executeQuery();
            return rs.next();  // Si hay un registro con ese nombre de usuario

        } catch (SQLException e) {
            e.printStackTrace();
            return true; // En caso de error, prevenimos el registro de nuevos usuarios
        }
    }
}

