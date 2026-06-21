package projetoleda.com.busca;

public class BuscaLinearRecursiva<T extends Comparable<T>> implements Searcher<T> {

    @Override
    public int buscar(T[] lista, T alvo) {
        return buscar(lista, alvo, 0);
    }

    private int buscar(T[] lista, T alvo, int indice) {
       
        if (indice >= lista.length) {
            return -1;
        }

        if (lista[indice].compareTo(alvo) == 0) {
            return indice;
        }

        return buscar(lista, alvo, indice + 1);
    }

    @Override
    public String getNome() {
        return "BUSCA LINEAR RECURSIVA";
    }
}
