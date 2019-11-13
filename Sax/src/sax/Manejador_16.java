/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Pablo
 */
public class Manejador_16 extends DefaultHandler{
    int nDir = 2;
    int count = 0;
    int pelis = 1;
    String titulo = "";
    String llave = "";
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Películas con más de "+nDir+" directores:");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("titulo")){
            llave = qName;
        }else if(qName.equals("director")){
            count++;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(count>=nDir && qName.equals("pelicula")){
            System.out.println(pelis+")"+titulo);
            pelis++;
            count = 0;
        }else if(qName.equals("pelicula")){
            count = 0;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        switch(llave){
            case "titulo":
                titulo = new String(ch,start,length);
                break;
        }
        llave = "";
    }
    
    
}
