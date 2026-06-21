package projetoleda.com.busca;

public class BuscaLinearDuasPontas<T extends Comparable<T>> implements Searcher<T> {
    @Override
    public int buscar(T[] lista, T chave) {
        int inicio = 0;            // Dois ponteiros usados para busca
        int fim = lista.length - 1;

        while (inicio <= fim) {
            if (lista[inicio].compareTo(chave) == 0) {
                return inicio;
            }
            if (lista[fim].compareTo(chave) == 0) {
                return fim;
            }
            inicio++;
            fim--;
        }

        return -1; // não encontrado
    }

    @Override
    public String getNome() {
        return "BUSCA LINEAR INTERATIVA DUAS PONTAS";
    }
}
