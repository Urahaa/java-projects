package model;

public class MatrizDistancia {

    private Vertice adjacente;
    private Integer custo;

    public MatrizDistancia(Vertice adjacente, Integer custo) {
        this.adjacente = adjacente;
        this.custo = custo;
    }

    public Vertice getAdjacente() {
        return adjacente;
    }

    public Integer getCusto() {
        return custo;
    }

}
