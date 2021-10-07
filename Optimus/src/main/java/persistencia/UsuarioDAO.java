/**
 *
 * @author Grupo Optimus
 */

package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import logica.Usuario;

/*Clase para gestion de la base de datos Usuarios*/
public class UsuarioDAO {
    //Metodo para consultar Usuarios - Read - cargar 
    public ArrayList<Usuario> consultarUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        String sql = "SELECT id, nombrecompleto, usuario, passw, fechanacimiento, parentesco, rol " +
                     "FROM usuarios ";
        ConexionBD con = new ConexionBD();
        ResultSet rs = con.ejecutarQuery(sql);
        try {
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNombrecompleto(rs.getString("nombrecompleto"));
                u.setUsuario(rs.getString("usuario"));
                u.setPassw(rs.getString("passw"));
                u.setFechanacimiento(rs.getString("fechanacimiento"));
                u.setParentesco(rs.getString("parentesco"));
                u.setRol(rs.getString("rol"));
                lista.add(u);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
            con.desconectar(); //Aca se cierra base de datos
            return null;
        }
        con.desconectar();
        return lista;
    }
    
    //Metodo para consultar Usuarios - Read - un usuario especifico
    public Usuario consultarUsuario(int idAConsultar) {
        Usuario u = null;
        String sql = "SELECT id, nombrecompleto, usuario, passw, fechanacimiento, parentesco, rol " +
                     "FROM usuarios " +
                     "WHERE id = " + idAConsultar + " ";
        ConexionBD con = new ConexionBD();
        ResultSet rs = con.ejecutarQuery(sql);
        try {
            if (rs.next()) {
                u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNombrecompleto(rs.getString("nombrecompleto"));
                u.setUsuario(rs.getString("usuario"));
                u.setPassw(rs.getString("passw"));
                u.setFechanacimiento(rs.getString("fechanacimiento"));
                u.setParentesco(rs.getString("parentesco"));
                u.setRol(rs.getString("rol"));
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
            con.desconectar();
            return null;
        }
        con.desconectar();
        return u;
    }
    
    //Metodo para consultar de acuerdo a un filtro o criterio
    public ArrayList<Usuario> consultarUsuariosPorFiltro(String filtro) {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        String sql = "SELECT id, nombrecompleto, usuario, passw, fechanacimiento, parentesco, rol " +
                     "FROM usuarios " +
                     "WHERE nombrecompleto LIKE '%" + filtro + "%' " +
                     "OR usuario LIKE '%" + filtro + "%' " +
                     "OR parentesco LIKE '%" + filtro + "%' ";
        ConexionBD con = new ConexionBD();
        ResultSet rs = con.ejecutarQuery(sql);
        try {
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNombrecompleto(rs.getString("nombrecompleto"));
                u.setUsuario(rs.getString("usuario"));
                u.setPassw(rs.getString("passw"));
                u.setFechanacimiento(rs.getString("fechanacimiento"));
                u.setParentesco(rs.getString("parentesco"));
                u.setRol(rs.getString("rol"));
                lista.add(u);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
            con.desconectar();
            return null;
        }
        con.desconectar();
        return lista;
    }
    
    //Metodo para crear nuevo usuario
    public int guardarNuevoUsuario(Usuario u) {
        int id = 0;
        String sql = "INSERT INTO usuarios (nombrecompleto, usuario, passw, fechanacimiento, parentesco, rol) " +
                     "VALUES ('" + u.getNombrecompleto() + "', '" + u.getUsuario() + "', '" + u.getPassw() + "', '" + u.getFechanacimiento() + "', '" + u.getParentesco() + "', '" + u.getRol() + "') ";
        ConexionBD con = new ConexionBD();
        ResultSet rs = con.ejecutarInsert(sql);
        try {
            if (rs.next()){
                id = rs.getInt(1);
            }
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
        return id;
    }
    
    //Metodo para actualizar usuario existente.
    public int guardarUsuarioExistente(Usuario u) {
        int filas = 0;
        String sql = "UPDATE usuarios " +
                     "SET nombrecompleto = '" + u.getNombrecompleto() + "', usuario = '" + u.getUsuario() + "', passw = '" + u.getPassw() + "', fechanacimiento = '" + u.getFechanacimiento() + "', parentesco = '" + u.getParentesco() + "', rol = '" + u.getRol() + "' " +
                     "WHERE id = " + u.getId() + " ";
        ConexionBD con = new ConexionBD();
        filas = con.ejecutarUpdate(sql);
        return filas;
    }
}