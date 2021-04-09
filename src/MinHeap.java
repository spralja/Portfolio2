public class MinHeap implements PriorityQueue{
    private static final int DEFAULT_CAPACITY = 1024;
    private Entry[] data = null;
    private int capacity = DEFAULT_CAPACITY;
    private int size = 0;
    public MinHeap(int capacity) {
        this.capacity = capacity;
        data = new Entry[this.capacity];
    }

    public MinHeap() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void insert(String key, int value) {
        ++size;
        int curr = size;
        data[curr] = new Entry(key, value);

        while(isSmaller(curr, getParentIndex(curr))) {
            swap(curr, getParentIndex(curr));
            curr = getParentIndex(curr);
        }

    }

    @Override
    public Entry min() {
        return data[1];
    }

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

    @Override
    public int size() {
        return this.size;
    }

    private void swap(int index1, int index2) {
        Entry temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    private boolean isSmaller(int index1, int index2) {
        if(index2 == 0) return false;
        if(index1 == 0) return true;
        if(data[index1] == null) return false;
        if(data[index2] == null) return true;
        return (data[index1].getValue() < data[index2].getValue());
    }

    private int getParentIndex(int index) {
        return index / 2;
    }

    private int getLeftChildIndex(int index) {
        return index * 2;
    }

    private int getRightChildIndex(int index) {
        return index * 2 + 1;
    }

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
