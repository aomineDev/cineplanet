package aomine.model;

public class User {
  private String username;
  private String hashPass;

  public User(String username, String hashPass) {
    this.username = username;
    this.hashPass = hashPass;
  }

  public String getUsername() {
    return username;
  }

  public String getHashPass() {
    return hashPass;
  }
}
