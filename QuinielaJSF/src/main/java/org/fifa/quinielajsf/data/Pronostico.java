package org.fifa.quinielajsf.data;

import java.util.Date;

public class Pronostico {
    private String golesRival1;
    private String golesRival2;
    private Partido partido;
    private Date fechaHoraPronostico;
    private String codigoUsuario;

    public Pronostico() {
        this.golesRival1 = "";
        this.golesRival2 = "";
        this.partido = null;
        this.fechaHoraPronostico = new Date();
        this.codigoUsuario = "";
    }

    public String getGolesRival1() {
        return golesRival1;
    }

    public void setGolesRival1(String golesRival1) {
        this.golesRival1 = golesRival1;
    }

    public String getGolesRival2() {
        return golesRival2;
    }

    public void setGolesRival2(String golesRival2) {
        this.golesRival2 = golesRival2;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Date getFechaHoraPronostico() {
        return fechaHoraPronostico;
    }

    public void setFechaHoraPronostico(Date fechaHoraPronostico) {
        this.fechaHoraPronostico = fechaHoraPronostico;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }
}
