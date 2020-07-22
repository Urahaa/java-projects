/*
Matheus Soares Lima
 */

package business;

import java.io.File;
import java.util.Scanner;

import model.Grafo;

import static utils.CommonUtils.*;

public class ProcessadorArquivo {

    public Grafo processarArquivo(File file) throws Exception {
        Grafo grafo = null;

        Scanner scanner = new Scanner(file);

        if (scanner.hasNext()) {
            String[] scannerLine = scanner.nextLine().split(SPACE);
            Integer qtdVertice = Integer.parseInt(scannerLine[0]);
            Integer qtdCaminhos = Integer.parseInt(scannerLine[0]);

            if (isZero(qtdVertice) || isZero(qtdCaminhos)) {
                System.out.println("Finalizou o processamento");
            }

            grafo = GeradorGrafo.criarGrafo(qtdVertice, qtdCaminhos);
            if (isNotNull(grafo)) {
                processarLinha(grafo, scanner);
            }

        }
        return grafo;
    }

    private void processarLinha(Grafo grafo, Scanner scanner) throws Exception {
        Integer v1;
        Integer v2;
        Integer custo;
        while (scanner.hasNext()) {
            String[] scannerLine = scanner.nextLine().split(SPACE);

            v1 = Integer.parseInt(scannerLine[0]);
            v2 = Integer.parseInt(scannerLine[1]);
            custo = Integer.parseInt(scannerLine[2]);

            if (isZero(v1) || isZero(v2)) {
                throw new Exception("Não é possível popular o grafo");
            }

            GeradorGrafo.popularVerticesGrafo(grafo, v1, v2, custo);

        }
    }

}
