package org.fifa.quinielajsf;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.fifa.quinielajsf.data.Partido;
import org.fifa.quinielajsf.data.Pronostico;

import java.util.ArrayList;
import java.util.List;

@Named("ResultadosBean")
@RequestScoped
public class ResultadosBean {
    private List<Pronostico> pronosticos;
    private String codigoUsuario;
    private Partido partidoSeleccionado;
    private String golesRival1;
    private String golesRival2;

    public ResultadosBean(){
        limpiarCampos();
        this.pronosticos = new ArrayList<>();
    }

    public void registrarResultado(){
        Pronostico pronosticoNuevo = new Pronostico();
        pronosticoNuevo.setCodigoUsuario(this.codigoUsuario);
        pronosticoNuevo.setPartido(this.partidoSeleccionado);
        pronosticoNuevo.setGolesRival1(this.golesRival1);
        pronosticoNuevo.setGolesRival2(this.golesRival2);

        this.pronosticos.add(pronosticoNuevo);
        limpiarCampos();
    }

    private void limpiarCampos() {
        this.codigoUsuario = "";
        this.partidoSeleccionado = null;
        this.golesRival1 = "";
        this.golesRival2 = "";
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Partido getPartidoSeleccionado() {
        return partidoSeleccionado;
    }

    public void setPartidoSeleccionado(Partido partidoSeleccionado) {
        this.partidoSeleccionado = partidoSeleccionado;
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

    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(List<Pronostico> pronosticos) {
        this.pronosticos = pronosticos;
    }
}
