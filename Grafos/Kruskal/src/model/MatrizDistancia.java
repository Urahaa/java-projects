/*
Matheus Soares Lima
 */

package model;

public class MatrizDistancia {

    private Vertice u;
    private Vertice v;
    private Integer custo;

    public MatrizDistancia(Vertice u, Vertice v, Integer custo) {
        this.u = u;
        this.v = v;
        this.custo = custo;
    }

    public Vertice getU() {
        return u;
    }

    public void setU(Vertice u) {
        this.u = u;
    }

    public Vertice getV() {
        return v;
    }

    public void setV(Vertice v) {
        this.v = v;
    }

    public Integer getCusto() {
        return custo;
    }

}
