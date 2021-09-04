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
import javax.swing.event.InternalFrameEvent;
import modelo.ModeloClientes;
import vista.*;

/**
 *
 * @author LATITUDE E6420
 */
public class ControladorPedidos extends Abstraccion {

    private PedidosEnCursoFrame pedidoEnCurso = new PedidosEnCursoFrame();
    private PedidosRealizadosFrame pedidosRealiz = new PedidosRealizadosFrame();
    private RealizarPedidosFrame realizPedidos = new RealizarPedidosFrame();
    private PresentacionFrame presentFrame = new PresentacionFrame();

    public ControladorPedidos(PresentacionFrame prens, ModeloClientes modelo) {
        presentFrame = prens;
        presentFrame.btnRealizarPedido.addMouseListener(this);
        presentFrame.btnRealizarPedido.addActionListener(this);
        presentFrame.btnPedidosRealizados.addMouseListener(this);
        presentFrame.btnPedidosRealizados.addActionListener(this);
        presentFrame.btnPedidosEnCurso.addMouseListener(this);
        presentFrame.btnPedidosEnCurso.addActionListener(this);
        bienvenidaUsuario(modelo, prens);
    }

    public ControladorPedidos(PedidosEnCursoFrame pedidoCurso) {
        pedidoEnCurso = pedidoCurso;
        pruebaFrame.addInternalFrameListener(this);
    }

    public ControladorPedidos(PedidosRealizadosFrame pedidosRealiz) {
        this.pedidosRealiz = pedidosRealiz;
    }

    public ControladorPedidos(RealizarPedidosFrame realizPedidos) {
        this.realizPedidos = realizPedidos;
    }
    private PedidosEnCursoFrame pruebaFrame = null;
    
    private void irAPedidosEnCurso(){
        if (pruebaFrame == null) {
            pruebaFrame = new PedidosEnCursoFrame();
            ControladorPedidos control = new ControladorPedidos(pruebaFrame);
            presentFrame.desktopPane.add(pruebaFrame);
            pruebaFrame.setVisible(true);
            System.out.println("Hola");
        }
    }

    private void bienvenidaUsuario(ModeloClientes modelo, PresentacionFrame present) {
        if (modelo != null && present != null) {
            present.labelBienvenida.setText("Bienvenido, " + modelo.getNombre() + "!!");
        }
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == presentFrame.btnPedidosEnCurso) {
             irAPedidosEnCurso();
         }
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
        if (e.getSource() == pruebaFrame) {
            pruebaFrame = null;
            System.out.println("Hola3232");
        }
    }

    /*@Override
    public void mouseEntered(MouseEvent e) {
        try {
            Thread.sleep(500);
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
    }*/
}
