/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generador.datos.examen;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Clase auxiliar para el profesor.
 * Ejecútala una vez para generar 'equipos.xml' y 'telemetria.dat' en la raíz del proyecto
 * y elimínala antes de entregar la plantilla a los alumnos.
 */
public class GeneradorDatosExamen {

    public static void main(String[] args) {
        generarXml();
        generarBinario();
    }

    private static void generarXml() {
        String xmlContent = """
                <?xml version="1.0" encoding="UTF-8"?>
                <flota>
                    <equipo id="EQ-101">
                        <nombre>Torno CNC Haaz</nombre>
                        <categoria>Mecanizado</categoria>
                    </equipo>
                    <equipo id="EQ-102">
                        <nombre>Fresadora Universal Milko</nombre>
                        <categoria>Mecanizado</categoria>
                    </equipo>
                    <equipo id="EQ-103">
                        <nombre>Soldadora TIG Fronius</nombre>
                        <categoria>Soldadura</categoria>
                    </equipo>
                    <equipo id="EQ-104">
                        <nombre>Carretilla Elevadora Linde</nombre>
                        <categoria>Logistica</categoria>
                    </equipo>
                    <equipo id="EQ-105">
                        <nombre>Prensa Hidraulica 50T</nombre>
                        <categoria>Conformado</categoria>
                    </equipo>
                </flota>
                """;

        try (PrintWriter pw = new PrintWriter(new FileWriter("equipos.xml"))) {
            pw.print(xmlContent);
            System.out.println("Fichero 'equipos.xml' generado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al generar XML: " + e.getMessage());
        }
    }

    private static void generarBinario() {
        // Horas de uso correspondientes a EQ-101, EQ-102, EQ-103, EQ-104 y EQ-105 en orden
        int[] horasEquipos = {1450, 820, 310, 2940, 615};

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("telemetria.dat"))) {
            for (int horas : horasEquipos) {
                dos.writeInt(horas); // Escribe 4 bytes (32 bits) en Big-Endian por cada entero
            }
            System.out.println("Fichero 'telemetria.dat' generado correctamente (" + (horasEquipos.length * 4) + " bytes).");
        } catch (IOException e) {
            System.err.println("Error al generar binario: " + e.getMessage());
        }
    }
}
