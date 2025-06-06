package Conexiones;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.*;
import javax.swing.JOptionPane;

public class LoginController {

    // Método que valida si el usuario y la contraseña son correctos
    public boolean validarLogin(String usuario, String contraseña) {
        if (usuario.isEmpty() || contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(null, "❌ Los campos de usuario y contraseña no pueden estar vacíos.");
            return false;
        }

        try {
            Connection con = Conexion.conectar(); // usa el método correcto
            String sql = "SELECT * FROM usuarios WHERE nombre_usuario = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String hashGuardado = rs.getString("contraseña");
                if (BCrypt.checkpw(contraseña, hashGuardado)) {
                    // Guardar datos en la sesión
                    Sesion.idUsuario = rs.getInt("id_usuario");
                    Sesion.nombreUsuario = rs.getString("nombre_usuario");
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(null, "❌ Usuario o contraseña incorrectos.");
        return false;
    }
}
