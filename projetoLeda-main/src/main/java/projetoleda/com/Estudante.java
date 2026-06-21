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

    public int getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return String.format("%s / %s / %d", nome, matricula, nota);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Estudante outro = (Estudante) obj;

        return this.nota == outro.nota &&
                this.nome.equals(outro.nome) &&
                this.matricula.equals(outro.matricula);
    }

    @Override
    public int hashCode() {
        int result = matricula != null ? matricula.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + nota;
        return result;
    }
}
