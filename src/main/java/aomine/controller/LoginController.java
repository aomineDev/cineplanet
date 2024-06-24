package aomine.controller;

import java.util.List;
import at.favre.lib.crypto.bcrypt.BCrypt;
import aomine.model.User;
import aomine.service.UserService;

public class LoginController {
  private UserService userService;
  private List<User> users;

  public LoginController() {
    userService = new UserService();
  }

  public User findUserByUsername(String username) throws Exception {
    users = userService.getAll();

    for(User user: users) {
      if (user.getUsername().equals(username)) return user;
    }

    throw new Exception("Incorrect credentials");
  }

  public boolean verifyPassword (String password, User user) throws Exception {
    BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), user.getHashPass());

    if (result.verified) return true;
    
    throw new Exception("Incorrect credentials");
  }
}
