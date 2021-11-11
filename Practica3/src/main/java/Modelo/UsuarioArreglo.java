/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author OCA-UIE
 */
public class UsuarioArreglo {
    private Usuario arregloU [];
    private int indice;

    public UsuarioArreglo(int tamaño) {
        this.indice = 0;
        this.arregloU = new Usuario[tamaño];
    }

    public UsuarioArreglo() {
        this.indice = 0;
        this.arregloU = new Usuario[5];
    }
    
    public boolean agregar(Usuario usuario){
        boolean result = false;
        if (!documentoRegistrado(usuario.getTipoDocumento(),  usuario.getDocumento())){
            if(estaLleno()){
               crecerArreglo();
            }
            this.arregloU[this.indice] = usuario;
            this.indice++;
            result= true;
        }
        return result;
    }
    
    public boolean eliminar(Usuario usuario){
        boolean result = false;
        
        return result;
    }
    
    public boolean eliminar(String documento){
        boolean result = false;
        
        return result;
    }
    
    public Usuario getUsuario(String documento){
        Usuario result = null;
        
        return result;
    }
    
    public boolean documentoRegistrado(String tipo,  String documento){
        boolean result = false;
        for(int i=0; i<this.indice; i++ ){
            if(this.arregloU[i].getDocumento().equalsIgnoreCase(documento) &&
                    this.arregloU[i].getTipoDocumento().equalsIgnoreCase(tipo)
                    ){
                result = true;
                break;
            }
        }
        return result;
    }
    
    private void crecerArreglo(){
        
    }
    
    private boolean estaLleno(){
        boolean result = false;
        
        return result;
        
    }
    
    private boolean estaVAcio(){
        boolean result = false;
        
        return result;
    }
    
    public void ordenarPorPaterno(){

    }
    
    public void ordenarPorMaterno(){

    }
    
    public void ordenarPorDocumento(){

    }

    @Override
    public String toString() {
        String result="";
        for(int i =0 ; i< this.indice ; i++ ){
            result += this.arregloU[i] + "\n";
        }
        return result;
    }

    
}
