package org.fifa.quiniela.quinielajsfprimefaces.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import org.fifa.quiniela.quinielajsfprimefaces.data.Partido;
import org.fifa.quiniela.quinielajsfprimefaces.data.Partidos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Named("PartidosBean")
@SessionScoped
public class PartidosBean implements java.io.Serializable {
    private Partido partido;
    private LocalDateTime minDateTime;
    private LocalDateTime maxDateTime;
    //private List<Partido> partidos;

    public PartidosBean(){
        this.partido = new Partido();
        this.minDateTime = LocalDateTime.now().plusMinutes(20);
        this.maxDateTime = LocalDateTime.now().plusMonths(6);
        //this.partidos = new java.util.ArrayList<>();
    }

    public void registrarPartido() {
        //todo: hacer todas las validaciones que sean necearias
        //this.partidos.add(this.partido);
        Partidos.getInstance().getPartidos().add(this.partido);
        this.partido = new Partido();
        showInfo("Registro de partido", "Registro completado exitosamente!");
    }

    public List<Partido> getPartidosNoJugados() {
        LocalDateTime ahora = LocalDateTime.now();
        return Partidos.getInstance().getPartidos().stream()
                .filter(p -> p.getFechaHora().isAfter(ahora))
                .collect(Collectors.toList());
    }

    public void showInfo(String messageHeader, String messageDetail) {
        addMessage(FacesMessage.SEVERITY_INFO, messageHeader, messageDetail);
    }

    public void showError(String messageHeader, String messageDetail) {
        addMessage(FacesMessage.SEVERITY_ERROR, messageHeader, messageDetail);
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
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

    public LocalDateTime getMinDateTime() {
        return minDateTime;
    }

    public LocalDateTime getMaxDateTime() {
        return maxDateTime;
    }
}
