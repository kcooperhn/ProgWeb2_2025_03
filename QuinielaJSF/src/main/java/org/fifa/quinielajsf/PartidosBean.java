package org.fifa.quinielajsf;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import org.fifa.quinielajsf.data.Partido;
import org.fifa.quinielajsf.data.Partidos;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Named("PartidosBean")
@SessionScoped
public class PartidosBean implements java.io.Serializable {
    private Partido partido;
    //private List<Partido> partidos;

    public PartidosBean(){
        this.partido = new Partido();
        //this.partidos = new java.util.ArrayList<>();
    }

    public void registrarPartido() {
        //todo: hacer todas las validaciones que sean necearias
        //this.partidos.add(this.partido);
        Partidos.getInstance().getPartidos().add(this.partido);
        this.partido = new Partido();
    }

    public List<Partido> getPartidosNoJugados() {
        Date ahora = new Date();
        return Partidos.getInstance().getPartidos().stream()
                .filter(p -> p.getFechaHora().after(ahora))
                .collect(Collectors.toList());
    }


    public Partido getPartido() {
        return partido;
    }

    public List<Partido> getPartidos() {
        return Partidos.getInstance().getPartidos();
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }


}
