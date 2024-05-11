package week10.labTask;

public class HeapSort {

    /* Heap sort algorithm for generic-type data */
    public static <Data extends Comparable<Data>> void sort(Data[] elements) {
        int n = elements.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(elements, n, i);

        for (int i = n - 1; i > 0; i--) {
            Data temp = elements[0];
            elements[0] = elements[i];
            elements[i] = temp;

            heapify(elements, i, 0);
        }
    }

    private static <Data extends Comparable<Data>> void heapify(Data[] elements, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && elements[left].compareTo(elements[largest]) > 0)
            largest = left;

        if (right < n && elements[right].compareTo(elements[largest]) > 0)
            largest = right;

        if (largest != i) {
            Data swap = elements[i];
            elements[i] = elements[largest];
            elements[largest] = swap;

            heapify(elements, n, largest);
        }
    }
}
