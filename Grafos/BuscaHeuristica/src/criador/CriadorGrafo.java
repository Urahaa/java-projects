package criador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import model.Distancia;
import model.Grafo;
import model.Vertice;
import utils.CommonsUtils;

public class CriadorGrafo {

    public static Grafo gerarGrafo(File file) throws IOException {
        Grafo grafo = new Grafo();

        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String[] split = scanner.nextLine().split(" ");

            String codigo = split[0];
            Integer custoHeuristico = Integer.parseInt(split[1]);

            Vertice vertice = new Vertice(codigo, custoHeuristico);

            grafo.getVertices().put(vertice.getCodigo(), vertice);
        }

        return grafo;
    }

    public static void popularGrafo(Grafo grafo, File file) throws Exception {
        Scanner scanner = new Scanner(file);

        String line = scanner.nextLine();
        if (CommonsUtils.isNotEmpty(line)) {
            definirOrigemDestino(grafo, line);
        } else {
            throw new IOException("Primeira linha do arquivo sem informação da origem e destino");
        }

        while(scanner.hasNext()) {
            popularRota(grafo, scanner.nextLine());
        }
        System.out.println("As rotas foram populadas no grafo");
    }

    private static void definirOrigemDestino(Grafo grafo, String line) throws Exception {
        String[] split = line.split(" ");

        String codigoOrigem = split[0];
        String codigoDestino = split[1];

        Vertice verticeOrigem = grafo.getVertices().get(codigoOrigem);
        Vertice verticeDestino = grafo.getVertices().get(codigoDestino);

        if (CommonsUtils.isNotNull(verticeOrigem) && CommonsUtils.isNotNull(verticeDestino)) {
            grafo.setOrigem(verticeOrigem);
            grafo.setDestino(verticeDestino);
        } else {
            throw new Exception("Vertice de origem ou destino não foi informado no arquivo de distancia");
        }
    }


    private static void popularRota(Grafo grafo, String line) throws Exception{
        String[] split = line.split(" ");

        String codigoVertice1 = split[0];
        String codigoVertice2 = split[1];
        Integer distanciaCidade = Integer.parseInt(split[2]);

        Vertice vertice1 = grafo.getVertices().get(codigoVertice1);
        Vertice vertice2 = grafo.getVertices().get(codigoVertice2);

        if (CommonsUtils.isNotNull(vertice1) && CommonsUtils.isNotNull(vertice2)) {
            vertice1.getDistancias().add(new Distancia(vertice2, distanciaCidade));
            vertice2.getDistancias().add(new Distancia(vertice1, distanciaCidade));
        } else {
            throw new Exception("Vertice de origem ou destino não foi informado no arquivo de distancia");
        }
    }

}
