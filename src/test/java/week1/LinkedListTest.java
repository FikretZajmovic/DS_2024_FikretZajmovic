package week1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week1.LinkedList;

public class LinkedListTest {
    @Test
    void testRemoveFromEmptyList() {
        LinkedList<Integer> ll = new LinkedList<>();
        // Remove from empty list
        Exception e = assertThrows(IndexOutOfBoundsException.class, () -> {
            ll.remove(0);
        });

        assertEquals("Invalid linked list node.", e.getMessage());
    }

    @Test
    void testRemoveFromFirstPosition() {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addToRear(5);
        ll.addToRear(1);
        ll.addToRear(4);
        ll.addToRear(7);
        ll.addToRear(2);
        ll.addToRear(9);

        ll.remove(0);
        assertEquals(5, ll.count());
        assertEquals(1, ll.get(0));
    }

    @Test
    void testRemoveFromLastPosition() {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addToRear(5);
        ll.addToRear(1);
        ll.addToRear(4);
        ll.addToRear(7);
        ll.addToRear(2);
        ll.addToRear(9);

        ll.remove(5);
        assertEquals(5, ll.count());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            ll.remove(5);
        });
    }

    @Test
    void testRemoveFromAnywhere() {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addToRear(5);
        ll.addToRear(1);
        ll.addToRear(4);
        ll.addToRear(7);
        ll.addToRear(2);
        ll.addToRear(9);

        ll.remove(2);
        assertEquals(ll.count(), 5);
        assertEquals(ll.get(2), 7);

        ll.remove(3);
        assertEquals(ll.count(), 4);
        assertEquals(ll.get(3), 9);
    }

    @Test
    void testAddToEmptyList() {
        // Remove from empty list
        LinkedList<Integer> ll = new LinkedList<>();

        ll.add(0, 12);
        assertEquals(1, ll.count());
        assertEquals(12, ll.get(0));
    }

    @Test
    void testAddToFirstPosition() {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addToRear(5);
        ll.addToRear(1);
        ll.addToRear(4);
        ll.addToRear(7);
        ll.addToRear(2);
        ll.addToRear(9);

        ll.add(0, 15);
        assertEquals(ll.count(), 7);
        assertEquals(ll.get(0), 15);
    }

    @Test
    void testAddToLastPosition() {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addToRear(5);
        ll.addToRear(1);
        ll.addToRear(4);
        ll.addToRear(7);
        ll.addToRear(2);
        ll.addToRear(9);

        ll.add(5, 11);
        assertEquals(7, ll.count());
        assertEquals(11, ll.get(5));
        assertEquals(9, ll.get(6));
    }

    @Test
    void testAddToAnywhere() {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addToRear(5);
        ll.addToRear(1);
        ll.addToRear(4);
        ll.addToRear(7);
        ll.addToRear(2);
        ll.addToRear(9);

        ll.add(2, 14);
        assertEquals(ll.count(), 7);
        assertEquals(ll.get(2), 14);
        assertEquals(ll.get(3), 4);

        ll.add(3, 12);
        assertEquals(ll.count(), 8);
        assertEquals(ll.get(3), 12);
        assertEquals(ll.get(4), 4);
    }
}
