/**
 *
 * @author Grupo Optimus
 */

package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;							   
import java.util.TreeMap;
import logica.Producto;
import java.lang.System;

/*Clase de gestion de base de datos de productos- Consulta la informacion (Read-Leer-) y 
Envia la informacion para archivar(Inserta información nueva -Create- o Actualiza -Update-). */

public class ProductoDAO {
    
    //Este método realiza la consulta a la base de datos de productos	   
    public ArrayList<Producto> consultarProductos() {
        ArrayList<Producto> lista = new ArrayList<>();
        ConexionBD con = new ConexionBD();
        String sql = "SELECT idProducto, NombreProducto, idTipoReferencia, diametromin, diametromax, "
                + "largomin, largomax, alto, pesomin, pesomax FROM producto ";
	ResultSet rs = con.ejecutarQuery(sql);									  
        try {
            while (rs.next()) {
                int idProducto = rs.getInt("idProducto");
                String NombreProducto = rs.getString("NombreProducto");
                int idTipoReferencia = rs.getInt("idTipoReferencia");
                float diametromin = rs.getFloat("diametromin");
                float diametromax = rs.getFloat("diametromax");
                float largomin = rs.getFloat("largomin");
                float largomax = rs.getFloat("largomax");
                float alto = rs.getFloat("alto");
                float pesomin = rs.getFloat("pesomin");
                float pesomax = rs.getFloat("pesomax");
                Producto p = new Producto(idProducto, NombreProducto, idTipoReferencia, diametromin, diametromax, largomin, largomax, alto, pesomin, pesomax);			   		   
                lista.add(p);
            }
        } catch (SQLException ex) {						  
			con.desconectar();				  
            return null;
        }
        con.desconectar();				  
        return lista;
    }
    
	   
    //Envía la sentencia SQL para obtener la información de 1 producto específico y estructura
    public Producto consultarProducto(int idAConsultar) {
        Producto p = null;
        ConexionBD con = new ConexionBD();
        String sql = "SELECT idProducto, NombreProducto, idTipoReferencia, diametromin, diametromax, " +
                     "largomin, largomax, alto, pesomin, pesomax FROM producto"+
                     "WHERE idProducto = " + idAConsultar + " ";
        ResultSet rs = con.ejecutarQuery(sql);
        try {
            if (rs.next()) {
                int idProducto = rs.getInt("idProducto");
                String NombreProducto = rs.getString("NombreProducto");
                int idTipoReferencia = rs.getInt("idTipoReferencia");
                float diametromin = rs.getFloat("diametromin");
                float diametromax = rs.getFloat("diametromax");
                float largomin = rs.getFloat("largomin");
                float largomax = rs.getFloat("largomax");
                float alto = rs.getFloat("alto");
                float pesomin = rs.getFloat("pesomin");
                float pesomax = rs.getFloat("pesomax");
                p = new Producto(idProducto, NombreProducto, idTipoReferencia, diametromin, diametromax, largomin, largomax, alto, pesomin, pesomax);
            }
        } catch (SQLException ex) {
            con.desconectar();
            return p;
        }
        con.desconectar();
        return p;
    }

	   
    // Consultar producto teniendo mediante filtro y estructura
    public ArrayList<Producto> consultarProductoPorFiltro(String filtro) {
        ArrayList<Producto> lista = new ArrayList<>();
        ConexionBD con = new ConexionBD();
        String sql = "SELECT p.idProducto, p.NombreProducto,p.idTipoReferencia, t.Referencia,p.diametromin, p.diametromax, p.largomin, p.largomax, p.alto, p.pesomin,p.pesomax  " +
                     "FROM producto p " +
                     "JOIN tiporeferencia t ON (p.idTipoReferencia = t.idTipoReferencia) " +
                     "WHERE p.NombreProducto LIKE '%" + filtro + "%' " +
                     "OR t.Referencia LIKE '%" + filtro + "%' ";
        ResultSet rs = con.ejecutarQuery(sql);
        try {
            while (rs.next()) {
                int idProducto = rs.getInt("idProducto");
                String NombreProducto = rs.getString("NombreProducto");
                int idTipoReferencia = rs.getInt("idTipoReferencia");
                float diametromin = rs.getFloat("diametromin");
                float diametromax = rs.getFloat("diametromax");
                float largomin = rs.getFloat("largomin");
                float largomax = rs.getFloat("largomax");
                float alto = rs.getFloat("alto");
                float pesomin = rs.getFloat("pesomin");
                float pesomax = rs.getFloat("pesomax");
                Producto p = new Producto(idProducto, NombreProducto, idTipoReferencia, diametromin, diametromax, largomin, largomax, alto, pesomin, pesomax);
                lista.add(p);
            }
        } catch (SQLException ex) {
            con.desconectar();
            return null;
        }
        con.desconectar();
        return lista;
    }

