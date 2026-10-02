/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ficheros;


import static com.mycompany.ejercicios.Ejercicios.mainEjercicios;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author apm25
 */
public class Ficheros {

    public static void main(String[] args) {
        mainEjercicios();
        /*
        File carpeta = new File("/ejercicio");
        
        if(!carpeta.exists()){System.out.println("No existe");}
        
        if(carpeta.isDirectory()){
            System.out.println("Es una carpeta");
        } else {
            System.out.println("Es un archivo");
            System.out.println(carpeta.getName());
            System.out.println(carpeta.getTotalSpace());
        }
        
        //File carpeta = crearCarpeta("datos");
        //File archivo = crearArchivo(carpeta, "Alumnos.mbd");
        System.out.println(carpeta.getAbsolutePath());
        
        //definicion del hashmap
        
        
        //Escritura de fichero
        //escribirFichero(archivo);
        
        //Lectura de fichero
        //ArrayList<String> datos = new ArrayList<>();
        //datos = leerDatos(archivo);
        
        //Escritura binaria
        //introducirEdades(archivo, datos);
        
        
        //Lectura binaria
        //leerFicheroBinario(archivo);
        */
    }
    
    public static File crearCarpeta(String nombre){
        File carpeta = new File(nombre);
        if(!carpeta.exists()) carpeta.mkdir();
        return carpeta;
    }
    
    public static File crearArchivo(File carpeta, String nombre){
        File arch = new File(carpeta, nombre);
        try {
            if(!arch.exists() && arch.createNewFile()){
                System.out.println("Archivo creado correctamente!");
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        return arch;
    }
    
    public static void escribirFichero(File a) {
        Scanner sc = new Scanner(System.in);
        
        try (PrintWriter salida = new PrintWriter(new FileWriter(a.getAbsoluteFile(), true))) {
            for(int i = 0; i < 3; i++){
                System.out.print("Introduce el nombre del alumno: ");
                String nombre = sc.nextLine();
                salida.println(nombre);
                System.out.println();
            }
            salida.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
            System.out.println("Usuarios guardados con éxito :)");
        }
    }
    
    public static List<String> leerDatos(File archivo){
        ArrayList<String> datos = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(archivo.getAbsoluteFile()))){
            String linea;
            while((linea = bf.readLine()) != null){
                datos.add(linea);
            }
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }
    
    
    public static void introducirEdades(File fichero, List<String> datos){
        System.out.println(datos.size());
        try (DataOutputStream ds = new DataOutputStream(new FileOutputStream(fichero.getAbsoluteFile(), false))){
            for(String alumno: datos) {
                ds.writeUTF(alumno + ", Edad: ");
                ds.writeUTF("{ nombre='Juanjo', edad=25 }");
            }
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void leerFicheroBinario(File archivo){
        try(DataInputStream di = new DataInputStream(new FileInputStream(archivo.getAbsoluteFile()))){
            while(true) {
                System.out.println(di.readInt());
            }
        } catch(EOFException e) {
            System.out.println("Fin de fichero");
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
