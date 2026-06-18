package projetoleda.com.ordenacao;

import java.util.List;

public interface Sorter<T> {
    void sort(T[] array);

    String getNome();
}
