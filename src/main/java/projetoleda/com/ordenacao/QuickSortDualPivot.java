package projetoleda.com.ordenacao;

public class QuickSortDualPivot<T extends Comparable<T>> implements Sorter<T> {
    // Essa é a versão do Quick Sort usada na linguagem java
    @Override
    public void sort(T[] lista) {
        if (lista.length == 0) return;
        dualPivotQuickSort(lista, 0, lista.length - 1);
    }

    private void dualPivotQuickSort(T[] A, int low, int high) {
        if (low < high) {
            // Garante que A[low] <= A[high]; se não, troca
            if (A[low].compareTo(A[high]) > 0) {
                trocar(A, low, high);
            }

            T pivot1 = A[low];
            T pivot2 = A[high];

            int lt = low + 1;   // fronteira: elementos < pivot1
            int gt = high - 1;  // fronteira: elementos > pivot2
            int i = lt;

            while (i <= gt) {
                if (A[i].compareTo(pivot1) < 0) {
                    trocar(A, i, lt);
                    lt++;
                } else if (A[i].compareTo(pivot2) > 0) {
                    while (i < gt && A[gt].compareTo(pivot2) > 0) {
                        gt--;
                    }
                    trocar(A, i, gt);
                    gt--;

                    if (A[i].compareTo(pivot1) < 0) {
                        trocar(A, i, lt);
                        lt++;
                    }
                }
                i++;
            }

            lt--;
            gt++;

            // Coloca os pivôs em suas posições finais
            trocar(A, low, lt);
            trocar(A, high, gt);

            // Três chamadas recursivas (uma para cada partição)
            dualPivotQuickSort(A, low, lt - 1);       // < pivot1
            dualPivotQuickSort(A, lt + 1, gt - 1);     // entre pivot1 e pivot2
            dualPivotQuickSort(A, gt + 1, high);       // > pivot2
        }
    }

    private void trocar(T[] A, int i, int j) {
        T temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    @Override
    public String getNome() {
        return "QUICK SORT DUAL PIVOT";
    }
}
