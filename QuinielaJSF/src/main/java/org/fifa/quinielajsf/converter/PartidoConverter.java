package org.fifa.quinielajsf.converter;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.fifa.quinielajsf.PartidosBean;
import org.fifa.quinielajsf.data.Partido;
import org.fifa.quinielajsf.data.Partidos;

@FacesConverter("partidoConverter")
public class PartidoConverter implements Converter<Partido> {

    @Inject
    private PartidosBean partidosBean;

    /**
     * Convierte un objeto Partido a su representación única como String.
     * Esta cadena se usará como el 'value' de la opción en el HTML.
     * Usamos una combinación de los nombres de los rivales y el timestamp para asegurar la unicidad.
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Partido partido) {
        if (partido == null || partido.getRival1() == null || partido.getRival2() == null || partido.getFechaHora() == null) {
            return "";
        }
        return partido.getRival1() + "-vs-" + partido.getRival2() + "_" + partido.getFechaHora().getTime();
    }

    /**
     * Convierte la representación en String (enviada desde el navegador) de vuelta a un objeto Partido.
     * Busca en la lista de todos los partidos disponibles en PartidosBean para encontrar la instancia correcta.
     */
    @Override
    public Partido getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }

        try {
            String[] parts = value.split("_");
            String[] rivals = parts[0].split("-vs-");
            long time = Long.parseLong(parts[1]);

            // Buscamos en la lista completa de partidos del bean
            for (Partido partido : Partidos.getInstance().getPartidos()) {
                if (partido.getRival1().equals(rivals[0]) &&
                        partido.getRival2().equals(rivals[1]) &&
                        partido.getFechaHora().getTime() == time) {
                    return partido;
                }
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new ConverterException("El formato del valor del partido no es válido: " + value, e);
        }

        return null;
    }
}