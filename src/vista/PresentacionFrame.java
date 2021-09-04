/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author LATITUDE E6420
 */
public class PresentacionFrame extends javax.swing.JFrame {

    /**
     * Creates new form PresentacionFrame2
     */
    public PresentacionFrame() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        labelBienvenida = new javax.swing.JLabel();
        btnPedidosRealizados = new javax.swing.JButton();
        btnPedidosEnCurso = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnRealizarPedido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Presentación");

        desktopPane.setBackground(new java.awt.Color(204, 204, 204));

        labelBienvenida.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelBienvenida.setText("Bienvenido ");

        btnPedidosRealizados.setBackground(new java.awt.Color(204, 204, 204));
        btnPedidosRealizados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono_pedidos.png"))); // NOI18N
        btnPedidosRealizados.setBorder(null);
        btnPedidosRealizados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnPedidosEnCurso.setBackground(new java.awt.Color(204, 204, 204));
        btnPedidosEnCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pedido-en-linea.png"))); // NOI18N
        btnPedidosEnCurso.setBorder(null);
        btnPedidosEnCurso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        btnRealizarPedido.setBackground(new java.awt.Color(204, 204, 204));
        btnRealizarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton_pedidos.png"))); // NOI18N
        btnRealizarPedido.setBorder(null);
        btnRealizarPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(btnRealizarPedido)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRealizarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        desktopPane.setLayer(labelBienvenida, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(btnPedidosRealizados, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(btnPedidosEnCurso, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(desktopPaneLayout.createSequentialGroup()
                        .addComponent(labelBienvenida)
                        .addGap(0, 279, Short.MAX_VALUE))
                    .addGroup(desktopPaneLayout.createSequentialGroup()
                        .addComponent(btnPedidosRealizados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPedidosEnCurso)))
                .addContainerGap())
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPedidosEnCurso)
                    .addComponent(btnPedidosRealizados))
                .addGap(18, 18, 18)
                .addComponent(labelBienvenida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PresentacionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PresentacionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PresentacionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PresentacionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PresentacionFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnPedidosEnCurso;
    public javax.swing.JButton btnPedidosRealizados;
    public javax.swing.JButton btnRealizarPedido;
    public javax.swing.JDesktopPane desktopPane;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel labelBienvenida;
    // End of variables declaration//GEN-END:variables
}
