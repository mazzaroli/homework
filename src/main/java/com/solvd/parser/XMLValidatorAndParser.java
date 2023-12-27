package com.solvd.parser;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class XMLValidatorAndParser {

    /**
     * Validates an XML file against an XSD schema.
     *
     * @param xsdPath Path to the XSD schema file
     * @param xmlPath Path to the XML file to be validated
     * @return true if the XML is valid according to the XSD schema, false otherwise
     */
    public static boolean validateXMLSchema(String xsdPath, String xmlPath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
            return true;
        } catch (IOException | SAXException e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
    }

    /**
     * Parses an XML file using DOM, extracting and printing all elements and their values within the <laptop> node.
     *
     * @param xmlFilePath Path to the XML file to be parsed
     */
    public static void parseXML(String xmlFilePath) {
        try {
            File xmlFile = new File(xmlFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

            NodeList laptopNodeList = doc.getElementsByTagName("laptop");
            for (int temp = 0; temp < laptopNodeList.getLength(); temp++) {
                Node laptopNode = laptopNodeList.item(temp);
                if (laptopNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element laptopElement = (Element) laptopNode;
                    NodeList childNodes = laptopElement.getChildNodes();

                    for (int i = 0; i < childNodes.getLength(); i++) {
                        Node node = childNodes.item(i);
                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                            System.out.println(node.getNodeName() + ": " + node.getTextContent());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String xmlFilePath = "src/main/resources/xml/xml.xml";
        String xsdFilePath = "src/main/resources/xml/xmlValidator.xsd";

        // Validate the XML file against the XSD schema
        boolean isValid = validateXMLSchema(xsdFilePath, xmlFilePath);
        if (isValid) {
            System.out.println("The XML file is valid according to the XSD schema.");
        } else {
            System.out.println("The XML file is not valid according to the XSD schema.");
            return;
        }

        // Parse the XML file using DOM
        parseXML(xmlFilePath);
    }
}