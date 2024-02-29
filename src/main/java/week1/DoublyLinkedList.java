package week1;

import java.util.Iterator;

public class DoublyLinkedList<Data> implements Iterable<Data> {
    private DoubleNode<Data> head;
    private DoubleNode<Data> tail;
    private int size = 0;

    /* Add a new node to the front of the doubly linked list */
    public void addToFront(Data data) {
        DoubleNode<Data> newNode = new DoubleNode<>();
        newNode.data = data;
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    /* Remove a node from the front of the doubly linked list */
    public void removeFromFront() {
        if(head == null){
            throw new IndexOutOfBoundsException("The list is empty");
        }
        if(head == tail){
            head = null;
            tail = null;
        }
        else {
            head = head.next;
            head.prev = null;
        }
    }

    /* Add a new node to the end of the doubly linked list */
    public void addToRear(Data data) {
        DoubleNode<Data> newNode = new DoubleNode<>();
        newNode.data = data;
        if(tail == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    /* Remove a node at the end of the doubly linked list */
    public void removeFromRear() {
        if(tail == null){
            throw new IndexOutOfBoundsException("The list is empty");
        }
        else if(head == tail){
            head = null;
            tail = null;
        }
        else{
            tail = tail.prev;
            tail.next = null;
        }
    }

    /* Get a linked list node by index (0-indexed) */
    public Data get(int index) {
        if (index < 0 || index >= size) {										// 1
            throw new IndexOutOfBoundsException("Invalid linked list node.");	// 1
        }
        DoubleNode<Data> current = head;
        int currentIndex = 0;
        while(current != null && currentIndex < index){
            current = current.next;
            currentIndex++;
        }
        return current.data;
    }

    /* Add an element to a doubly linked list by index (0-index) */
    public void add(int index, Data data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            addToFront(data);
            return;
        }
        DoubleNode<Data> newNode = new DoubleNode<>();
        newNode.data = data;
        DoubleNode<Data> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
        size++;
    }

    /* Delete an element from a doubly linked list by index (0-index) */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else {
            DoubleNode<Data> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            if (current.next != null) {
                current.next.prev = current;
            } else {
                tail = current;
            }
        }
        size--;
    }

    /* Return the current size of the doubly linked list */
    public int count() {
        return size;
    }

    /* Return an Iterator Object */
    @Override
    public Iterator<Data> iterator() {
        return new DoublyLinkedListIterator();
    }

    /* Define the Iterator class, and hasNext() and next() methods */
    private class DoublyLinkedListIterator implements Iterator<Data> {
        DoubleNode<Data> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Data next() {
            Data data = current.data;                                   // 4
            current = current.next;                                     // 4
            return data;
        }
    }

    /* Get head node (for test purposes) */
    public DoubleNode<Data> getHead() {
        return head;
    }

    /* Get tail node (for test purposes) */
    public DoubleNode<Data> getTail() {
        return tail;
    }
}