package projetoleda.com.busca;

public class BuscaBinariaRecursiva<T extends Comparable<T>> implements Searcher<T> {
    @Override
    public int buscar(T[] lista, T alvo) {
        return buscar(lista, alvo, 0, lista.length - 1);
    }

    private int buscar(
            T[] lista,
            T alvo,
            int inicio,
            int fim
    ) {
        if (inicio > fim) {
            return -1;
        }

        int meio = inicio + (fim - inicio) / 2;
        int comparacao = alvo.compareTo(lista[meio]);

        if (comparacao == 0) {
            return meio;
        }

        if (comparacao < 0) {
            return buscar(lista, alvo, inicio, meio - 1);
        }

        return buscar(lista, alvo, meio + 1, fim);
    }

    @Override
    public String getNome() {
        return "BUSCA BINÁRIA RECURSIVA";
    }
}