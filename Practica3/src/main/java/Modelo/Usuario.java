/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Programa.Configuracion;

/**
 *
 * @author OCA-UIE
 */
public class Usuario {
    
    private String paterno;
    private String materno;
    private String nombres;
    private String documento;
    private String tipoDocumento;
    private Tarjeta tarjetas[];
    private int indice;
    private Tarjeta pordefecto;

    public Usuario(String paterno, String materno, String nombres, String documento, String tipoDocumento) {
        this.paterno = paterno;
        this.materno = materno;
        this.nombres = nombres;
        this.documento = documento;
        this.tipoDocumento = tipoDocumento;
        this.indice = 0;
        this.tarjetas = new Tarjeta[Configuracion.maxTarjetasxUsuario];
    }

    public Usuario(String paterno, String nombres, String documento, String tipoDocumento) {
        this.paterno = paterno;
        this.nombres = nombres;
        this.documento = documento;
        this.tipoDocumento = tipoDocumento;
        this.indice = 0;
        this.tarjetas = new Tarjeta[Configuracion.maxTarjetasxUsuario];
    }

    public Usuario(String materno, String nombres, String documento) {
        this.materno = materno;
        this.nombres = nombres;
        this.documento = documento;
        this.tipoDocumento = "DNI";
        this.indice = 0;
        this.tarjetas = new Tarjeta[Configuracion.maxTarjetasxUsuario];
    }

    public boolean registrarTarjeta(Tarjeta tarjeta){          
        boolean result = false;
        if(!estaLleno()){
            this.tarjetas[this.indice]=  tarjeta;
            this.indice++;
            this.pordefecto = tarjeta;
            result = true;
        }
        return result;
    }
    
    public boolean registrarTarjeta(Tarjeta tarjeta, boolean pordefecto ){
        boolean result = false;
        if(!estaLleno()){
            this.tarjetas[this.indice]=  tarjeta;
            result = true;
            if (pordefecto){
                this.pordefecto = tarjeta;
            }
        }
        return result;
    }
    
    public boolean recargar(float monto){
        boolean result = false;
        if(this.pordefecto != null ){
            this.pordefecto.recargar(monto);
            result = true;
        }else{
            if(!estaVacio()){
                this.tarjetas[0].recargar(monto);
                result = true;
            }
        }
        return result;
    }
    
       
    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDocumento() {
        return documento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    @Override
    public String toString() {
        String imprimirTar="";
        for(int i=0; i< this.indice; i++ ){
            imprimirTar +=this.tarjetas[i]+ "  "; 
        }
        
        // System.out.println(imprimirTar);
        
        return  paterno + " " + 
                materno + " " + 
                nombres + " " + 
                tipoDocumento + " " +  
                documento +"\n" +
                imprimirTar ;
        
    }

    private boolean estaLleno() {
        if(this.indice == Configuracion.maxTarjetasxUsuario){
            return true;
        }else {
            return false;
        }
    }

    private boolean estaVacio() {
        if(this.indice == 0 ) {
            return true;
        }else{
            return false;
        }
    }

    
    
    
}
