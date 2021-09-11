/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ModeloClientes;
import vista.*;

/**
 *
 * @author LATITUDE E6420
 */
public class ControladorPresentacion extends Abstraccion {

    static PedidosEnCursoFrame pedidoEnCurso = null;
    static PedidosRealizadosFrame pedidosRealiz = null;
    static CarritoComprasFrame realizarPedidos = null;
    private PresentacionFrame presentFrame = new PresentacionFrame();
    static int enviarIdCliente;

    public ControladorPresentacion(PresentacionFrame prens, ModeloClientes modelo) {
        presentFrame = prens;
        presentFrame.btnRealizarPedido.addMouseListener(this);
        presentFrame.btnRealizarPedido.addActionListener(this);
        presentFrame.btnPedidosRealizados.addMouseListener(this);
        presentFrame.btnPedidosRealizados.addActionListener(this);
        presentFrame.btnPedidosEnCurso.addMouseListener(this);
        presentFrame.btnPedidosEnCurso.addActionListener(this);
        bienvenidaUsuario(modelo, prens);
    }
    
    private void irAPedidosEnCurso(){
        if (pedidoEnCurso == null) {
            pedidoEnCurso = new PedidosEnCursoFrame();
            ControladorInternalFrames control = new ControladorInternalFrames(pedidoEnCurso);
            presentFrame.desktopPane.add(pedidoEnCurso);
            pedidoEnCurso.setVisible(true);
        }
    }
    
    private void irPedidosRealizado(){
        if (pedidosRealiz == null) {
            pedidosRealiz = new PedidosRealizadosFrame();
            ControladorInternalFrames control = new ControladorInternalFrames(pedidosRealiz);
            presentFrame.desktopPane.add(pedidosRealiz);
            pedidosRealiz.setVisible(true);
        }
    }
    
    private void irRealizarPedidos(){
        if (realizarPedidos == null) {
            realizarPedidos = new CarritoComprasFrame();
            ControladorInternalFrames control = new ControladorInternalFrames(realizarPedidos);
            presentFrame.desktopPane.add(realizarPedidos);
            realizarPedidos.setVisible(true);
        }
    }
    
    private void bienvenidaUsuario(ModeloClientes modelo, PresentacionFrame present) {
        if (modelo != null && present != null) {
            present.labelBienvenida.setText("Bienvenido, " + modelo.getNombre() + "!!");
            enviarIdCliente = modelo.getId();
            
        }
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == presentFrame.btnPedidosEnCurso) {
             irAPedidosEnCurso();
         } else if (e.getSource() == presentFrame.btnPedidosRealizados) {
             irPedidosRealizado();
         } else if (e.getSource() == presentFrame.btnRealizarPedido) {
             irRealizarPedidos();
         }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(ControladorClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (e.getSource() == this.presentFrame.btnPedidosRealizados) {
            presentFrame.btnPedidosRealizados.setText("Pedidos Realizados");
        } else if (e.getSource() == this.presentFrame.btnPedidosEnCurso) {
            presentFrame.btnPedidosEnCurso.setText("Pedidos en Curso");
        } else if (e.getSource() == presentFrame.btnRealizarPedido) {
            presentFrame.btnRealizarPedido.setText("Realizar un Pedido");
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this.presentFrame.btnPedidosRealizados) {
            presentFrame.btnPedidosRealizados.setText("");
        } else if (e.getSource() == this.presentFrame.btnPedidosEnCurso) {
            presentFrame.btnPedidosEnCurso.setText("");
        } else if (e.getSource() == this.presentFrame.btnRealizarPedido) {
            presentFrame.btnRealizarPedido.setText("");
        }
    }
}
