package org.fifa.quiniela.quinielajsfprimefaces.data;

import java.util.ArrayList;
import java.util.List;

public class Partidos {
    private List<Partido> partidos;
    private List<Pronostico> pronosticos;
    private static Partidos instance;

    private Partidos() {
        this.partidos = new ArrayList<>();
        this.pronosticos = new ArrayList<>();
    }

    public static Partidos getInstance(){
        if(instance == null){
            synchronized(Partidos.class){
                if(instance == null){
                    instance = new Partidos();
                }
            }
        }
        return instance;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }
}
