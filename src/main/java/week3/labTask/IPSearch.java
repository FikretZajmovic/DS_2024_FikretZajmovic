package week3.labTask;

public class IPSearch {
    public static IPAddress search(IPAddress[] ipAddresses, String ipAddress) {
        long ipNumber = convertIPToNumber(ipAddress);
        int low = 0;
        int high = ipAddresses.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (ipAddresses[mid].getStartIp() <= ipNumber && ipAddresses[mid].getEndIp() >= ipNumber) {
                return ipAddresses[mid];
            } else if (ipAddresses[mid].getEndIp() < ipNumber) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    private static long convertIPToNumber(String ipAddress) {
        String[] parts = ipAddress.split("\\.");
        long w = Long.parseLong(parts[0]);
        long x = Long.parseLong(parts[1]);
        long y = Long.parseLong(parts[2]);
        long z = Long.parseLong(parts[3]);

        return 16777216 * w + 65536 * x + 256 * y + z;
    }
}
