package br.com.alura.test;

import br.com.alura.model.Aluno;
import br.com.alura.model.Aula;
import br.com.alura.model.Curso;

import java.util.Collections;
import java.util.Set;

public class TestaCursoComAluno {

    public static void main(String[] args) {
        Curso javaColecoes = new Curso("Dominando as coleções java", "Paulo Silveira");

        javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
        javaColecoes.adiciona(new Aula("Criando uma aula", 20));
        javaColecoes.adiciona(new Aula("Modelando com coleções", 22));

        Aluno a1 = new Aluno("Rodrigo Torini", 34672);
        Aluno a2 = new Aluno("Guilherme Silveira", 5617);
        Aluno a3 = new Aluno("Mauricio Aniche", 17645);

        javaColecoes.matricula(a1);
        javaColecoes.matricula(a2);
        javaColecoes.matricula(a3);

        javaColecoes.getAlunos().forEach(System.out::println);

        Aluno torini = new Aluno("Rodrigo Torini", 34672);
        System.out.println(javaColecoes.estaMatriculado(a1));
        System.out.println(javaColecoes.estaMatriculado(torini));
        System.out.println(torini.equals(a1));
        System.out.println(a1.hashCode() == torini.hashCode());

    }

}
