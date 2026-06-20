package projetoleda.com;

public class Main {
    public static void main(String[] args) {
        int caso1 = 20_000;
        int caso2 = 0;
        int caso3 = 0;

//        Testador.ExecutarTestesBusca(caso1);
//        Testador.ExecutarTestesBusca(caso2);
//        Testador.ExecutarTestesBusca(caso3);

//        for (int i = 0; i < 20; i++){
//            Testador.ExecutarTestesOrdenacao(Cenarios.DESORDENADO, caso1);
//        }

//        for (int i = 0; i < 20; i++){
//            Testador.ExecutarTestesOrdenacao(Cenarios.ORDENADO, caso1);
//        }

        for (int i = 0; i < 20; i++){
            Testador.ExecutarTestesOrdenacao(Cenarios.ORDENADO_INVERSAMENTE, caso1);
        }
//        Testador.ExecutarTestesOrdenacao(Cenarios.DESORDENADO, caso2);
//        Testador.ExecutarTestesOrdenacao(Cenarios.DESORDENADO, caso3);
//
//        Testador.ExecutarTestesOrdenacao(Cenarios.ORDENADO_INVERSAMENTE, caso1);
//        Testador.ExecutarTestesOrdenacao(Cenarios.ORDENADO_INVERSAMENTE, caso2);
//        Testador.ExecutarTestesOrdenacao(Cenarios.ORDENADO_INVERSAMENTE, caso3);
//
//        Testador.ExecutarTestesOrdenacao(Cenarios.ORDENADO, caso1);
//        Testador.ExecutarTestesOrdenacao(Cenarios.ORDENADO, caso2);
//        Testador.ExecutarTestesOrdenacao(Cenarios.ORDENADO, caso3);
    }
}