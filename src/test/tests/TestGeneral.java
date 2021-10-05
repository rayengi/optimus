/**
 *
 * @author Bizagi
 */
 
package tests;

import logica.Producto;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import persistencia.ConexionBD;
import persistencia.ProductoDAO;


public class TestGeneral {
    
	@Ignore
    @Test
    public void verificarConexion() {
        ConexionBD con = new ConexionBD();
        Assert.assertTrue(con.isConectado(), "No hay conexión creada. ");
        con.desconectar();
        Assert.assertFalse(con.isConectado(), "No se cerró conexión. ");
    }
    
	@Ignore
    @Test   
    public void verificarCargaProductos() {
        ProductoDAO dao = new ProductoDAO();
        Assert.assertTrue(dao.consultarProductos().size() > 0, "No se cargaron datos. ");
    }
	
    @Test
    public void verificarCargaTiposProductos() {
        ProductoDAO dao = new ProductoDAO();
        Assert.assertTrue(dao.cargarTiposProductos().size() > 0, "No se cargaron datos de los tipos de producto. ");
    }
    
    @Test
    @Ignore
    public void verificarInsercionProducto() {
        ProductoDAO dao = new ProductoDAO();
        Producto p = new Producto("Nombre Producto", 1, 1);
        int id = dao.guardarNuevoProducto(p);
        Assert.assertTrue(id > 0, "No se guardó dato de un juguete. ");
        String sql = "DELETE FROM Producto WHERE id = " + id;
        ConexionBD con = new ConexionBD();
        int cant = con.ejecutarUpdate(sql);
        Assert.assertTrue(cant == 1, "No se logró hacer limpieza del dato de prueba de un producto ingresado. ");
        con.desconectar();
    }	  
}
