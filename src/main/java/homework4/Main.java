package homework4;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        Scanner console = new Scanner(System.in);

        File file = new File("social_network.csv");
        Scanner fileScanner = new Scanner(file);
        SocialNetwork socialNetwork = new SocialNetwork(fileScanner);
        fileScanner.close();

        // Print the total number of users and friendships
        System.out.println("Social Network loaded.");
        System.out.println("Total number of users: " + socialNetwork.getNumberOfUsers());
        System.out.println("Total number of friendships: " + socialNetwork.getNumberOfFriendships());

        while (true) {
            System.out.println("Enter a name and surname to recommend friends to, or -1 to exit:");
            String input = console.nextLine();

            if (input.equals("-1")) {
                break;
            }

            if (socialNetwork.hasUser(input)) {
                ArrayList<FriendshipRecommendation> recommendations = socialNetwork.recommendFriends(input);
                System.out.println("Total number of recommendations: " + recommendations.size());

                int limit = Math.min(10, recommendations.size());
                System.out.println("Top " + limit + " recommendations:");
                for (int i = 0; i < limit; i++) {
                    FriendshipRecommendation rec = recommendations.get(i);
                    System.out.println((i + 1) + ". " + rec.getUser() + " (Strength: " + rec.getRecommendationStrength() + ")");
                }
            } else {
                System.out.println("User not found in the social network.");
            }
        }

        console.close();
    }
}
