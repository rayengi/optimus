/**
 * 
 * @author Bizagi
 */
 
package logica;

import java.util.ArrayList;
import java.util.TreeMap;
import persistencia.ProductoDAO;								   

//public class ColeccionProductos {    /*Esta parte no es coherente*/
    
    public class LogicaProductos {
        private ArrayList<Producto> lista;
		
	public ArrayList<Producto> getLista() {
        return lista;
	}
    
	public String getIdTipoReferencia(int key) {
            ProductoDAO dao = new ProductoDAO();
            TreeMap<Integer, String> listaTipoReferencia = dao.cargarTipoReferencia();  //En la clase ProductoDAO no existe este metodo, la clase tipo de referencia no se ha creado
            String value = listaTipoReferencia.get(key);
            return value;
	}
	
	public TreeMap<Integer, String> getidTipoReferencia() {
        ProductoDAO dao = new ProductoDAO();   
		TreeMap<Integer, String> listaTipoReferencia = dao.cargarTiposReferencia();
        return listaTipoReferencia;
	}		
	
	public String getIdEspecificaciones(int key) {
            ProductoDAO dao = new ProductoDAO();
            TreeMap<Integer, String> listaEspecificaciones = dao.cargarEspecificaciones(); //No se ha creado el metodo cargar Especificaciones-Crear Clase Especificaciones
            String value = listaEspecificaciones.get(key);
            return value;
	}
      
    public TreeMap<Integer, String> getIdEspecificaciones() {
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
            lista = dao.consultarProductoPorFiltro(filtro); //Este metodo no existe
            if (lista.size() > 0) {
				return true;
            }
            else {
				return false;
            }
	}
	    
    public Producto cargarUnJuguete(int idProducto) {
        ProductoDAO dao = new ProductoDAO();
        Producto p = dao.consultarProducto(idProducto);  //Revisar instruccion
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