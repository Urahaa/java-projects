/*
Matheus Soares Lima
 */

import java.io.File;

import business.CaminhadorGrafo;
import business.ProcessadorArquivo;
import model.Grafo;

public class Main {

    private static String DEFAULT_FILE_PATH = "c:\\temp\\entrada.in";

    public static void main(String[] args) {
        System.out.println("Iniciando o processamento do grafo: " + DEFAULT_FILE_PATH + "\n");

        ProcessadorArquivo processadorArquivo = new ProcessadorArquivo();
        CaminhadorGrafo caminhadorGrafo = new CaminhadorGrafo();
        try {
            Grafo grafoProcessado = processadorArquivo.processarArquivo(new File(DEFAULT_FILE_PATH));

            System.out.println(caminhadorGrafo.aplyKruskal(grafoProcessado));

        } catch (Exception e) {
            e.getMessage();
        }
    }

}
