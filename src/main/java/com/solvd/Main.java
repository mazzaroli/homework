package com.solvd;

import com.solvd.parser.models.Laptop;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;


public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/resources/xml/xml.xml");

        try {
            JAXBContext context = JAXBContext.newInstance(Laptop.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Laptop laptop = (Laptop) unmarshaller.unmarshal(file);
            System.out.println(laptop);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}