/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author 59399
 */
public class Cotizacion {
    String idCotizacion;
    Cliente cliente;
    PersonalCaja vendedor;
    ArrayList<Producto> productos;
    ArrayList<Servicio> servicios;
    LocalDate fecha;
    Float total;

    public Cotizacion(String idCotizacion, Cliente cliente, PersonalCaja vendedor, ArrayList<Producto> productos, ArrayList<Servicio> servicios, LocalDate fecha, Float total) {
        this.idCotizacion = idCotizacion;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.productos = productos;
        this.servicios = servicios;
        this.fecha = fecha;
        this.total = total;
    }

    public String getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(String idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public PersonalCaja getVendedor() {
        return vendedor;
    }

    public void setVendedor(PersonalCaja vendedor) {
        this.vendedor = vendedor;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }
    
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
    
    
}


