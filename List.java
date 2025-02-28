public interface List<T> {
    void add(T item);
    T remove();
    T get();
    boolean isEmpty();
    int size();
}