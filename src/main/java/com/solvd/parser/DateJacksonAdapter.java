package com.solvd.parser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateJacksonAdapter extends JsonDeserializer<Date> {
    static final String CUSTOM_FORMAT_STRING = "dd/mm/yyyy";

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(CUSTOM_FORMAT_STRING);
        String dateString = jsonParser.getText();

        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new IOException("Error al deserializar la fecha: " + e.getMessage());
        }
    }
}