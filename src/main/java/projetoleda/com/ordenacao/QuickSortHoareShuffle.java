package projetoleda.com.ordenacao;

import java.util.Random;

public class QuickSortHoareShuffle<T extends Comparable<T>> implements Sorter<T> {
    private final Random random = new Random();
    @Override
    public void sort(T[] lista) {
        if (lista.length == 0) return;

        shuffle(lista);              // embaralha antes de ordenar
        quickSort(lista, 0, lista.length - 1);
    }

    // Fisher-Yates / Knuth Shuffle
    private void shuffle(T[] A) {
        for (int i = A.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1); // índice aleatório entre 0 e i
            trocar(A, i, j);
        }
    }

    private void quickSort(T[] A, int p, int r) {
        if (p < r) {
            int q = hoarePartition(A, p, r);
            quickSort(A, p, q);
            quickSort(A, q + 1, r);
        }
    }

    private int hoarePartition(T[] A, int p, int r) {
        T x = A[p]; // pivô = primeiro elemento (após o shuffle, isso já é "aleatório")
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
        return "QUICK SORT (Esquema HOARE + Shuffle)";
    }
}
