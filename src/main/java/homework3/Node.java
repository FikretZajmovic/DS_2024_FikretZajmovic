package homework3;

import java.util.ArrayList;

public class Node<Entry> {
    String key; // key is the customer name and surname
    ArrayList<Entry> values; // values are the entries associated with the key
    Node<Entry> left, right;
    boolean color;

    public Node(String key, Entry value, boolean color) {
        this.key = key;
        this.values = new ArrayList<>();
        this.values.add(value);
        this.color = color;
    }
}
