package business;

import model.Grafo;
import model.MatrizDistancia;
import model.Vertice;

import static utils.CommonUtils.*;

public class GeradorGrafo {

    public static Grafo criarGrafo(Integer qtdVertice, Integer qtdCaminhos) {
        Grafo grafo = null;

        if(isNotZero(qtdVertice) && isNotZero(qtdCaminhos)) {
            grafo = new Grafo(qtdCaminhos);

            Integer count = 1;
            while(count <= qtdVertice){
                Vertice v = new Vertice(count);
                grafo.getVertices().put(v.getCodigo(), v);
                count ++;
            }
        }
        return grafo;
    }

    public static void popularVerticesGrafo(Grafo grafo, Integer v1, Integer v2, Integer custo) throws Exception {
        Vertice vertice = grafo.getVertices().get(v1);
        Vertice caminho = grafo.getVertices().get(v2);

        validarVertices(vertice, caminho);

        MatrizDistancia matrizDistancia = new MatrizDistancia(caminho, custo);
        vertice.getMatrizes().add(matrizDistancia);

    }

    private static void validarVertices(Vertice vertice, Vertice caminho) throws Exception {
        if (isNull(vertice) || isNull(caminho)) {
            throw new Exception("Não é possível realizar a busca em vértices não adicionados ao grafo");
        }
    }

    public static void setCaminhoBusca(Grafo grafo, Integer v1, Integer v2) throws Exception {
        if(isNotNull(grafo) && isNotZero(v1) && isNotZero(v2)) {
            Vertice inicio = grafo.getVertices().get(v1);
            Vertice fim = grafo.getVertices().get(v2);

            validarVertices(inicio, fim);

            grafo.setInicio(inicio);
            grafo.setFim(fim);
        }
    }
}
