package org.fifa.quiniela.quinielajsfprimefaces.beans;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.model.SelectItem;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.fifa.quiniela.quinielajsfprimefaces.data.Partido;
import org.fifa.quiniela.quinielajsfprimefaces.data.Partidos;
import org.fifa.quiniela.quinielajsfprimefaces.data.Pronostico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("PronosticosBean")
@ViewScoped
public class PronosticosBean implements Serializable {
    private Partido partido;
    private String usuario;
    private int golesLocal;
    private int golesVisitante;
    private List<SelectItem> partidosItems;

    @PostConstruct
    public void init() {
        partidosItems = new ArrayList<>();
        for (Partido p : Partidos.getInstance().getPartidos()) {
            partidosItems.add(new SelectItem(p, p.toString()));
        }
        limpiarPantalla();
    }

    public void limpiarPantalla(){
        this.golesLocal = 0;
        this.golesVisitante = 0;
        this.usuario = "";
        // No inicializar partido a new Partido() para que la selección se mantenga
    }

    public void registrarPronostico() {
        if (partido == null) {
            showError("Error de validación", "Debe seleccionar un partido.");
            return;
        }
        Pronostico pronostico = new Pronostico(golesLocal, golesVisitante, usuario, partido);
        Partidos.getInstance().getPronosticos().add(pronostico);

        limpiarPantalla();
        showInfo("Registro de pronóstico", "Registro guardado exitosamente!");
    }

    public List<Pronostico> obtenerPronosticos(){
        return Partidos.getInstance().getPronosticos();
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

    // Getters y Setters

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public List<SelectItem> getPartidosItems() {
        return partidosItems;
    }

    public void setPartidosItems(List<SelectItem> partidosItems) {
        this.partidosItems = partidosItems;
    }
}
