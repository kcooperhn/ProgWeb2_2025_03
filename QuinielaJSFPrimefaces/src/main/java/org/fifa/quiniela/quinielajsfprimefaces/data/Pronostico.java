package org.fifa.quiniela.quinielajsfprimefaces.data;

public class Pronostico implements java.io.Serializable{
    private Partido partido;
    private int golesLocal;
    private int golesVisitante;
    private String usuario;

    public Pronostico(int golesLocal, int golesVisitante, String usuario, Partido partido) {
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.usuario = usuario;
        this.partido = partido;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
}
