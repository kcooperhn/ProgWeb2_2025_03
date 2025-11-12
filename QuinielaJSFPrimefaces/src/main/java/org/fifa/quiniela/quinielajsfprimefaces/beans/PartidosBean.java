package org.fifa.quiniela.quinielajsfprimefaces.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.fifa.quiniela.quinielajsfprimefaces.controlador.PartidosInteractor;
import org.fifa.quiniela.quinielajsfprimefaces.controlador.PartidosInteractorImpl;
import org.fifa.quiniela.quinielajsfprimefaces.data.Partido;
import org.fifa.quiniela.quinielajsfprimefaces.data.Partidos;
import org.fifa.quiniela.quinielajsfprimefaces.vista.PartidosViewModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Named("PartidosBean")
@SessionScoped
public class PartidosBean implements java.io.Serializable, PartidosViewModel {
    private Partido partido;
    private LocalDateTime minDateTime;
    private LocalDateTime maxDateTime;
    private List<Partido> items;
    private PartidosInteractor controlador;

    public PartidosBean(){
        this.partido = new Partido();
        this.items = new ArrayList<>();
        this.controlador = new PartidosInteractorImpl(this);
        this.minDateTime = LocalDateTime.now().plusMinutes(20);
        this.maxDateTime = LocalDateTime.now().plusMonths(6);
        this.controlador.obtenerPartidos();
    }

    public void registrarPartido() {
        if(this.partido.getRival1() == null || this.partido.getRival1().isEmpty()){
            showError("Debes de ingresar el equipo local","Error");
            return;
        }
        if(this.partido.getRival2() == null || this.partido.getRival2().isEmpty()){
            showError("Debes de ingresar el equipo visitante","Error");
            return;
        }
        if(this.partido.getFechahora() == null){
            showError("Debes de ingresar la fecha y hora del partido","Error");
            return;
        }
        this.controlador.crearPartido(this.partido);
        this.partido = new Partido();
    }

    public List<Partido> obtenerPartidos(){
        return this.items;
    }

    public List<Partido> getPartidosNoJugados() {
        LocalDateTime ahora = LocalDateTime.now();
        return Partidos.getInstance().getPartidos().stream()
                .filter(p -> p.getFechahora().isAfter(ahora))
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
        return items;
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

    @Override
    public void mostrarMensajeError(String mensaje) {
        showError(mensaje, "Error");
    }

    @Override
    public void mostrarMensajeExito(String mensaje) {
        showInfo(mensaje, "Exito");
    }

    @Override
    public void mostrarPartidos(List<Partido> partidosBD) {
        this.items = partidosBD;
    }
}
