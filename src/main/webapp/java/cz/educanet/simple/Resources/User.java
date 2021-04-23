package java.cz.educanet.simple.Resources;

public class User implements Comparable {

    public String username;
    public String password;
    public boolean verified;
    public int score;

    public User() {
        this.username = null;
        this.password = null;
        this.verified = false;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.verified = false;
    }

    public User(String username, String password, boolean verified) {
        this.username = username;
        this.password = password;
        this.verified = verified;
    }

    @Override
    public int compareTo(Object o) {
        User user = (User) o;
        return user.score - this.score;
    }
}
