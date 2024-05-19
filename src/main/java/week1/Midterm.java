package week1;

import java.util.Iterator;

public class Midterm<Data> implements Iterable<Data> {
    private Node<Data> head;
    private int size = 0;

    /* Add a new item to the beginning of the list */
    public void addToFront(Data data) {
        Node<Data> newNode = new Node<>();
        newNode.data = data;
        newNode.next = head;
        head = newNode;
        size++;
    }

    /* Remove an item from the beginning of the list */
    public void removeFromFront() {
        if(head == null){
            throw new IndexOutOfBoundsException("list is empty");
        }
        head = head.next;
        size--;
    }

    /* Add a new item to the end of the list */
    public void addToRear(Data data) {
        Node<Data> newNode = new Node<>();
        newNode.data = data;
        if(head == null){
            head = newNode;
        }
        else{
            Node<Data> current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /* Remove an item from the end of the list */
    public void removeFromRear() {
        if(head == null){
            throw new IndexOutOfBoundsException("Empty");
        }
        else if(size == 1){
            head = null;
        }
        else{
            Node<Data> current = head;
            while(current.next.next != null){
                current = current.next;
            }
            current.next = null;
        }
        size--;
    }

    /* Get a linked list node by index (0-indexed) */
    public Data get(int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Invalid");
        }
        Node<Data> current = head;
        int i = 0;
        while(i < index){
            current = current.next;
            i++;
        }
        return current.data;
    }

    /* Add an element to a linked list by index (0-index) */
    public void add(int index, Data data) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Cannot add at negative index");
        }
        Node<Data> newNode = new Node<>();
        newNode.data = data;
        if(index == 0){
            newNode.next = head;
            head = newNode;
        }
        else{
            Node<Data> current = head;
            int currentIndex = 0;
            while(current != null && currentIndex < index - 1){
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
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            if(head != null){
                head = head.next;
            }
            else{
                throw new IndexOutOfBoundsException();
            }
        }
        else{
            Node<Data> previous = head;
            int currentIndex = 0;
            while(previous != null && currentIndex < index - 1){
                previous = previous.next;
                currentIndex++;
            }
            if(previous == null || previous.next == null){
                throw new IndexOutOfBoundsException();
            }
            Node<Data> current = previous.next;
            previous.next = current.next;
        }
    }

    public void reverse() {
        Node<Data> current = head;
        Node<Data> prev = null;
        while(current != null){
            Node<Data> next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    /* Return the size of the linked list */
    public int count() {
        int count = 0;
        Node<Data> current = head;
        while(current != null){
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
        return new Midterm.LinkedListIterator();
    }
}
