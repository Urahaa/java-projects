package br.com.alura.test;

import java.util.Collection;
import java.util.HashSet;

public class TestaAluno {

    public static void main(String[] args) {
        Collection<String> alunos = new HashSet<>();
        alunos.add("Rodrigo Turini");
        alunos.add("Alberto Souza");
        alunos.add("Nico Seppat");
        alunos.add("Sérgio Lopes");
        alunos.add("Renan Saggio");
        alunos.add("Mauricio Aniche");

        //HashCode
        System.out.println(alunos.contains("Paulo Silveira"));
        alunos.remove("Sergio Lopes");

        System.out.println(alunos);

    }

}
