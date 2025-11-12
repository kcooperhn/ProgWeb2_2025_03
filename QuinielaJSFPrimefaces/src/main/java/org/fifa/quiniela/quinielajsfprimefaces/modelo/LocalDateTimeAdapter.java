package org.fifa.quiniela.quinielajsfprimefaces.modelo;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    @Override
    public void write(JsonWriter out, LocalDateTime value) throws IOException {
        if (value == null) {
            out.nullValue();
        } else {
            // Convertir LocalDateTime a ZonedDateTime usando la zona horaria del sistema
            ZonedDateTime zonedDateTime = value.atZone(ZoneId.of("America/Tegucigalpa"));
            out.value(FORMATTER.format(zonedDateTime));
        }
    }

    @Override
    public LocalDateTime read(JsonReader in) throws IOException {
        if (in.peek() == com.google.gson.stream.JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        String dateStr = in.nextString();
        // El formateador ya maneja la conversión desde una cadena con zona horaria
        TemporalAccessor temporalAccessor = FORMATTER.parse(dateStr);
        return LocalDateTime.from(temporalAccessor);
    }
}
