package lania.edu.mx.sicosvac.db.pojo;

public class Menor {
    private int id_menor;
    private String nombre;
    private String apellidos;
    private String curp;
    private String fecha_nac;
    private int id_tutor;

    public Menor(int id_menor, String nombre, String apellidos, String curp, String fecha_nac, int id_tutor) {
        this.id_menor = id_menor;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curp = curp;
        this.fecha_nac = fecha_nac;
        this.id_tutor = id_tutor;
    }

    public int getId_menor() {
        return id_menor;
    }

    public void setId_menor(int id_menor) {
        this.id_menor = id_menor;
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

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public int getId_tutor() {
        return id_tutor;
    }

    public void setId_tutor(int id_tutor) {
        this.id_tutor = id_tutor;
    }
}
