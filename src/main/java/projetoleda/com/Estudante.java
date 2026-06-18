package projetoleda.com;

import java.util.Random;

public class Estudante implements Comparable<Estudante> {
    String matricula;
    String nome;
    int nota;

    public Estudante(String matricula, String nome, int nota){
        this.matricula = matricula;
        this.nome = nome;
        this.nota = nota;
    }

    // Atualizar compareTo
    @Override
    public int compareTo(Estudante estudante2) {
        return 0;
    }
}
