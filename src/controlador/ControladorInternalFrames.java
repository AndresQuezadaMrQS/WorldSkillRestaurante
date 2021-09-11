/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;
import modelo.ModeloPedidos;
import modelo.PedidosDAO;
import vista.PedidosEnCursoFrame;
import vista.PedidosRealizadosFrame;
import vista.CarritoComprasFrame;

/**
 *
 * @author LATITUDE E6420
 */
public class ControladorInternalFrames extends Abstraccion {

    private PedidosEnCursoFrame pedidosCurso = new PedidosEnCursoFrame();
    private PedidosRealizadosFrame pedidosRealizado = new PedidosRealizadosFrame();
    private CarritoComprasFrame realizarPedidos = new CarritoComprasFrame();
    private ModeloPedidos modPedidos = new ModeloPedidos();
    private PedidosDAO pedDao = new PedidosDAO();

    public ControladorInternalFrames(PedidosEnCursoFrame pedidoEnCurso) {
        pedidosCurso = pedidoEnCurso;
        pedidosCurso.addInternalFrameListener(this);
    }

    public ControladorInternalFrames(PedidosRealizadosFrame pedidosRealiz) {
        pedidosRealizado = pedidosRealiz;
        pedidosRealizado.addInternalFrameListener(this);
        //tablaPedidosRealizados(pedidosRealizado.TablePedidosRealizados);

    }

    public ControladorInternalFrames(CarritoComprasFrame realizarPedidos) {
        this.realizarPedidos = realizarPedidos;
        this.realizarPedidos.addInternalFrameListener(this);
    }

    private void tablaPedidosRealizados(JTable table) {
        pedidosRealizado.labelIDUsuario.setText(String.valueOf(ControladorPresentacion.enviarIdCliente));
        DefaultTableModel miModel = (DefaultTableModel) table.getModel();
        ArrayList<ModeloPedidos> datos = pedDao.pedidosEnCurso(ControladorPresentacion.enviarIdCliente);
        if (!datos.isEmpty()) {
            int longitud = datos.size();
            Object row[] = new Object[3];
            for (int i = 0; i < longitud; i++) {
                row[0] = datos.get(i).getId();
                row[1] = datos.get(i).getFecha();
                row[2] = datos.get(i).getId_estado();
                miModel.addRow(row);
            }

        }
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        if (e.getSource() == pedidosCurso) {
            ControladorPresentacion.pedidoEnCurso = null;
        } else if (e.getSource() == pedidosRealizado) {
            ControladorPresentacion.pedidosRealiz = null;
        } else if (e.getSource() == realizarPedidos) {
            ControladorPresentacion.realizarPedidos = null;
        }
    }
}
