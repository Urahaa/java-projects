package gals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import model.Rotulo;

public class Semantico implements Constants {

    private final String INT64 = "int64";
    private final String FLOAT64 = "float64";
    private final String BOOL = "bool";
    private final String BIN = "bin";
    private final String HEXA = "hexa";
    private final String STRING = "string";

    private String operador = "";
    private String tipoVar = "";
    private String valorVar = "";

    private StringBuilder dup = new StringBuilder();
    private StringBuilder codigoGerado = new StringBuilder();
    private Stack<String> pilhaTipo = new Stack<>();
    private Stack<Rotulo> pilhaRotulo = new Stack<>();
    private List<String> identificadores = new ArrayList<>();
    private Map<String, String> tabelaSimbolos = new HashMap<>();
    private List<String> identificadoresAux = new ArrayList<>();

    public void executeAction(int action, Token token) throws SemanticError {
        System.out.println("Ação #" + action + ", Token: " + token);

        switch (action) {
            case (1):
                acao1();
                break;
            case (2):
                acao2();
                break;
            case (3):
                acao3();
                break;
            case (4):
                acao4();
                break;
            case (5):
                acao5(token);
                break;
            case (6):
                acao6(token);
                break;
            case (7):
                acao7();
                break;
            case (8):
                acao8();
                break;
            case (9):
                acao9(token);
                break;
            case (10):
                acao10();
                break;
            case (11):
                acao11();
                break;
            case (12):
                acao12();
                break;
            case (13):
                acao13();
                break;
            case (14):
                acao14();
                break;
            case (15):
                acao15();
                break;
            case (16):
                acao16();
                break;
            case (17):
                acao17();
                break;
            case (18):
                acao18();
                break;
            case (19):
                acao19(token);
                break;
            case (20):
                acao20(token);
                break;
            case (21):
                acao21(token);
                break;
            case (22):
                acao22();
                break;
            case (23):
                acao23();
                break;
            case (24):
                acao24();
                break;
            case (30):
                acao30(token);
                break;
            case (31):
                acao31();
                break;
            case (32):
                acao32(token);
                break;
            case (33):
                acao33(token);
                break;
            case (34):
                acao34();
                break;
            case (35):
                acao35(token);
                break;
            case (36):
                acao36(token);
                break;
            case (37):
                acao37();
                break;
            case (38):
                acao38(token);
                break;
            case (39):
                acao39();
                break;
            case (40):
                acao40();
                break;
            case (41):
                acao41();
                break;
            case (42):
                acao42();
                break;
            case (43):
                acao43();
                break;
            case (44):
                acao44();
                break;
            case (45):
                acao45();
                break;
            default:
                throw new SemanticError("Ação não implementada!");
        }
    }

    private void empilhaTipo() throws SemanticError {
        empilhaTipo(Boolean.FALSE);
    }

    private void empilhaTipo(Boolean isDivisao) throws SemanticError {
        String tipo1 = pilhaTipo.pop();
        String tipo2 = pilhaTipo.pop();
        if (isDivisao) {
            if ((FLOAT64.equals(tipo1) || INT64.equals(tipo1)) && (FLOAT64.equals(tipo2) || INT64.equals(tipo2))) {
                pilhaTipo.push(FLOAT64);
            } else {
                validaTipo(tipo1, tipo2);
            }
        } else {
            validaTipo(tipo1, tipo2);
        }
    }

    private void validaTipo(String tipo1, String tipo2) throws SemanticError {
        if (isTipoOperavel(tipo1) && isTipoOperavel(tipo2)) {
            if (FLOAT64.equals(tipo1) || INT64.equals(tipo1)) {
                validaTipoNumerico(tipo1, tipo2);
            } else if (tipo1.equals(tipo2)) {
                pilhaTipo.push(tipo1);
            } else {
                throw new SemanticError("tipos incompatíveis em expressão aritmética");
            }
        } else {
            throw new SemanticError("tipos incompatíveis em expressão aritmética");
        }
    }

    private void validaTipoEmpilhado() throws SemanticError {
        String tipo = pilhaTipo.pop();
        if (isTipoOperavel(tipo)) {
            pilhaTipo.push(tipo);
        } else {
            throw new SemanticError("tipos incompatíveis em expressão aritmética");
        }
    }

