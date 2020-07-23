package model;

public enum IdEnum {
    IDENTIFICADOR(2, "identificador"),
    INTEIRO(3, "constante inteira"),
    REAL(4, "constante real"),
    BINARIA(5, "constante binária"),
    HEXADECIMAL(6, "constante hexadecimal"),
    STRING(7, "constante string"),
    BIN(8, "palavra reservada"),
    BOOl(9, "palavra reservada"),
    DEF(10, "palavra reservada"),
    DO(11, "palavra reservada"),
    ELIF(12, "palavra reservada"),
    ELSE(13, "palavra reservada"),
    END(14, "palavra reservada"),
    FALSE(15, "palavra reservada"),
    FLOAT(16, "palavra reservada"),
    HEXA(17, "palavra reservada"),
    IF(18, "palavra reservada"),
    INT(19, "palavra reservada"),
    LISTEN(20, "palavra reservada"),
    MAIN(21, "palavra reservada"),
    SPEAK(22, "palavra reservada"),
    STR(23, "palavra reservada"),
    TOINT(24, "palavra reservada"),
    TOBIN(25, "palavra reservada"),
    TOHEXA(26, "palavra reservada"),
    TRUE(27, "palavra reservada"),
    WHILEFALSE(28, "palavra reservada"),
    ABREPARENTESES (29, "símbolo especial"), 
    FECHAPARENTESES (30, "símbolo especial"), 
    DOISIGUAIS (31, "símbolo especial"), 
    DIFERENTE (32, "símbolo especial"), 
    MENOR (33, "símbolo especial"), 
    MAIOR (34, "símbolo especial"), 
    ECOMERCIAL (35, "símbolo especial"), 
    PIPE (36, "símbolo especial"), 
    EXCLAMACAO (37, "símbolo especial"), 
    MAIS (38, "símbolo especial"), 
    MENOS (39, "símbolo especial"), 
    ASTERISCO (40, "símbolo especial"), 
    BARRA (41, "símbolo especial"), 
    VIRGULA (42, "símbolo especial"), 
    PONTO (43, "símbolo especial"), 
    PONTOVIRGULA (44, "símbolo especial"), 
    DOISPONTOS (45, "símbolo especial"), 
    IGUAL (46, "símbolo especial"), 
    MAISIGUAL (47, "símbolo especial"), 
    MENOSIGUAL (48, "símbolo especial");

    private String descricao;
    private Integer id;

    IdEnum(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getId() {
        return id;
    }
}
