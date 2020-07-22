package model;

import java.util.HashMap;
import java.util.Map;

public class Grafo {

    private Integer quantidadeVertices;
    private Map<Integer, Vertice> vertices;
    private Integer quantidadeArestas;
    private Integer totalSequenciaGrau;

    public Grafo(Integer quantidadeVertices) {
        this.quantidadeVertices = quantidadeVertices;
        this.vertices = new HashMap<>();
        this.quantidadeArestas = 0;
        this.totalSequenciaGrau = 0;
    }

    public Integer getQuantidadeVertices() {
        return quantidadeVertices;
    }

    public Map<Integer, Vertice> getVertices() {
        return vertices;
    }

    public Integer getQuantidadeArestas() {
        return quantidadeArestas;
    }

    public void setQuantidadeArestas(Integer quantidadeArestas) {
        this.quantidadeArestas = quantidadeArestas;
    }

    public Integer getTotalSequenciaGrau() {
        return totalSequenciaGrau;
    }

    public void setTotalSequenciaGrau(Integer totalSequenciaGrau) {
        this.totalSequenciaGrau = totalSequenciaGrau;
    }
}
