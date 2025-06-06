/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Conexiones.Conexion;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Alejandro
 */
public class Usuarios2 extends javax.swing.JFrame {
public Connection conectar() {
    Connection conn = null;
    try {
        // Cambia estos datos según tu base de datos
        String url = "jdbc:mysql://localhost:3306/farmacia";
        String user = "root";
        String pass = "";

        conn = DriverManager.getConnection(url, user, pass);
    } catch (SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error de conexión: " + e.getMessage());
    }
    return conn;
}
public void limpiarCampos() {
    txtUsuarioR.setText("");
    jComboRolR.setSelectedItem("");
    txtContraR.setText("");
    txtId.setText(""); // solo si usas txtId para actualizar o eliminar
}
public void agregarUsuarios() {
    String sql = "INSERT INTO usuarios (id_usuario, nombre_usuario, rol, nombre_completo) VALUES (?, ?, ?)";
    try (Connection con = Conexion.conectar();
        PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setString(1, txtUsuarioR.getText());
        pst.setString(2, txtContraR.getText());
        pst.setString(3, (String) jComboRolR.getSelectedItem());
        pst.executeUpdate();
        javax.swing.JOptionPane.showMessageDialog(this, "Usuario agregado");
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al agregar usuario: " + e.getMessage());
    }
}
public void listarUsuarios() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID");
    model.addColumn("usuario");
    model.addColumn("ROL");
    model.addColumn("nombre");
    

    String sql = "SELECT * FROM usuarios";

    try (Connection con = conectar();
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql)) {

        while (rs.next()) {
            Object[] fila = {
                rs.getInt("id_usuario"),
                rs.getString("nombre_usuario"),
                rs.getString("rol"),
                rs.getString("nombre_completo")
                
            };
            model.addRow(fila);
        }
        tablaUsuario.setModel(model);
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al listar Usuarios: " + e.getMessage());
    }
}
public void actualizarUsuarios() {
    String sql = "UPDATE usuarios SET = id_usuarios = ?, stock = ?, precio = ? WHERE id_producto = ?";
    try (Connection con = conectar();
         PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setString(1, txtUsuarioR.getText());
        pst.setDouble(3, Double.parseDouble(txtContraR.getText()));
        pst.setInt(2, Integer.parseInt((String) jComboRolR.getSelectedItem()));
        pst.setInt(4, Integer.parseInt(txtId.getText()));

        int res = pst.executeUpdate();
        if (res > 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Producto actualizado");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "No se encontró producto con ese ID");
        }
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al actualizar producto: " + e.getMessage());
    }
}
public void eliminarUsuario() {
    String sql = "DELETE FROM productos WHERE id_producto = ?";
    try (Connection con = conectar();
         PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setInt(1, Integer.parseInt(txtId.getText()));

        int res = pst.executeUpdate();
        if (res > 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Producto eliminado");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "No se encontró producto con ese ID");
        }
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al eliminar producto: " + e.getMessage());
    }
}

    public Usuarios2() {
        initComponents();
        txtUsuarioR.setText("");
        jComboRolR.setSelectedItem("");
        txtContraR.setText("");
        txtId.setText("");
        tablaUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        int fila = tablaUsuario.getSelectedRow();
        if (fila != -1) {
            txtId.setText(tablaUsuario.getValueAt(fila, 0).toString());
            txtUsuarioR.setText(tablaUsuario.getValueAt(fila, 1).toString());
            jComboRolR.setSelectedItem(tablaUsuario.getValueAt(fila, 3).toString());
            txtContraR.setText(tablaUsuario.getValueAt(fila, 2).toString());
        }
    }
});
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuario = new javax.swing.JTable();
        txtUsuarioR = new javax.swing.JTextField();
        txtContraR = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        ID = new javax.swing.JLabel();
        btnatrasinfo = new javax.swing.JButton();
        jComboRolR = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 140, 186));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("USUARIOS");
        jLabel1.setToolTipText("");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ESOBRAD2.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(135, 135, 135)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, -1));

        tablaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Usuario", "Nombre", "Rol"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaUsuario);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 620, 460));
        jPanel1.add(txtUsuarioR, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 130, -1));
        jPanel1.add(txtContraR, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 130, -1));

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 100, -1));

        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 100, -1));

        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        btnListar.setText("LISTAR");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });
        jPanel1.add(btnListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 100, -1));

        jLabel2.setText("USUARIO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel3.setText("CONTRASEÑA");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel4.setText("ROL");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 70, -1));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 130, -1));

        ID.setText("ID:");
        jPanel1.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        btnatrasinfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRetroceso.jpg"))); // NOI18N
        btnatrasinfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnatrasinfoActionPerformed(evt);
            }
        });
        jPanel1.add(btnatrasinfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 50, 40));

        jComboRolR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Gerente", "Vendedor" }));
        jComboRolR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboRolRActionPerformed(evt);
            }
        });
        jPanel1.add(jComboRolR, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 130, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
    agregarUsuarios();
    limpiarCampos();
    listarUsuarios();   
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
          listarUsuarios();// TODO add your handling code here:
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
    actualizarUsuarios();
    limpiarCampos();
    listarUsuarios();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
    eliminarUsuario();
    limpiarCampos();
    listarUsuarios();        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnatrasinfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatrasinfoActionPerformed
        this.dispose();
        Interfaz1 R2 = new Interfaz1();
        R2.setVisible(true);
        R2.setLocationRelativeTo(null);

    }//GEN-LAST:event_btnatrasinfoActionPerformed

    private void jComboRolRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboRolRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboRolRActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Usuarios2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ID;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnatrasinfo;
    private javax.swing.JComboBox<String> jComboRolR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaUsuario;
    private javax.swing.JTextField txtContraR;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtUsuarioR;
    // End of variables declaration//GEN-END:variables
}
