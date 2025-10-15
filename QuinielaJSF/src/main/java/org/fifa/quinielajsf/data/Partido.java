package org.fifa.quinielajsf.data;

import java.time.LocalDateTime;

public class Partido implements java.io.Serializable {

    private String rival1;
    private String rival2;
    private LocalDateTime fechaHora;

    public Partido() {
        this.rival1 = "";
        this.rival2 = "";
        //this.fechaHora = LocalDateTime.now();
    }

    public Partido(String rival1, String rival2, LocalDateTime fechaHora) {
        this.rival1 = rival1;
        this.rival2 = rival2;
        this.fechaHora = fechaHora;
    }

    // Getters y Setters
    public String getRival1() {
        return rival1;
    }

    public void setRival1(String rival1) {
        this.rival1 = rival1;
    }

    public String getRival2() {
        return rival2;
    }

    public void setRival2(String rival2) {
        this.rival2 = rival2;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
}