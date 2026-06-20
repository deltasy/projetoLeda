package projetoleda.com;

public class Main {
    public static void main(String[] args) {
        int caso = 100_000;

        for (int i = 0; i < 20; i++){
            Testador.ExecutarTestesBusca(caso);
        }

//        for (int i = 0; i < 20; i++){
//            Testador.ExecutarTestesOrdenacao(Cenarios.DESORDENADO, caso);
//        }

//        for (int i = 0; i < 20; i++){
//            Testador.ExecutarTestesOrdenacao(Cenarios.ORDENADO, caso);
//        }

//        for (int i = 0; i < 20; i++){
//            Testador.ExecutarTestesOrdenacao(Cenarios.ORDENADO_INVERSAMENTE, caso);
//        }
    }
}