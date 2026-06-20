package projetoleda.com;

import projetoleda.com.busca.BuscaBinariaIterativa;
import projetoleda.com.busca.BuscaBinariaRecursiva;
import projetoleda.com.busca.BuscaLinear;
import projetoleda.com.busca.BuscaLinearDuasPontas;
import projetoleda.com.busca.Searcher;
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
                new CountingSort<>(Estudante::getNota),
                new InsertionSort<>(),
                new SelectionSort<>(),
                new SelectionSortEstavel<>(),
                new MergeSort<>(),
                new MergeSortTimSort<>(),
                new QuickSortDualPivot<>(),
                new QuickSortHoare<>(),
                new QuickSortHoareShuffle<>()
                );

        System.out.print("\n\n================ Algoritmos de Ordenação ================\n");
        for (Sorter<Estudante> a : algoritmos) {
            Testador.testar(a, listaOriginal, listaOrdenada);
            System.out.print("---------------------------------------------------------\n");
        }

        // buscas binárias
        // o array precisa estar ordenado antes das buscas
        Estudante[] listaParaBusca = listaOriginal.clone();
        Arrays.sort(listaParaBusca);

        // usa o primeiro estudante da lista ordenada como alvo de exemplo
        Estudante alvo = listaParaBusca[0];

        Searcher<Estudante> buscadorBI = new BuscaBinariaIterativa<>();
        Searcher<Estudante> buscadorBR = new BuscaBinariaRecursiva<>();
        Searcher<Estudante> buscadorBL = new BuscaLinear<>();
        Searcher<Estudante> buscadorBLDP = new BuscaLinearDuasPontas<>();

        List<Searcher<Estudante>> buscadores = List.of(
                buscadorBI,
                buscadorBR,
                buscadorBL,
                buscadorBLDP
        );

        System.out.print("\n\n================ Algoritmos de Busca ================\n");
        for (Searcher<Estudante> buscadorAtual : buscadores) {
            Testador.testarSearch(buscadorAtual, listaOriginal, alvo);
            System.out.print("-----------------------------------------------------\n");
        }
    }
}