/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;


import directivo_vista.Menu_buscarController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Robert Moreno
 */
public class LoginController implements Initializable {

    
    @FXML
    private Button loginBtn;
    
    @FXML
    private TextField usuarioTf;
    @FXML
    private PasswordField contraseniaPf;
    @FXML
    private Label messageLbl;
    @FXML
    private Label tipoUsuarioLbl;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.messageLbl.setText("");
    }   
    
    @FXML
    public void presionar_login(ActionEvent e) throws IOException{
        System.out.println(usuarioTf.getText());
        System.out.println(contraseniaPf.getText());
        ir_a_menu_directivos(e);
    }
    
    
    public void ir_a_menu_directivos(ActionEvent event) throws IOException{

        System.out.println("Al menú de consultas");
        Parent escenario = (new Menu_buscarController()).getParent();
        Scene escenarioScene = new Scene(escenario);
        Stage windows = (Stage) ((Node) event.getSource()).getScene().getWindow();
        windows.setScene(escenarioScene);
        windows.show();
    }
    
}
