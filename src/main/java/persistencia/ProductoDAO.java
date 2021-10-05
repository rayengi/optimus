package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;							   
import logica.Producto;

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
                Producto j = new Producto(idProducto, NombreProducto, idTipoReferencia, idEspecificaciones);			   		   
                lista.add(j);
            }
        } catch (SQLException ex) {						  
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
}