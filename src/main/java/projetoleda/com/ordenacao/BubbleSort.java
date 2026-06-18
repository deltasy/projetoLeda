package projetoleda.com.ordenacao;

import java.util.List;

public class BubbleSort<T extends Comparable<T>> implements Sorter<T> {
    @Override
    public void sort(T[] a) {

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {

                if (a[j].compareTo(a[j + 1]) > 0) {
                    T temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public String getNome() {
        return "BUBBLE SORT";
    }
}
