package projetoleda.com.busca;

public class BuscaBinariaIterativa<T extends Comparable<T>> implements Searcher<T> {
    @Override
    public int buscar(T[] lista, T alvo) {
        int esquerda = 0;
        int direita = lista.length - 1;

        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;
            int comparacao = alvo.compareTo(lista[meio]);

            if (comparacao == 0) {
                return meio; // encontrou o alvo
            } else if (comparacao < 0) {
                direita = meio - 1; // alvo está na metade esquerda
            } else {
                esquerda = meio + 1; // alvo está na metade direita
            }
        }
        return -1; // não encontrou
    }

    @Override
    public String getNome() {
        return "BUSCA BINÁRIA INTERATIVA";
    }
}
