/*
Matheus Soares Lima
 */

package business;

import model.Grafo;
import model.MatrizDistancia;
import model.Vertice;

import static utils.CommonUtils.*;

public class GeradorGrafo {

    public static Grafo criarGrafo(Integer qtdVertice, Integer qtdCaminhos) {
        Grafo grafo = null;

        if (isNotZero(qtdVertice) && isNotZero(qtdCaminhos)) {
            grafo = new Grafo(qtdCaminhos);

            Integer count = 1;
            while (count <= qtdVertice) {
                Vertice v = new Vertice(count);
                grafo.getVertices().put(v.getCodigo(), v);
                count++;
            }
        }
        return grafo;
    }

    public static void popularVerticesGrafo(Grafo grafo, Integer v1, Integer v2, Integer custo) {
        Vertice vertice = grafo.getVertices().get(v1);
        Vertice caminho = grafo.getVertices().get(v2);

        MatrizDistancia matrizDistancia = new MatrizDistancia(vertice, caminho, custo);
        grafo.getMatrizes().add(matrizDistancia);

    }
}
