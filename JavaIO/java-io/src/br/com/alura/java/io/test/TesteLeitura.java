package br.com.alura.java.io.test;

import java.io.*;

public class TesteLeitura {

    public static void main(String[] args) {

        try {
            InputStream fis = new FileInputStream("lorem_leitura.txt");
            Reader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String linha = br.readLine();

            while(linha != null){
                System.out.println(linha);
                linha = br.readLine();
            }

            br.close();

        } catch (IOException ex){
            ex.printStackTrace();
        }

    }

}
