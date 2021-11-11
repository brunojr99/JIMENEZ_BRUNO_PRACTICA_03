
package Programa;

import Modelo.Tarjeta;
import Modelo.Usuario;
import Modelo.UsuarioArreglo;
import Controlador.ControladorUsuario;

public class App {
    
    public static  void main (String[] args){
        Tarjeta t1, t2,t3;
        Usuario usuario;
        UsuarioArreglo usuarios;
        frmUsuario fUsuario = new frmUsuario();
        usuarios = new UsuarioArreglo();
        ControladorUsuario controlador = new ControladorUsuario(usuarios,fUsuario );
        
        usuario = new Usuario("Díaz", "Perez", "Jose", "9080706050", "DNI");
        usuario.registrarTarjeta( 
                        new Tarjeta( 25.0f,2.5f));
                
        usuarios.agregar(usuario);
        usuario = new Usuario("Rios", "Casas", "Francisco","1020304050","DNI");
        usuario.registrarTarjeta( 
                        new Tarjeta( 30.0f,2.5f));
        usuarios.agregar(usuario);
        usuario = new Usuario("Casas", "Perez", "Carlos","1020304050","DNI");
        usuarios.agregar(usuario);
        
        
        System.out.println(usuarios);
        controlador.iniciar();
        
        
      
    }
    
   
}
