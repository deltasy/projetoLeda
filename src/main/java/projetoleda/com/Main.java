package projetoleda.com;

import projetoleda.com.busca.BuscaBinariaIterativa;
import projetoleda.com.busca.BuscaBinariaRecursiva;
import projetoleda.com.ordenacao.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Estudante[] estudantesGerados = EstudanteFactory.criarEstudantes(10);
        Estudante[] listaOriginal = estudantesGerados.clone();
        Estudante[] listaOrdenada = estudantesGerados.clone();
        Arrays.sort(listaOrdenada);

        // ordenações
        List<Sorter<Estudante>> algoritmos = List.of(
                new BubbleSort<>(),
                new BubbleSortOtimizado<>(),
                new InsertionSort<>(),
                new SelectionSort<>(),
                new SelectionSortEstavel<>(),
                new MergeSort<>(),
                new MergeSortTimSort<>()
        );

        for (Sorter<Estudante> a : algoritmos) {
            Testador.testar(a, listaOriginal, listaOrdenada);
        }

        System.out.println();
        System.out.println("Lista original (desordenada):");
        Utils.printEstudantes(listaOriginal);

        // buscas binárias
        // o array precisa estar ordenado antes das buscas
        Estudante[] listaParaBusca = listaOriginal.clone();
        Arrays.sort(listaParaBusca);

        // usa o primeiro estudante da lista ordenada como alvo de exemplo
        Estudante alvo = listaParaBusca[0];

        System.out.println();
        System.out.println("=== Buscas Binárias ===");
        System.out.println("Alvo: " + alvo);

        int resultadoIterativo = BuscaBinariaIterativa.buscar(listaParaBusca, alvo);
        System.out.println("Busca Binária Iterativa  → índice: " + resultadoIterativo);

        int resultadoRecursivo = BuscaBinariaRecursiva.buscar(listaParaBusca, alvo);
        System.out.println("Busca Binária Recursiva  → índice: " + resultadoRecursivo);
    }
}