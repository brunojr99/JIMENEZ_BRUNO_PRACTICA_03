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
public class Tarjeta {
    private int numero;
    private float saldo;
    private boolean activo;
    private float precio;
    private static int correlativo = 1;

    public Tarjeta( float saldo, float precio) {
        this.numero = Tarjeta.correlativo++;
        this.saldo = saldo;
        this.precio = precio;
        this.activo = true;
        
    }

    public Tarjeta() {
        this.numero = Tarjeta.correlativo++;;
        this.activo = false;
    }
       

    public int getNumero() {
        return numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public boolean isActivo() {
        return activo;
    }

    public float getPrecio() {
        return precio;
    }

    public boolean recargar(float monto){
        boolean result= false;
        if(this.isActivo() && monto > 0.0){
            this.saldo += monto;
            result = true;
        }
        return result;
    }
    
    public boolean consumir(){
        boolean result= false;
        if(this.isActivo() && this.precio >0.0 &&
                this.saldo >= this.precio  ){
            this.saldo -= this.precio;
            result = true;
        }
        return result;
    }

    @Override
    public String toString() {
        return  "Numero=" + numero + 
                " Saldo=" + saldo + 
                " Activo=" + activo + 
                " Pasaje=" + precio;
    }
    
    
    
    
}
