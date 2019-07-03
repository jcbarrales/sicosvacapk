package lania.edu.mx.sicosvac.db.pojo;

public class User {
    private int id_tutor;
    private String nombre;
    private String apellidos;
    private String usuario;
    private String password;
    private int id_rol;
    private int estatus;


    public User(int id_tutor, String nombre, String apellidos, String usuario, String password, int id_rol, int estatus) {

        this.id_tutor = id_tutor;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.password = password;
        this.id_rol = id_rol;
        this.estatus = estatus;
    }

    public int getId_tutor() {
        return id_tutor;
    }

    public void setId_tutor(int id_tutor) {
        this.id_tutor = id_tutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
}
