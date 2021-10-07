package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;							   
import logica.Producto;
import logica.Especificaciones;        

/**
 *
 * @author Grupo Optimus
 */

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
    
    /**
     * Envía la sentencia SQL para obtener la información de 1 producto específico y estructura
     * la respuesta en un objeto de tipo Producto
     * @param idAConsultar el id del producto para consultar
     * @return un objeto de tipo Producto con la información cargada o null
     */
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
        
        String sql = "INSERT INTO producto (NombreProducto, idTipoReferencia, idEspecificaciones) VALUES ('"+NombreProducto+"', '"+idTipoReferencia+"', '"+idEspecificaciones+"')";
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
    //Agrego metodos faltantes
    /**
     * Envía la sentencia SQL para obtener la información de ciertos productos mediante filtro y estructura
     * la respuesta en una lista de tipo Producto
     * @param filtro el filtro para buscar datos en la lista de productos para consultar
     * @return un arraylist de tipo Juguete con la información cargada
     */
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
     
     /**
     * Cargar los diferentes tipos de juguetes desde la BD
     * @return un treemap con la lista de los tipos de juguetes
     */
    public TreeMap<Integer, String> cargarTipoReferencia() {
        TreeMap<Integer, String> listaTipos = new TreeMap<Integer, String>();
        ConexionBD con = new ConexionBD();
        ResultSet rs = con.ejecutarQuery("SELECT idTipoReferencia, Referencia FROM tiporeferencia ");
        try {
            while (rs.next()) {
                int idTipoReferencia = rs.getInt("idTipoReferencia");
                String Referencia = rs.getString("Referencia");
                listaTipos.put(idTipoReferencia, Referencia);
            }
        } catch (SQLException ex) {
            con.desconectar();
            return null;
        }
        con.desconectar();
        return listaTipos;
    }
    /*
     * Cargar los diferentes especificaciones de los productos desde la BD
     * @return un treemap con la lista de las especificaciones de los productos.
     */
    //Terminar este metodo -pendiente.
    public TreeMap<Integer, Especificaciones> cargarEspecificaciones() {
        // Especificaciones medidas=new Especificaciones(); //hacer clase - listo, hecha
        TreeMap<Integer, Especificaciones> listaEspecificaciones = new TreeMap<Integer, Especificaciones>();
        ConexionBD con = new ConexionBD();
        ResultSet rs = con.ejecutarQuery("SELECT idEspecificaciones, DiametroMin, DiametroMax, LargoMin, LargoMax, Alto, PesoMin, PesoMax  FROM especificaciones ");
        try {
            while (rs.next()) {
                int idEspecificaciones = rs.getInt("idEspecificaciones");
                float DiametroMin = rs.getFloat("DiametroMin");
                float DiametroMax = rs.getFloat("DiametroMax");
                float LargoMin = rs.getFloat("LargoMin");
                float LargoMax = rs.getFloat("LargoMax");
                float Alto = rs.getFloat("Alto");
                float PesoMin = rs.getFloat("PesoMin");
                float PesoMax = rs.getFloat("PesoMax");
                listaEspecificaciones.put(idEspecificaciones, new Especificaciones(DiametroMin, DiametroMax, LargoMin, LargoMax, Alto, PesoMin, PesoMax));
            }
        } catch (SQLException ex) {
            con.desconectar();
            return null;
        }
        con.desconectar();
        return listaEspecificaciones;
    }
    /**
     * Envía la sentencia SQL para actualizar el dato de un juguete existente
     * @param p un objeto de tipo Juguete
     * @return un número indicando la cantidad de registros afectados
     */
    public int guardarProductoExistente(Producto p) {
        ConexionBD con = new ConexionBD();
        int idProducto =p.getIdProducto();
        String NombreProducto = p.getNombreProducto();
        int idTipoReferencia = p.getIdTipoReferencia();
        int idEspecificaciones = p.getIdEspecificaciones();
        
        
        String sql = "UPDATE juguetes "+
                          "SET NombreProducto = '" + NombreProducto + "' , idTipoReferencia = " + idTipoReferencia + " , idEspecificaciones = " + idEspecificaciones + 
                          "WHERE idProducto = " + idProducto + " ";
        int filas = con.ejecutarUpdate(sql);
        con.desconectar();
        return filas;
    }
    
    
    
}   
     
    
    
    
