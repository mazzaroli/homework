package com.solvd;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.parser.models.Laptop;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        // JAXB - Reading from XML
        File xmlFile = new File("src/main/resources/xml/xml.xml");
        try {
            JAXBContext context = JAXBContext.newInstance(Laptop.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Laptop laptop = (Laptop) unmarshaller.unmarshal(xmlFile);
            System.out.println("Deserialized Object: " + laptop);

            // JAXB - Writing to XML
            File outputXmlFile = new File("src/main/resources/xml/output.xml");
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(laptop, outputXmlFile);
            System.out.println("Object successfully written to XML file.");

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        // Jackson - Reading from JSON
        File jsonFile = new File("src/main/resources/json/jacksonTest.json");
        ObjectMapper mapper = new ObjectMapper();
        try {
            Laptop laptop = mapper.readValue(jsonFile, Laptop.class);
            System.out.println("Deserialized Object: " + laptop);

            // Jackson - Writing to JSON
            File outputJsonFile = new File("src/main/resources/json/output.json");
            mapper.writeValue(outputJsonFile, laptop);
            System.out.println("Object successfully written to JSON file.");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}