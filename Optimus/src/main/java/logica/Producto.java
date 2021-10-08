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
    private float diametromin;
    private float diametromax;
    private float  largomin;
    private float largomax;
    private float alto;
    private float pesomin;
    private float pesomax;
    //Costructores
    public Producto() {
    }  

    public Producto(String NombreProducto, int idTipoReferencia, float diametromin, float diametromax, float largomin, float largomax, float alto, float pesomin, float pesomax) {
        this.NombreProducto = NombreProducto;
        this.idTipoReferencia = idTipoReferencia;
        this.diametromin = diamentromin;
        this.diametromax = diametromax;
        this.largomin = largomin;
        this.largomax = largomax;
        this.alto = alto;
        this.pesomin = pesomax;
    }
    
    public Producto(int idProducto, String NombreProducto, int idTipoReferencia, float diametromin, float diametromax, float largomin, float largomax, float alto, float pesomin, float pesomax) {
        this.idProducto = idProducto;
        this.NombreProducto = NombreProducto;
        this.idTipoReferencia = idTipoReferencia;
        this.diametromin = diamentromin;
        this.diametromax = diametromax;
        this.largomin = largomin;
        this.largomax = largomax;
        this.alto = alto;
        this.pesomin = pesomin;
        this.pesomax = pesomax;
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
     public void setdiametromin(float diametromin) {
        this.diametromin = diametromin;
   }
    public float getdiametromin() {
        return diametromin;
    }
   public void setdiametromax(float diametromax) {
        this.diametromax = diametromax;
   }
    public float getdiametromax() {
        return diametromax;
    }
    public void setlargomin(float largomin) {
        this.largomin = largomin;
   }
    public float getlargomin() {
        return largomin;
    }
    public void setlargomax(float largomax) {
        this.largomax = largomax;
   }
    public float getlargomax() {
        return largomax;
    }
    public void setalto(float alto) {
        this.alto = alto;
   }
    public float getalto() {
        return alto;
    }
    public void setpesomin(float pesomin) {
        this.pesomin = pesomin;
   }
    public float getpesomin() {
        return pesomin;
    }
    public void setpesomax(float pesomax) {
        this.pesomax = pesomax;
   }
    public float getpesomax() {
        return pesomax;
    }
    public void setlargomax(float largomax) {
        this.largomax = largomax;
   }  

    public void setdiametromin(float diametromin) {
        this.diametromin = diametromin;
    }

    public void setdiametromax(float diametromax) {
        this.diametromax = diametromax;
    }

    public void setlargomin(float largomin) {
        this.largomin = largomin;
    }

    public void setlargomax(float largomax) {
        this.largomax = largomax;
    }

    public void setalto(float alto) {
        this.alto = alto;
    }

    public void setpesomin(float pesomin) {
        this.pesomin = pesomin;
    }

    public void setpesomax(float pesomax) {
        this.pesomax = pesomax;
    } 
}
