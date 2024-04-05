package week6.labTask;

import java.util.Random;

public class DualPivotQuickSort {

    /* Quick sort algorithm (public invocation) */
    public static <Data extends Comparable<Data>> void sort(Data[] elements) {
        shuffle(elements);
        sort(elements, 0, elements.length - 1);
    }

    /* Knuth shuffle (performance guarantee) */
    private static <Data extends Comparable<Data>> void shuffle(Data[] elements) {
        Random rand = new Random();
        for (int i = 0; i < elements.length; i++) {
            int randomIndex = i + rand.nextInt(elements.length - i);
            swap(elements, i, randomIndex);
        }
    }

    /* Recursive quick sort logic */
    private static <Data extends Comparable<Data>> void sort(Data[] elements, int low, int high) {
        if (high <= low) {
            return;
        }

        int[] pivots = partition(elements, low, high);

        sort(elements, low, pivots[0] - 1);
        sort(elements, pivots[0] + 1, pivots[1] - 1);
        sort(elements, pivots[1] + 1, high);
    }

    /* Partition an array using the dual-pivot approach and return the pivot indices */
    public static <Data extends Comparable<Data>> int[] partition(Data[] elements, int low, int high) {
        if (elements[low].compareTo(elements[high]) > 0) {
            swap(elements, low, high);
        }

        int leftPivot = low + 1;
        int rightPivot = high - 1;
        int k = low + 1;
        Data p = elements[low];
        Data q = elements[high];

        while (k <= rightPivot) {
            if (elements[k].compareTo(p) < 0) {
                swap(elements, k, leftPivot++);
            }
            else if (elements[k].compareTo(q) >= 0) {
                while (k < rightPivot && elements[rightPivot].compareTo(q) > 0) {
                    rightPivot--;
                }
                swap(elements, k, rightPivot--);

                if (elements[k].compareTo(p) < 0) {
                    swap(elements, k, leftPivot++);
                }
            }
            k++;
        }

        leftPivot--;
        rightPivot++;

        swap(elements, low, leftPivot);
        swap(elements, high, rightPivot);

        return new int[]{leftPivot, rightPivot};
    }

    private static <Data extends Comparable<Data>> void swap(Data[] elements, int i, int j) {
        Data tmp = elements[i];
        elements[i] = elements[j];
        elements[j] = tmp;
    }

    public static void main(String[] args) {
        Integer[] array = {5, -1, 7, 19, 3, 12, 4};

        DualPivotQuickSort.sort(array);

        for (Integer num : array) {
            System.out.println(num);
        }
    }
}
