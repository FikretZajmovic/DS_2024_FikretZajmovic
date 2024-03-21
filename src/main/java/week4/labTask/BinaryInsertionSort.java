package week4.labTask;

public class BinaryInsertionSort {

    public static <Data extends Comparable<Data>> void sort(LinkedList<Data> ll) {
        for (int i = 1; i < ll.count(); i++) {
            Data key = ll.get(i);
            int j = i - 1;
            int location = findInsertionPoint(ll, j, key);
            ll.remove(i);
            ll.add(location, key);
        }
    }

    public static <Data extends Comparable<Data>> int findInsertionPoint(LinkedList<Data> ll, int high, Data key) {
        int low = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (ll.get(mid).compareTo(key) < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }
}
