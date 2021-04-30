package java.cz.educanet.simple.Resources;

public class User implements Comparable {

    private String username;
    private String password;
    private boolean verified;
    private int score;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.verified = false;
        this.score = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        User user = (User) o;
        return user.score - this.score;
    }
}
