/**
 *														
 * @author Bizagi
 */

package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//Conexion base de datos
public class ConexionBD {
    private String conectorInstalado = "jdbc:mysql:";
    private String host = "localhost:3306";
    private String baseDatos = "dboptimus";
    private String username = "root"; 
    private String password = "root"; //Puede variar según la base de datos local										
    private Connection conexion;
    private Statement ejecutor;

    //Acá se conecta la base de datos - Hay prueba unitaria para verificar
    public ConexionBD() {
        conectar();
    }
	
    public boolean isConectado(){
        return (this.conexion != null);
    }
	
    public void conectar(){
        try{		 
            String cadenaConexion = conectorInstalado + "//" + host + "/" + baseDatos;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(cadenaConexion, username, password);
            ejecutor = conexion.createStatement();
																	
            ejecutor.setQueryTimeout(30);
			ejecutor.setQueryTimeout(30);	
		}
        catch(Exception e){ 
            e.printStackTrace();
        }  
    }   
	
    public ResultSet ejecutarQuery(String sql){
        ResultSet rs = null;
        try{
            rs = ejecutor.executeQuery(sql);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }
	 
	public ResultSet ejecutarInsert(String sql) {
        ResultSet rs = null;
        try{
            int cant = ejecutor.executeUpdate(sql);

            if (cant > 0) {
                rs = ejecutor.getGeneratedKeys();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

   public int ejecutarUpdate(String sql) {
        int cant = 0;
        try{
            cant = ejecutor.executeUpdate(sql);	 
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return cant;
    }
	
    public void desconectar(){
        try{
            conexion.close();
            conexion = null;
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}