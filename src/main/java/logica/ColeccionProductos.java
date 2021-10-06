/**
 *
 * @author Grupo Optimus
 */

package logica;

import java.util.ArrayList;
import persistencia.ProductoDAO;

//Esta clase para que se utilizará?
//Contiene la logica requerida para gestionar la informacion de los productos
public class ColeccionProductos {   
   
    private ArrayList<Producto> lista;
    
    public ArrayList<Producto> getLista() {
        return lista;
    }
    
    public boolean cargarProductos() {
//la linea anterior sobraría?
	    //cargar la informacion de los productos de la base de datos
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
	//Guarda la información de un producto capturada desde el formulario
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
