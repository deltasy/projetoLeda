package projetoleda.com;

public class Utils {
    public static <T> void swap(T[] list, int i, int j) {
        T temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static <Estudante> void printEstudantes(Estudante[] lista){
        for(Estudante e : lista){
            System.out.println(e);
        }
    }
}
