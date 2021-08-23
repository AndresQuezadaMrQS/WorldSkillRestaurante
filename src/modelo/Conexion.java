/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LATITUDE E6420
 */
public class Conexion {

    private final String url = "jdbc:mysql://remotemysql.com:3306/dbSOCk1lEI";
    private final String user = "dbSOCk1lEI";
    private final String pass = "JuTnZYdveo";
    private Connection miConexion = null;

    protected Connection conectarConexion() {
        try {
            miConexion = (Connection) DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("Fallo en la conexion. " + e.getMessage());
        }
        return miConexion;
    }

    protected Connection cerrarConexion() {
        try {
            if (miConexion != null) {
                if (!miConexion.isClosed()) {
                    miConexion.close();
                }
            }
        } catch (SQLException e) {
            System.out.println("Fallo en la conexion. " + e.getMessage());
        }
        return miConexion;
    }
}
