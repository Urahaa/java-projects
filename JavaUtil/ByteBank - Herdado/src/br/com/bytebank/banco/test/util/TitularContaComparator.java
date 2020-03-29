package br.com.bytebank.banco.test.util;

import br.com.bytebank.banco.model.Conta;

import java.util.Comparator;

public class TitularContaComparator implements Comparator<Conta> {

    @Override
    public int compare(Conta c1, Conta c2) {

        String titularNomeC1 = c1.getTitular().getNome();
        String titularNomeC2 = c2.getTitular().getNome();

        return titularNomeC1.compareTo(titularNomeC2);
    }
}
