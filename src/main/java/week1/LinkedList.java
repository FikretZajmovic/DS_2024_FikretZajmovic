package week1;

import java.util.Iterator;

public class LinkedList<Data> implements Iterable<Data> {
    private Node<Data> head;
    private int size = 0;

    /* Add a new item to the beginning of the list */
    public void addToFront(Data data) {
        Node<Data> newNode = new Node<>();      // 1
        newNode.data = data;                    // 1
        newNode.next = head;                    // 2
        head = newNode;                         // 3
        size++;                                 // 4
    }

    /* Remove an item from the beginning of the list */
    public void removeFromFront() {
        if (head == null) {                                                     // 1
            throw new IndexOutOfBoundsException("The linked list is empty.");   // 1
        }                                                                       // 1
        head = head.next;                                                       // 2
        size--;                                                                 // 3
    }

    /* Add a new item to the end of the list */
    public void addToRear(Data data) {
        Node<Data> newNode = new Node<>();          // 1
        newNode.data = data;                        // 1

        if (head == null) {                         // 2
            head = newNode;                         // 2
        } else {
            Node<Data> current = head;              // 3
            while (current.next != null) {          // 4
                current = current.next;             // 4
            }                                       // 4
            current.next = newNode;                 // 5
        }
        size++;                                     // 6
    }

    /* Remove an item from the end of the list */
    public void removeFromRear() {
        if (head == null) {                                                     // 1
            throw new IndexOutOfBoundsException("The linked list is empty.");   // 1
        } else if (size == 1) {                                                 // 2
            head = null;                                                        // 2
        } else {                                                                // 3
            Node<Data> current = head;                                          // 3
            while (current.next.next != null) {                                 // 4
                current = current.next;                                         // 4
            }                                                                   // 4
            current.next = null;                                                // 5
        }
        size--;                                                                 // 6
    }

    /* Get a linked list node by index (0-indexed) */
    public Data get(int index) {
        if (index < 0 || index > size) {										// 1
            throw new IndexOutOfBoundsException("Invalid linked list node.");	// 1
        }

        Node<Data> current = head;												// 2
        int i = 0;																// 3
        while (i < index) {														// 4
            current = current.next;												// 4
            i++;																// 4
        }

        return current.data;													// 5
    }

    /* Add an element to a linked list by index (0-index) */
    public void add(int index, Data data) {
        if(index < 0){
            System.out.println("Cannot add an element at negative index");
        }

        Node<Data> newNode = new Node<>();
        newNode.data = data;

        if(index == 0){
            newNode.next = head;
            head = newNode;
        }
        else {
            Node<Data> current = head;
            int currentIndex = 0;
            while (current != null && currentIndex < index - 1) {
                current = current.next;
                currentIndex++;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    /* Delete an element from a linked list by index (0-index) */
    public void remove(int index) {
        if(index < 0){
            throw new IndexOutOfBoundsException("Invalid index. Cannot be negative");
        }
        if (index == 0) {
            if (head != null) {
                head = head.next;
            } else {
                throw new IndexOutOfBoundsException("Invalid linked list node.");
            }
        }
        else {
            Node<Data> previous = head;
            int currentIndex = 0;
            while (previous != null && currentIndex < index - 1) {
                previous = previous.next;
                currentIndex++;
            }
            if (previous == null || previous.next == null) {
                throw new IndexOutOfBoundsException("Index out of bounds.");
            }
            Node<Data> current = previous.next;
            previous.next = current.next;
        }
    }

    public void reverse() {
        Node<Data> current = head;                                              // 1
        Node<Data> previous = null;                                             // 1

        while (current != null) {                                               // 2
            Node<Data> next = current.next;                                     // 3
            current.next = previous;                                            // 4
            previous = current;                                                 // 5
            current = next;                                                     // 6
        }
        head = previous;                                                        // 7
    }

    /* Return the size of the linked list */
    public int count() {
        int count = 0;
        Node<Data> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /* Define the Iterator class, and hasNext() and next() methods */
    private class LinkedListIterator implements Iterator<Data> {        // 1
        Node<Data> current = head;                                      // 2

        public boolean hasNext() {                                      // 3
            return current != null;                                     // 3
        }                                                               // 3

        public Data next() {                                            // 4
            Data data = current.data;                                   // 4
            current = current.next;                                     // 4
            return data;                                                // 4
        }
    }

    /* Return an Iterator Object */
    public Iterator<Data> iterator() {
        return new LinkedListIterator();
    }
}