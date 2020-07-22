package model;

import java.util.ArrayList;
import java.util.List;

public class Vertice {

    private Integer codigo;
    private Integer distanciaOrigem;
    private Integer sequenciaGrau;
    private Integer nivel;

    private List<Vertice> vertices;
    private Vertice verticePai;

    private Situacao situacao;

    public Vertice(Integer codigo) {
        this.codigo = codigo;
        this.distanciaOrigem = 0;
        this.verticePai = null;
        this.vertices = new ArrayList<>();
        this.sequenciaGrau = 0;
        this.situacao = Situacao.BRANCO;
        this.nivel = 0;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Integer getDistanciaOrigem() {
        return distanciaOrigem;
    }

    public void setDistanciaOrigem(Integer distanciaOrigem) {
        this.distanciaOrigem = distanciaOrigem;
    }

    public Vertice getVerticePai() {
        return verticePai;
    }

    public void setVerticePai(Vertice verticePai) {
        this.verticePai = verticePai;
    }

    public Integer getSequenciaGrau() {
        return sequenciaGrau;
    }

    public void setSequenciaGrau(Integer sequenciaGrau) {
        this.sequenciaGrau = sequenciaGrau;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
}
