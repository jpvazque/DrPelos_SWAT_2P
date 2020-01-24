/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.personas;

/**
 *
 * @author 59399
 */
public class Usuario extends Persona{
    String usuario;
    String contrasena;

    public Usuario(String usuario, String contrasena, String id, String nombre, String apellido, String direccion, String telefono) {
        super(id, nombre, apellido, direccion, telefono);
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
}



