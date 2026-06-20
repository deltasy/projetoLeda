package projetoleda.com.busca;

public interface Searcher<T> {
    int buscar(T[] array, T key);

    String getNome();
}