    private String getCodigoOperador(String operador) {
        Map<String, String> mapa = new HashMap<>();
        mapa.put(">", "cgt\n");
        mapa.put("<", "clt\n");
        mapa.put("==", "ceq\n");
        mapa.put("!=", "ceq\nldc.i4.1\nxor");

        return mapa.get(operador);
    }

    private void acao1() throws SemanticError {
        empilhaTipo();
        codigoGerado.append("add\n");
    }

    private void acao2() throws SemanticError {
        empilhaTipo();
        codigoGerado.append("sub\n");
    }

    private void acao3() throws SemanticError {
        empilhaTipo();
        codigoGerado.append("mul\n");
    }

    private void acao4() throws SemanticError {
        empilhaTipo(Boolean.TRUE);
        codigoGerado.append("div\n");
    }

    private void acao5(Token token) {
        pilhaTipo.push(INT64);
        codigoGerado.append("ldc.r8 ");
        codigoGerado.append(token.getLexeme());
        codigoGerado.append("\n");
    }

    private void acao6(Token token) {
        pilhaTipo.push(FLOAT64);
        codigoGerado.append("ldc.i8 ");
        codigoGerado.append(token.getLexeme());
    }

    private void acao7() throws SemanticError {
        validaTipoEmpilhado();
    }

    private void acao8() throws SemanticError {
        validaTipoEmpilhado();
        codigoGerado.append("ldc.i8 -1\n");
        codigoGerado.append("conv.r8\n");
        codigoGerado.append("mul\n");
    }

    private void acao9(Token token) {
        operador = token.getLexeme();
    }

    private void acao10() throws SemanticError {
        String tipo1 = pilhaTipo.pop();
        String tipo2 = pilhaTipo.pop();

        if (isTiposComparaveis(tipo1, tipo2)) {
            pilhaTipo.push(BOOL);
        } else {
            throw new SemanticError("tipos incompatíveis em expressão relacional");
        }

        String codigoOperador = getCodigoOperador(operador);
        if (codigoOperador != null) {
            codigoGerado.append(codigoOperador);
        } else {
            throw new SemanticError("símbolo não implementado: " + codigoOperador);
        }
    }

    private void acao11() {
        pilhaTipo.push(BOOL);
        codigoGerado.append("ldc.i4.1\n");
    }

    private void acao12() {
        pilhaTipo.push(BOOL);
        codigoGerado.append("ldc.i4.0\n");
    }

    private void acao13() throws SemanticError {
        String tipo = pilhaTipo.pop();
        if (BOOL.equals(tipo)) {
            pilhaTipo.push(BOOL);
        } else {
            throw new SemanticError("tipo incompatível em expressão lógica");
        }
        codigoGerado.append("ldc.i4.0\n");
        codigoGerado.append("xor\n");
    }

    private void acao14() {
        String tipo = pilhaTipo.pop();
        if (BIN.equals(tipo) || HEXA.equals(tipo)) {
            if (BIN.equals(tipo)) {
                codigoGerado.append("ldstr \"#b\"\n");
                codigoGerado.append("call void [mscorlib]System.Console::Write(string)\n");
                codigoGerado.append("ldc.i4 2\n");
            } else {
                codigoGerado.append("ldstr \"#x\"\n");
                codigoGerado.append("call void [mscorlib]System.Console::Write(string)\n");
                codigoGerado.append("ldc.i4 16\n");
            }
            codigoGerado.append("call string [mscorlib]System.Convert::ToString(int64, int32)\n");
            codigoGerado.append("call void [mscorlib]System.Console::Write(string)\n");
        } else {
            if (INT64.equals(tipo)) {
                codigoGerado.append("conv.i8\n");
            }
            codigoGerado.append("call void [mscorlib]System.Console::Write(");
            codigoGerado.append(tipo);
            codigoGerado.append(")\n");
        }

    }

    private void acao15() {
        codigoGerado.append(".assembly extern mscorlib {}\n");
        codigoGerado.append(".assembly _codigo_objeto {}\n");
        codigoGerado.append(".module _codigo_objeto.exe\n");
        codigoGerado.append(".class public _UNICA {\n");
        codigoGerado.append(".method static public void _principal() {\n");
        codigoGerado.append(".entrypoint\n");

    }

