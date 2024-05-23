package homework2;

public class ProcessQueue {
    public Process[] pq = new Process[2];
    public int length = 0;

    /* Add a new process into the priority queue */
    public void addProcess(Process process) {
        if (length + 1 == pq.length) {
            resize(2 * pq.length);
        }
        pq[++length] = process;
        swim(length);
    }

    /* Return and remove the next Process that should be run */
    public Process runNextProcess() {
        if (length == 0) return null;
        Process min = pq[1];
        exch(1, length--);
        sink(1);
        pq[length + 1] = null;
        if (length > 0 && length == (pq.length - 1) / 4) {
            resize(pq.length / 2);
        }
        return min;
    }

    /* Return the next Process that should be run (but do not delete it) */
    public Process peekNextProcess() {
        if (length == 0) return null;
        return pq[1];
    }

    /* Implement any other helper methods, if you need them. */
    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= length) {
            int j = 2 * k;
            if (j < length && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean greater(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void exch(int i, int j) {
        Process swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    private void resize(int capacity) {
        Process[] temp = new Process[capacity];
        for (int i = 1; i <= length; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public boolean isEmpty() {
        return length == 0;
    }
}

