package projetoleda.com;

import java.util.Arrays;

import projetoleda.com.ordenacao.Sorter;

public class Testador {
    // Ordena e mostra o resultado da ordenação
    public static void testar(Sorter<Estudante> sorter, Estudante[] listaOriginal, Estudante[] listaOrdenada){
        Estudante[] lista = listaOriginal.clone();
        sorter.sort(lista);

        boolean ordenouCorretamente = Arrays.equals(lista, listaOrdenada);

        if(ordenouCorretamente){
            System.out.println("(✔) " + sorter.getNome());

        }else{
            System.out.println("(✘) " + sorter.getNome());
            // Se a ordenação está incorreta, printe a lista inteira para detectar erros
            Utils.printEstudantes(lista);
        }
        System.out.println("-------------------------");


    }

}