    private void acao16() {
        codigoGerado.append("ret\n");
        codigoGerado.append("}\n");
        codigoGerado.append("}\n");
    }

    private void acao17() throws SemanticError {
        empilhaTipoBool();
        codigoGerado.append("and\n");

    }

    private void acao18() throws SemanticError {
        empilhaTipoBool();
        codigoGerado.append("or\n");

    }

    private void acao19(Token token) throws SemanticError {
        pilhaTipo.push(STRING);
        codigoGerado.append("ldstr ");
        codigoGerado.append(token.getLexeme());
        codigoGerado.append("\n");
    }

    private void acao20(Token token) throws SemanticError {
        pilhaTipo.push(BIN);
        codigoGerado.append("ldstr \"");
        codigoGerado.append(token.getLexeme().replaceAll("#b", ""));
        codigoGerado.append("\"\n");
        codigoGerado.append("ldc.i4 2\n");
        codigoGerado.append("call int64 [mscorlib]System.Convert::ToInt64(string, int32)\n");
    }

    private void acao21(Token token) throws SemanticError {
        pilhaTipo.push(HEXA);
        codigoGerado.append("ldstr \"");
        codigoGerado.append(token.getLexeme().replaceAll("#x", ""));
        codigoGerado.append("\"\n");
        codigoGerado.append("ldc.i4 16\n");
        codigoGerado.append("call int64 [mscorlib]System.Convert::ToInt64(string, int32)\n");
    }

    private void acao22() throws SemanticError {
        String tipo = pilhaTipo.pop();
        if (HEXA.equals(tipo) || BIN.equals(tipo)) {
            pilhaTipo.push(INT64);
            codigoGerado.append("conv.r8\n");
        } else {
            throw new SemanticError(" tipo incompatível em operação de conversão de valor");
        }
    }

    private void acao23() throws SemanticError {
        String tipo = pilhaTipo.pop();
        if (INT64.equals(tipo) || HEXA.equals(tipo)) {
            pilhaTipo.push(BIN);
            codigoGerado.append("conv.i8\n");
        } else {
            throw new SemanticError(" tipo incompatível em operação de conversão de valor");
        }
    }

    private void acao24() throws SemanticError {
        String tipo = pilhaTipo.pop();
        if (INT64.equals(tipo) || BIN.equals(tipo)) {
            pilhaTipo.push(HEXA);
            codigoGerado.append("conv.i8\n");
        } else {
            throw new SemanticError(" tipo incompatível em operação de conversão de valor");
        }
    }

    private void acao30(Token token) {
        tipoVar = getTipoVar(token.getLexeme());
    }

    private void acao31() throws SemanticError {
        validarIdentificadorDeclarado();
        gerarLocals(tipoVar);
        identificadores.clear();
    }

    private void acao32(Token token) {
        identificadores.add(token.getLexeme());
    }

    private void acao33(Token token) throws SemanticError {
        String identificador = token.getLexeme();
        validarIdenficadorNaoDeclarado(identificador);
        String tipo = tabelaSimbolos.get(identificador);
        pilhaTipo.push(tipo);

        codigoGerado.append("ldloc ");
        codigoGerado.append(identificador);
        codigoGerado.append("\n");
        codigoGerado.append("conv.r8\n");
    }

    private void validarIdenficadorNaoDeclarado(String identificador) throws SemanticError {
        if (!tabelaSimbolos.containsKey(identificador)) {
            throw new SemanticError("identificador " + identificador + " não declarado");
        }
    }

    private void acao34() throws SemanticError {

        for (String id : identificadores) {
            if (tabelaSimbolos.containsKey(id)) {
                String tipoId = tabelaSimbolos.get(id);
                String tipoPilha = pilhaTipo.pop();
                if (!tipoId.equals(tipoPilha)) {
                    throw new SemanticError("tipos incompatíveis");
                } else {
                    if (INT64.equals(tipoId)) {
                        codigoGerado.append("conv.i8\n");
                    }
                    codigoGerado.append(getCodigoOperacao(id));
                    codigoGerado.append("\n");
                    dup.append("dup\n");
                }
            } else {
                throw new SemanticError("identificador " + id + " não declarado");
            }
        }
        if (identificadores.size() > 1 && dup.length() != 0) {
            codigoGerado.append(dup);
        }
        identificadores = new ArrayList<>();
    }

