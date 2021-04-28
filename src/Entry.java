public class Entry {
    private final String key;
    private final int value;

    public Entry(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() { return this.key; }
    public int getValue() { return this.value; }
}
