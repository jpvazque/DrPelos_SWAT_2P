/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directivo_vista;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Robert Moreno
 */
public class Menu_buscarController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML 
    private Button serviciosBtn;
    @FXML 
    private Button usuariosBtn;
    @FXML 
    private Button productosBtn;
    @FXML 
    private Button documentoBtn;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    @FXML
    private void presionar_serviciosBtn(ActionEvent event) {
        System.out.println("Servicios");
    }
    @FXML
    private void presionar_usuariosBtn(ActionEvent event) throws IOException {
        System.out.println("Usuarios");
        consultar(event, "Consultar_clientesGUI.fxml");
    }
    @FXML
    private void presionar_productosBtn(ActionEvent event) throws IOException {
        System.out.println("Productos");
        consultar(event, "Consultar_productosGUI.fxml");
       
    }
    @FXML
    private void presionar_documentosBtn(ActionEvent event) {
        System.out.println("Documentos");
    } 
    
    private void consultar(ActionEvent event,String FXMLFileName) throws IOException{
        Parent registroEstudiante = FXMLLoader.load(getClass().getResource(FXMLFileName));
        Scene registroEstudianteScene = new Scene(registroEstudiante);
        Stage windows = (Stage) ((Node) event.getSource()).getScene().getWindow();
        windows.setScene(registroEstudianteScene);
        windows.show(); 
        
    }
    public Parent getParent() throws IOException {
        return FXMLLoader.load(getClass().getResource("Menu_buscarGUI.fxml"));
    }
}
