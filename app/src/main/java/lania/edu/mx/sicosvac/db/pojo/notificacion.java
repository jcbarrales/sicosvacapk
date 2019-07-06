package lania.edu.mx.sicosvac.db.pojo;

public class notificacion {

    private int id_vacuns_menor;
    private int id_vacuns;
    private int id_menor;
    private String fecha_sugerida;
    private int dias;
    private int diasvencidos;
    private String menornombre;
    private String vacunanombre;
    private int id_tutor;

    public notificacion(int id_vacuns_menor, int id_vacuns, int id_menor, String fecha_sugerida, int dias, int diasvencidos, String menornombre, String vacunanombre, int id_tutor) {
        this.id_vacuns_menor = id_vacuns_menor;
        this.id_vacuns = id_vacuns;
        this.id_menor = id_menor;
        this.fecha_sugerida = fecha_sugerida;
        this.dias = dias;
        this.diasvencidos = diasvencidos;
        this.menornombre = menornombre;
        this.vacunanombre = vacunanombre;
        this.id_tutor = id_tutor;
    }

    public int getId_vacuns_menor() {
        return id_vacuns_menor;
    }

    public void setId_vacuns_menor(int id_vacuns_menor) {
        this.id_vacuns_menor = id_vacuns_menor;
    }

    public int getId_vacuns() {
        return id_vacuns;
    }

    public void setId_vacuns(int id_vacuns) {
        this.id_vacuns = id_vacuns;
    }

    public int getId_menor() {
        return id_menor;
    }

    public void setId_menor(int id_menor) {
        this.id_menor = id_menor;
    }

    public String getFecha_sugerida() {
        return fecha_sugerida;
    }

    public void setFecha_sugerida(String fecha_sugerida) {
        this.fecha_sugerida = fecha_sugerida;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getDiasvencidos() {
        return diasvencidos;
    }

    public void setDiasvencidos(int diasvencidos) {
        this.diasvencidos = diasvencidos;
    }

    public String getMenornombre() {
        return menornombre;
    }

    public void setMenornombre(String menornombre) {
        this.menornombre = menornombre;
    }

    public String getVacunanombre() {
        return vacunanombre;
    }

    public void setVacunanombre(String vacunanombre) {
        this.vacunanombre = vacunanombre;
    }

    public int getId_tutor() {
        return id_tutor;
    }

    public void setId_tutor(int id_tutor) {
        this.id_tutor = id_tutor;
    }
}
