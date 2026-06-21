package projetoleda.com.ordenacao;
import java.util.List;

import java.util.function.ToIntFunction;

public class CountingSort<T extends Comparable<T>> implements Sorter<T> {

    private final ToIntFunction<T> extratorDeChave;

    public CountingSort(ToIntFunction<T> extratorDeChave) {
        this.extratorDeChave = extratorDeChave;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void sort(T[] vetorEstudantes) {
        int tamanhoVetor = vetorEstudantes.length;
        if (tamanhoVetor == 0) return;

        int maiorChave = extratorDeChave.applyAsInt(vetorEstudantes[0]);
        for (int indiceMaior = 1; indiceMaior < tamanhoVetor; indiceMaior++) {
            int chaveAtual = extratorDeChave.applyAsInt(vetorEstudantes[indiceMaior]);
            if (chaveAtual > maiorChave) {
                maiorChave = chaveAtual;
            }
        }

        int[] contagem = new int[maiorChave + 1];
        for (int indiceContagem = 0; indiceContagem < tamanhoVetor; indiceContagem++) {
            contagem[extratorDeChave.applyAsInt(vetorEstudantes[indiceContagem])]++;
        }

        for (int indiceAcumulado = 1; indiceAcumulado <= maiorChave; indiceAcumulado++) {
            contagem[indiceAcumulado] += contagem[indiceAcumulado - 1];
        }

        T[] vetorSaida = (T[]) new Comparable[tamanhoVetor];
        for (int indicePosicionamento = tamanhoVetor - 1; indicePosicionamento >= 0; indicePosicionamento--) {
            int chave = extratorDeChave.applyAsInt(vetorEstudantes[indicePosicionamento]);
            vetorSaida[contagem[chave] - 1] = vetorEstudantes[indicePosicionamento];
            contagem[chave]--;
        }

        System.arraycopy(vetorSaida, 0, vetorEstudantes, 0, tamanhoVetor);
    }

    @Override
    public String getNome() {
        return "COUNTING SORT";
    }
}

