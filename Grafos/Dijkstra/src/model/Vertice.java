package model;

import java.util.HashSet;
import java.util.Set;

public class Vertice {

    private Integer codigo;
    private Set<MatrizDistancia> matrizes;
    private Integer custo;
    private Vertice pai;

    public Vertice(Integer codigo) {
        this.codigo = codigo;
        this.pai = null;
        this.matrizes = new HashSet<>();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Set<MatrizDistancia> getMatrizes() {
        return matrizes;
    }

    public Integer getCusto() {
        return custo;
    }

    public void setCusto(Integer custo) {
        this.custo = custo;
    }

    public Vertice getPai() {
        return pai;
    }

    public void setPai(Vertice pai) {
        this.pai = pai;
    }
}
