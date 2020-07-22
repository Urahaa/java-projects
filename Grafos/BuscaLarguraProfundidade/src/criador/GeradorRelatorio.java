package criador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.Date;
import java.util.Random;

import busca.Busca;
import model.Grafo;
import model.TipoRepresentacao;
import model.Vertice;

import static utils.CommonsUtils.*;

public class GeradorRelatorio {

    private static final BigDecimal KB = new BigDecimal(1024);

    public void gerarRelatorioGrafoDadosGerais(Grafo grafo) throws IOException {
        File file = new File("dados_gerais_grafo.txt");
        file.createNewFile();
        FileWriter fw = new FileWriter(file);
        fw.write("Número de vértices: " + grafo.getQuantidadeVertices() + "\n");
        fw.write("Número de arestas: " + grafo.getQuantidadeArestas() + "\n");
        fw.write("Sequência de grau: " + grafo.getTotalSequenciaGrau() + "\n");

        System.out.println("Gerado acompanhamento com os dados gerais do grafo: " + file.getAbsolutePath());

        fw.close();
    }

    public void gerarRepresentacaoGrafo(Grafo grafo, TipoRepresentacao tipo) throws IOException {
        if (TipoRepresentacao.MATRIZ_ADJACENCIA.equals(tipo)) {
            gerarRepresentacaoMatriz(grafo);
        } else if (TipoRepresentacao.VETOR_ADJACENCIA.equals(tipo)) {
            gerarRepresentacaoVetor(grafo);
        }
    }

    private String gerarRepresentacaoVetor(Grafo grafo) throws IOException {
        File file = new File("representacao_grafo_vetor_" + new Date().getTime() + ".txt");
        file.createNewFile();
        FileWriter fw = new FileWriter(file);

        for (Vertice verticeGrafo : grafo.getVertices().values()) {
            fw.write(gerarLinhaVetor(verticeGrafo));
            fw.flush();
        }
        fw.close();
        BigDecimal tamanhoMb = BigDecimal.valueOf(file.length()).divide(KB, new MathContext(4)).divide(KB, new MathContext(4)).setScale(3, RoundingMode.HALF_DOWN);

        System.out.println(gerarData() + " - Representação lista gerada em: " + file.getAbsolutePath());

        return tamanhoMb + " mb";
    }

    private String gerarLinhaVetor(Vertice verticeGrafo) {
        StringBuilder sb = new StringBuilder();
        sb.append("V:" + verticeGrafo.getCodigo());
        verticeGrafo.getVertices().sort(Comparator.comparing(Vertice::getCodigo));
        for (Vertice vertice : verticeGrafo.getVertices()) {
            sb.append(" -> " + vertice.getCodigo());
        }
        sb.append("\n");
        return sb.toString();
    }

    private String gerarRepresentacaoMatriz(Grafo grafo) throws IOException {
        File file = new File("representacao_grafo_matriz" + new Date().getTime() + ".csv");
        file.createNewFile();
        FileWriter fw = new FileWriter(file);

        fw.write(gerarCabecalhoMatriz(grafo));

        for (Vertice verticeGrafo : grafo.getVertices().values()) {
            fw.append(gerarLinhaMatriz(verticeGrafo, fw));

        }

        fw.flush();
        fw.close();

        BigDecimal tamanhoMb = BigDecimal.valueOf(file.length()).divide(KB, new MathContext(4)).divide(KB, new MathContext(4)).setScale(3, RoundingMode.HALF_DOWN);
        System.out.println(gerarData() + " - Representação matriz gerada em: " + file.getAbsolutePath());
        return tamanhoMb + " mb";
    }

    private String gerarCabecalhoMatriz(Grafo grafo) {
        StringBuilder sb = new StringBuilder();
        sb.append(";");

        for (Vertice verticeCabecalho : grafo.getVertices().values()) {
            sb.append(verticeCabecalho.getCodigo());
            sb.append(";");
        }

        sb.append("\n");
        return sb.toString();
    }

    private String gerarLinhaMatriz(Vertice verticeGrafo, FileWriter fw) throws IOException {
        StringBuilder sb = new StringBuilder();

        Integer count = 1;
        sb.append(verticeGrafo.getCodigo());
        verticeGrafo.getVertices().sort(Comparator.comparing(Vertice::getCodigo));
        for (Vertice vertice : verticeGrafo.getVertices()) {
            sb.append(";");

            if (vertice.getCodigo() == count - 1) {
                Integer numeroRecuperado = Integer.parseInt((sb.toString().substring(sb.length() - 2, sb.length() - 1)).trim());
                numeroRecuperado++;
                sb = new StringBuilder(sb.toString().substring(0, sb.length() - 2));
                sb.append(numeroRecuperado);

            } else {
                while (count < vertice.getCodigo()) {
                    sb.append(";");
                    count++;
                }
                sb.append(1);
            }
            count++;
        }
        sb.append("\n");
        return sb.toString();
    }

    public String gerarRelatorioComparativoBusca(Busca busca, Grafo grafo, String nomeArquivo) {
        Random random = new Random();
        StringBuilder sbLargura = new StringBuilder();
        try {
            File file = new File("comparativo_busca" + busca.getClass().getName() + ".csv");
            file.createNewFile();
            FileWriter fw = new FileWriter(file);

            fw.write(gerarCabecalhoComparativo());
            String sizeMatriz = gerarRepresentacaoMatriz(grafo);
            String sizeVetor = gerarRepresentacaoVetor(grafo);

            fw.write(nomeArquivo.concat(";").concat(sizeMatriz).concat(";").concat(sizeVetor).concat(";"));

            BigDecimal totalTempo = new BigDecimal(0);

            int contadorBusca = 1;
            while (contadorBusca <= 10) {
                int codigoVertice = random.nextInt(grafo.getQuantidadeVertices());
                BigDecimal tempo = busca.percorrerGrafo(grafo, codigoVertice);
                sbLargura.append("V").append(codigoVertice).append(" - ").append(tempo).append("s").append(";");
                contadorBusca++;
                totalTempo = totalTempo.add(tempo);
            }

            BigDecimal media = totalTempo.divide(BigDecimal.valueOf(contadorBusca), new MathContext(4)).setScale(3, RoundingMode.HALF_DOWN);
            sbLargura.append(media).append("s");

            fw.write(sbLargura.toString());
            fw.flush();
            fw.close();

            return file.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String gerarCabecalhoComparativo() {
        StringBuilder sbCabecalho = new StringBuilder();
        sbCabecalho.append("Nome Arquivo").append(";").append("Memoria matriz").append(";").append("Memoria lista").append(";");

        int t = 1;
        while (t <= 10) {
            sbCabecalho.append("T").append(t).append(";");
            t++;
        }
        sbCabecalho.append("Media").append("\n");

        return sbCabecalho.toString();
    }

}
