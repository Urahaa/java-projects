package br.com.bytebank.banco.test.io;

import br.com.bytebank.banco.model.ContaCorrente;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TesteDesserealizacao {

    public static void main(String[] args) {

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cc.bin"));
            ContaCorrente cc = (ContaCorrente) ois.readObject();
            ois.close();

            System.out.println(cc.toString());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
