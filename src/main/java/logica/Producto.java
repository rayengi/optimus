package logica;

/**
 *
 * @author Grupo Optimus
 */
//Clase Producto para crear objetos productos de acuerdo a base de datos
public class Producto { 
    //Atributos
    private int idProducto = 0;
    private String NombreProducto;
    private int idTipoReferencia;
    private float diametromin;
    private float diametromax;
    private float largomin;
    private float largomax;
    private float alto;
    private float pesomin;
    private float pesomax;
    
    //Costructores
    public Producto() {
    }  

    public Producto(String NombreProducto, int idTipoReferencia, float diametromin, float diametromax, float largomin, 
        float largomax, float alto, float pesomin, float pesomax) {
        this.NombreProducto = NombreProducto;
        this.idTipoReferencia = idTipoReferencia;
        this.diametromin = diametromin;
        this.diametromax = diametromax;
        this.largomin = largomin;
        this.largomax = largomax;
        this.alto = alto;
        this.pesomin = pesomin;
        this.pesomax = pesomax;
    }

    public Producto(int idProducto, String NombreProducto, int idTipoReferencia, float diametromin, float diametromax, float largonmin, 
        float largomax, float alto, float pesomin, float pesomax) {
        this.idProducto = idProducto;
        this.NombreProducto = NombreProducto;
        this.idTipoReferencia = idTipoReferencia;
        this.diametromin = diametromin;
        this.diametromax = diametromax;
        this.largomin = largomin;
        this.largomax = largomax;
        this.alto = alto;
        this.pesomin = pesomin;
        this.pesomax = pesomax;
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

    public float getDiametromin() {
        return diametromin;
    }

    public void setDiametromin(float diametromin) {
        this.diametromin = diametromin;
    }

    public float getDiametromax() {
        return diametromax;
    }

    public void setDiametromax(float diametromax) {
        this.diametromax = diametromax;
    }

    public float getLargomin() {
        return largomin;
    }

    public void setLargomin(float largomin) {
        this.largomin = largomin;
    }

    public float getLargomax() {
        return largomax;
    }

    public void setLargomax(float largomax) {
        this.largomax = largomax;
    }

    public float getAlto() {
        return alto;
    }

    public void setAlto(float alto) {
        this.alto = alto;
    }

    public float getPesomin() {
        return pesomin;
    }

    public void setPesomin(float pesomin) {
        this.pesomin = pesomin;
    }

    public float getPesomax() {
        return pesomax;
    }

    public void setPesomax(float pesomax) {
        this.pesomax = pesomax;
    }
}