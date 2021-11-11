
package Controlador;

import Modelo.Tarjeta;
import Modelo.Usuario;
import Modelo.UsuarioArreglo;
import Programa.frmUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;



public class ControladorUsuario {
    private UsuarioArreglo modelo;
    private frmUsuario vista;
    
    
    public ControladorUsuario(UsuarioArreglo modelo, frmUsuario vista){
        this.modelo = modelo;
        this.vista = vista;
        limpiar();
        this.vista.btnSalir.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });
        
        this.vista.btnAgregar.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                
            if (!modelo.documentoRegistrado(
                    vista.cboTipoDocumento.getSelectedItem().toString(),
                    vista.txtDocumento.getText())) {
                Usuario  usuario = new Usuario(
                           vista.txtPaterno.getText(), 
                           vista.txtMaterno.getText(), 
                           vista.txtNombres.getText(), 
                           vista.txtDocumento.getText(), 
                           vista.cboTipoDocumento.getSelectedItem().toString() );
                
                usuario.registrarTarjeta( 
                        new Tarjeta( Float.parseFloat( vista.txtMonto.getText()),
                            Float.parseFloat(vista.txtPasaje.getText() ) ) );
               
                modelo.agregar(usuario);
               limpiar();               
            } else{
                 JOptionPane.showMessageDialog(vista,"Error:Documento ya se encuentra registrado");
            }   

            }
        });
        
        this.vista.btnImprimir.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(vista,modelo);

            }
        });
        
    }
    
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
    private void limpiar(){
        this.vista.txtPaterno.setText(""); 
        this.vista.txtMaterno.setText("");
        this.vista.txtNombres.setText("");
        this.vista.txtDocumento.setText("");
        this.vista.cboTipoDocumento.setSelectedIndex(-1);
        
    }
    
}
