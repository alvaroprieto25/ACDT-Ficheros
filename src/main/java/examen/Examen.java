/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Examen {

    public static void main(String[] args) {
        System.out.println("=== INICIANDO PROCESAMIENTO DE FLOTA ===");

        // Definición de ficheros según el enunciado
        File fXml = new File("equipos.xml");
        File fBinario = new File("telemetria.dat");
        File fSalida = new File("reporte_flota.json");

        // Verificación básica para ayudar al alumno a detectar si falta algún archivo en la raíz
        if (!fXml.exists() || !fBinario.exists()) {
            System.err.println("ADVERTENCIA: No se encuentran los ficheros de entrada ('equipos.xml' o 'telemetria.dat') en la raíz del proyecto.");
        }

        // 1. Carga de datos combinada (XML + Binario)
        System.out.println("\n1. Cargando datos desde XML y fichero binario...");
        List<Maquinaria> flota = cargarFlota(fXml, fBinario);

        // Comprobación por consola de los objetos cargados
        if (flota != null && !flota.isEmpty()) {
            System.out.println("Se han cargado " + flota.size() + " equipos correctamente:");
            for (Maquinaria m : flota) {
                System.out.println(" -> " + m);
            }
        } else {
            System.out.println("La lista de flota está vacía o no se ha podido cargar.");
        }

        // 2. Exportación a JSON
        System.out.println("\n2. Exportando flota a formato JSON...");
        exportarAJson(flota, fSalida);

        System.out.println("\n=== PROCESO FINALIZADO ===");
    }

    /**
     * PARTE B: Parseo XML (DOM o SAX) y Lectura de Atributo Binario[cite: 1]
     * 
     * @param fXml     Fichero XML de entrada (equipos.xml)[cite: 1]
     * @param fBinario Fichero binario de entrada (telemetria.dat)[cite: 1]
     * @return Lista de objetos Maquinaria con los datos combinados[cite: 1]
     */
    public static List<Maquinaria> cargarFlota(File fXml, File fBinario) {
        List<Maquinaria> lista = new ArrayList<>();

        // TODO: 
        // 1. Leer 'equipos.xml' usando DOM o SAX para extraer id, nombre y categoria.[cite: 1]
        // 2. Por cada equipo, leer de forma coordinada desde 'telemetria.dat' las horasUso (int de 32 bits) con DataInputStream.[cite: 1]
        // 3. Instanciar Maquinaria y añadirla a la colección 'lista'.[cite: 1]

        return lista;
    }

    /**
     * PARTE C: Exportación de la Colección a JSON[cite: 1]
     * 
     * @param flota   Lista de maquinaria cargada previamente[cite: 1]
     * @param fSalida Fichero de destino (reporte_flota.json)[cite: 1]
     */
    public static void exportarAJson(List<Maquinaria> flota, File fSalida) {
        // TODO:
        // 1. Configurar Gson con GsonBuilder para salida formateada (pretty printing).[cite: 1]
        // 2. Serializar la lista 'flota' y guardarla en 'fSalida' asegurando el cierre de flujos.[cite: 1]

    }
}