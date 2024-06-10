package homework4;

import java.util.Objects;

public class Friendship {
    private String friend1;
    private String friend2;
    private int friendshipStrength;

    // Constructor
    public Friendship(String friend1, String friend2, int friendshipStrength) {
        this.friend1 = friend1;
        this.friend2 = friend2;
        this.friendshipStrength = friendshipStrength;
    }

    // Getters
    public String getFriend1() {
        return friend1;
    }

    public String getFriend2() {
        return friend2;
    }

    public int getFriendshipStrength() {
        return friendshipStrength;
    }

    // Setters
    public void setFriend1(String friend1) {
        this.friend1 = friend1;
    }

    public void setFriend2(String friend2) {
        this.friend2 = friend2;
    }

    public void setFriendshipStrength(int friendshipStrength) {
        this.friendshipStrength = friendshipStrength;
    }

    // Equals and hashCode for correct comparison and storage in collections
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friendship that = (Friendship) o;
        return friendshipStrength == that.friendshipStrength &&
                Objects.equals(friend1, that.friend1) &&
                Objects.equals(friend2, that.friend2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(friend1, friend2, friendshipStrength);
    }

    // ToString method for easy printing
    @Override
    public String toString() {
        return "Friendship{" +
                "friend1='" + friend1 + '\'' +
                ", friend2='" + friend2 + '\'' +
                ", friendshipStrength=" + friendshipStrength +
                '}';
    }
}
