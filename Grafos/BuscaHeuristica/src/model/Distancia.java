package model;

public class Distancia {

    private Vertice verticeDestino;
    private Integer custoDistanciaCidade;

    public Distancia(Vertice verticeDestino, Integer custoDistanciaCidade) {
        this.verticeDestino = verticeDestino;
        this.custoDistanciaCidade = custoDistanciaCidade;
    }

    public Vertice getVerticeDestino() {
        return verticeDestino;
    }

    public Integer getCustoDistanciaCidade() {
        return custoDistanciaCidade;
    }

    public void setVerticeDestino(Vertice verticeDestino) {
        this.verticeDestino = verticeDestino;
    }

    public void setCustoDistanciaCidade(Integer custoDistanciaCidade) {
        this.custoDistanciaCidade = custoDistanciaCidade;
    }
}
