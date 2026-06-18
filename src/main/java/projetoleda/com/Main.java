package projetoleda.com;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Estudante> lista = EstudanteFactory.criarEstudantes(10);

        for(Estudante e : lista){
            System.out.printf("%s / %s / %d\n", e.nome, e.matricula, e.nota);
        }

        Estudante e1 = lista.getFirst();
        Estudante e2 = lista.get(1);
        System.out.println(e1.compareTo(e2));
    }
}