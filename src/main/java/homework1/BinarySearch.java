package homework1;

public class BinarySearch {
    public static int[] search(Entry[] entries, String searchableName) {
        int low = 0;
        int high = entries.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = entries[mid].getName().compareTo(searchableName);
            if (comparison == 0) {
                int startIndex = mid;
                int endIndex = mid;
                while (startIndex > 0 && entries[startIndex - 1].getName().equals(searchableName)) {
                    startIndex--;
                }
                while (endIndex < entries.length - 1 && entries[endIndex + 1].getName().equals(searchableName)) {
                    endIndex++;
                }
                return new int[]{startIndex, endIndex};
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new int[]{};
    }
}