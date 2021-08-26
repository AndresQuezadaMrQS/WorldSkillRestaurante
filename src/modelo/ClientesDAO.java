/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LATITUDE E6420
 */
public class ClientesDAO {

    private String sql, respuesta = null;
    private Conexion conexionActual = new Conexion();
    private Connection miConexion;
    private ResultSet RS;
    private PreparedStatement PS;

    public ModeloClientes credencialesCliente(String correo, String pass) {
        ModeloClientes modelo = null;
        try {
            miConexion = conexionActual.conectarConexion();
            sql = "SELECT correo, password FROM tbl_clientes WHERE correo = ? AND password = ?;";

            PS = miConexion.prepareStatement(sql);
            PS.setString(1, correo);
            PS.setString(2, pass);

            RS = PS.executeQuery();
            while (RS.next()) {
                modelo = new ModeloClientes();
                modelo.setCorreo(RS.getString("correo"));
                modelo.setPassword(RS.getString("password"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            miConexion = conexionActual.cerrarConexion();
        }
        return modelo;
    }

    public String crearCliente(ModeloClientes modelo) {
        try {
            miConexion = conexionActual.conectarConexion();
            sql = "INSERT INTO tbl_clientes(nombre, ciudad, correo, password) VALUES(?,?,?,?);";

            PS = miConexion.prepareStatement(sql);
            PS.setString(1, modelo.getNombre());
            PS.setString(2, modelo.getCiudad());
            PS.setString(3, modelo.getCorreo());
            PS.setString(4, modelo.getPassword());
            
            int resultado = PS.executeUpdate();
            if (resultado > 0) {
                respuesta = "Cliente registrado correctamente.";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            respuesta = "El cliente no fue registrado.";
        } finally {
            miConexion = conexionActual.cerrarConexion();
        }
        return respuesta;
    }
    
    public boolean isEmailRegister(String email){
        try {
            miConexion = conexionActual.conectarConexion();
            sql = "SELECT correo FROM tbl_clientes WHERE correo = ?";
            
            PS = miConexion.prepareStatement(sql);
            PS.setString(1, email);
            
            RS = PS.executeQuery();
            while(RS.next()){
                if (email.equals(RS.getString("correo"))) {
                   return true; 
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            miConexion = conexionActual.cerrarConexion();
        }
        return false;
    }
}