    //Metodo para Insertar nuevo producto (Create)
    public int guardarNuevoProducto(Producto p) {																				   
        ConexionBD con = new ConexionBD();
        String NombreProducto = p.getNombreProducto();
        int idTipoReferencia = p.getIdTipoReferencia();
        float diametromin = p.getDiametromin();
        float diametromax = p.getDiametromax();
        float largomin = p.getLargomin();
        float largomax = p.getLargomax();
        float alto = p.getAlto();
        float pesomin = p.getPesomin();
        float pesomax = p.getPesomax();
        String sql = "INSERT INTO `dboptimus`.`producto`(NombreProducto,idTipoReferencia,diametromin,diametromax,largomin,largomax,alto,pesomin,pesomax)" + 
                     "VALUES('"+NombreProducto+"',"+idTipoReferencia+","+diametromin+","+diametromax+","+largomin+"," + largomax+","+alto+","+pesomin+","+pesomax+" ) ";       
        ResultSet rs = con.ejecutarInsert(sql); //se verifico el insert en la base de datos, ok.
        int id = 0;                       
        try {
            if (rs.next()){
                id = rs.getInt(1);             //Posible error en esta instrucción
            }
        } catch (SQLException ex) {            //bug capturado por esta instrucción - no ha pasado la prueba unitaria
            con.desconectar();
            return 0; 
        }
        con.desconectar();
        return id;
    }
    
	   
   //Consulta los diferentes tipos referencia de producto desde la BD
																 
	   
    public TreeMap<Integer, String> cargarTiposReferencia() {
        TreeMap<Integer, String> listaTipos = new TreeMap<Integer, String>();
        ConexionBD con = new ConexionBD();
        ResultSet rs = con.ejecutarQuery("SELECT idTipoReferencia, Referencia FROM tiporeferencia");
        try {
            while (rs.next()) {
                int id = rs.getInt("idTipoReferencia");
                String tipo = rs.getString("Referencia");
                listaTipos.put(id, tipo);
            }
        } catch (SQLException ex) {
            con.desconectar();
            return null;
        }
        con.desconectar();
        return listaTipos;
    }
    
    
    //Almacenar los productos existentes
        public int guardarProductoExistente(Producto p) {
        ConexionBD con = new ConexionBD();
        int idProducto = p.getIdProducto();
        String NombreProducto = p.getNombreProducto();
        int idTipoReferencia = p.getIdTipoReferencia();
        float diametromin = p.getDiametromin();
        float diametromax = p.getDiametromax();
        float largomin = p.getLargomin();
        float largomax = p.getLargomax();
        float alto = p.getAlto();
        float pesomin = p.getPesomin();
        float pesomax = p.getPesomax();
        String sql = "UPDATE producto"+
                     "SET NombreProducto = '" + NombreProducto + "' , idTipoReferencia= " + idTipoReferencia + " , diametromin = " + diametromin + 
                     " , diametromax= " + diametromax + " , largomin = " + largomin + ", largomax = " + largomax + ", alto = " + alto + 
                     ", pesomin= " + pesomin + " , pesomax = " + pesomax + " "+
                     "WHERE idProducto = " + idProducto + " ";
        int filas = con.ejecutarUpdate(sql);
        con.desconectar();
        return filas;
    }
}					 