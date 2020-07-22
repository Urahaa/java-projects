package model;

import java.util.HashMap;
import java.util.Map;

public class Grafo {

    private Map<String, Vertice> vertices;
    private Vertice origem;
    private Vertice destino;

    public Grafo() {
        this.vertices = new HashMap<>();
    }

    public Map<String, Vertice> getVertices() {
        return vertices;
    }

    public Vertice getOrigem() {
        return origem;
    }

    public Vertice getDestino() {
        return destino;
    }

    public void setOrigem(Vertice origem) {
        this.origem = origem;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }
}
