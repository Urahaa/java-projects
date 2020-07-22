/*
Matheus Soares Lima
 */

package model;

import java.util.Set;

public class ConjuntoVertice {

    private Integer identificador;
    private Set<Vertice> vertices;

    public ConjuntoVertice(Integer identificador, Set<Vertice> vertices) {
        this.identificador = identificador;
        this.vertices = vertices;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public Set<Vertice> getVertices() {
        return vertices;
    }

}
