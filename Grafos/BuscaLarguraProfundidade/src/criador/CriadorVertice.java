package criador;

import model.Vertice;

public class CriadorVertice {

    public Vertice criarVertice(Integer codigo) {
        Vertice vertice = new Vertice(codigo);
        return vertice;
    }
}
