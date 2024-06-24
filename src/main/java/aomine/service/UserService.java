package aomine.service;

import java.util.ArrayList;

import aomine.db.CineplanetDB;
import aomine.model.User;

public class UserService {
  private ArrayList<User> users;

  public UserService() {
    users = CineplanetDB.getInstance().getUsers();
  }

  public ArrayList<User> getAll() {
    return users;
  }
}
