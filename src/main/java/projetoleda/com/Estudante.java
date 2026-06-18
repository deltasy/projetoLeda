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
        int comparacaoNota = Integer.compare(this.nota, estudante2.nota);
        if(comparacaoNota != 0){
            return comparacaoNota;
        }

        int comparacaoNome = this.nome.compareTo(estudante2.nome);
        if(comparacaoNome != 0){
            return comparacaoNome;
        }

        return this.matricula.compareTo(estudante2.matricula);
    }

    @Override
    public String toString() {
        return String.format("%s / %s / %d", nome, matricula, nota);
    }
}
