/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directivo_vista;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Robert Moreno
 */
public class Consultar_productosController implements Initializable {
    @FXML 
    private Button filtrarBtn;
    @FXML 
    private Button limpiarBtn;
    @FXML
    private TextField idTf;
    @FXML
    private TextField nombreTf;
    @FXML
    private ComboBox categoriaCb;
    @FXML
    private TableView<String> tableView;
    @FXML
    private Button regresarBtn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        llenar_categoriaCb();
        
        tableView.setPlaceholder(new Label("No hay resultados que coincidan con los criterios de búsqueda".toUpperCase())); 
    }  
    
    private void llenar_categoriaCb(){
        Collection<String> categorias = new ArrayList();
        categorias.add("Categoria 1");
        categorias.add("Categoria 2");
        categorias.add("Todas las Categor�as");
        categoriaCb.getItems().addAll(categorias);
        categoriaCb.setValue("Todas las Categorias");
             
        
    }
    @FXML
    private void presionar_limpiarBtn(ActionEvent event) {
        System.out.println("Limpiar");
        idTf.setText("");
        nombreTf.setText("");
        categoriaCb.setValue("Todas las Categorias");
    }   

    @FXML
    private void filtrar(Event event){
        System.out.println("Filtrar");
        
    }
    
    @FXML
    private void presionar_regresarBtn(ActionEvent event) throws IOException{
        Parent registroEstudiante = FXMLLoader.load(getClass().getResource("Menu_buscarGUI.fxml"));
        Scene registroEstudianteScene = new Scene(registroEstudiante);
        Stage windows = (Stage) ((Node) event.getSource()).getScene().getWindow();
        windows.setScene(registroEstudianteScene);
        windows.show(); 
        
    }


    
}
