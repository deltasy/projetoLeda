package projetoleda.com.ordenacao;

import java.util.List;

public class InsertionSort<T extends Comparable<T>> implements Sorter<T> {
    @Override
    public void sort(T[] lista) {
        for (int i = 1; i < lista.length; i++) {
            T chave = lista[i];
            int j = i - 1;

            while (j >= 0 &&
                    lista[j].compareTo(chave) > 0) {
                    lista[j + 1] = lista[j];
                    j--;
            }
            lista[j + 1] = chave;
        }
    }

    @Override
    public String getNome() {
        return "INSERTION SORT";
    }
}
