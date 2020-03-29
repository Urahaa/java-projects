package br.com.alura.java.io.test;

import java.io.*;

public class TesteEscritaPrintWriter {

    public static void main(String[] args) {

        try {
            //PrintStream ps = new PrintStream("lorem_escrita.txt");

            PrintWriter ps = new PrintWriter("lorem_escrita.txt");

            ps.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
            ps.println();
            ps.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");

            ps.close();


        } catch (IOException ex){
            ex.printStackTrace();
        }

    }

}
