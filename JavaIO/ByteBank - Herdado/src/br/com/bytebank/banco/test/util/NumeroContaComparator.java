package br.com.bytebank.banco.test.util;

import br.com.bytebank.banco.model.Conta;

import java.util.Comparator;

public class NumeroContaComparator implements Comparator<Conta> {

    @Override
    public int compare(Conta c1, Conta c2) {
        return Integer.compare(c1.getNumero(), c2.getNumero());
    }
}
