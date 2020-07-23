package model;

public final class Rotulo {
    
    private Integer numeroRotulo;
    private static Integer sequencia = 0;
    private final String codigo = "r";

    public Rotulo() {
        sequencia++;
        setNumeroRotulo(sequencia);
    }
    
    
    public Integer getNumeroRotulo() {
        return numeroRotulo;
    }

    public void setNumeroRotulo(Integer numeroRotulo) {
        this.numeroRotulo = sequencia;
    }

    public static Integer getSequencia() {
        return sequencia;
    }

    public static void setSequencia(Integer sequencia) {
        Rotulo.sequencia = sequencia;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return codigo.concat(String.valueOf(numeroRotulo));
    }
    
    
    
    
}
