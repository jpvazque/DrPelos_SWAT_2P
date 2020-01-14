/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 59399
 */
public class Servicio_TrasladoMascota implements Servicio{
    Cliente cliente;
    String direccionPartida;
    String direccionLlegada;

    public Servicio_TrasladoMascota(Cliente cliente, String direccionPartida, String direccionLlegada) {
        this.cliente = cliente;
        this.direccionPartida = direccionPartida;
        this.direccionLlegada = direccionLlegada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDireccionPartida() {
        return direccionPartida;
    }

    public void setDireccionPartida(String direccionPartida) {
        this.direccionPartida = direccionPartida;
    }

    public String getDireccionLlegada() {
        return direccionLlegada;
    }

    public void setDireccionLlegada(String direccionLlegada) {
        this.direccionLlegada = direccionLlegada;
    }
    
}



