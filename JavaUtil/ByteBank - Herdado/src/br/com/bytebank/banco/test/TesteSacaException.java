package br.com.bytebank.banco.test;

import br.com.bytebank.banco.model.Conta;
import br.com.bytebank.banco.model.ContaCorrente;
import br.com.bytebank.banco.model.SaldoInsuficienteException;

public class TesteSacaException {

    public static void main(String[] args) {
        Conta c = new ContaCorrente(123, 321);
        try {
            c.deposita(200);
            c.saca(210);
        } catch (SaldoInsuficienteException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(c.getSaldo());
    }

}
