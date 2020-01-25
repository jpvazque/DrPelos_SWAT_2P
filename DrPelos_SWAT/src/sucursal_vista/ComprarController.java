/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sucursal_vista;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
    

      
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        subtotalLbl.setText("$0.00");
        ivaLbl.setText("$0.00");
        totalLbl.setText("$0.00");
        productosTv.setPlaceholder(new Label("No hay resultados que coincidan con los criterios de búsqueda")); 
        comprasTv.setPlaceholder(new Label("No hay resultados que coincidan con los criterios de búsqueda")); 
    }    
    @FXML
    public void presionar_agregarBtn(){
        String cantidad = cantidadTf.getText();
        try{
            Integer.parseInt(cantidad);
            System.out.println("Agregar");
        }catch(NumberFormatException nfe){
            System.out.println("Debe ingresar una cantidad válida");

        }

    }
    @FXML
    public void filtrar(){
        System.out.println("Filtrar");
    }    
    
    @FXML
    public void generar_factura(){
        System.out.println("Generar Factura");
    } 
    @FXML
    public void generar_cotizacion(){
        System.out.println("Generar cotizacion");
    } 
}
