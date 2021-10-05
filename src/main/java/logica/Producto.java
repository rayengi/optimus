package logica;

/**
 *
 * @author Bizagi
 */
public class Producto {   
    private int idProducto;
    private String NombreProducto;
    private int idTipoReferencia;
    private int idEspecificaciones;

    public Producto() {
    }  

    public Producto(String NombreProducto, int idTipoReferencia, int idEspecificaciones) {
        this.NombreProducto = NombreProducto;
        this.idTipoReferencia = idTipoReferencia;
        this.idEspecificaciones = idEspecificaciones;
    }
    
    public Producto(int idProducto, String NombreProducto, int idTipoReferencia, int idEspecificaciones) {
        this.idProducto = idProducto;
        this.NombreProducto = NombreProducto;
        this.idTipoReferencia = idTipoReferencia;
        this.idEspecificaciones = idEspecificaciones;
    }
    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
	
    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public int getIdTipoReferencia() {
        return idTipoReferencia;
    }

    public void setIdTipoReferencia(int idTipoReferencia) {
        this.idTipoReferencia = idTipoReferencia;
    }

    public int getIdEspecificaciones() {
        return idEspecificaciones;
    }

    public void setIdEspecificaciones(int idEspecificaciones) {
        this.idEspecificaciones = idEspecificaciones;
    }
}