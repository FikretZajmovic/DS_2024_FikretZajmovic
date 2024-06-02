package homework3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PhonebookV2 {
    public static void main(String[] args) {
        RedBlackTree<Entry> phonebook = null;
        try {
            phonebook = FileUtils.readFile("raw_phonebook_data.csv");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        int[] edgeCounts = phonebook.countRedAndBlackEdges();
        System.out.println("Total number of black edges: " + edgeCounts[0]);
        System.out.println("Total number of red edges: " + edgeCounts[1]);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter 'Surname, Name' to search for or -1 to exit:");
            String input = scanner.nextLine();

            if (input.equals("-1")) {
                System.out.println("Exiting the program.");
                break;
            }

            ArrayList<Entry> results = phonebook.get(input);
            if (results == null) {
                System.out.println("No entries found for: " + input);
            } else {
                System.out.println("Entries found: " + results.size());
                for (Entry entry : results) {
                    System.out.println(entry);
                }
            }
        }
        scanner.close();
    }
}
