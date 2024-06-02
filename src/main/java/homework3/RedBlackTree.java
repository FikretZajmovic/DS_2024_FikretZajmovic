package homework3;

import java.util.ArrayList;

public class RedBlackTree<Entry> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node<Entry> root;

    public ArrayList<Entry> get(String searchableName) {
        Node<Entry> node = get(root, searchableName);
        if (node == null) {
            return null;
        } else {
            System.out.println("Red edges: " + countRedEdges(root, searchableName));
            System.out.println("Black edges: " + countBlackEdges(root, searchableName));
            return node.values;
        }
    }

    private Node<Entry> get(Node<Entry> node, String key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return get(node.left, key);
        else if (cmp > 0) return get(node.right, key);
        else return node;
    }

    public void put(String searchableName, Entry entry) {
        root = put(root, searchableName, entry);
        root.color = BLACK;
    }

    private Node<Entry> put(Node<Entry> node, String key, Entry value) {
        if (node == null) return new Node<>(key, value, RED);

        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = put(node.left, key, value);
        else if (cmp > 0) node.right = put(node.right, key, value);
        else node.values.add(value);

        if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right)) flipColors(node);

        return node;
    }

    private boolean isRed(Node<Entry> node) {
        if (node == null) return false;
        return node.color == RED;
    }

    private Node<Entry> rotateLeft(Node<Entry> h) {
        Node<Entry> x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node<Entry> rotateRight(Node<Entry> h) {
        Node<Entry> x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node<Entry> h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public int[] countRedAndBlackEdges() {
        int[] counts = new int[2]; // [black, red]
        countEdges(root, counts);
        return counts;
    }

    private void countEdges(Node<Entry> node, int[] counts) {
        if (node == null) return;
        if (isRed(node)) {
            counts[1]++;
        } else {
            counts[0]++;
        }
        countEdges(node.left, counts);
        countEdges(node.right, counts);
    }

    private int countRedEdges(Node<Entry> node, String key) {
        int count = 0;
        while (node != null) {
            if (node.key.equals(key)) break;
            if (isRed(node)) count++;
            int cmp = key.compareTo(node.key);
            if (cmp < 0) node = node.left;
            else node = node.right;
        }
        return count;
    }

    private int countBlackEdges(Node<Entry> node, String key) {
        int count = 0;
        while (node != null) {
            if (node.key.equals(key)) break;
            if (!isRed(node)) count++;
            int cmp = key.compareTo(node.key);
            if (cmp < 0) node = node.left;
            else node = node.right;
        }
        return count;
    }
}
