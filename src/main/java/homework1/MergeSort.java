package homework1;

import java.util.Comparator;

public class MergeSort {

    public static void sort(Entry[] elements, Comparator<Entry> comparator) {
        Entry[] aux = new Entry[elements.length];
        sort(elements, aux, 0, elements.length - 1, comparator);
    }

    private static void sort(Entry[] elements, Entry[] aux, int low, int high, Comparator<Entry> comparator) {
        if (high <= low) {
            return;
        }

        int mid = low + (high - low) / 2;
        sort(elements, aux, low, mid, comparator);
        sort(elements, aux, mid + 1, high, comparator);
        merge(elements, aux, low, mid, high, comparator);
    }

    private static void merge(Entry[] elements, Entry[] aux, int low, int mid, int high, Comparator<Entry> comparator) {
        for(int k = low; k <= high; k++) {
            aux[k] = elements[k];
        }

        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                elements[k] = aux[j++];
            } else if (j > high) {
                elements[k] = aux[i++];
            } else if (less(aux[j], aux[i], comparator)) {
                elements[k] = aux[j++];
            } else {
                elements[k] = aux[i++];
            }
        }
    }

    private static boolean less(Entry a, Entry b, Comparator<Entry> comparator) {
        if (comparator == null) {
            return a.compareTo(b) < 0;
        } else {
            return comparator.compare(a, b) < 0;
        }
    }
}
