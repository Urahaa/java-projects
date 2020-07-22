package business;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import model.Grafo;

import static utils.CommonUtils.*;

public class ProcessadorArquivo {

    public Set<Grafo> processarArquivo(File file) throws Exception {
        Set<Grafo> grafos = new LinkedHashSet<>();

        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String[] scannerLine = scanner.nextLine().split(SPACE);
            Integer qtdVertice = Integer.parseInt(scannerLine[0]);
            Integer qtdCaminhos = Integer.parseInt(scannerLine[0]);

            if (isZero(qtdVertice) || isZero(qtdCaminhos)) {
                System.out.println("Finalizou o processamento");
                break;
            }

            Grafo grafo = GeradorGrafo.criarGrafo(qtdVertice, qtdCaminhos);
            if (isNotNull(grafo)) {
                processarLinha(grafo, scanner);
                grafos.add(grafo);
            }

        }

        return grafos;
    }

    private void processarLinha(Grafo grafo, Scanner scanner) throws Exception {
        String[] scannerLine = scanner.nextLine().split(SPACE);

        Integer v1 = Integer.parseInt(scannerLine[0]);
        Integer v2 = Integer.parseInt(scannerLine[1]);

        if(isZero(v1) || isZero(v2)) {
            throw new Exception("Não é possível popular o grafo");
        }

        Integer custo = null;
        if(scannerLine.length == 3) {
            custo = Integer.parseInt(scannerLine[2]);
        }

        while(isNotNull(custo)){
            GeradorGrafo.popularVerticesGrafo(grafo, v1, v2, custo);

            scannerLine = scanner.nextLine().split(SPACE);

            v1 = Integer.parseInt(scannerLine[0]);
            v2 = Integer.parseInt(scannerLine[1]);
            custo = null;
            if(scannerLine.length == 3) {
                custo = Integer.parseInt(scannerLine[2]);
            }
        }

        GeradorGrafo.setCaminhoBusca(grafo, v1, v2);
    }

}
