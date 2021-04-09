public class Entry {
    private String key = null;
    private int value = Integer.MAX_VALUE;

    public Entry(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return this.key;
    }

    public int getValue() {
        return this.value;
    }
}
