/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.personas;

import java.util.ArrayList;

import modelo.servicios.Servicio_EntregaProducto;

/**
 *
 * @author 59399
 */
public class Repartidor extends Persona{
    ArrayList<Servicio_EntregaProducto> entregas;

    public Repartidor(ArrayList<Servicio_EntregaProducto> entregas, String id, String nombre, String apellido, String direccion, String telefono) {
        super(id, nombre, apellido, direccion, telefono);
        this.entregas = entregas;
    }

    public ArrayList<Servicio_EntregaProducto> getEntregas() {
        return entregas;
    }
   
}



