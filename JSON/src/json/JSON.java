/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author Pablo
 */
public class JSON {

    public JsonValue leeJSON(String ruta) {
        JsonReader reader = null;
        JsonValue jsonV = null;
        try {
            if (ruta.toLowerCase().startsWith("http://")) {
                URL url = new URL(ruta);
                InputStream is = url.openStream();
                reader = Json.createReader(is);
            } else if (ruta.toLowerCase().startsWith("https://")) {
                URL url = new URL(ruta);
                HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                InputStream is = conn.getInputStream();
                reader = Json.createReader(is);
            } else {
                reader = Json.createReader(new FileReader(ruta));
            }
            jsonV = reader.read();
        } catch (IOException e) {
            System.out.println("Error procesando documento Json " + e.getLocalizedMessage());
        }
        if (reader != null) {
            reader.close();
        }
        return jsonV;
    }

    public static void main(String[] args) {
        JSON j = new JSON();
        j.getNCitys(3, "vigo");
    }

    public JsonObject getDatos(String ciudad) {
        JsonObject obj = (JsonObject)leeJSON("http://api.openweathermap.org/data/2.5/weather?q="+ciudad+",es&lang=es&APPID=a975f935caf274ab016f4308ffa23453");
        return obj;
    }
    public JsonObject getDatos(Double lat, Double lon) {
        JsonObject obj = (JsonObject)leeJSON("http://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&APPID=a975f935caf274ab016f4308ffa23453");
        return obj;
    }
    public JsonObject getNPredicts(int predicts, Double lat, Double lon){
        JsonObject obj = (JsonObject)leeJSON("http://api.openweathermap.org/data/2.5/find?"
                + "lat="+lat
                + "&lon="+lon
                + "&cnt="+predicts
                + "&APPID=a975f935caf274ab016f4308ffa23453");
        return obj;
    }
    public JsonObject getDatosById(int id) {
        JsonObject obj = (JsonObject)leeJSON("http://api.openweathermap.org/data/2.5/weather?id="+id+"&lang=es&APPID=a975f935caf274ab016f4308ffa23453");
        return obj;
    }
    
    public JsonValue getIdCity(String name){
        return getDatos(name).get("id");
    }
    public JsonValue getNameCity(int id){
        return getDatosById(id).get("name");
    }
    public JsonValue getLat(String name){
        return getDatos("vigo").get("coord").asJsonObject().get("lat");
    }
    public JsonValue getLon(String name){
        return getDatos("vigo").get("coord").asJsonObject().get("lon");
    }
    public String getDate(String name){
        return unixTimeToString(Long.parseLong(getDatos("vigo").get("dt").toString()));
    }
    public String unixTimeToString(long unixTime ){
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Instant.ofEpochSecond(unixTime).atZone(ZoneId.of("GMT+1")).format(formatter);
    }
    public JsonValue getTemp(String name){
        return getDatos(name).get("main").asJsonObject().get("temp");
    }
    public JsonValue getHumidity(String name){
        return getDatos(name).get("main").asJsonObject().get("humidity");
    }
    public JsonValue getClouds(String name){
        return getDatos(name).get("clouds").asJsonObject().get("all");
    }
    public JsonValue getWindSpeed(String name){
        return getDatos(name).get("wind").asJsonObject().get("speed");
    }
    public void getNCitys(int n, String name){
        JsonObject obj = getNPredicts(n, Double.parseDouble(getLat(name).toString()), Double.parseDouble(getLat(name).toString()));
        for(int i=0; i< obj.size(); i++){
            System.out.println(obj.asJsonObject().get("name"));            
        }
    }
}
