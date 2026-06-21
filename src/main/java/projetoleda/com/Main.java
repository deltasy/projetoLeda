package projetoleda.com;

public class Main {
    public static void main(String[] args) {
        int caso1 = 10_000;
        int caso2 = 50_000;
        int caso3 = 100_000;

        for (int i = 0; i < 20; i++){
            Testador.ExecutarTestesBusca(caso2);
        }
//        long inicio = System.nanoTime();
//
//        for (int i = 1; i < 21; i++){
//            System.out.printf("EXECUÇÃO: %d (%.2f%%)%n", i, ((i - 1) / 20.0) * 100);
//            Testador.ExecutarTestesOrdenacao(Cenarios.ORDENADO_INVERSAMENTE, caso2);
//        }
//        long fim = System.nanoTime();
//        double tempoS = (fim - inicio) / 60_000_000_000.0;
//        System.out.printf("%s %.3fmin%n", "TEMPO GASTO EM 20 EXE:", tempoS);
    }
}