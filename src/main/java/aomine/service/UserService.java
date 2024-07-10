package aomine.service;

import java.util.ArrayList;

import aomine.db.CineplanetDB;
import aomine.model.User;

public class UserService {
  private ArrayList<User> userList;

  public UserService() {
    userList = CineplanetDB.getInstance().getUserList();
  }

  public ArrayList<User> getAll() {
    ArrayList<User> userListCloned = new ArrayList<>(userList);
    return userListCloned;
  }

  public User getByUsername(String username) {
    for (User user: userList) {
      if (username.equals(user.getUsername())) return user;
    }

    return null;
  }
}
