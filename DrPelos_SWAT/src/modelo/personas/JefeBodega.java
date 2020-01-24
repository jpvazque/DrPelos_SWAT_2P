/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.personas;

import java.util.ArrayList;

/**
 *
 * @author 59399
 */
public class JefeBodega extends Usuario{
    ArrayList<Repartidor> repartidores;

    public JefeBodega(ArrayList<Repartidor> repartidores, String usuario, String contrasena, String id, String nombre, String apellido, String direccion, String telefono) {
        super(usuario, contrasena, id, nombre, apellido, direccion, telefono);
        this.repartidores = repartidores;
    }

    public ArrayList<Repartidor> getRepartidores() {
        return repartidores;
    }

}



