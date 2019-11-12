/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sax;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 *
 * @author Pablo
 */
public class Sax extends DefaultHandler {

    

    public void getSax(String entradaXML) throws
            ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        Manejador parserSax = new Manejador();
        parser.parse(entradaXML, parserSax);
    }
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        Sax s=new Sax();
        String ruta = System.getenv("USERPROFILE")+"\\Desktop\\peliculas.xml";
        s.getSax(ruta);
    }


}
