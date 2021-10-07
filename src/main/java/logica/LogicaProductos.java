/**
 * 
 * @author Grupo Optimus
 */
 
package logica;

import java.util.ArrayList;
import java.util.TreeMap;
import persistencia.ProductoDAO;								   
//Contiene la logica requerida para gestionar la informacion de los productos
//public class ColeccionProductos {    /*Esta parte no es coherente*/
    
    public class LogicaProductos {
        private ArrayList<Producto> lista;	
        public ArrayList<Producto> getLista() {
            return lista;
        }
        //Obtiene el nombre del tipo de referencia de producto dado en el Id correspondiente
        /*
        * Obtiene el nombre del tipo de referencia dado el id correspondiente
        * @param key el id del tipo de referencia
        * @return el nombre del tipo de Producto
        */
        public String getTipoReferencia(int key) {
            ProductoDAO dao = new ProductoDAO();
            TreeMap<Integer, String> listaTipoReferencia = dao.cargarTipoReferencia();  //En la clase ProductoDAO no existe este metodo, la clase tipo de referencia no se ha creado-Listo creada.
            String value = listaTipoReferencia.get(key);
            return value;
        }
        //Obtiene la lista de los tipos de referencia de los productos
        public TreeMap<Integer, String> getTiposReferencias() {
            ProductoDAO dao = new ProductoDAO();   
            TreeMap<Integer, String> listaTipoReferencia = dao.cargarTipoReferencia();  //Corregido
            return listaTipoReferencia;
        }		
	
        public String getEspecificacion(int key) {
            ProductoDAO dao = new ProductoDAO();
            TreeMap<Integer, String> listaEspecificaciones = dao.cargarEspecificaciones(); //No se ha creado el metodo cargar Especificaciones-Crear Clase Especificaciones
            String value = listaEspecificaciones.get(key);
            return value;
        }
      
        public TreeMap<Integer, String> getEspecificaciones() {
            ProductoDAO dao = new ProductoDAO();
            TreeMap<Integer, String> listaEspecificaciones = dao.cargarEspecificaciones();
            return listaEspecificaciones;
        }
	
        public boolean cargarTodosLosProductos() {
            ProductoDAO dao = new ProductoDAO();
            lista = dao.consultarProductos();
            if (lista.size() > 0) {
                return true;
            }
            else {
                return false;
            }
        }
    
        public boolean cargarProductoPorFiltro(String filtro) {
            ProductoDAO dao = new ProductoDAO();
            lista = dao.consultarProductosPorFiltro(filtro); //Este metodo no existe -creado metodo.
            if (lista.size() > 0) {
                return true;
            }
            else {
	return false;
            }
        }
	    
        public Producto cargarUnProducto(int idProducto) {
            ProductoDAO dao = new ProductoDAO();
            Producto p = dao.consultarProducto(idProducto);  //No existe el método-Listo creado metodo
            return p;
        }												  
										  
        public boolean guardarProducto(Producto p) {
            ProductoDAO dao = new ProductoDAO();
            if (p.getIdProducto() == 0) {
                int id = dao.guardarNuevoProducto(p);
	if (id > 0) {
                    return true;
	} 
                else {
                    return false;
                }
            }
            else {
                int filas = dao.guardarProductoExistente(p);  //metodo no existe
	if (filas == 1) {
                    return true;
	} 
	else {
                    return false;
	}
            }
        }
    }   	
//}
