/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 59399
 */
public class Inventario {
    List<Servicio> servicios;
    List<Producto> productos;
    ArrayList<Integer> stock;

    public Inventario(List<Servicio> servicios, List<Producto> productos, ArrayList<Integer> stock) {
        this.servicios = servicios;
        this.productos = productos;
        this.stock = stock;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public ArrayList<Integer> getStock() {
        return stock;
    }
  
}


