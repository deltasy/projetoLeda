package projetoleda.com.ordenacao;

import java.util.Arrays;

public class MergeSortTimSort<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public void sort(T[] array) {
        Arrays.sort(array);
    }

    @Override
    public String getNome() {
        return "TimSort (Arrays.sort do Java)";
    }
}
