package model;

import java.util.HashMap;
import java.util.Map;

public class Grafo {

    private Map<Integer, Vertice> vertices;
    private Integer qtdCaminhos;
    private Vertice inicio;
    private Vertice fim;

    public Grafo(Integer qtdCaminhos) {
        this.qtdCaminhos = qtdCaminhos;
        this.vertices = new HashMap<>();
    }

    public Map<Integer, Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(Map<Integer, Vertice> vertices) {
        this.vertices = vertices;
    }


    public Vertice getInicio() {
        return inicio;
    }

    public void setInicio(Vertice inicio) {
        this.inicio = inicio;
    }

    public Vertice getFim() {
        return fim;
    }

    public void setFim(Vertice fim) {
        this.fim = fim;
    }
}
