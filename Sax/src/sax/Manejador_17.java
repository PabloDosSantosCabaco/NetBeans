/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sax;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Pablo
 */
public class Manejador_17 extends DefaultHandler{
    int count = 0;
    ArrayList<String> generos = new ArrayList<>();
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("pelicula")){
            for(int i=0; i<attributes.getLength(); i++){
                if(attributes.getQName(i).equals("genero")){
                    if(!generos.contains(attributes.getValue(i))){
                        generos.add(attributes.getValue(i));
                    }
                }
            }
        }
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Existen "+generos.size()+" géneros distintos de películas.");
        for(int i=0; i<generos.size(); i++){
            System.out.println(generos.get(i));
        }
    }
    
    
    
}
