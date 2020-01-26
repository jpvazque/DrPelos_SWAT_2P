/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sucursal_vista;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        this.mostrarAlerta();
        /**
        if (this.cedulaTf.getText()!=""){
            this.nombreTf.setText("Robert");
            this.cedulaGuardada= this.cedulaTf.getText();
            revisar_estado();
        }
        */
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
        this.generar_facturaBtn.setDisable(true);
        if (tarjetaChB.isSelected() || efectivoChB.isSelected()) {
        	this.generar_facturaBtn.setDisable(false);
        }
        else 
        	this.generar_facturaBtn.setDisable(true);
        
    }
    public Parent getParent() throws IOException {
        return FXMLLoader.load(getClass().getResource("AgregarInformacionCompra.fxml"));
    }
    
    @FXML
    private void seleccionarEfectivoChB(Event event) {
    	tarjetaChB.setSelected(false);
        this.revisar_estado();
    }
    @FXML
    private void seleccionarTarjetaChB(Event event) {
    	efectivoChB.setSelected(false);
        this.revisar_estado();
    }
    
    private void mostrarAlerta(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cliente no registrado");
        alert.setHeaderText("No se encontró un cliente registrado con ese número de cédula");
        alert.setContentText("¿Desea agregar un nuevo cliente?");
        ButtonType okBtn = new ButtonType("OK");
        ButtonType intentatBtn = new ButtonType("Intentar nuevamente");
        alert.getButtonTypes().setAll(okBtn);
        Optional<ButtonType> result =alert.showAndWait();
        if((result.get()==okBtn)){
            abrirVentana("AgregarClienteGUI.fxml");
        }
        
    }

    
    public void abrirVentana(String archivoFXML){
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(archivoFXML));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
        
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AgregarClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}