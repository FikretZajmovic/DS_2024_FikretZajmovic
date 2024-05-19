package homework1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static Entry[] readFile(String filePath) throws FileNotFoundException{
        List<Entry> entries = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                entries.add(new Entry(values[0], values[1], values[2], values[3], values[4], values[5]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries.toArray(new Entry[0]);
    }

    public static void writeToFile(Entry[] entries, String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Entry entry : entries) {
                String line = entry.getName() + ";" +
                        entry.getAddress() + ";" +
                        entry.getCity() + ";" +
                        entry.getPostcode() + ";" +
                        entry.getCountry() + ";" +
                        entry.getPhoneNumber();
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}