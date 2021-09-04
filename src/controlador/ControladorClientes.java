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
import vista.RegistroFrame;

/**
 *
 * @author LATITUDE E6420
 */
public class ControladorClientes extends Abstraccion {

    private ModeloClientes modeloClientes = new ModeloClientes();
    private final ClientesDAO clientesDAO = new ClientesDAO();
    private LoginFrame logFrame = new LoginFrame();
    private RegistroFrame regFrame = new RegistroFrame();

    public ControladorClientes(LoginFrame logFrame2) {
        this.logFrame = logFrame2;
        logFrame.btnIngresar.addActionListener(this);
        logFrame.btnIrARegistro.addActionListener(this);
    }

    public ControladorClientes(RegistroFrame regFrame) {
        this.regFrame = regFrame;
        this.regFrame.btnRegistrarme.addActionListener(this);
        this.regFrame.btnVolver.addActionListener(this);
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

    private void registrarCliente() {
        String nombre = regFrame.txtNombre.getText();
        String ciudad = regFrame.txtCiudad.getText();
        String correo = regFrame.txtCorreo.getText();
        String pass = new String(regFrame.txtPass.getPassword());
        String passConfirm = new String(regFrame.txtPassConfirm.getPassword());

        if (!nombre.isEmpty() && !ciudad.isEmpty() && !correo.isEmpty()) {
            if (!clientesDAO.isEmailRegister(correo)) {
                if (pass.equals(passConfirm)) {
                    modeloClientes.setNombre(nombre);
                    modeloClientes.setCiudad(ciudad);
                    modeloClientes.setCorreo(correo);
                    modeloClientes.setPassword(passConfirm);
                    String respuesta = clientesDAO.crearCliente(modeloClientes);
                    if (respuesta != null) {
                        JOptionPane.showMessageDialog(null, respuesta);
                        limpiarLogFrame();
                        volverAlLogin();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se ingresaron los datos.");
                        limpiarLogFrame();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La contraseña no coincide.", "Contraseñas invalidas", 0);
                    regFrame.txtPass.setText("");
                    regFrame.txtPass.requestFocus();
                    regFrame.txtPassConfirm.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El correo ya esta registrado.", "Correo ya registrado", 0);
                regFrame.txtCorreo.setText("");
                regFrame.txtCorreo.requestFocus();
                regFrame.txtPass.setText("");
                regFrame.txtPassConfirm.setText("");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Hay campos vacíos.");
        }
    }

    private void volverAlLogin() {
        regFrame.dispose();
        LoginFrame login = new LoginFrame();
        ControladorClientes control = new ControladorClientes(login);
        login.setVisible(true);
    }

    private void irAlRegistro() {
        logFrame.dispose();
        RegistroFrame log = new RegistroFrame();
        ControladorClientes control = new ControladorClientes(log);
        log.setVisible(true);
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
        } else if (e.getSource() == logFrame.btnIrARegistro) {
            irAlRegistro();
        } else if (e.getSource() == regFrame.btnRegistrarme) {
            registrarCliente();
        } else if (e.getSource() == regFrame.btnVolver) {
            volverAlLogin();
        }
    }
}
