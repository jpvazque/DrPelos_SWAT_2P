/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sucursal_vista;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Robert Moreno
 */
public class AgregarInformacionCompraController implements Initializable {

    @FXML private TextField fechaTf;
    @FXML private TextField cedulaTf;
    @FXML private TextField nombreTf;
    @FXML private Button buscar_cedulaBtn;
    @FXML private Button generar_cotizacionBtn;
    @FXML private Button generar_facturaBtn;
    private String cedulaGuardada = "";
    @FXML private CheckBox efectivoChB;
    @FXML private CheckBox tarjetaChB;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nombreTf.setText("");
        fechaTf.setText(LocalDate.now().toString().replace("-", "/"));
        revisar_estado();

    }    
    
    @FXML
    public void buscar_usuario(ActionEvent e){
        System.out.println("Buscar Usuario");
        if (this.cedulaTf.getText()!=""){
            this.nombreTf.setText("Robert");
            this.cedulaGuardada= this.cedulaTf.getText();
            revisar_estado();
        }
    }
    @FXML
    private void controlar_campo_cedula(Event e){
        if (this.nombreTf.getText() !="" && this.cedulaTf.getText()!=cedulaGuardada){
            this.nombreTf.setText("");
            this.efectivoChB.setSelected(false);
            this.tarjetaChB.setSelected(false);
            revisar_estado();
        }

        
    }
    
    private void revisar_estado(){
        
        boolean habilitado = nombreTf.getText().equals("");
        this.generar_cotizacionBtn.setDisable(habilitado);
        this.efectivoChB.setDisable(habilitado);
        this.tarjetaChB.setDisable(habilitado);
        
        

        
    }

    
}
