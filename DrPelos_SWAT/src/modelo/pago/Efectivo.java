/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pago;

/**
 *
 * @author 59399
 */
public class Efectivo implements FormaPago{
    float recibido;
    float cambio;

    public Efectivo(float recibido, float cambio) {
        this.recibido = recibido;
        this.cambio = cambio;
    }

    public float getRecibido() {
        return recibido;
    }

    public void setRecibido(float recibido) {
        this.recibido = recibido;
    }

    public float getCambio() {
        return cambio;
    }

    public void setCambio(float cambio) {
        this.cambio = cambio;
    }
    
}



