/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import logica.Producto;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import persistencia.ConexionBD;
import persistencia.ProductoDAO;


/**
 *
 * @author Grupo optimus
 */
public class TestGeneral { 
    @Ignore
    public void verificarConexion() {
        ConexionBD con = new ConexionBD();
        Assert.assertTrue(con.isConectado(), "No hay conexión creada. ");
        con.desconectar();
        Assert.assertFalse(con.isConectado(), "No se cerró conexión. ");
    }
    
    @Ignore
    public void verificarCargaProductos() {
        ProductoDAO dao = new ProductoDAO();
        Assert.assertTrue(dao.consultarProductos().size() > 0, "No se cargaron datos de productos. ");
    }
    
    @Ignore
    public void verificarCargaTipoReferencia() {
        ProductoDAO dao = new ProductoDAO();
        Assert.assertTrue(dao.cargarTiposReferencia().size() > 0, "No se cargaron datos de los tipos de referencia. ");
    }
    
    
    @Ignore
    public void verificarInsercionProducto() {
        ProductoDAO dao = new ProductoDAO();
        Producto p = new Producto("Cono de prueba", (int)1, (float)14.3, (float)14.7, (float)5.5, (float)6.5, (float)6.5, (float)33, (float)43);
        int id = dao.guardarNuevoProducto(p);
        Assert.assertTrue(id > 0, "No se guardó dato de un producto. ");
        String sql = "DELETE FROM producto WHERE idProducto = " + id;
        ConexionBD con = new ConexionBD();
        int cant = con.ejecutarUpdate(sql);
        Assert.assertTrue(cant == 1, "No se logró hacer limpieza del dato de prueba de un producto ingresado. ");
        con.desconectar();
        
    }   
}
