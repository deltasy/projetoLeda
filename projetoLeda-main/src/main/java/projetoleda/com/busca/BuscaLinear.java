package projetoleda.com.busca;

public class BuscaLinear <T extends Comparable<T>> implements Searcher<T>{

    @Override
    public int buscar(T[] lista, T chave) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i].compareTo(chave) == 0) {
                return i; // encontrado, retorna o índice
            }
        }
        return -1; // não encontrado
    }

    @Override
    public String getNome() {
        return "BUSCA LINEAR INTERATIVA";
    }
}