    private void acao35(Token token) throws SemanticError {
        for (String id : identificadores) {
            if (tabelaSimbolos.containsKey(id)) {
                String tipoId = tabelaSimbolos.get(id);
                String classe = getClasse(tipoId);

                codigoGerado.append("call string [mscorlib]System.Console::ReadLine()\n");
                codigoGerado.append("call ");
                codigoGerado.append(tipoId);
                codigoGerado.append(" [mscorlib]System.");
                codigoGerado.append(classe);
                codigoGerado.append("::Parse(string)\n");
                codigoGerado.append("stloc ");
                codigoGerado.append(id);
                codigoGerado.append("\n");
                System.out.println("IDs: " + identificadores);
            } else {
                throw new SemanticError("identificador " + id + " não declarado");
            }
        }
        identificadores.clear();
    }

    private void acao36(Token token) {
        valorVar = token.getLexeme();
    }

    private void acao37() throws SemanticError {
        validarIdentificadorDeclarado();
        gerarLocals(getTipoReconhecido());
        gerarAlocacao();

        identificadoresAux.addAll(identificadores);
        identificadores.clear();
    }

    private void acao38(Token token) throws SemanticError {
        operador = token.getLexeme();
        if (token.getLexeme().equals("-=") || token.getLexeme().equals("+=")) {
            String identificador = identificadores.stream().findFirst().get();
            codigoGerado.append("ldloc ");
            codigoGerado.append(identificador);
            codigoGerado.append("\n");

            identificadores.remove(identificador);
        }
    }

    private void acao39() {
        Rotulo rotulo = new Rotulo();
        codigoGerado.append("brfalse ");
        codigoGerado.append(rotulo.toString());
        codigoGerado.append("\n");
        pilhaRotulo.push(rotulo);
    }

    private void acao40() {
        while (!pilhaRotulo.isEmpty()) {
            codigoGerado.append(pilhaRotulo.pop().toString());
            codigoGerado.append(":");
            codigoGerado.append("\n");
        }
    }

    private void acao41() {
        Rotulo rotulo = new Rotulo();
        codigoGerado.append("br ");
        codigoGerado.append(rotulo.toString());
        codigoGerado.append("\n");
        codigoGerado.append(pilhaRotulo.pop().toString());
        codigoGerado.append(":");
        codigoGerado.append("\n");
        pilhaRotulo.push(rotulo);
    }

    private void acao42() {
        Rotulo rotulo = new Rotulo();
        codigoGerado.append("brfalse ");
        codigoGerado.append(rotulo.toString());
        codigoGerado.append("\n");
        pilhaRotulo.push(rotulo);
    }

    private void acao43() {
        Rotulo rotulo = new Rotulo();
        codigoGerado.append("br ");
        codigoGerado.append(rotulo.toString());
        codigoGerado.append("\n");
        codigoGerado.append(pilhaRotulo.pop().toString());
        codigoGerado.append(":");
        codigoGerado.append("\n");
        pilhaRotulo.push(rotulo);
    }

    private void acao44() {
        Rotulo rotulo = new Rotulo();
        codigoGerado.append(rotulo.toString());
        codigoGerado.append(":");
        codigoGerado.append("\n");
        pilhaRotulo.push(rotulo);
    }

    private void acao45() {
        codigoGerado.append("brfalse ");
        codigoGerado.append(pilhaRotulo.pop().toString());
        codigoGerado.append("\n");
    }

    public StringBuilder getCodigoGerado() {
        return codigoGerado;
    }

    private boolean isTipoOperavel(String tipo) {
        return !tipo.equals(STRING) && !tipo.equals(BOOL);
    }

