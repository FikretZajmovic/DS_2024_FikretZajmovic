package homework4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SocialNetwork {
    private int V;  // number of vertices (users)
    private int E;  // number of edges (friendships)
    private HashMap<String, ArrayList<Friendship>> adj;  // adjacency list

    // Constructor to initialize an empty social network
    public SocialNetwork() {
        this.V = 0;
        this.E = 0;
        this.adj = new HashMap<>();
    }

    // Constructor to initialize a graph from an input stream
    public SocialNetwork(Scanner in) {
        this();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.isEmpty() || line.equals("friend1;friend2;friendship_strength")) continue;
            String[] parts = line.split(";");
            if (parts.length == 3) {
                String friend1 = parts[0].trim();
                String friend2 = parts[1].trim();
                int strength = Integer.parseInt(parts[2].trim());
                addFriendship(new Friendship(friend1, friend2, strength));
            }
        }
    }

    // Method to add a new user to the graph
    public void addUser(String user) {
        if (!adj.containsKey(user)) {
            adj.put(user, new ArrayList<>());
            V++;
        }
    }

    // Method to add a new friendship to the graph
    public void addFriendship(Friendship f) {
        String friend1 = f.getFriend1();
        String friend2 = f.getFriend2();
        addUser(friend1);
        addUser(friend2);
        adj.get(friend1).add(f);
        adj.get(friend2).add(f);
        E++;
    }

    // Helper method to get the friends of a user
    private List<String> getFriends(String user) {
        List<String> friends = new ArrayList<>();
        if (adj.containsKey(user)) {
            for (Friendship f : adj.get(user)) {
                if (f.getFriend1().equals(user)) {
                    friends.add(f.getFriend2());
                } else {
                    friends.add(f.getFriend1());
                }
            }
        }
        return friends;
    }

    // Method to recommend friends for a user
    public ArrayList<FriendshipRecommendation> recommendFriends(String user) {
        Set<String> directFriends = new HashSet<>(getFriends(user));
        HashMap<String, Integer> potentialFriends = new HashMap<>();

        for (String friend : directFriends) {
            for (String friendsFriend : getFriends(friend)) {
                if (!directFriends.contains(friendsFriend) && !friendsFriend.equals(user)) {
                    int currentStrength = potentialFriends.getOrDefault(friendsFriend, 0);
                    int minStrength = Integer.MAX_VALUE;
                    for (Friendship f : adj.get(user)) {
                        if ((f.getFriend1().equals(user) && f.getFriend2().equals(friend)) ||
                                (f.getFriend2().equals(user) && f.getFriend1().equals(friend))) {
                            int friendFriendshipStrength = f.getFriendshipStrength();
                            for (Friendship ff : adj.get(friend)) {
                                if ((ff.getFriend1().equals(friend) && ff.getFriend2().equals(friendsFriend)) ||
                                        (ff.getFriend2().equals(friend) && ff.getFriend1().equals(friendsFriend))) {
                                    int potentialFriendshipStrength = ff.getFriendshipStrength();
                                    minStrength = Math.min(minStrength, Math.min(friendFriendshipStrength, potentialFriendshipStrength));
                                }
                            }
                        }
                    }
                    potentialFriends.put(friendsFriend, currentStrength + minStrength);
                }
            }
        }

        ArrayList<FriendshipRecommendation> recommendations = new ArrayList<>();
        for (String potentialFriend : potentialFriends.keySet()) {
            int strength = potentialFriends.get(potentialFriend);
            recommendations.add(new FriendshipRecommendation(potentialFriend, strength));
        }

        Collections.sort(recommendations, Collections.reverseOrder());
        return recommendations;
    }

    // Method to check if a user exists in the network
    public boolean hasUser(String user) {
        return adj.containsKey(user);
    }

    // Method to get the total number of users
    public int getNumberOfUsers() {
        return V;
    }

    // Method to get the total number of friendships
    public int getNumberOfFriendships() {
        return E;
    }
}
