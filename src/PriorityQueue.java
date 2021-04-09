public interface PriorityQueue {
    public void insert(String key, int value);
    public Entry min();
    public Entry removeMin();
    public int size();
    default boolean isEmpty() {
        return (size() == 0);
    }
}
