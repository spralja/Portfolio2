import java.util.HashMap;

public class MinHeap implements PriorityQueue{
    /**
     * Default capacity of the array that represents the minHeap (the acctual capacity is one smaller because the first
     * element is null)
     */
    private static final int DEFAULT_CAPACITY = 1024;
    /**
     * The array that represents the heap
     */
    private Entry[] data;
    /**
     * The capacity of the array that represents minHeap
     */
    private int capacity;
    /**
     * The number of elements in the minHeap
     */
    private int size = 0;
    /**
     * a HashMap that links names of vertices to their index to accomodate the update method
     */
    private HashMap< String, Integer> indices = new HashMap<>();

    /**
     * Constructor for custom capacity
     * @param capacity the chosen capacity
     */
    public MinHeap(int capacity) {
        this.capacity = capacity;
        data = new Entry[this.capacity];
    }

    /**
     * Default constructor with default capacity
     */
    public MinHeap() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Insert a key, value pair into the heap
     * @param key associated with the value
     * @param value sorted by
     */
    @Override
    public void insert(String key, int value) {
        ++size;
        int curr = size;
        data[curr] = new Entry(key, value);
        indices.put(key, curr);

        while(isSmaller(curr, getParentIndex(curr))) {
            swap(curr, getParentIndex(curr));
            curr = getParentIndex(curr);
        }

    }

    /**
     * Get the entry with the smallest value
     * @return the entry with the smallest value
     */
    @Override
    public Entry min() {
        return data[1];
    }

    /**
     * Removes the entry with the smallest value from the minHeap
     * @return the entry with the smallest value
     */
    @Override
    public Entry removeMin() {
        int curr = 1;
        final Entry MIN = data[curr];
        data[curr] = null;
        if(size == 1) {
            --size;
            return MIN;
        }

        swap(curr, size);
        while(
                !isSmaller(curr, getLeftChildIndex(curr)) ||
                !isSmaller(curr, getLeftChildIndex(curr))) {
            if(isSmaller(getLeftChildIndex(curr), getRightChildIndex(curr))) {
                swap(curr, getLeftChildIndex(curr));
                curr = getLeftChildIndex(curr);
            } else {
                swap(curr, getRightChildIndex(curr));
                curr = getRightChildIndex(curr);
            }
        }

        --size;
        return MIN;
    }

    /**
     * Get the number of elements in the heap
     * @return the number of elements in the heap
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Update the value of a key, value pair
     * @param key the key whose value is to be updated
     * @param value the new value
     */
    @Override
    public void update(String key, int value) {
        int curr = indices.get(key);
        if(value <= data[curr].getValue()) {
            data[curr] = new Entry(key, value);
            while(isSmaller(curr, getParentIndex(curr))) {
                swap(curr, getParentIndex(curr));
                curr = getParentIndex(curr);
            }
        } else {
            data[curr] = new Entry(key, value);
            while(
                    !isSmaller(curr, getLeftChildIndex(curr)) ||
                            !isSmaller(curr, getRightChildIndex(curr))
            ) {
                if(isSmaller(getLeftChildIndex(curr), getRightChildIndex(curr))) {
                    swap(curr, getLeftChildIndex(curr));
                    curr = getLeftChildIndex(curr);
                } else {
                    swap(curr, getRightChildIndex(curr));
                    curr = getRightChildIndex(curr);
                }
            }
        }

    }

    /**
     * Swaps two elements and updates their indices in the hashmap
     * @param index1 the index of the first element
     * @param index2 the index of the second element
     */
    private void swap(int index1, int index2) {
        Entry temp = data[index1];
        data[index1] = data[index2];
        if(data[index1] != null) indices.put(data[index1].getKey(), index1);
        data[index2] = temp;
        if(data[index2] != null) indices.put(data[index2].getKey(), index2);
    }

    /**
     * Tests whether one element is smaller than another
     * @param index1 the index of the first element
     * @param index2 the index of the second element
     * @return true if the first element is smaller than the second element, false otherwise
     */
    private boolean isSmaller(int index1, int index2) {
        if(index2 == 0) return false;
        if(index1 == 0) return true;
        if(data[index1] == null) return false;
        if(data[index2] == null) return true;
        return (data[index1].getValue() < data[index2].getValue());
    }

    /**
     * Get the index of an elements parent
     * @param index the index of the element
     * @return the index of the parent of the element
     */
    private int getParentIndex(int index) {
        return index / 2;
    }

    /**
     * Get the index of the left child of an element
     * @param index the index of the element
     * @return the index of the left child of the element
     */
    private int getLeftChildIndex(int index) {
        return index * 2;
    }

    /**
     * Get the inedx of the right child of an element
     * @param index the index of the element
     * @return the index of the right child of the element
     */
    private int getRightChildIndex(int index) {
        return index * 2 + 1;
    }

    /**
     * Get a String representing the array of the minHeap (used for debugging)
     * @return a String which represents the array of the minHeap
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[ ");
        for(int i = 0; i <= size; ++i) {
            if(data[i] == null) {
                string.append("null ");
            } else {
                string.append(data[i].getValue());
                string.append(" ");
            }
        }

        string.append("]");
        return string.toString();
    }

}
