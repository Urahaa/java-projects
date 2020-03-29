package br.com.alura.java.io.test;

import java.io.*;

public class TesteSerializacaoCliente {

    public static void main(String[] args) {

//        Cliente cliente = new Cliente();
//        cliente.setNome("Matheus");
//        cliente.setProfissao("Programador");
//        cliente.setCpf("123456789-10");

        try {

//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cliente.bin"));
//            oos.writeObject(cliente);
//            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cliente.bin"));
            Cliente cliente = (Cliente) ois.readObject();
            ois.close();
            System.out.println(cliente.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
