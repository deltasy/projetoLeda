package projetoleda.com;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import projetoleda.com.busca.*;
import projetoleda.com.ordenacao.*;

public class Testador {
    private static final Random random = new Random();
    // Ordena e mostra o resultado da ordenação
    public static void testar(Sorter<Estudante> sorter, Estudante[] listaOriginal, Estudante[] listaOrdenada){
        Estudante[] lista = listaOriginal.clone();
        long inicio = System.nanoTime();
        sorter.sort(lista);
        long fim = System.nanoTime();

        Arrays.sort(listaOriginal, Comparator.comparing(Estudante::getNota));

        boolean ordenouCorretamente = Arrays.equals(lista, listaOrdenada);
        boolean ordenouPorNotas = Arrays.equals(listaOriginal, lista);

        if(ordenouCorretamente){
            System.out.print("(✔) ");

        } else if (ordenouPorNotas) {
            System.out.print("(✔ CS) ");
        }
        else{
            System.out.print("(✘) ");
        }

        double tempoMin = (fim - inicio) / 60_000_000_000.0;
        System.out.printf("%-25s → %.3f min%n", sorter.getNome(), tempoMin);
    }

    private static void shuffle(Estudante[] A) {
        for (int i = A.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1); // índice aleatório entre 0 e i
            trocar(A, i, j);
        }
    }

    private static void trocar(Estudante[] A, int i, int j) {
        Estudante temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static Estudante[] inverter(Estudante[] lista) {
        for (int inicio = 0, fim = lista.length - 1; inicio < fim; inicio++, fim--) {
            Estudante temp = lista[inicio];
            lista[inicio] = lista[fim];
            lista[fim] = temp;
        }
        return lista;
    }

    public static void testarSearch(Searcher<Estudante> search, Estudante[] listaOriginal, Estudante alvo) {
        List<Estudante> lista = List.<Estudante>of(listaOriginal);
        int indiceReal = lista.indexOf(alvo);
        long inicio = System.nanoTime();
        int indiceEncontrado = search.buscar(listaOriginal, alvo);
        long fim = System.nanoTime();

        if (indiceEncontrado == indiceReal) {
            System.out.print("(✔) ");
        }
        else {
            System.out.print("(✘) ");
        }

        double tempoMin = (fim - inicio) / 60_000_000_000.0;
        System.out.printf("%-25s → %.3f min%n", search.getNome(), tempoMin);

        System.out.println(indiceEncontrado);
        System.out.println(indiceReal);
    }

    public static void ExecutarTestesOrdenacao(Cenarios cenario, int Qtd) {
        if (Qtd < 1) return;
        Estudante[] lista = EstudanteFactory.criarEstudantes(Qtd);
        Estudante[] listaOrdenada = lista.clone();
        Arrays.sort(listaOrdenada);

        switch (cenario) {
            case ORDENADO: Arrays.sort(lista); break;
            case DESORDENADO: shuffle(lista); break;
            case ORDENADO_INVERSAMENTE:
                Arrays.sort(lista);
                inverter(lista);
                break;
        }

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
            Estudante[] listaParaOrdenar = lista.clone();
            Testador.testar(a, listaParaOrdenar, listaOrdenada);
            System.out.print("---------------------------------------------------------\n");
        }
    }

    public static void ExecutarTestesBusca(int Qtd) {
        if (Qtd < 1) return;
        Estudante[] lista = EstudanteFactory.criarEstudantes(Qtd);
        int indice_alvo = random.nextInt(lista.length);
        Estudante alvo = lista[indice_alvo];

        List<Searcher<Estudante>> buscadores = List.of(
                new BuscaBinariaIterativa<>(),
                new BuscaBinariaRecursiva<>(),
                new BuscaLinear<>(),
                new BuscaLinearDuasPontas<>()
        );

        System.out.print("\n\n================ Algoritmos de Busca ================\n");
        System.out.printf("\tAlvo: %s\n", alvo);
        System.out.print("-----------------------------------------------------\n");
        System.out.print("-----------------------------------------------------\n");
        for (Searcher<Estudante> buscadorAtual : buscadores) {
            Testador.testarSearch(buscadorAtual, lista, alvo);
            System.out.print("-----------------------------------------------------\n");
        }
    }
}
