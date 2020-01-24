/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.personas;

import modelo.BaseDatos;

/**
 *
 * @author 59399
 */
public class Directivo extends Usuario{
    BaseDatos conexion;

    public Directivo(BaseDatos conexion, String usuario, String contrasena, String id, String nombre, String apellido, String direccion, String telefono) {
        super(usuario, contrasena, id, nombre, apellido, direccion, telefono);
        this.conexion = conexion;
    }

    public BaseDatos getConexion() {
        return conexion;
    }

    public void setConexion(BaseDatos conexion) {
        this.conexion = conexion;
    }
    
}



