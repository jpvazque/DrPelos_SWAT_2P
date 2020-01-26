/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sucursal_vista;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Robert Moreno
 */
public class AgregarClienteController implements Initializable {

    @FXML private TextField cedulaTf;
    @FXML private TextField nombreTf;
    @FXML private TextField telefonoTf;
    @FXML private TextField direccionTf;
    @FXML private TextField correoTf;
    @FXML private Label alertaLbl;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        alertaLbl.setText("");
    }    
    @FXML
    private void revisar_estado(ActionEvent event){
        boolean cedula_ok = cedulaTf.getText().length()<=10 && cedulaTf.getText().length()>=5;
        boolean nombre_ok = nombreTf.getText().length()>=5;
        boolean telefono_ok = telefonoTf.getText().length()>=5;
        boolean direccion_ok = direccionTf.getText().length()>=5;
        boolean correo_ok = correoTf.getText().length()>=5 && correoTf.getText().contains("@") && correoTf.getText().contains(".");

        if (!cedula_ok){
            alertaLbl.setText("Ingrese un cedula valida");
        }
        else if (!nombre_ok){
            alertaLbl.setText("Ingrese un nombre valida");
        }
        else if (!direccion_ok){
            alertaLbl.setText("Ingrese una direccion valida");
        }
        else if (!correo_ok){
            alertaLbl.setText("Ingrese un correo con un formato valido");
        }
        else if (!telefono_ok){
            alertaLbl.setText("Ingrese un numero de telefono valido");
        }


        else {
            alertaLbl.setText("");
            crearUsuario();
        }
        
    }
    private void crearUsuario(){
        System.out.println("Crear usuario");
    }
    
    
}





















