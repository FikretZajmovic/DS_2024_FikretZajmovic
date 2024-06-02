package homework3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileUtils {
    public static RedBlackTree<Entry> readFile(String filePath) throws IOException {
        RedBlackTree<Entry> tree = new RedBlackTree<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ";");
                String name = st.nextToken();
                String streetAddress = st.nextToken();
                String city = st.nextToken();
                String postcode = st.nextToken();
                String country = st.nextToken();
                String phoneNumber = st.nextToken();

                Entry entry = new Entry(name, streetAddress, city, postcode, country, phoneNumber);
                tree.put(name, entry);
            }
        }

        return tree;
    }
}
