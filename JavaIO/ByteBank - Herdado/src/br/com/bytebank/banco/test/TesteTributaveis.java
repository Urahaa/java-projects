package br.com.bytebank.banco.test;

import br.com.bytebank.banco.model.CalculadorDeImposto;
import br.com.bytebank.banco.model.ContaCorrente;
import br.com.bytebank.banco.model.SeguroDeVida;

public class TesteTributaveis {

    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente(222, 333);
        cc.deposita(100);

        SeguroDeVida sv = new SeguroDeVida();

        CalculadorDeImposto ci = new CalculadorDeImposto();
        ci.registra(cc);
        ci.registra(sv);

        System.out.println(ci.getTotalImposto());
    }

}
