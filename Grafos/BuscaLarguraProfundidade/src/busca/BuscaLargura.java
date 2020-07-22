package busca;

import static utils.CommonsUtils.gerarData;
import static utils.CommonsUtils.isNotNull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Stack;

import model.Grafo;
import model.Situacao;
import model.Vertice;

public class BuscaLargura implements Busca {

    private Stack<Vertice> fila;

    public BuscaLargura() {
        this.fila = new Stack<>();
    }

    @Override
    public BigDecimal percorrerGrafo(Grafo grafo, Integer codigo) {
        BigDecimal start = BigDecimal.valueOf(System.currentTimeMillis());
        iniciarGrafo(grafo);
        Vertice verticeInicial = grafo.getVertices().get(codigo);
        if (isNotNull(verticeInicial)) {
            verticeInicial.setSituacao(Situacao.CINZA);
            fila.push(verticeInicial);
            try {
                File file = new File("busca_largura_vertice_" + verticeInicial.getCodigo() + "_" + new Date().getTime() +".txt");
                FileWriter fw = new FileWriter(file);
                while (!fila.isEmpty()) {
                    Vertice verticeEmpilhado = fila.pop();
                    List<Vertice> verticesAdjacentes = verticeEmpilhado.getVertices();
                    fw.write("VPai:" + verticeEmpilhado.getCodigo() + " N:" + verticeEmpilhado.getNivel() + "\n");
                    for (Vertice vertice : verticesAdjacentes) {
                        if (Situacao.BRANCO.equals(vertice.getSituacao())) {
                            fila.push(vertice);
                            vertice.setSituacao(Situacao.CINZA);
                            vertice.setVerticePai(verticeEmpilhado);
                            vertice.setDistanciaOrigem(verticeEmpilhado.getDistanciaOrigem() + 1);
                            vertice.setNivel(verticeEmpilhado.getNivel()+1);
                            fw.write("\tVFilho:" + vertice.getCodigo() + " N:" + vertice.getNivel() + "\n");
                            fw.flush();
                        }
                    }
                    verticeEmpilhado.setSituacao(Situacao.PRETO);
                }

                System.out.println(gerarData() + " - Arvore de busca em largura gerada em: " + file.getAbsolutePath());
                fw.flush();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        BigDecimal end = BigDecimal.valueOf(System.currentTimeMillis());
        BigDecimal total = end.subtract(start).divide(BigDecimal.valueOf(1000));

        return total;
    }

    public void iniciarGrafo(Grafo grafo) {
        if (isNotNull(grafo)) {
            grafo.getVertices().values().forEach(vertice -> {
                vertice.setSituacao(Situacao.BRANCO);
                vertice.setVerticePai(null);
                vertice.setDistanciaOrigem(0);
                vertice.setNivel(0);
            });
        }
    }
}

