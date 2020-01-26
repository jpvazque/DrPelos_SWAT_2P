/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sucursal_vista;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
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
public class ComprarController implements Initializable {
    @FXML 
    private Button agregarBtn;
    @FXML
    private TextField idTf;
    @FXML
    private TextField nombreTf;
    @FXML
    private TextField cantidadTf;

    @FXML 
    private Button generar_facturaBtn;
    @FXML 
    private Button generar_cotizacionBtn;
    
    @FXML
    private Label subtotalLbl;
    @FXML
    private Label ivaLbl;
    @FXML
    private Label totalLbl;
    @FXML 
    private TableView productosTv;
    @FXML 
    private TableView comprasTv;
    @FXML
    private ComboBox categoriaCb;
    @FXML
    private ComboBox<String> tipoCb;
    @FXML
    private Label labelTipo;

      
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        subtotalLbl.setText("$0.00");
        ivaLbl.setText("$0.00");
        totalLbl.setText("$0.00");
        productosTv.setPlaceholder(new Label("No hay resultados que coincidan con los criterios de busqueda")); 
        comprasTv.setPlaceholder(new Label("No hay resultados que coincidan con los criterios de busqueda")); 
        llenar_categoriaCb();
	    Collection<String> busquedasPor = new ArrayList<String>();
	    busquedasPor.add("Servicio");
	    busquedasPor.add("Producto");
	    tipoCb.getItems().addAll(busquedasPor);
	    tipoCb.setValue("Producto");
         
    }    
    @FXML
    public void presionar_agregarBtn(){
        String cantidad = cantidadTf.getText();
        try{
            Integer.parseInt(cantidad);
            System.out.println("Agregar");
        }catch(NumberFormatException nfe){
            System.out.println("Debe ingresar una cantidad v�lida");

        }

    }
    @FXML
    public void filtrar(){
        System.out.println("Filtrar");
    }    
    
    @FXML
    public void generar_factura(ActionEvent event) throws IOException{
        System.out.println("Generar Factura");
        Parent registroEstudiante = FXMLLoader.load(getClass().getResource("AgregarInformacionCompraGUI.fxml"));
        Scene registroEstudianteScene = new Scene(registroEstudiante);
        Stage windows = (Stage) ((Node) event.getSource()).getScene().getWindow();
        windows.setScene(registroEstudianteScene);
        windows.show(); 
        
        
    } 
    @FXML
    public void generar_cotizacion(){
        System.out.println("Generar cotizacion");
    }
  
    private void llenar_categoriaCb(){
	    Collection<String> categorias = new ArrayList();
	    categorias.add("Categor�a 1");
	    categorias.add("Categor�a 2");
	    categorias.add("Todas las Categor�as");
	    categoriaCb.getItems().addAll(categorias);
	    categoriaCb.setValue("Todas las Categor�as");
         
    }
    
    @FXML
    private void cambiarBuscarPor(ActionEvent e){
    	System.out.println("Cambiar");
    	boolean esProducto = tipoCb.getValue().equals("Producto");
    	if (esProducto) {
    		labelTipo.setText("Productos disponibles");
    	}else {
    		labelTipo.setText("Servicios disponibles");
    	}
         
    }
    @FXML
    private void cambiarCategoria(ActionEvent e){
    	boolean todasCat = tipoCb.getValue().equals("Todas las Categor�as");
    	if (todasCat) {
    		labelTipo.setText("Productos disponibles");
    	}else {
    		labelTipo.setText("Servicios disponibles");
    	}
    }
    

}
