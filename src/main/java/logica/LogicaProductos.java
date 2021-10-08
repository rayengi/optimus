/**
 *
 * @author Grupo Optimus
 */
package logica;

import java.util.ArrayList;
import java.util.TreeMap;
import persistencia.ProductoDAO;


//Contiene la logica requerida para gestionar la informacion de los productos
public class LogicaProductos {   
    private ArrayList<Producto> lista;
    
	
    //Obtiene una lista de productos
    public ArrayList<Producto> getLista() {
        return lista;
    }
    
    //Obtiene el nombre del tipo de referencia dado el id correspondiente
	public String getIdTipoReferencia(int key) {
        ProductoDAO dao = new ProductoDAO();
        TreeMap<Integer, String> listaTipoReferencia = dao.cargarTiposReferencia();
        String value = listaTipoReferencia.get(key);
        return value;
    }
	
    //Obtiene la lista de los tipos de referencia
	public TreeMap<Integer, String> getIdTiposReferencia() {
        ProductoDAO dao = new ProductoDAO();
        TreeMap<Integer, String> listaTipoReferencia = dao.cargarTiposReferencia();
        return listaTipoReferencia;
    }
	
    //cargar la informacion de los productos de la base de datos
    public boolean cargarTodosLosProductos(){
        ProductoDAO dao = new ProductoDAO();
        lista = dao.consultarProductos();
        if (lista.size() > 0){
            return true;
        }
        else {
            return false;
        }
    } 

    //Carga la información de ciertos productos de la base de datos mediante filtro
    public boolean cargarProductosPorFiltro(String filtro) {
        ProductoDAO dao = new ProductoDAO();
        lista = dao.consultarProductoPorFiltro(filtro);
        if (lista.size() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
	
    //Carga la información de un solo juguete de la base de datos
	public Producto cargarUnProducto(int idProducto) {
        ProductoDAO dao = new ProductoDAO();
        Producto p = dao.consultarProducto(idProducto);
        return p;
    }
	
    //Guarda la información de un producto capturada desde el formulario	
	public boolean guardarProducto(Producto p) {
        ProductoDAO dao = new ProductoDAO();
        if (p.getIdProducto() == 0) {
            int id = dao.guardarNuevoProducto(p);
            if (id > 0) {
                return true;
            } else {
                return false;
            }
        }
        else {
            int filas = dao.guardarProductoExistente(p);
            if (filas == 1) {
                return true;
            } else {
                return false;
            }
        }
    }
}