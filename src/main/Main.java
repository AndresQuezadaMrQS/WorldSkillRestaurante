/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controlador.ControladorClientes;
import vista.LoginFrame;

/**
 *
 * @author LATITUDE E6420
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginFrame frame = new LoginFrame();
        ControladorClientes control = new ControladorClientes(frame);
        frame.setVisible(true);
    }
    
}
