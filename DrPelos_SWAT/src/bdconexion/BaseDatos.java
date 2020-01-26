/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bdconexion;

    import java.sql.CallableStatement;
    import java.sql.Connection;
    import java.sql.Date;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    import java.time.LocalDate;
    import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import modelo.Producto;

    public class BaseDatos {

        // Librer�a de MySQL
        private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
        
        // Datos de la BD
        private static final String DB = "dr_pelos";
        private static final String HOST = "localhost"; 
        //private static final String LOCAL = "192.168.136.54";
        private static final String PUERTO = "3306";

        private static final String URL = "jdbc:mysql://" + HOST + ":" + PUERTO + "/" + DB
                + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        // Datos del usuario de la BD
        
        
        private static String usuario = "root";
        private static String password = "root";

        public static Connection conectarMySQL() throws SQLException {
            Connection conn = null;

            try {
                Class.forName(DRIVER);
                conn = DriverManager.getConnection(URL,usuario,password);
            } catch (ClassNotFoundException | SQLException e) {
                throw new SQLException("Ha ocurrido un error" + e.getMessage());
            }

            return conn;
        }

        private static ResultSet seleccionarDatos(String query, Connection conn) throws SQLException {
            if (conn == null) {
                throw new SQLException("Conexi�n con la base de datos fallida.\n Compruebe autentificaci�n o"
                        + "Driver de conexi�n.");
            }
            //create the java statement
            Statement st = null;
            ResultSet rs = null;
            try {
                st = conn.createStatement();
            } catch (SQLException ex) {
                throw new SQLException("La base de datos se desconect� inesperadamente.");
            }

            try {
                // execute the query, and get a java resultset
                rs = st.executeQuery(query);
            } catch (SQLException ex) {
                throw new SQLException("la Consulta no fue exitosa.\nInt�ntelo m�s tarde. " + ex.getMessage());
            }
            return rs;
        }

        public static void insertarCliente(String cedula, String nombre, String direccion,String telefono,
                String correo) throws SQLException {
        	
            /**hacerQuery("CREATE USER " + cedula + " IDENTIFIED BY '" + contrasena + "'");*/
        	
            String sql_process_order = "{call agregar_cliente(?,?,?,?,?)}";
            Connection conn = conectarMySQL();

            if (conn == null) {
                throw new SQLException("Conexion fallida");
            }

            CallableStatement cl = conn.prepareCall(sql_process_order);
            cl.setString(1, cedula);
            cl.setString(2, nombre);
            cl.setString(3, direccion);
            cl.setString(4, telefono);
            cl.setString(5, correo);
            cl.execute();
            cerrarConexion(conn);
        }

        
        private static void cerrarConexion(Connection conn) throws SQLException {
            try {
                conn.close();
            } catch (SQLException ex) {
                throw new SQLException("Fallo al cerrar conexion a base de datos");
            }
        }

        public static void hacerQuery(String query) throws SQLException {
            Connection conn = conectarMySQL();
            if (conn == null) {
                throw new SQLException("Conexion fallida");
            }

            CallableStatement cl = conn.prepareCall(query);
            cl.execute();
        }
        
        
        
        public static List<Producto> obtenerProductos() throws SQLException {
            //Instancia de la clase ConexionBD
            Connection conn = conectarMySQL();
            Statement sql = conn.createStatement();
            String s = "call productos_nombre('',1)";
            
            ResultSet rs = sql.executeQuery(s);
            
            List<Producto> productos = new LinkedList<>();
            if (rs == null) {
                throw new SQLException("Productos no encontrados.\nIntentelo mas tarde. ");
            }
            while(rs.next()){
                productos.add(obtenerProd(rs));
            }

            cerrarConexion(conn);
            return productos;
        }
        
        private static Producto obtenerProd(ResultSet rs) throws SQLException {
            
            String codigo = rs.getString("producto_id");
            String nombre = rs.getString("nombre");
            String cat = rs.getString("categoria");
            String des = rs.getString("descripcion");
            float costo = rs.getFloat("precio");
            Producto p = new Producto(codigo,nombre,cat, des, costo);
            return p;
        }
        /**
        
        public static void insertarHistorial(String cedula, String nombrePat, String obser) throws SQLException {
            int id_pat = obtenerPatologia1(nombrePat);
            System.out.println("dsfsdg");
            String sql_process_order = "{call insertHistorial(?,?,?)}";
            Connection conn = conectarMySQL();
            
            if (conn == null) {
                throw new SQLException("Conexion fallida");
            }
            
           
            
            CallableStatement callableS = conn.prepareCall(sql_process_order);
            callableS.setString(1, cedula);
            callableS.setInt(2, id_pat);
            callableS.setString(3, obser);
            callableS.execute();
            cerrarConexion(conn);
        }
        
        public static void insertarReceta(String cedulaPac, String cedulaDoc, String id_medicina, String frecuencia, String dosis) throws SQLException {
            
            String sql_process_order = "{call insertReceta(?,?,?,?,?)}";
            Connection conn = conectarMySQL();
            
            if (conn == null) {
                throw new SQLException("Conexion fallida");
            }
            
            int id_med = Integer.valueOf(id_medicina);
            
            CallableStatement callableS = conn.prepareCall(sql_process_order);
            callableS.setString(1, cedulaPac);
            callableS.setString(2, cedulaDoc);
            callableS.setInt(3, id_med);
            callableS.setString(4, frecuencia);
            callableS.setString(5, dosis);
            callableS.execute();
            cerrarConexion(conn);
        }
        
        
        public static List<Doctor> obtenerDoctores() throws SQLException {
            //Instancia de la clase ConexionBD
            Connection conn = conectarMySQL();
            List<Doctor> doctores = new LinkedList<>();
            ResultSet rs = seleccionarDatos("SELECT * FROM centro_dermatologico.reportedoc", conn);

            if (rs == null) {
                throw new SQLException("Doctores no encontrado.\nInt�ntelo m�s tarde. ");
            }
            while (rs.next()) {
                doctores.add(obtenerDoctor(rs));
            }

            cerrarConexion(conn);
            return doctores;
        }

        public static List<Farmaceutico> obtenerFarmas() throws SQLException {
            //Instancia de la clase ConexionBD
            Connection conn = conectarMySQL();
            List<Farmaceutico> farmas = new LinkedList<>();
            ResultSet rs = seleccionarDatos("SELECT * FROM centro_dermatologico.reportefarma", conn);

            if (rs == null) {
                throw new SQLException("Farmac�uticos no encontrados.\nInt�ntelo m�s tarde. ");
            }
            while (rs.next()) {
                farmas.add(obtenerFarma(rs));
            }

            cerrarConexion(conn);
            return farmas;
        }

        public static List<Operador> ObtenerOperadores() throws SQLException {
            //Instancia de la clase ConexionBD
            Connection conn = conectarMySQL();
            List<Operador> operadores = new LinkedList<>();
            ResultSet rs = seleccionarDatos("SELECT * FROM `Operador`", conn);

            if (rs == null) {
                throw new SQLException("Operadores no encontrado.\nInt�ntelo m�s tarde. ");
            }
            while (rs.next()) {
                operadores.add(obtenerOperador(rs));
            }

            cerrarConexion(conn);
            return operadores;
        }

        private static Patologia obtenerPatologia(ResultSet rs) throws SQLException{
            
            String nombre_pat = rs.getString("nombre_pat");
            String desc_pat = rs.getString("descripcion");
            
            Patologia p = new Patologia(nombre_pat,desc_pat);
            return p;
        }
        
        private static int obtenerPatologia1(String nombre) throws SQLException{
            Connection conn = conectarMySQL();
            int id_pat;
            ResultSet rs = seleccionarDatos("SELECT Id_Patologia FROM centro_dermatologico.patologias WHERE nombre = '" + nombre + "'", conn);

            if (rs == null) {
                throw new SQLException("Patolog�a no encontrada.\nInt�ntelo m�s tarde. ");
            }
            rs.next();
            id_pat = rs.getInt("Id_Patologia");
            cerrarConexion(conn);
            return id_pat;
        }
        
        public static Usuario buscarUsuario(String username, String contrasena) throws SQLException {
            Usuario u = null;
            Connection conn = conectarMySQL();
            String query = "SELECT u.cedula, u.tipo FROM `usuario` u Where cedula = '" + username
                    + "' AND contrasena = '" + contrasena + "'";

            ResultSet rs = seleccionarDatos(query, conn);

            if (rs == null || rs.isClosed() || !rs.next()) {
                throw new SQLException("Usuario no encontrado.\nInt�ntelo m�s tarde. ");
            }

            String cedula = rs.getString("cedula");
            int tipo = rs.getInt("tipo");

            switch (tipo) {
                case 0:
                    u = new Administrador("Admin", "", cedula, "", "");
                    break;
                case 1:
                    query = "SELECT * FROM `farmaceutico` Where cedula = '" + cedula + "'";
                    rs = seleccionarDatos(query, conn);
                    rs.next();
                    u = obtenerFarma(rs);
                    break;
                case 2:
                    query = "SELECT * FROM `doctor` Where cedula = '" + cedula + "'";
                    rs = seleccionarDatos(query, conn);
                    rs.next();
                    u = obtenerDoctor(rs);
                    break;
                case 3:
                    query = "SELECT * FROM `operador` Where cedula = '" + cedula + "'";
                    rs = seleccionarDatos(query, conn);
                    rs.next();
                    u = obtenerOperador(rs);
                    break;
            }
            ConexionBD.usuario = username;
            ConexionBD.password = contrasena;
            cerrarConexion(conn);
            return u;
        }

        public static List<Cita> buscarCitaDeDoc(Doctor d) throws SQLException {
            List<Cita> citas = new LinkedList<>();

            String sql_process_order = "{call buscarPacienteDoc(?)}";
            Connection conn = conectarMySQL();

            if (conn == null) {
                throw new SQLException("Conexion fallida");
            }

            CallableStatement cl = conn.prepareCall(sql_process_order);
            cl.setString(1, d.getCedula());
            ResultSet rs = cl.executeQuery();
            while (rs.next()) {
                Paciente p = obtenerPaciente(rs);
                Cita c = obtenerCita(rs, p, d);
                citas.add(c);
            }
            cerrarConexion(conn);

            return citas;
        }

        public static List<Cita> obtenerCitas() throws SQLException {
            //Instancia de la clase ConexionBD
            Connection conn = conectarMySQL();
            List<Cita> citas = new LinkedList<>();
            ResultSet rs = seleccionarDatos("SELECT * FROM centro_dermatologico.reporteCitas", conn);

            if (rs == null) {
                throw new SQLException("Doctores no encontrado.\nInt�ntelo m�s tarde. ");
            }
            while (rs.next()) {
                citas.add(obtenerCita(rs));
            }

            cerrarConexion(conn);
            return citas;
        }
        
        public static List<Paciente> obtenerPacientes() throws SQLException{
             //Instancia de la clase ConexionBD
            Connection conn = conectarMySQL();
            List<Paciente> pacientes = new LinkedList<>();
            ResultSet rs = seleccionarDatos("SELECT * FROM centro_dermatologico.reportePacientes", conn);

            if (rs == null) {
                throw new SQLException("Doctores no encontrado.\nInt�ntelo m�s tarde. ");
            }
            while (rs.next()) {
                pacientes.add(obtenerPaciente(rs));
            }

            cerrarConexion(conn);
            return pacientes;
        }
        
        public static List<Historial_Medico> buscarHistorial(String id) throws SQLException{
            List<Historial_Medico> historial = new LinkedList<>();
            
            String sql_process_order = "{call buscarHistorialPac(?)}";
            Connection conn = conectarMySQL();

            if (conn == null) {
                throw new SQLException("Conexion fallida");
            }

            CallableStatement cl = conn.prepareCall(sql_process_order);
            cl.setString(1, id);
            ResultSet rs = cl.executeQuery();
            
            while(rs.next()){
                Paciente p = obtenerPaciente(rs);
                Patologia pt = obtenerPatologia(rs);
                Historial_Medico hm = new Historial_Medico(p,pt,rs.getString("observaciones"));
                historial.add(hm);
            }
            cerrarConexion(conn);
            return historial;
        }

        private static Doctor obtenerDoctor(ResultSet rs) throws SQLException {
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String cedula = rs.getString("cedula");
            String mail = rs.getString("correo");
            String phone = rs.getString("Telefono");
            LocalDate date1 = LocalDate.parse(rs.getString("Fecha_Ingreso"));
            LocalTime hour1 = LocalTime.parse(rs.getString("Hora_Ingreso"));
            LocalTime hour2 = LocalTime.parse(rs.getString("Hora_Salida"));
            String specialty = rs.getString("Especialidad");
            String charge = rs.getString("Cargo");
            Doctor d = new Doctor(nombre, apellido, cedula, mail, null, phone,
                    date1, hour1, hour2, specialty, charge);
            return d;
        }

        private static Farmaceutico obtenerFarma(ResultSet rs) throws SQLException {
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String cedula = rs.getString("cedula");
            String mail = rs.getString("correo");

            Farmaceutico f = new Farmaceutico(nombre, apellido, cedula, mail, "");
            return f;
        }

        private static Operador obtenerOperador(ResultSet rs) throws SQLException {
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String cedula = rs.getString("cedula");
            String mail = rs.getString("correo");

            Operador o = new Operador(nombre, apellido, cedula, mail, "");
            return o;
        }

        private static Paciente obtenerPaciente(ResultSet rs) throws SQLException {
            String nombre = rs.getString("Nombre");
            String apellido = rs.getString("Apellido");
            String cedula = rs.getString("Cedula");
            String direccion = rs.getString("Direccion");
            String phone = rs.getString("Telefono");
            Paciente p = new Paciente(nombre, apellido, cedula, direccion, phone);
            return p;
        }

        private static Cita obtenerCita(ResultSet rs, Paciente p, Doctor d) throws SQLException {
            String idC = Integer.toString(rs.getInt("Id_cita"));
            LocalDate date = LocalDate.parse(rs.getString("fecha"));
            LocalTime hour = LocalTime.parse(rs.getString("hora"));
            String color = rs.getString("color");
            ColorCita cc;

            if (color.equalsIgnoreCase("rojo")) {
                cc = ColorCita.ROJO;
            } else if (color.equalsIgnoreCase("amarillo")) {
                cc = ColorCita.AMARILLO;
            } else {
                cc = ColorCita.VERDE;
            }

            Cita c = new Cita(idC,p, d, date, hour, cc); // new Paciente(nombre, apellido, cedula, direccion, phone);
            return c;
        }

         private static Cita obtenerCita(ResultSet rs) throws SQLException{
            String nombrep = rs.getString("nombreP");
            String apellidop = rs.getString("apellidoP");
            String cedulap = rs.getString("cedulaP");
            Paciente p = new Paciente(nombrep, apellidop, cedulap,"", "");
            
            String nombre = rs.getString("nombreD");
            String apellido = rs.getString("apellidoD");
            String cedula = rs.getString("cedulaD");
            
            Doctor d = new Doctor(nombre, apellido, cedula, "", null, "",
                    null, null, null, "", "");
            
            return obtenerCita(rs, p, d);
         }
        
        

        public static void reiniciarUsuario() {
            usuario = "InicioSesion";
            password = "bAs3DAT0s";
        }
    }
**/
    
}


