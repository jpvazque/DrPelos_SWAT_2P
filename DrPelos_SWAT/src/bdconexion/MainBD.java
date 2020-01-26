package bdconexion;

import java.sql.SQLException;
import java.util.List;
import modelo.Producto;

public class MainBD {

	
	public static void main(String[] args) {
		
            try {
                    //BaseDatos.conectarMySQL();
                    //BaseDatos.insertarCliente("0987654321", "Robert Moreno", "asghdyj", "6345789", "rodemore@espol.edu.ec");
                    List<Producto> prods = BaseDatos.obtenerProductos();
                    System.out.println(prods);
                    
            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    System.out.println(e.getMessage());
            }

		
		
	}
	
}
