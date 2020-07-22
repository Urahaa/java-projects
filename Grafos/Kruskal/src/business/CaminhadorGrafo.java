/*
Matheus Soares Lima
 */

package business;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import model.ConjuntoVertice;
import model.Grafo;
import model.MatrizDistancia;
import model.Vertice;

public class CaminhadorGrafo {

    private Map<Integer, ConjuntoVertice> A = new HashMap<>();
    private List<MatrizDistancia> E = new ArrayList<>();
    private Integer identificador = 0;

    public int aplyKruskal(Grafo grafo) {
        AtomicInteger custo = new AtomicInteger(0);
        grafo.getVertices().values().forEach(v -> {
            makeSet(Set.of(v));
        });
        E.addAll(grafo.getMatrizes());
        E.sort(Comparator.comparing(MatrizDistancia::getCusto));
        E.forEach(e -> {
            Integer u = findSet(e.getU());
            Integer v = findSet(e.getV());
            if (!u.equals(v)) {
                union(u, v);
                custo.addAndGet(e.getCusto());
            }
        });

        return custo.intValue();
    }

    public void makeSet(Set<Vertice> v) {
        ConjuntoVertice conjuntoVertice = new ConjuntoVertice(identificador, v);
        A.put(conjuntoVertice.getIdentificador(), conjuntoVertice);
        identificador++;
    }

    public Integer findSet(Vertice v) {
        return A.values().stream()
                .filter(conjuntoVertice -> conjuntoVertice.getVertices().contains(v))
                .findFirst()
                .get()
                .getIdentificador();
    }

    public void union(Integer u, Integer v) {
        ConjuntoVertice conjuntoU = A.remove(u);
        ConjuntoVertice conjuntoV = A.remove(v);

        Set<Vertice> unionVertice = new HashSet<>();
        unionVertice.addAll(conjuntoU.getVertices());
        unionVertice.addAll(conjuntoV.getVertices());

        makeSet(unionVertice);
    }

}
