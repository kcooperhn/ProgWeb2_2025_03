package org.fifa.quiniela.quinielajsfprimefaces.beans;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import org.fifa.quiniela.quinielajsfprimefaces.data.Partido;
import org.fifa.quiniela.quinielajsfprimefaces.data.Partidos;

@FacesConverter("partidoConverter")
public class PartidoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        // Busca el objeto Partido basado en su representación de cadena
        for (Partido partido : Partidos.getInstance().getPartidos()) {
            if (partido.toString().equals(value)) {
                return partido;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof Partido) {
            // Convierte el objeto Partido a su representación de cadena única
            return ((Partido) value).toString();
        }
        // Esto maneja el String vacío de la opción "Seleccione un partido"
        return value.toString();
    }
}
