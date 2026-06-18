package projetoleda.com.ordenacao;

import projetoleda.com.Utils;

public class BubbleSortOtimizado<T extends Comparable<T>> implements Sorter<T> {
    @Override
    public void sort(T[] lista) {
        boolean houveTroca;
        for (int i = 0; i < lista.length - 1; i++) {
            houveTroca = false;
            for (int j = 1; j < lista.length - i; j++) {
                if (lista[j - 1].compareTo(lista[j]) > 0) {
                    Utils.swap(lista, j - 1, j);
                    houveTroca = true;
                }
            }

            if (!houveTroca) {
                break;
            }
        }
    }

    @Override
    public String getNome() {
        return "BUBBLE SORT OTIMIZADO";
    }
}
