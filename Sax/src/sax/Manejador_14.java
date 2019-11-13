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
public class Manejador_14 extends DefaultHandler {
    int count = 0;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        for(int i=0; i<count; i++){
            System.out.print((char)32);
        }
        System.out.print("<"+qName+">");
        count++;
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.print("</"+qName+">");
        count--;
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String cad = new String(ch,start,length);
        System.out.print(cad);
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Comienzo a leer");
    }
    @Override
    public void endDocument() throws SAXException {

    }
    
}
