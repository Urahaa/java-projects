package busca;

import model.Grafo;
import model.Situacao;
import model.Vertice;

import static utils.CommonsUtils.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

public class BuscaProfundidade implements Busca {

    private Integer tempo;

    public BuscaProfundidade() {
        this.tempo = 0;
    }

    @Override
    public BigDecimal percorrerGrafo(Grafo grafo, Integer codigo) {
        BigDecimal start = BigDecimal.valueOf(System.currentTimeMillis());

        iniciarGrafo(grafo);
        Vertice verticeInicial = grafo.getVertices().get(codigo);
        if (isNotNull(verticeInicial)) {
            try {
                File file = new File("busca_profundidade_vertice_" + verticeInicial.getCodigo() + "_" + new Date().getTime() + ".txt");
                FileWriter fw = new FileWriter(file);

                if (Situacao.BRANCO.equals(verticeInicial.getSituacao())) {
                    dfsVisit(verticeInicial, fw);
                }
                System.out.println(gerarData() + " - Arvore de busca em profundidade gerada em: " + file.getAbsolutePath());
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

    private void dfsVisit(Vertice verticeVisitado, FileWriter fw) throws IOException {
        //Problema de memoria ao utilizar o arquivo teste2.txt
        fw.write("VPai:" + verticeVisitado.getCodigo() + " Dist:" + verticeVisitado.getDistanciaOrigem() + "\n");
        fw.flush();
        verticeVisitado.setSituacao(Situacao.CINZA);
        tempo = tempo +1;
        verticeVisitado.setDistanciaOrigem(tempo);
        for (Vertice vertice : verticeVisitado.getVertices()) {
            if (Situacao.BRANCO.equals(vertice.getSituacao())) {
                vertice.setDistanciaOrigem(verticeVisitado.getDistanciaOrigem());
                fw.write("\tVFilho:" + vertice.getCodigo() + " Dist:" + vertice.getDistanciaOrigem() + "\n");
                fw.flush();
                dfsVisit(vertice, fw);
            }
        }
        tempo = tempo +1;
        verticeVisitado.setSituacao(Situacao.PRETO);
        verticeVisitado.setDistanciaOrigem(tempo);

        fw.write("VPai:" + verticeVisitado.getCodigo() + " Dist:" + verticeVisitado.getDistanciaOrigem() + "\n");
        fw.flush();
    }

    @Override
    public void iniciarGrafo(Grafo grafo) {
        if (isNotNull(grafo)) {
            grafo.getVertices().values().forEach(vertice -> {
                vertice.setSituacao(Situacao.BRANCO);
                vertice.setDistanciaOrigem(0);
                tempo = 0;
            });
        }
    }
}
