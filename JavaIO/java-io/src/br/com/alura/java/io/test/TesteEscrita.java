package br.com.alura.java.io.test;

import java.io.*;

public class TesteEscrita {

    public static void main(String[] args) {

        try {
            OutputStream fos = new FileOutputStream("lorem_escrita.txt");
            Writer osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);

            bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
            bw.newLine();
            bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");

            bw.close();

        } catch (IOException ex){
            ex.printStackTrace();
        }

    }

}
