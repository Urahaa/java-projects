package model;

import java.util.HashMap;
import java.util.Map;

public enum TipoRepresentacao {

    MATRIZ_ADJACENCIA(1),
    VETOR_ADJACENCIA(2);


    public Integer codigo;
    private static final Map<Integer, TipoRepresentacao> tiposRepresentacao = new HashMap<>();

    static {
        for (TipoRepresentacao tipo: TipoRepresentacao.values()) {
            tiposRepresentacao.put(tipo.getCodigo(), tipo);
        }
    }

    TipoRepresentacao(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public static TipoRepresentacao getTipoPorCodigo(Integer codigo) {
        return tiposRepresentacao.get(codigo);
    }
}
