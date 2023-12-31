package com.solvd;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.parser.models.Laptop;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        //JAXB
        File file = new File("src/main/resources/xml/xml.xml");
        try {
            JAXBContext context = JAXBContext.newInstance(Laptop.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Laptop laptop = (Laptop) unmarshaller.unmarshal(file);
            System.out.println(laptop);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        //Jackson
        File jsonFile = new File("src/main/resources/json/jacksonTest.json");
        ObjectMapper mapper = new ObjectMapper();
        try {
            Laptop laptop = mapper.readValue(jsonFile, Laptop.class);
            System.out.println(laptop);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}