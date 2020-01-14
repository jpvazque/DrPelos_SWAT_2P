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
public class Sucursal {
    String idSucursal;
    String direccion;
    boolean agencia;
    Administrador admin;
    JefeBodega jefeBod;

    public Sucursal(String idSucursal, String direccion, boolean agencia, Administrador admin, JefeBodega jefeBod) {
        this.idSucursal = idSucursal;
        this.direccion = direccion;
        this.agencia = agencia;
        this.admin = admin;
        this.jefeBod = jefeBod;
    }

    public String getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(String idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isAgencia() {
        return agencia;
    }

    public void setAgencia(boolean agencia) {
        this.agencia = agencia;
    }

    public Administrador getAdmin() {
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    public JefeBodega getJefeBod() {
        return jefeBod;
    }

    public void setJefeBod(JefeBodega jefeBod) {
        this.jefeBod = jefeBod;
    }
    
}



