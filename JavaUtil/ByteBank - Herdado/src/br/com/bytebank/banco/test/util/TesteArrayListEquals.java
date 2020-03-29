package br.com.bytebank.banco.test.util;

import br.com.bytebank.banco.model.Conta;
import br.com.bytebank.banco.model.ContaCorrente;

import java.util.ArrayList;
import java.util.List;

public class TesteArrayListEquals {

    public static void main(String[] args) {

        //Generics
        List<Conta> lista = new ArrayList<Conta>();

        Conta cc = new ContaCorrente(22, 11);
        lista.add(cc);

        Conta cc2 = new ContaCorrente(22, 22);
        lista.add(cc2);

        Conta cc3 = new ContaCorrente(22, 22);
        lista.add(cc3);

        if(lista.contains(cc2)){
            System.out.println("O elemento já existe");
        }

        for(Conta conta : lista) {
            if(conta.equals(cc3)){
                System.out.println("As contas são iguais");
            }
        }
    }
}