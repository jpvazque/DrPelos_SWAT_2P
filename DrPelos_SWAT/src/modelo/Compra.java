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
public class Compra {
    String idCompra;
    ArrayList<Producto> productos;
    ArrayList<Servicio> servicios;
    ArrayList<Integer> cantidad;
    Cliente cliente;
    PersonalCaja vendedor;
    FormaPago formaPago;
    LocalDate fecha;
    float total;

    public Compra(String idCompra, ArrayList<Producto> productos, ArrayList<Servicio> servicios, ArrayList<Integer> cantidad, Cliente cliente, PersonalCaja vendedor, FormaPago formaPago, LocalDate fecha, float total) {
        this.idCompra = idCompra;
        this.productos = productos;
        this.servicios = servicios;
        this.cantidad = cantidad;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.formaPago = formaPago;
        this.fecha = fecha;
        this.total = total;
    }

    public String getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(String idCompra) {
        this.idCompra = idCompra;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public ArrayList<Integer> getCantidad() {
        return cantidad;
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

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
}


