public class ListStack<T> implements Stack<T> {
    private List<T> list;

    public ListStack(List<T> list) {
        this.list = list;
    }

    @Override
    public void push(T item) {
        list.add(item);
    }

    @Override
    public T pop() {
        return list.remove();
    }

    @Override
    public T peek() {
        return list.get();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}