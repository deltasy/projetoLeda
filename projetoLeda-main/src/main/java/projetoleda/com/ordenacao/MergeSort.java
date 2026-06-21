package projetoleda.com.ordenacao;

public class MergeSort<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public void sort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(T[] arr, int inicio, int fim) {
        if (inicio >= fim) {
            return;
        }
        int meio = (inicio + fim) / 2;
        mergeSort(arr, inicio, meio);
        mergeSort(arr, meio + 1, fim);
        merge(arr, inicio, meio, fim);
    }

    @SuppressWarnings("unchecked")
    private void merge(T[] arr, int inicio, int meio, int fim) {
        Object[] auxiliar = new Object[fim - inicio + 1];
        int ponteiroEsq = inicio;
        int ponteiroDir = meio + 1;
        int k = 0;

        while (ponteiroEsq <= meio && ponteiroDir <= fim) {
            if (arr[ponteiroEsq].compareTo(arr[ponteiroDir]) <= 0) {
                auxiliar[k] = arr[ponteiroEsq];
                ponteiroEsq++;
            } else {
                auxiliar[k] = arr[ponteiroDir];
                ponteiroDir++;
            }
            k++;
        }

        while (ponteiroEsq <= meio) {
            auxiliar[k] = arr[ponteiroEsq];
            ponteiroEsq++;
            k++;
        }

        while (ponteiroDir <= fim) {
            auxiliar[k] = arr[ponteiroDir];
            ponteiroDir++;
            k++;
        }

        for (int i = 0; i < auxiliar.length; i++) {
            arr[inicio + i] = (T) auxiliar[i];
        }
    }

    @Override
    public String getNome() {
        return "Merge Sort Clássico";
    }
}
