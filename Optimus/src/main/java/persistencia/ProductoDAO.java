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

/*Clase de gestion de base de datos de productos- Consulta la informacion (Read-Leer-) y 
Envia la informacion para archivar(Inserta información nueva -Create- o 
Actualiza -Update-). */

public class ProductoDAO {
    
    //Este método realiza la consulta a la base de datos de productos
    public ArrayList<Producto> consultarProductos() {
        ArrayList<Producto> lista = new ArrayList<>();
        ConexionBD con = new ConexionBD();
        ResultSet rs = con.ejecutarQuery("SELECT idProducto, NombreProducto, idTipoReferencia, idEspecificaciones FROM Producto");
        try {
            while (rs.next()) {
                int idProducto = rs.getInt("idProducto");
                String NombreProducto = rs.getString("NombreProducto");
                int idTipoReferencia = rs.getInt("idTipoReferencia");
                int idEspecificaciones = rs.getInt("idEspecificaciones");
                Producto p = new Producto(idProducto, NombreProducto, idTipoReferencia, idEspecificaciones);			   		   
                lista.add(p);
            }
        } catch (SQLException ex) {						  
            return null;
        }
        con.desconectar();				  
        return lista;
    }
    
    //Envía la sentencia SQL para obtener la información de 1 producto específico y estructura
    public Producto consultarProducto(int idAConsultar) {
        Producto p = null;
        ConexionBD con = new ConexionBD();
        String sql = "SELECT idProducto, NombreProducto, idTipoReferencia, idEspecificaciones " +
                     "FROM producto "+
                     "WHERE id = " + idAConsultar + " ";
        ResultSet rs = con.ejecutarQuery(sql);
        try {
            if (rs.next()) {
                int idProducto = rs.getInt("idProducto");
                String NombreProducto = rs.getString("NombreProducto");
                int idTipoReferencia = rs.getInt("idTipoReferencia");
                int idEspecificaciones = rs.getInt("idEspecificaciones");
                p = new Producto(idProducto, NombreProducto, idTipoReferencia, idEspecificaciones);
            }
        } catch (SQLException ex) {
            con.desconectar();
            return p;
        }
        con.desconectar();
        return p;
    }

    //Metodo para Insertar nuevo producto (Create)
    public int guardarNuevoProducto(Producto p) {
        ConexionBD con = new ConexionBD();
        String NombreProducto = p.getNombreProducto();
        int idTipoReferencia = p.getIdTipoReferencia();
        int idEspecificaciones = p.getIdEspecificaciones();
        
        String sql = "INSERT INTO juguetes (NombreProducto, idTipoReferencia, idEspecificaciones) VALUES ('"+NombreProducto+"', '"+idTipoReferencia+"', '"+idEspecificaciones+"')";
        System.out.println(sql);
        ResultSet rs = con.ejecutarInsert(sql);
        int id = 0;
        try {
            if (rs.next()){
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            con.desconectar();
            return 0; 
        }
        con.desconectar();
        return id;
    }
    
    //Consultar producto por filtro
    public ArrayList<Producto> consultarProductosPorFiltro(String filtro) {
        ArrayList<Producto> lista = new ArrayList<>();
        ConexionBD con = new ConexionBD();
        //revisar este codigo, es mysql, hay que crear las FK sino no funciona.
        String sql = "SELECT p.idProducto, p.NombreProducto, p.idTipoReferencia, t.idTipoReferencia, p.idEspecificaciones, e.idEspecificaciones " +
                     "FROM producto p " +
                     "JOIN tiporeferencia t ON (p.idTipoReferencia = t.idTipoReferencia) " +
                     "JOIN especificaciones e ON (p.idEspecificaciones = e.idEspecificaciones) " +
                     "WHERE p.NombreProducto LIKE '%" + filtro + "%' " +
                     "OR t.idTipoReferencia LIKE '%" + filtro + "%' " +
                     "OR e.idEspecificaciones LIKE '%" + filtro + "%' "; 
        ResultSet rs = con.ejecutarQuery(sql);
        try {
            while (rs.next()) {
                int idProducto = rs.getInt("idProducto");
                String NombreProducto = rs.getString("NombreProducto");
                int idTipoReferencia = rs.getInt("idTipoReferencia");
                int idEspecificaciones = rs.getInt("idEspecificaciones");
                Producto p = new Producto(idProducto, NombreProducto, idTipoReferencia, idEspecificaciones);
                lista.add(p);
            }
        } catch (SQLException ex) {
            con.desconectar();
            return null;
        }
        con.desconectar();
        return lista;
    }
    
   //Cargar los diferentes tipos referencia de producto desde la BD
    public TreeMap<Integer, String> cargarTiposReferencia() {
        TreeMap<Integer, String> listaTipos = new TreeMap<Integer, String>();
        ConexionBD con = new ConexionBD();
        ResultSet rs = con.ejecutarQuery("SELECT idTipoReferencia, idTipoReferencia FROM tiporeferencia");
        try {
            while (rs.next()) {
                int id = rs.getInt("idTipoReferencia");
                String tipo = rs.getString("idTipoReferencia");
                listaTipos.put(id, tipo);
            }
        } catch (SQLException ex) {
            con.desconectar();
            return null;
        }
        con.desconectar();
        return listaTipos;
    }
    
    
   //Cargar especificaciones de producto desde la BD 
    // Este es el metodo que debemos cambiara para que reciba los 7 parametros
    public TreeMap<Integer, String> cargarEspecificaciones() {
        TreeMap<Integer, String> listaEspecificaciones = new TreeMap<Integer, String>();
        ConexionBD con = new ConexionBD();
        ResultSet rs = con.ejecutarQuery("SELECT idEspecificaciones, DiametroMin, "
                + " FROM especificaciones");
        try {
            while (rs.next()) {
                int id = rs.getInt("idEspecificaciones");
                String estado = rs.getString("DiametroMin");
                listaEspecificaciones.put(id, estado);
            }
        } catch (SQLException ex) {
            con.desconectar();
            return null;
        }
        con.desconectar();
        return listaEspecificaciones;
    }
    
    
    //Almacenar los productos existentes
        public int guardarProductoExistente(Producto p) {
        ConexionBD con = new ConexionBD();
        int id = p.getIdProducto();
        String nombre = p.getNombreProducto();
        int idTipo = p.getIdTipoReferencia();
        int idEspecificaciones = p.getIdEspecificaciones();
        
        String sql = "UPDATE producto "+
                    "SET nombre = '" + NombreProducto + "' , tiporeferencia_id = " + idTipoReferencia + 
                    " ,  Especificaciones_id = " + idEspecificaciones +
                    "WHERE id = " + id + " ";
        int filas = con.ejecutarUpdate(sql);
        con.desconectar();
        return filas;
    }
}