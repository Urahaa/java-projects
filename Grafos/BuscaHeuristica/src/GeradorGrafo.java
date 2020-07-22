import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import busca.BuscaHeuristica;
import criador.CriadorGrafo;
import model.Grafo;

public class GeradorGrafo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = "";

        System.out.println("Informar o arquivo com os valores da distância em linha reta: ");
        path = scanner.next();
        File fileDistanciaEmLinha = new File(path);

        System.out.println("Informar o arquivo com os valores da distância entre as cidades e com a rota para a busca A*: ");
        path = scanner.next();
        File fileDistanciaCidade = new File(path);

        Grafo grafo;

        try {
            grafo = CriadorGrafo.gerarGrafo(fileDistanciaEmLinha);
            System.out.println("O grafo foi gerado");

            CriadorGrafo.popularGrafo(grafo, fileDistanciaCidade);
            System.out.println("O grafo foi populado");

            System.out.println("Iniciando a busca heuristica no grafo");
            BuscaHeuristica buscaHeuristica = new BuscaHeuristica();
            buscaHeuristica.percorrerGrafo(grafo);
            System.out.println("Finalizado a busca heuristica no grafo");

        } catch (Exception e) {
            System.out.println("Erro ao gerar o grafo");
        }

    }

}
