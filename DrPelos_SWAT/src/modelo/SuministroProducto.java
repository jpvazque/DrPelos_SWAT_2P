/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author 59399
 */
public class SuministroProducto {
    String idSuministro;
    Administrador admin;
    Sucursal agencia;
    ArrayList<Producto> productos;
    ArrayList<Integer> cantidad;

    public SuministroProducto(String idSuministro, Administrador admin, Sucursal agencia, ArrayList<Producto> productos, ArrayList<Integer> cantidad) {
        this.idSuministro = idSuministro;
        this.admin = admin;
        this.agencia = agencia;
        this.productos = productos;
        this.cantidad = cantidad;
    }

    public String getIdSuministro() {
        return idSuministro;
    }

    public void setIdSuministro(String idSuministro) {
        this.idSuministro = idSuministro;
    }

    public Administrador getAdmin() {
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    public Sucursal getAgencia() {
        return agencia;
    }

    public void setAgencia(Sucursal agencia) {
        this.agencia = agencia;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public ArrayList<Integer> getCantidad() {
        return cantidad;
    }  
    
}


