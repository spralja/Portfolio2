public interface PriorityQueue {
    /**
     * Insert a key, value pair into the heap
     * @param key associated with the value
     * @param value sorted by
     */
    void insert(String key, int value);

    /**
     * Get the entry with the smallest value
     * @return the entry with the smallest value
     */
    Entry min();

    /**
     * Remove the entry with the smallest value
     * @return the smallest value
     */
    Entry removeMin();

    /**
     * Get the number of entries in the heap
     * @return the number of entries in the heap
     */
    int size();

    /**
     * Update the value of a key in the heap
     * @param key the key whose value is to be updated
     * @param value the new value
     */
    void update(String key, int value);

    /**
     * Tests whether the heap is empty
     * @return true if empty otherwise false
     */
    default boolean isEmpty() {
        return (size() == 0);
    }
}
