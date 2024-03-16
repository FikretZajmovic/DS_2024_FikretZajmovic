package week3.labTask;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtils {
    public static IPAddress[] readFile(String filePath) {
        List<IPAddress> list = new ArrayList<>();
        IPAddress[] ipAddresses;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

            List<String> lines = bufferedReader.lines().collect(Collectors.toList());

            for(int i = 0; i < lines.size(); i++){
                String line = lines.get(i);
                String[] parsedLine = line.split(";");

                IPAddress ipAddress = new IPAddress(Long.parseLong(parsedLine[0]), Long.parseLong(parsedLine[1]), parsedLine[2], parsedLine[3], parsedLine[4], parsedLine[5]);

                list.add(ipAddress);
            }
            ipAddresses = list.toArray(new IPAddress[0]);
            bufferedReader.close();
            return ipAddresses;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
