package model;

import java.util.ArrayList;
import java.util.List;

public class Vertice {

    private String codigo;
    private Integer custoHeuristico;
    private Integer custoAcumulado;
    private Integer distanciaAcumulada;
    private String caminho;
    private List<Distancia> distancias;
    private Boolean visitado;

    public Vertice(String codigo, Integer custoHeuristico) {
        this.codigo = codigo;
        this.custoHeuristico = custoHeuristico;
        this.distancias = new ArrayList<>();
        this.visitado = Boolean.FALSE;
        this.custoAcumulado = 0;
        this.distanciaAcumulada = 0;
        this.caminho = "";
    }

    public String getCodigo() {
        return codigo;
    }

    public List<Distancia> getDistancias() {
        return distancias;
    }

    public Boolean getVisitado() {
        return visitado;
    }

    public Integer getCustoHeuristico() {
        return custoHeuristico;
    }

    public void setVisitado(Boolean visitado) {
        this.visitado = visitado;
    }

    public Integer getCustoAcumulado() {
        return custoAcumulado;
    }

    public void setCustoAcumulado(Integer custoAcumulado) {
        this.custoAcumulado = custoAcumulado;
    }

    public Integer getDistanciaAcumulada() {
        return distanciaAcumulada;
    }

    public void setDistanciaAcumulada(Integer distanciaAcumulada) {
        this.distanciaAcumulada = distanciaAcumulada;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
}
