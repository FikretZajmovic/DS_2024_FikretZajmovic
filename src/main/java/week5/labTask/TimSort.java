package week5.labTask;

public class TimSort {

    public static <Data extends Comparable<Data>> void sort(Data[] elements, int threshold) {
        int n = elements.length;
        Data[] aux = (Data[]) new Comparable[n];

        int minRun = calculateRunLength(elements.length, threshold);
        for (int i = 0; i < n; i += minRun) {
            insertionSort(elements, i, Math.min(n - 1, i + minRun - 1));
        }

        for (int size = minRun; size < n; size *= 2) {
            for (int left = 0; left < n; left += size * 2) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);
                if (mid < right) {
                    merge(elements, aux, left, mid, right);
                }
            }
        }
    }

    public static <Data extends Comparable<Data>> void insertionSort(Data[] elements, int low, int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low; j--) {
                if (elements[j].compareTo(elements[j - 1]) < 0) {
                    Data temp = elements[j];
                    elements[j] = elements[j - 1];
                    elements[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static <Data extends Comparable<Data>> void merge(Data[] elements, Data[] aux, int low, int mid, int high) {
        // System.arraycopy(elements, low, aux, low, high - low + 1); <- This can be used to optimise it a few seconds
        for (int k = low; k <= high; k++) {
            aux[k] = elements[k];
        }

        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                elements[k] = aux[j++];
            } else if (j > high) {
                elements[k] = aux[i++];
            } else if (aux[j].compareTo(aux[i]) < 0) {
                elements[k] = aux[j++];
            } else {
                elements[k] = aux[i++];
            }
        }
    }

    public static int calculateRunLength(int initialLength, int threshold) {
        int runLength = initialLength;

        while(runLength > threshold) {
            if(runLength % 2 == 0) {
                runLength = runLength / 2;
            }
            else {
                runLength = (runLength / 2) + 1;
                if(runLength - 1 == threshold) {
                    return runLength;
                }
            }
        }
        return runLength;
    }

    public static void main(String[] args) {
        Integer[] elements = {4, -2, 7, 19, 3, 12, 9, 21, -5, 17, 8};

        int low = 9;
        int high = 10;

        for (int i = low; i <= high; i++) {
            for (int j = i; j > low; j--) {
                if (elements[j] < elements[j - 1]) {
                    int temp = elements[j];
                    elements[j] = elements[j - 1];
                    elements[j - 1] = temp;
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < elements.length; i++) {
            System.out.println(elements[i]);
        }
    }
}