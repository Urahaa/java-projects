import java.io.File;
import java.util.Date;
import java.util.Scanner;

import busca.Busca;
import busca.BuscaLargura;
import busca.BuscaProfundidade;
import criador.CriadorGrafo;
import criador.GeradorRelatorio;
import model.Grafo;
import model.TipoRepresentacao;

import static utils.CommonsUtils.*;

public class GeradorGrafo {

    public static GeradorRelatorio geradorRelatorio = new GeradorRelatorio();

    public static void main(String[] args) {
        Integer codigoUsuario = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informar caminho do arquivo a ser processado: ");

        Grafo grafo = null;
        File file = null;
        try {
            file = new File(scanner.next());
            grafo = gerarGrafo(file);
            geradorRelatorio.gerarRelatorioGrafoDadosGerais(grafo);
            System.out.println("Informar a forma de representação do grafo: '1' - Matriz adjacência ou 2 - Vetor adjacência");
            geradorRelatorio.gerarRepresentacaoGrafo(grafo, TipoRepresentacao.getTipoPorCodigo(scanner.nextInt()));

            while (codigoUsuario != 0) {

                System.out.println("Informar modo de busca no grafo: '1' - Busca em largura, '2' - Busca em profundidade ou '0' para finalizar a execução");
                codigoUsuario = scanner.nextInt();

                if (codigoUsuario > 0) {
                    System.out.println("Informar vertice para inicio da busca:");
                    Integer codigoBusca = scanner.nextInt();

                    if (codigoUsuario == 1) {
                        System.out.println(gerarData() + " - Iniciando busca em largura no grafo a partir do vértice: " + codigoBusca);
                        executarBuscaLargura(grafo, codigoBusca);
                    } else if (codigoUsuario == 2) {
                        executarBuscaProfundidade(grafo, codigoBusca);
                    }
                    System.out.println(gerarData() + " - Finalizado a busca no grafo");

                    System.out.println(gerarData() + " - Iniciando execução de busca em largura em vértices aleatórios");
                    String filePath = geradorRelatorio.gerarRelatorioComparativoBusca(new BuscaLargura(), grafo, file.getName());
                    System.out.println(gerarData() + " - Gerado comparativo busca em largura: " + filePath);
                    System.out.println(gerarData() + " - Iniciando execução de busca em profundidade em vértices aleatórios");
                    filePath = geradorRelatorio.gerarRelatorioComparativoBusca(new BuscaProfundidade(), grafo, file.getName());
                    System.out.println(gerarData() + " - Gerado comparativo busca em profundidade: " + filePath);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void executarBuscaLargura(Grafo grafo, Integer codigoBusca) {
        Busca buscaLargura = new BuscaLargura();
        buscaLargura.percorrerGrafo(grafo, codigoBusca);
    }

    private static void executarBuscaProfundidade(Grafo grafo, Integer codigoBusca) {
        Busca buscaProfundidade = new BuscaProfundidade();
        buscaProfundidade.percorrerGrafo(grafo, codigoBusca);
    }

    private static Grafo gerarGrafo(File file) throws Exception {
        try {
            Grafo grafo;

            Scanner scanner = new Scanner(file);

            System.out.println(gerarData() + " - Iniciando a geração do grafo a partir do arquivo: " + file.getAbsolutePath());
            CriadorGrafo criadorGrafo = new CriadorGrafo();
            grafo = criadorGrafo.construirGrafo(scanner.nextLine());
            System.out.println(gerarData() + " - Finalizado a geração do grafo");

            System.out.println(gerarData() + " - Populando grafo");
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                criadorGrafo.popularGrafo(grafo, line);
            }

            System.out.println(gerarData() + " - Grafo populado");

            return grafo;
        } catch (Exception e) {
            throw new Exception("Houve um erro ao gerar o grafo");
        }
    }

}
