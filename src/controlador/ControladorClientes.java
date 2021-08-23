/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import modelo.ClientesDAO;
import modelo.ModeloClientes;
import vista.LoginFrame;
import vista.PresentacionFrame;

/**
 *
 * @author LATITUDE E6420
 */
public class ControladorClientes extends Abstraccion {

    private ModeloClientes modeloClientes = new ModeloClientes();
    private ClientesDAO clientesDAO = new ClientesDAO();
    private LoginFrame logFrame = new LoginFrame();

    public ControladorClientes(LoginFrame logFrame2) {
        this.logFrame = logFrame2;
        logFrame.btnIngresar.addActionListener(this);
    }

    private void validarCredenciales() {
        String correo = logFrame.txtCorreo.getText();
        String pass = logFrame.txtPass.getText();
        if (!correo.isEmpty() && !pass.isEmpty()) {
            if (correo.contains("@")) {
                modeloClientes = clientesDAO.credencialesCliente(correo, pass);
                if (modeloClientes != null) {
                    if (modeloClientes.getCorreo().equals(correo) && modeloClientes.getPassword().equals(pass)) {
                        logFrame.dispose();
                        PresentacionFrame presentFrame = new PresentacionFrame();
                        presentFrame.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No existe un usuario "
                            + "con estas credenciales o no son correctas. "
                            + "Intente de nuevo.", "Credenciales no encontradas", 0);
                    limpiarLogFrame();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un correo correcto.", "Correo no identificado", 0);
                logFrame.txtCorreo.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese datos para los campos vacíos", "Campos vacíos", 0);
            limpiarLogFrame();
        }
    }

   
    
    private void limpiarLogFrame() {
        logFrame.txtCorreo.requestFocus();
        logFrame.txtCorreo.setText("");
        logFrame.txtPass.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logFrame.btnIngresar) {
            validarCredenciales();
        }
    }
}
