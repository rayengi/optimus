package logica;

/**
 *
 * @author Grupo Optimus
 */
public class Usuario {
    //Atributos
    private int id;
    private String nombrecompleto;
    private String usuario;
    private String passw;
    private String fechanacimiento;
    private String parentesco;
    private String rol;
//Se puede simplificar y dejar solamente id, nombre completo, usuario, passw, cargo
    //Constructores
    public Usuario() {
    }

    /* Constructor para añadir un nuevo usuario */
    public Usuario(String nombrecompleto, String usuario, String passw, String fechanacimiento, String parentesco, String rol) {
        this.nombrecompleto = nombrecompleto;
        this.usuario = usuario;
        this.passw = passw;
        this.fechanacimiento = fechanacimiento;
        this.parentesco = parentesco;
        this.rol = rol;
    }

    
    public Usuario(int id, String nombrecompleto, String usuario, String passw, String fechanacimiento, String parentesco, String rol) {
        this(nombrecompleto, usuario, passw, fechanacimiento, parentesco, rol);
        this.id = id;
    }
    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }  
}
