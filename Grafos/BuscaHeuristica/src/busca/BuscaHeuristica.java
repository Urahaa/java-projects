package busca;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import model.Distancia;
import model.Grafo;
import model.Vertice;

public class BuscaHeuristica {

    public void percorrerGrafo(Grafo grafo) throws IOException {
        iniciarGrafo(grafo);
        List<Vertice> listaPrioridade = new ArrayList<>();
        File file = new File("expansao_vertices.txt");
        file.createNewFile();
        FileWriter fw = new FileWriter(file);

        Vertice verticeOrigem = grafo.getOrigem();
        verticeOrigem.setCaminho(verticeOrigem.getCodigo());
        Vertice verticeDestino = grafo.getDestino();
        listaPrioridade.add(verticeOrigem);
        fw.write("Expansão de busca dos vértices com o custo:\n");
        fw.write("V:" + verticeOrigem.getCodigo() + " " + verticeOrigem.getDistanciaAcumulada() + " + " + verticeOrigem.getCustoHeuristico() + " = " + verticeOrigem.getCustoAcumulado() + "\n");
        while (listaPrioridade.size() > 0) {
            listaPrioridade.sort(Comparator.comparing(Vertice::getCustoAcumulado));
            Vertice verticeVisitado = listaPrioridade.remove(0);
            System.out.println("Visitando vertice: " + verticeVisitado.getCodigo());
            System.out.println("Vertice destino: " + verticeDestino.getCodigo());
            if (verticeVisitado.equals(verticeDestino)) {
                fw.write("V:" + verticeVisitado.getCodigo() + " " + verticeVisitado.getDistanciaAcumulada() + " + " + verticeVisitado.getCustoHeuristico() + " = " + verticeVisitado.getCustoAcumulado() + "\n");
                System.out.println("Encontrou a rota");
                break;
            }

            for (Distancia verticeDistancia : verticeVisitado.getDistancias()) {
                Vertice v = verticeDistancia.getVerticeDestino();
                v.setDistanciaAcumulada(verticeDistancia.getCustoDistanciaCidade() + verticeVisitado.getDistanciaAcumulada());
                v.setCustoAcumulado(v.getCustoHeuristico() + v.getDistanciaAcumulada());
                fw.write("\tV:" + v.getCodigo() + " " + v.getDistanciaAcumulada() + " + " + v.getCustoHeuristico() + " = " + v.getCustoAcumulado() + "\n");
                fw.flush();
                v.setCaminho(verticeVisitado.getCaminho() + " -> " + v.getCodigo());
                listaPrioridade.add(v);
            }

        }
        fw.write("\nCaminho mais curto adotado:" + "\n" + verticeDestino.getCaminho());

        fw.close();

    }

    private void iniciarGrafo(Grafo grafo) {
        grafo.getVertices().values().forEach(vertice -> {
            vertice.setVisitado(Boolean.FALSE);
            vertice.setCustoAcumulado(0);
            vertice.setDistanciaAcumulada(0);
        });
    }

}
