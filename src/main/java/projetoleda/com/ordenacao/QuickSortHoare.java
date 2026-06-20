package projetoleda.com.ordenacao;

public class QuickSortHoare<T extends Comparable<T>> implements Sorter<T> {
    @Override
    public void sort(T[] lista) {
        if (lista.length == 0) return;
        quickSort(lista, 0, lista.length - 1);
    }

    private void quickSort(T[] A, int p, int r) {
        if (p < r) {
            int q = hoarePartition(A, p, r);
            quickSort(A, p, q);
            quickSort(A, q + 1, r);
        }
    }

    private int hoarePartition(T[] A, int p, int r) {
        T x = A[p]; // pivô = primeiro elemento
        int i = p - 1;
        int j = r + 1;

        while (true) {
            do {
                j--;
            } while (A[j].compareTo(x) > 0);

            do {
                i++;
            } while (A[i].compareTo(x) < 0);

            if (i < j) {
                trocar(A, i, j);
            } else {
                return j;
            }
        }
    }

    private void trocar(T[] A, int i, int j) {
        T temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    @Override
    public String getNome() {
        return "QUICK SORT (Esquema HOARE)";
    }
}
