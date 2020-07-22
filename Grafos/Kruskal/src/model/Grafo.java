/*
Matheus Soares Lima
 */

package model;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Grafo {

    private Map<Integer, Vertice> vertices;
    private Set<MatrizDistancia> matrizes;
    private Integer qtdCaminhos;

    public Grafo(Integer qtdCaminhos) {
        this.vertices = new HashMap<>();
        this.matrizes = new LinkedHashSet<>();
        this.qtdCaminhos = qtdCaminhos;
    }

    public Map<Integer, Vertice> getVertices() {
        return vertices;
    }

    public Set<MatrizDistancia> getMatrizes() {
        return matrizes;
    }

}



