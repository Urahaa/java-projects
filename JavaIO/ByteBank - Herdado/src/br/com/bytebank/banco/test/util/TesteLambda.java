package br.com.bytebank.banco.test.util;

import br.com.bytebank.banco.model.Cliente;
import br.com.bytebank.banco.model.Conta;
import br.com.bytebank.banco.model.ContaCorrente;
import br.com.bytebank.banco.model.ContaPoupanca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TesteLambda {

    public static void main(String[] args) {

        Conta cc1 = new ContaCorrente(22, 33);
        Cliente clienteCC1 = new Cliente();
        clienteCC1.setNome("Nico");
        cc1.setTitular(clienteCC1);
        cc1.deposita(333.0);

        Conta cc2 = new ContaPoupanca(22, 44);
        Cliente clienteCC2 = new Cliente();
        clienteCC2.setNome("Guilherme");
        cc2.setTitular(clienteCC2);
        cc2.deposita(444.0);

        Conta cc3 = new ContaCorrente(22, 11);
        Cliente clienteCC3 = new Cliente();
        clienteCC3.setNome("Paulo");
        cc3.setTitular(clienteCC3);
        cc3.deposita(111.0);

        Conta cc4 = new ContaPoupanca(22, 22);
        Cliente clienteCC4 = new Cliente();
        clienteCC4.setNome("Ana");
        cc4.setTitular(clienteCC4);
        cc4.deposita(222.0);

        List<Conta> lista = new ArrayList<>();
        lista.add(cc1);
        lista.add(cc2);
        lista.add(cc3);
        lista.add(cc4);

        System.out.println("Contas na ordem de inclusão");
        lista.forEach(System.out::println); //Lambda

        System.out.println("Contas ordenadas por número");
        lista.sort(Comparator.comparingInt(Conta::getNumero));
        lista.forEach(System.out::println);

        Comparator<Conta> comp = (c1, c2) -> { // Lambda
            String titularNomeC1 = c1.getTitular().getNome();
            String titularNomeC2 = c2.getTitular().getNome();
            return titularNomeC1.compareTo(titularNomeC2);
        };

        lista.sort(comp);
        System.out.println("Contas ordenadas por titular");
        lista.forEach(System.out::println);

    }
}