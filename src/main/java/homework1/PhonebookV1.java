package homework1;

import java.util.Comparator;
import java.util.Scanner;
import java.io.IOException;

public class PhonebookV1 {
    public static void main(String[] args) throws IOException {
        Entry[] entries = FileUtils.readFile("raw_phonebook_data.csv");

        System.out.println("Please enter the sorting criteria (name, address, city, postcode, country, phoneNumber):");
        Scanner scanner = new Scanner(System.in);
        String criteria = scanner.nextLine();

        Comparator<Entry> comparator;
        switch (criteria.toLowerCase()) {
            case "address":
                comparator = new AddressComparator();
                break;
            case "city":
                comparator = new CityComparator();
                break;
            case "postcode":
                comparator = new PostcodeComparator();
                break;
            case "country":
                comparator = new CountryComparator();
                break;
            case "phonenumber":
                comparator = new PhoneNumberComparator();
                break;

            default:
                comparator = null;
                break;
        }

        MergeSort.sort(entries, comparator);

        FileUtils.writeToFile(entries, "sorted_phonebook_data.csv");

        while (true) {
            System.out.println("Please enter a 'Surname, Name' combination to search for, or -1 to close the program:");
            String input = scanner.nextLine();

            if (input.equals("-1")) {
                System.out.println("Closing the program. Goodbye!");
                break;
            }

            int[] indices = BinarySearch.search(entries, input);

            if (indices.length == 0) {
                System.out.println("No entries found for the name: " + input);
            } else {
                System.out.println("Found " + (indices[1] - indices[0] + 1) + " entries for the name: " + input);
                for (int i = indices[0]; i <= indices[1]; i++) {
                    System.out.println(entries[i].toString());
                }
            }
        }

        scanner.close();
    }
}
