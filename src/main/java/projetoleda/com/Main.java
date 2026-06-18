package projetoleda.com;

import projetoleda.com.ordenacao.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Estudante[] estudantesGerados = EstudanteFactory.criarEstudantes(10);
        Estudante[] listaOriginal = estudantesGerados.clone();
        Estudante[] listaOrdenada = estudantesGerados.clone();
        Arrays.sort(listaOrdenada);

        List<Sorter<Estudante>> algoritmos = List.of(
                new BubbleSort<>(),
                new BubbleSortOtimizado<>(),
                new InsertionSort<>()
        );

        for (Sorter<Estudante> a : algoritmos) {
            Testador.testar(a, listaOriginal, listaOrdenada);
        }

        System.out.println();
        System.out.println("Lista original (desordenada):");
        Utils.printEstudantes(listaOriginal);
    }
}