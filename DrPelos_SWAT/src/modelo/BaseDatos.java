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
public class BaseDatos {
    String hostRemoto;
    String hostLocal;

    public BaseDatos(String hostRemoto, String hostLocal) {
        this.hostRemoto = hostRemoto;
        this.hostLocal = hostLocal;
    }

    public String getHostRemoto() {
        return hostRemoto;
    }

    public void setHostRemoto(String hostRemoto) {
        this.hostRemoto = hostRemoto;
    }

    public String getHostLocal() {
        return hostLocal;
    }

    public void setHostLocal(String hostLocal) {
        this.hostLocal = hostLocal;
    }
    
}


