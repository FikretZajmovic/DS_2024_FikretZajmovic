package homework4;

import java.util.Objects;

public class FriendshipRecommendation implements Comparable<FriendshipRecommendation> {
    private String user;
    private int recommendationStrength;

    // Constructor
    public FriendshipRecommendation(String user, int recommendationStrength) {
        this.user = user;
        this.recommendationStrength = recommendationStrength;
    }

    // Getters
    public String getUser() {
        return user;
    }

    public int getRecommendationStrength() {
        return recommendationStrength;
    }

    // Setters
    public void setUser(String user) {
        this.user = user;
    }

    public void setRecommendationStrength(int recommendationStrength) {
        this.recommendationStrength = recommendationStrength;
    }

    // Comparable implementation based on recommendation strength
    @Override
    public int compareTo(FriendshipRecommendation o) {
        return Integer.compare(this.recommendationStrength, o.recommendationStrength);
    }

    // Equals and hashCode for correct comparison and storage in collections
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendshipRecommendation that = (FriendshipRecommendation) o;
        return recommendationStrength == that.recommendationStrength &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, recommendationStrength);
    }

    // ToString method for easy printing
    @Override
    public String toString() {
        return "FriendshipRecommendation{" +
                "user='" + user + '\'' +
                ", recommendationStrength=" + recommendationStrength +
                '}';
    }
}
