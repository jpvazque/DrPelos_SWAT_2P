/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.documentos;

import modelo.Compra;

/**
 *
 * @author 59399
 */
public class NotaCredito {
    String idNota;
    Compra compra;

    public NotaCredito(String idNota, Compra compra) {
        this.idNota = idNota;
        this.compra = compra;
    }

    public String getIdNota() {
        return idNota;
    }

    public void setIdNota(String idNota) {
        this.idNota = idNota;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    
}


