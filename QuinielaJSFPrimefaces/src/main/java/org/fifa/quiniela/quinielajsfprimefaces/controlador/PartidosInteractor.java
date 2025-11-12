package org.fifa.quiniela.quinielajsfprimefaces.controlador;

import org.fifa.quiniela.quinielajsfprimefaces.data.Partido;

public interface PartidosInteractor {

    void obtenerPartidos();
    void crearPartido(Partido nuevo);
}
