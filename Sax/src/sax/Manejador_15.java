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
public class Manejador_15 extends DefaultHandler {
    String titulo = "";
    String genero = "";
    ArrayList<String> directores;
    ArrayList<String> apellidos;
    String llave = "";
    @Override
    public void startDocument() throws SAXException {
        directores = new ArrayList<>();
        apellidos = new ArrayList<>();
    }
    @Override
    public void endDocument() throws SAXException {
        super.endDocument(); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("pelicula")){
            for(int i=0; i<attributes.getLength(); i++){
                if(attributes.getQName(i).equals("genero")){
                    genero = attributes.getValue(i);
                }
            }
        }else{
            llave = qName;
        }
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("pelicula")){
            System.out.println("***Película***");
            System.out.println("Título: "+titulo+"#");
            System.out.println("Género: "+genero+"#");
            System.out.println("Directores: ");
            for(int i=0; i<directores.size(); i++){
                System.out.println((i+1)+")"+directores.get(i)+" "+apellidos.get(i));
            }
            System.out.println("**************");
            titulo = "";
            genero = "";
            directores.clear();
            apellidos.clear();
            
        }
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        switch(llave){
            case "titulo":    
                titulo = new String(ch,start,length);
                break;
            case "nombre":
                directores.add(new String(ch,start,length));
                break;
            case "apellido":
                apellidos.add(new String(ch,start,length));
                break;
            default:
                
        }
        llave = "";
    }
}
