/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sax;

import javax.xml.stream.events.EndElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Pablo
 */
public class Manejador extends DefaultHandler{
String nodo = "";
    @Override
    public void startDocument() throws SAXException {
        super.startDocument(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Comienza el documento.");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Fin del documento.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes); //To change body of generated methods, choose Tools | Templates.
         this.nodo = qName;
        if (this.nodo.equals("pelicula")) {
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.printf("Atributo %s con valor %s%n",
                        attributes.getLocalName(i), attributes.getValue(i));
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName); //To change body of generated methods, choose Tools | Templates.
        if (qName.equals("pelicula")) {
            System.out.println("------------------");
        }
        this.nodo = "";
    }

    @Override
    public void characters(char[] chars, int i, int len) throws SAXException {
        String info = new String(chars, i, len);
        if (this.nodo.equals("titulo")) {
            System.out.println("Película: " + info);
        } else if (this.nodo.equals("nombre")) {
            System.out.println("Director: " + info);
        } else if (this.nodo.equals("apellido")) {
            System.out.println("Apellidos: " + info);
        }
    }
   
}
