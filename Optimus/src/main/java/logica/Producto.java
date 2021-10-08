package logica;

/**
 *
 * @author Grupo Optimus
 */
//Clase Producto para crear objetos productos de acuerdo a base de datos
public class Producto { 
    //Atributos
    private int idProducto;
    private String NombreProducto;
    private int idTipoReferencia;
    private int idEspecificaciones;
    //Constructores
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
    //Getters and Setters
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

    public float getDiametroMin() {
        return DiametroMin;
    }

    public float getDiametroMax() {
        return DiametroMax;
    }

    public float getLargoMin() {
        return LargoMin;
    }

    public float getLargoMax() {
        return LargoMax;
    }

    public float getAlto() {
        return Alto;
    }

    public float getPesoMin() {
        return PesoMin;
    }

    public float getPesoMax() {
        return PesoMax;
    }

    public void setIdEspecificaciones(int idEspecificaciones) {
        this.idEspecificaciones = idEspecificaciones;
    }

    public void setDiametroMin(float DiametroMin) {
        this.DiametroMin = DiametroMin;
    }

    public void setDiametroMax(float DiametroMax) {
        this.DiametroMax = DiametroMax;
    }

    public void setLargoMin(float LargoMin) {
        this.LargoMin = LargoMin;
    }

    public void setLargoMax(float LargoMax) {
        this.LargoMax = LargoMax;
    }

    public void setAlto(float Alto) {
        this.Alto = Alto;
    }

    public void setPesoMin(float PesoMin) {
        this.PesoMin = PesoMin;
    }

    public void setPesoMax(float PesoMax) {
        this.PesoMax = PesoMax;
    } 
}