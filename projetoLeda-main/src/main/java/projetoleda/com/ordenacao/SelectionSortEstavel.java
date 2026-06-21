package projetoleda.com.ordenacao;

public class SelectionSortEstavel<T extends Comparable<T>> implements Sorter<T> {
    @Override
    public void sort(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // Faz o shift para garantir a estabilidade
            T menor = array[minIndex];
            for (int k = minIndex; k > i; k--) {
                array[k] = array[k - 1];
            }
            array[i] = menor;
        }
    }

    @Override
    public String getNome() {
        return "Selection Sort Estável";
    }
}
