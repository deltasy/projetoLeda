package projetoleda.com;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import projetoleda.com.busca.Searcher;
import projetoleda.com.ordenacao.Sorter;

public class Testador {
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
            // Se a ordenação está incorreta, printe a lista inteira para detectar erros
            Utils.printEstudantes(lista);
        }

        double tempoMs = (fim - inicio) / 1_000_000.0;
        System.out.printf("%-25s → %.3f ms%n", sorter.getNome(), tempoMs);
    }

    public static void testarSearch(Searcher<Estudante> search, Estudante[] listaOriginal, Estudante alvo) {
        List<Estudante> lista = List.<Estudante>of(listaOriginal);
        int indiceReal = lista.indexOf(alvo);
        long inicio = System.nanoTime();
        int indiceEncontrado = search.buscar(listaOriginal, alvo);
        long fim = System.nanoTime();

        if (indiceEncontrado == -1 && indiceReal == -1) {
            System.out.print("(✔) " + "Não encontrou ");
        }
        else if (indiceEncontrado == -1) {
            System.out.print("(✘) " + "Não encontrou ");
        }
        else if (indiceEncontrado == indiceReal) {
            System.out.print("(✔) ");
        }
        else {
            System.out.print("(✘) ");
        }

        double tempoMs = (fim - inicio) / 1_000_000.0;
        System.out.printf("%-25s → %.3f ms%n", search.getNome(), tempoMs);
    }
}
