package projetoleda.com.ordenacao;

public class SelectionSort<T extends Comparable<T>> implements Sorter<T> {
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
            T temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    @Override
    public String getNome() {
        return "Selection Sort Clássico";
    }
}
