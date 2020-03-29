package br.com.bytebank.banco.model;

import java.io.Serializable;

public class ContaCorrente extends Conta implements Tributavel {

    public ContaCorrente(int agencia, int numero){
        super(agencia, numero);
    }

    @Override
    public void deposita(double valor) {
        if(valor > 0){
            super.saldo += valor;
        }
    }

    @Override
    public void saca(double valor) throws SaldoInsuficienteException {
        double valorSacar = valor + 0.2;
        super.saca(valorSacar);
    }

    @Override
    public double getValorImposto() {
        return super.saldo * 0.01;
    }
}
