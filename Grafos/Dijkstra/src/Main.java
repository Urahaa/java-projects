import java.io.File;
import java.util.Set;

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
            Set<Grafo> grafosProcessados = processadorArquivo.processarArquivo(new File(DEFAULT_FILE_PATH));

            for(Grafo grafo : grafosProcessados) {
                caminhadorGrafo.aplyDijkstra(grafo);
            }

        } catch (Exception e) {
            e.getMessage();
        }
    }

}
