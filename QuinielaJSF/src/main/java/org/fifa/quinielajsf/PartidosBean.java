package org.fifa.quinielajsf;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.fifa.quinielajsf.data.Partido;

import java.util.List;

@Named("PartidosBean")
@RequestScoped
public class PartidosBean {
    private Partido partido;
    private List<Partido> partidos;

    public PartidosBean(){
        this.partido = new Partido();
        this.partidos = new java.util.ArrayList<>();
    }

    public void registrarPartido() {
        //todo: hacer todas las validaciones que sean necearias
        partidos.add(this.partido);
    }

    public Partido getPartido() {
        return partido;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }
}
