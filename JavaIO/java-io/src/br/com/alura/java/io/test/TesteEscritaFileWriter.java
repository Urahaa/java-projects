package br.com.alura.java.io.test;

import java.io.*;

public class TesteEscritaFileWriter {

    public static void main(String[] args) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("lorem_escrita.txt"));
            bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
            bw.newLine();
            bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");

            bw.close();

        } catch (IOException ex){
            ex.printStackTrace();
        }

    }

}