    private void validaTipoNumerico(String tipo1, String tipo2) throws SemanticError {
        if (FLOAT64.equals(tipo1)) {
            if (FLOAT64.equals(tipo2) || INT64.equals(tipo2)) {
                pilhaTipo.push(FLOAT64);
            } else {
                throw new SemanticError("tipos incompatíveis em expressão aritmética");
            }
        } else if (INT64.equals(tipo1)) {
            if (FLOAT64.equals(tipo2)) {
                pilhaTipo.push(FLOAT64);
            } else if (INT64.equals(tipo2)) {
                pilhaTipo.push(INT64);
            } else {
                throw new SemanticError("tipos incompatíveis em expressão aritmética");
            }
        }
    }

    private String getTipoVar(String lexeme) {
        Map<String, String> mapa = new HashMap<>();
        mapa.put("int", INT64);
        mapa.put("float", FLOAT64);
        mapa.put("bool", BOOL);
        mapa.put("str", STRING);
        mapa.put("bin", BIN);
        mapa.put("hexa", HEXA);

        return mapa.get(lexeme);
    }

    private boolean isTiposComparaveis(String tipo1, String tipo2) {
        if (FLOAT64.equals(tipo1) || INT64.equals(tipo1)) {
            return FLOAT64.equals(tipo2) || INT64.equals(tipo2);
        }

        return STRING.equals(tipo1) && tipo1.equals(tipo2);
    }

    private String getCodigoOperacao(String id) {
        Map<String, String> mapa = new HashMap<>();
        mapa.put("=", "stloc " + id);
        mapa.put("-=", "sub\nstloc " + id);
        mapa.put("+=", "add\nstloc " + id);

        return mapa.get(operador);
    }

    private String getClasse(String tipoId) {
        Map<String, String> mapa = new HashMap<>();
        mapa.put("int64", "Int64");
        mapa.put("float64", "Double");
        mapa.put("bool", "Boolean");
        mapa.put("string", "String");
        mapa.put("bin", "Int64");
        mapa.put("hexa", "Int64");

        return mapa.get(tipoId);
    }

    private void empilhaTipoBool() throws SemanticError {
        String tipo1 = pilhaTipo.pop();
        String tipo2 = pilhaTipo.pop();

        if (BOOL.equals(tipo1) && BOOL.equals(tipo2)) {
            pilhaTipo.push(BOOL);
        } else {
            throw new SemanticError("tipos incompatíveis em expressão lógica");
        }

    }

    private String getTipoReconhecido() {
        if (valorVar.startsWith("#b")) {
            return BIN;
        }

        if (valorVar.startsWith("#x")) {
            return HEXA;
        }

        if (valorVar.equals("true") || valorVar.equals("false")) {
            return BOOL;
        }

        if (isInteger(valorVar)) {
            return INT64;
        }

        if (isFloat(valorVar)) {
            return INT64;
        }

        return STRING;
    }

    private boolean isInteger(String inteiro) {
        try {
            Integer intReconhecido = Integer.valueOf(inteiro);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isFloat(String inteiro) {
        try {
            Float intReconhecido = Float.valueOf(inteiro);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void validarIdentificadorDeclarado() throws SemanticError {
        for (String id : identificadores) {
            if (tabelaSimbolos.containsKey(id)) {
                throw new SemanticError("identificador já declarado");
            }
        }
    }

    private void gerarAlocacao() {
        identificadores.forEach(ids -> {
            codigoGerado.append("ldc.i8 ");
            codigoGerado.append(valorVar);
            codigoGerado.append("\n");
            codigoGerado.append("stloc ");
            codigoGerado.append(ids);
            codigoGerado.append("\n");
        });
    }

    private void gerarLocals(String tipoReconhecido) {
        AtomicInteger cont = new AtomicInteger(identificadores.size());
        codigoGerado.append(".locals (");
        identificadores.forEach(ids -> {
            cont.getAndDecrement();
            if (BIN.equals(tipoReconhecido) || HEXA.equals(tipoReconhecido)) {
                codigoGerado.append(INT64);
            } else {
                codigoGerado.append(tipoReconhecido);
                codigoGerado.append(" ");
                codigoGerado.append(ids);
            }
            if (cont.get() > 0) {
                codigoGerado.append(", ");
            }
            tabelaSimbolos.put(ids, tipoReconhecido);
        });
        codigoGerado.append(")\n");
    }

}
