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
import java.util.ArrayList;

/**
 *
 * @author LATITUDE E6420
 */
public class PedidosDAO {

    private String sql;
    private final Conexion conexionActual = new Conexion();
    private Connection miConexion;
    private ResultSet RS;
    private PreparedStatement PS;

    public ArrayList<ModeloPedidos> pedidosEnCurso(int id) {
        ArrayList<ModeloPedidos> datos = new ArrayList<>();
        ModeloPedidos mod = null;
        try {
            miConexion = conexionActual.conectarConexion();
            sql = "SELECT * FROM tbl_pedidos WHERE id_cliente = ?;";

            PS = miConexion.prepareStatement(sql);
            PS.setInt(1, id);
            RS = PS.executeQuery();
            while (RS.next()) {
                mod = new ModeloPedidos();
                mod.setId(RS.getInt("id"));
                mod.setFecha(RS.getString("fecha"));
                mod.setId_cliente(RS.getInt("id_cliente"));
                mod.setId_estado(RS.getInt("id_estado"));
                datos.add(mod);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            miConexion = conexionActual.cerrarConexion();
        }
        return datos;
    }
}
