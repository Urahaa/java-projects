package busca;

import java.math.BigDecimal;

import model.Grafo;

public interface Busca {

    BigDecimal percorrerGrafo(Grafo grafo, Integer codigo);
    void iniciarGrafo(Grafo grafo);

}
