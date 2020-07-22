package business;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import model.Grafo;
import model.MatrizDistancia;
import model.Vertice;

import static utils.CommonUtils.*;

public class CaminhadorGrafo {

    private Set<Vertice> Q = new LinkedHashSet<>();
    private Set<Vertice> S = new HashSet<>();

    /*
     * s = vértice inicial
     * u = pivô
     * q = fila de prioridades
     * s = vértices já calculados
     */

    public void aplyDijkstra(Grafo grafo) {
        Vertice u;

        initializeSingleSource(grafo);
        Q.addAll(grafo.getVertices().values());

        while (isNotEmpty(Q)) {
            u = extractMin(Q);
            S.add(u);

            Set<MatrizDistancia> matrizes = u.getMatrizes();
            if (isNotEmpty(matrizes)) {
                final Vertice uFinal = u;
                matrizes.forEach(matrizDistancia -> {
                    Vertice v1 = matrizDistancia.getAdjacente();
                    relax(uFinal, v1, matrizDistancia.getCusto());
                });
            }

        }

        printFinalPath(grafo.getInicio(), grafo.getFim());
    }

    private void relax(Vertice u, Vertice v, Integer w) {
        if (v.getCusto() >= u.getCusto() + w) {
            v.setCusto(u.getCusto() + w);
            v.setPai(u);
        }
    }

    private void initializeSingleSource(Grafo grafo) {
        grafo.getVertices().values().stream().forEach(v -> {
            v.setCusto(Integer.MAX_VALUE);
            v.setPai(null);
        });
        grafo.getInicio().setCusto(0);
    }

    private Vertice extractMin(Set<Vertice> Q) {
        Vertice u = Q.stream().sorted(Comparator.comparing(Vertice::getCusto)).findFirst().get();
        Q.remove(u);
        return u;
    }

    private void printFinalPath(Vertice inicio, Vertice fim) {
        Vertice antecessor = fim.getPai();
        Integer custoCaminho = -1;
        while (isNotNull(antecessor)) {
            if(antecessor.equals(inicio)){
                custoCaminho = fim.getCusto();
                break;
            }
            antecessor = antecessor.getPai();
        }
        System.out.println("Caminho grafo: " + inicio.getCodigo() + " -> " + fim.getCodigo() + ": " + custoCaminho);
    }

}
