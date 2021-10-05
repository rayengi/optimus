package logica;

import java.util.ArrayList;
import persistencia.UsuarioDAO;

/**
 *
 * @author bizagi
 */
public class LogicaUsuario {
    
    private ArrayList<Usuario> lista;
    
    public ArrayList<Usuario> getListaUsuarios() {
        return lista;
    }
    
    public boolean cargarTodosLosUsuarios() {
        UsuarioDAO dao = new UsuarioDAO();
        lista = dao.consultarUsuarios();
        if (lista.size() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
}