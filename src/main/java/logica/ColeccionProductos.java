/**
 *
 * @author Bizagi
 */

package logica;

import java.util.ArrayList;
import persistencia.ProductoDAO;

//Esta clase para que se utilizará?

public class ColeccionProductos {   
   
    private ArrayList<Producto> lista;
    
    public ArrayList<Producto> getLista() {
        return lista;
    }
    
    public boolean cargarProductos() {

	public boolean cargarTodosLosProductos(){
            ProductoDAO dao = new ProductoDAO();
            lista = dao.consultarProductos();
            if (lista.size() > 0) {
		return true;
            }
            else {
		return false;
            }
	} 
	 
        public boolean guardarProducto(Producto p) {
            ProductoDAO dao = new ProductoDAO();
            int idProducto = dao.guardarNuevoProducto(p);
            if (idProducto > 0) {
                return true;
            }
            else {
                return false;
            } 
        }
}