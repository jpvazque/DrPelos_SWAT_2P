/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.servicios;

import modelo.Compra;
import modelo.personas.Repartidor;

/**
 *
 * @author 59399
 */
public class Servicio_EntregaProducto implements Servicio{
    String idEntrega;
    Repartidor repartidor;
    Compra compra;

    public Servicio_EntregaProducto(String idEntrega, Repartidor repartidor, Compra compra) {
        this.idEntrega = idEntrega;
        this.repartidor = repartidor;
        this.compra = compra;
    }

    public String getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(String idEntrega) {
        this.idEntrega = idEntrega;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    
}



