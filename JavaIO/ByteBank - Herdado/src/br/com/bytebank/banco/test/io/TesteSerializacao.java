package br.com.bytebank.banco.test.io;

import br.com.bytebank.banco.model.Cliente;
import br.com.bytebank.banco.model.ContaCorrente;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TesteSerializacao {

    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNome("Matheus");
        cliente.setProfissao("Dev");
        cliente.setCpf("123456789-10");

        ContaCorrente cc = new ContaCorrente(222,333);
        cc.deposita(222.3);
        cc.setTitular(cliente);


        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cc.bin"));
            oos.writeObject(cc);
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
