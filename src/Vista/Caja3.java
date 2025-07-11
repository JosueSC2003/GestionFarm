
package Vista;
import Conexiones.Conexion;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.PrintWriter;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Caja3 extends javax.swing.JFrame {
Map<String, Double> productos = new HashMap<>();
DefaultTableModel modeloTabla;
double subtotal = 0.0;
private final double IVA_PORCENTAJE = 0.16;

/**
     * Creates new form Caja
     */
    public Caja3() {
        initComponents();
        cargarProductosDesdeBD();
        
lblSubtotal.setText("Subtotal: $0.00");
lblIva.setText("IVA (16%): $0.00");
lblTotal.setText("Total: $0.00");
lblCambio.setText("Cambio: $0.00");
modeloTabla = new DefaultTableModel();
modeloTabla.setColumnIdentifiers(new String[] {"Cantidad", "Artículo", "Precio Unitario", "Total"});
tablaProductos.setModel(modeloTabla);
txtEfectivo.addKeyListener(new java.awt.event.KeyAdapter() {
    public void keyReleased(java.awt.event.KeyEvent evt) {
        txtEfectivoKeyReleased(evt);
    }
});

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lblSeleccionar = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEfectivo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnatrasca = new javax.swing.JButton();
        cbnombre = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        lblSubtotal = new javax.swing.JLabel();
        lblCambio = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblIva = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblSeleccionar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        lblSeleccionar.setText("Nombre o codigo:");

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel8.setText("Efectivo:");

        txtEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEfectivoActionPerformed(evt);
            }
        });
        txtEfectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEfectivoKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel9.setText("Cambio:");

        jButton1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton1.setText("IMPRIMIR");
        jButton1.setMaximumSize(new java.awt.Dimension(200, 100));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton2.setText("COBRAR");
        jButton2.setMaximumSize(new java.awt.Dimension(200, 100));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnatrasca.setText("Atras");
        btnatrasca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnatrascaActionPerformed(evt);
            }
        });

        cbnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbnombreActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lblSubtotal.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        lblSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubtotal.setText("SubTotal");
        lblSubtotal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblCambio.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N

        lblCantidad.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        lblCantidad.setText("Cantidad:");

        lblIva.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        lblIva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIva.setText("Iva");
        lblIva.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblTotal.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal.setText("Total");
        lblTotal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnatrasca)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                            .addComponent(lblCantidad)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                            .addComponent(lblSeleccionar)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cbnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEfectivo)
                                    .addComponent(lblCambio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblIva, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(76, 76, 76)
                                    .addComponent(btnAgregar))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(67, 67, 67)
                                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnatrasca)
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSeleccionar)
                    .addComponent(cbnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCantidad))
                .addGap(29, 29, 29)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(lblSubtotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIva)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblCambio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 111, 320, 480));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cantidad", "Articulo", "Pre.Uni", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, -6, 780, 490));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 119, -1, 470));

        jPanel2.setBackground(new java.awt.Color(0, 140, 186));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CAJA DE COBRO");
        jLabel1.setToolTipText("");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ESOBRAD2.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(387, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 1110, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void cargarProductosDesdeBD() {
    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/farmacia", "root", "");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT nombre, precio FROM productos");

        while (rs.next()) {
            String nombre = rs.getString("nombre");
            double precio = rs.getDouble("precio");
            cbnombre.addItem(nombre);
            productos.put(nombre, precio); // Guardar en mapa para acceso rápido
        }

        conn.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al conectar: " + e.getMessage());
    }
}
private void imprimirTicket() {
    if (modeloTabla.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "No hay productos para imprimir.");
        return;
    }

    try {
     
PrintWriter writer = new PrintWriter("src/recibostxt/ticket.txt");

        writer.println("====== FARMACIA ESO BRAD ======");
        writer.println("         Ticket de Venta        ");
        writer.println("--------------------------------");
        writer.printf("%-10s %-15s %-10s %-10s%n", "Cant", "Producto", "P.Unit", "Total");

        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            int cantidad = Integer.parseInt(modeloTabla.getValueAt(i, 0).toString());
            String producto = modeloTabla.getValueAt(i, 1).toString();
            String precio = modeloTabla.getValueAt(i, 2).toString();
            String total = modeloTabla.getValueAt(i, 3).toString();

            writer.printf("%-10d %-15s %-10s %-10s%n", cantidad, producto, precio, total);
        }

        double iva = subtotal * IVA_PORCENTAJE;
        double totalFinal = subtotal + iva;

        writer.println("--------------------------------");
        writer.printf("Subtotal:     $%.2f%n", subtotal);
        writer.printf("IVA (16%%):    $%.2f%n", iva);
        writer.printf("Total:        $%.2f%n", totalFinal);

        try {
            double efectivo = Double.parseDouble(txtEfectivo.getText());
            double cambio = efectivo - totalFinal;
            writer.printf("Efectivo:     $%.2f%n", efectivo);
            writer.printf("Cambio:       $%.2f%n", cambio < 0 ? 0.00 : cambio);
        } catch (NumberFormatException e) {
            writer.println("Efectivo:     No ingresado");
            writer.println("Cambio:       No disponible");
        }

        writer.println("Gracias por su compra :)");
        writer.println("Fecha: " + java.time.LocalDateTime.now());

        writer.close();

        JOptionPane.showMessageDialog(this, "Ticket guardado como 'ticket.txt'");
        jButton2.setEnabled(true);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al imprimir el ticket: " + e.getMessage());
    }
}
private void actualizarStock() {
    try {
        Connection con = Conexion.getConnection(); // Usa tu método de conexión
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            // Cantidad está en columna 0 (asegúrate de que sea un número entero)
            int cantidadVendida = Integer.parseInt(modeloTabla.getValueAt(i, 0).toString());
            // Nombre del producto está en columna 1
            String nombreProducto = modeloTabla.getValueAt(i, 1).toString();

            String sql = "UPDATE productos SET stock = stock - ? WHERE nombre = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cantidadVendida);
            ps.setString(2, nombreProducto);
            ps.executeUpdate();
        }
        con.close();
    } catch (SQLException | NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Error al actualizar stock: " + e.getMessage());
    }
}
private void actualizarTotales() {
    subtotal = 0.0;
    for (int i = 0; i < modeloTabla.getRowCount(); i++) {
        double totalProducto = Double.parseDouble(modeloTabla.getValueAt(i, 3).toString());
        subtotal += totalProducto;
    }
    double iva = subtotal * IVA_PORCENTAJE;
    double total = subtotal + iva;

    lblSubtotal.setText(String.format("Subtotal: $%.2f", subtotal));
    lblIva.setText(String.format("IVA (16%%): $%.2f", iva));
    lblTotal.setText(String.format("Total: $%.2f", total));
}

       
    private void txtEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEfectivoActionPerformed
      try {
        double efectivo = Double.parseDouble(txtEfectivo.getText());
        double iva = subtotal * IVA_PORCENTAJE;
        double total = subtotal + iva;
        double cambio = efectivo - total;

        if (cambio < 0) {
            lblCambio.setText("Cambio: $0.00 (Falta dinero)");
        } else {
            lblCambio.setText(String.format("Cambio: $%.2f", cambio));
        }
    } catch (NumberFormatException e) {
        lblCambio.setText("Cambio: $0.00");
        JOptionPane.showMessageDialog(this, "Ingresa un valor válido en efectivo.");
    }
      
    }//GEN-LAST:event_txtEfectivoActionPerformed

    private void btnatrascaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatrascaActionPerformed
        this.dispose();
        Interfaz1 R2 = new Interfaz1();
        R2.setVisible(true);
        R2.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnatrascaActionPerformed

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
    
    }//GEN-LAST:event_txtCantidadKeyPressed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void cbnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbnombreActionPerformed
    
    }//GEN-LAST:event_cbnombreActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
      String producto = (String) cbnombre.getSelectedItem();
    
    if (producto == null || producto.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Selecciona un producto.");
        return;
    }

    double precio = productos.getOrDefault(producto, 0.0);
    int cantidad;

    try {
        cantidad = Integer.parseInt(txtCantidad.getText().trim());
        if (cantidad <= 0) throw new NumberFormatException();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Ingresa una cantidad válida.");
        return;
    }

    double total = cantidad * precio;

    // Agrega la fila a la tabla
    modeloTabla.addRow(new Object[] {
        cantidad,
        producto,
        String.format("%.2f", precio),
        String.format("%.2f", total)
    });

    // Recalcula subtotal, IVA y total
    actualizarTotales();

    // Limpia el campo cantidad para próxima entrada
    txtCantidad.setText("");

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtEfectivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEfectivoKeyReleased
      try {
        double efectivo = Double.parseDouble(txtEfectivo.getText());
        double iva = subtotal * IVA_PORCENTAJE;
        double total = subtotal + iva;
        double cambio = efectivo - total;

        if (cambio < 0) {
            lblCambio.setText("Cambio: $0.00 (Falta dinero)");
        } else {
            lblCambio.setText(String.format("Cambio: $%.2f", cambio));
        }
    } catch (NumberFormatException e) {
        lblCambio.setText("Cambio: $0.00");
    }
    }//GEN-LAST:event_txtEfectivoKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (modeloTabla.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "No hay productos para cobrar.");
        return;
    }

    double efectivo;
    try {
        efectivo = Double.parseDouble(txtEfectivo.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Ingresa una cantidad válida en efectivo.");
        return;
    }

    double iva = subtotal * IVA_PORCENTAJE;
    double total = subtotal + iva;
    double cambio = efectivo - total;

    if (cambio < 0) {
        JOptionPane.showMessageDialog(this, "El efectivo no es suficiente para cubrir el total.");
        return;
    }

    // Confirmación de cobro
    JOptionPane.showMessageDialog(this, String.format(
        "Cobro realizado con éxito.\nTotal: $%.2f\nEfectivo: $%.2f\nCambio: $%.2f",
        total, efectivo, cambio
    ));
  imprimirTicket();
  actualizarStock();
    // Limpiar tabla y reiniciar campos
    modeloTabla.setRowCount(0);
    subtotal = 0.0;
    txtCantidad.setText("");
    txtEfectivo.setText("");
    lblSubtotal.setText("Subtotal: $0.00");
    lblIva.setText("IVA (16%): $0.00");
    lblTotal.setText("Total: $0.00");
    lblCambio.setText("Cambio: $0.00");

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        imprimirTicket();
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Caja3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Caja3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Caja3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Caja3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Caja3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnatrasca;
    private javax.swing.JComboBox<String> cbnombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCambio;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblIva;
    private javax.swing.JLabel lblSeleccionar;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tablaProductos;
    public javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtEfectivo;
    // End of variables declaration//GEN-END:variables
}
