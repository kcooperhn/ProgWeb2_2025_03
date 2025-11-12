package org.fifa.quiniela.quinielajsfprimefaces.vista;

import org.fifa.quiniela.quinielajsfprimefaces.data.Partido;

import java.util.List;

public interface PartidosViewModel {
    void mostrarMensajeError(String mensaje);
    void mostrarMensajeExito(String mensaje);
    void mostrarPartidos(List<Partido> items);
}
