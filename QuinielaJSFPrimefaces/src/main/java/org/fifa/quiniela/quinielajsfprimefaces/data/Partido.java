package org.fifa.quiniela.quinielajsfprimefaces.data;

import java.time.LocalDateTime;

public class Partido implements java.io.Serializable {

    private String rival1;
    private String rival2;
    private LocalDateTime fechahora;

    public Partido() {
        this.rival1 = "";
        this.rival2 = "";
        this.fechahora = LocalDateTime.now().plusDays(1);
    }

    public Partido(String rival1, String rival2, LocalDateTime fechahora) {
        this.rival1 = rival1;
        this.rival2 = rival2;
        this.fechahora = fechahora;
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

    public LocalDateTime getFechahora() {
        return fechahora;
    }

    public void setFechahora(LocalDateTime fechahora) {
        this.fechahora = fechahora;
    }

    @Override
    public String toString() {
        return rival1 + " vs " + rival2 ;
    }
}