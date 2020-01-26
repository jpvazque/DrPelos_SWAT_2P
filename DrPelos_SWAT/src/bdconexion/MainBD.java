package bdconexion;

import java.sql.SQLException;

public class MainBD {

	
	public static void main(String[] args) {
		
            try {
                    //BaseDatos.conectarMySQL();
                    BaseDatos.insertarCliente("0987654321", "Robert Moreno", "asghdyj", "6345789", "rodemore@espol.edu.ec");

            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    System.out.println(e.getMessage());
            }

		
		
	}
	
}
