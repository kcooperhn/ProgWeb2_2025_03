package org.fifa.quiniela.quinielajsfprimefaces.controlador;

import org.fifa.quiniela.quinielajsfprimefaces.data.Partido;
import org.fifa.quiniela.quinielajsfprimefaces.data.ResponsePartidos;
import org.fifa.quiniela.quinielajsfprimefaces.modelo.DatabaseRepositoryImpl;
import org.fifa.quiniela.quinielajsfprimefaces.vista.PartidosViewModel;

public class PartidosInteractorImpl implements PartidosInteractor {

    private DatabaseRepositoryImpl modelo;
    private PartidosViewModel vista;

    public PartidosInteractorImpl(PartidosViewModel vista) {
        super();
        this.vista = vista;
        this.modelo = DatabaseRepositoryImpl.getInstance("https://oracleapex.com",20L);
    }

    @Override
    public void obtenerPartidos() {
        try{
            ResponsePartidos response = this.modelo.consultarPartidos();
            if(response == null || response.getItems() == null || response.getItems().isEmpty()){
                this.vista.mostrarMensajeError("No se encontraron partidos");
            }else{
                this.vista.mostrarPartidos(response.getItems());
            }
        }catch(Exception e){
            this.vista.mostrarMensajeError(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void crearPartido(Partido nuevo) {
        try{
            boolean exito = this.modelo.crearPartido(nuevo);
            if(exito){
                this.vista.mostrarMensajeExito("Partido creado exitosamente!");
                this.obtenerPartidos();
            }else{
                this.vista.mostrarMensajeError("No se encontraron partidos");
            }
        }catch(Exception e){
            this.vista.mostrarMensajeError(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
