/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasandoficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RepasandoFicheros {

    class Caracter{
        char nombre;
        int cont;
        public Caracter(char nombre){
            this.nombre = nombre;
            this.cont = 1;
        }
        public void aumentar(){
            this.cont++;
        }

        public char getNombre() {
            return nombre;
        }

        public int getCont() {
            return cont;
        }

        @Override
        public boolean equals(Object obj) {
            Caracter c=(Caracter) obj;
            return c.getNombre()==this.nombre;
        }

        
        
    }
    public static void main(String[] args) {
        RepasandoFicheros e = new RepasandoFicheros();
        String ruta = System.getenv("USERPROFILE")+"\\Desktop\\ruta";
        e.Ejercicio8(new File(ruta+"\\A.txt"),new byte[1]);
        e.Ejercicio8(new File(ruta+"\\A.txt"),new byte[1000000]);
    }
    
    //Ejercicio 8
    public void Ejercicio8(File f,byte[] buffer){
        try(FileInputStream in = new FileInputStream(f);
            FileOutputStream out = new FileOutputStream(f.getParent()+"\\copia.txt")){
            int i;
            while((i=in.read(buffer))!=-1){
                out.write(buffer,0,i);
            }
        }catch(IOException ex){
        }
        System.out.println(System.currentTimeMillis());
    }
    public void Ejercicio8(File f){
        Ejercicio8(f,new byte[1]);
    }
    //Ejercicio 7
    public void Ejercicio7(String archivo, char operacion){
        ArrayList<String> lineas = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(archivo))){
            while(sc.hasNext()){
                lineas.add(sc.nextLine());
            }
        }catch(FileNotFoundException ex){
        }
        Collections.sort(lineas);
        switch(operacion){
            case 'n':
                System.out.printf("El archivo tiene %s lineas y %s palabras\n",
                        cuentaLineasYPalabras(archivo,true),
                        cuentaLineasYPalabras(archivo,false));
                break;
            case 'A':
                ordenarPorLineas(archivo, lineas);
                break;
            case 'D':
                Collections.reverse(lineas);
                ordenarPorLineas(archivo, lineas);
                break;
            case 'a':
                Collections.sort(lineas,String.CASE_INSENSITIVE_ORDER);                
                ordenarPorLineas(archivo, lineas);
                break;
            case 'd':
                Collections.sort(lineas,String.CASE_INSENSITIVE_ORDER);
                Collections.reverse(lineas);
                ordenarPorLineas(archivo, lineas);
                break;
            default:
                System.out.println("Error.");
        }
    }
    public void ordenarPorLineas(String archivo,ArrayList<String> cadenas){
        try(PrintWriter pOut = new PrintWriter(new FileWriter(
                (new File(archivo).getParent()+"\\ordenado.txt"),true))){
            for(int i=0; i<cadenas.size(); i++){
                pOut.write(cadenas.get(i)+"\n");
            }
        }catch(IOException ex){
        }
    }
    public int cuentaLineasYPalabras(String archivo,boolean lineas){
        int cont = 0;
        try(Scanner sc = new Scanner(new File(archivo))){
            while(sc.hasNext()){
                if(lineas)sc.nextLine();
                else    sc.next();
                cont++;
            }
        }catch(FileNotFoundException ex){
        }
        return cont;
    }
    //Ejercicio 6
    public void Ejercicio6_1(File f,int n){
        char[] buffer = new char[n];
        int contador = 0;
        try(FileReader fIn = new FileReader(f)){
            int i;
            while((i=fIn.read(buffer))!=-1){
                try(FileWriter fOut = new FileWriter(new File(f.getParent()+"\\"+contador+".txt"))){
                    contador++;
                    fOut.write(buffer,0,i);
                }
            }
        }catch(IOException ex){
            System.out.println("No encotnrado");   
        }
    }
    public void Ejercicio6_2(File f, int n){
        int contador = 0;
        try(Scanner sc = new Scanner(f)){
            while(sc.hasNext()){
                try(PrintWriter pOut = new PrintWriter(new FileWriter(f.getParent()+"\\"
                        +contador+".txt",true))){
                    for (int i=0;i<n && sc.hasNext();i++){
                        pOut.write(sc.nextLine()+"\n");
                    }
                    contador++;
                } catch (IOException ex) {
                    Logger.getLogger(RepasandoFicheros.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }catch(FileNotFoundException ex){
            
        }
    }
    public void Ejercicio6_3(File...f){
        String ruta = System.getenv("USERPROFILE")+"\\Desktop\\ruta";
        try(PrintWriter pOut = new PrintWriter(new FileWriter(new File(ruta+"\\resumen.txt"),true))){
            for(int i=0; i<f.length; i++){
                try(Scanner sc = new Scanner(f[i])){
                    while(sc.hasNext()){
                        pOut.write(sc.nextLine()+"\n");
                    }
                }
            }
        }catch(IOException ex){
        }
    }
    
    //Ejercicio 5
    public void Ejercicio5(File f,String cadena){
        int cont = 1;
        try(Scanner sc = new Scanner(f)){
            while(sc.hasNext()){
                if(sc.nextLine().toLowerCase().contains(cadena.toLowerCase())){
                    System.out.println("Linea "+cont);
                }
                cont++;
            }
        }catch(FileNotFoundException ex){
            System.out.println("No se encontró el archivo");
        }
    }
    //Ejercicio 4
    public char Ejercicio4(File f){
        char caracter = 'b';
        ArrayList<Caracter> caracteres = new ArrayList<>();
        try(FileReader fIn = new FileReader(f)){
            int i;
            while((i=fIn.read())!=1){
                if(caracteres.contains(new Caracter((char)i))){
                    caracteres.get(caracteres.indexOf(new Caracter((char)i))).aumentar();
                }else{
                    caracteres.add(new Caracter((char)i));
                }
            }
        }catch(IOException ex){
        }
        int max = 0;
        for(int i=0; i<caracteres.size(); i++){
            if(caracteres.get(i).cont>max){
                caracter = caracteres.get(i).getNombre();
                max = caracteres.get(i).getCont();
            }
        }
        return caracter;
    }
    //Ejercicio 3
    public int Ejercicio3(File f,char caracter){
        int count = 0;
        try(FileReader fIn = new FileReader(f)){
           int i;
           while((i=fIn.read())!=-1){
               if((char)i==caracter){
                   count++;
               }
           }
        }catch(IOException ex){
            
        }
        return count;
    }
    
    //Ejercicio 2
    public void Ejercicio2(File f){
        File[] archivos = f.listFiles();
        for(int i=0; i<archivos.length; i++){
            System.out.println(archivos[i].getAbsolutePath());
            if(archivos[i].isDirectory()){
                Ejercicio2(archivos[i]);
            }
        }
        
    }
    
    //Ejericio 1
    public void showDirectoryContent(File f){
        File[] archivos = f.listFiles();
        for(File a:archivos){
            if(a.isDirectory()){
                System.out.println(a.getAbsolutePath());
            }
        }
        for(File a:archivos){
            if(!a.isDirectory()){
                System.out.println(a.getAbsolutePath());
            }
        }
    }
}
