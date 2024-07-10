package aomine.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;

import aomine.model.User;
import aomine.service.UserService;
import aomine.store.Store;

public class LoginController {
  private UserService userService;
  private User user;
  private Store store;

  public LoginController() {
    userService = new UserService();
    store = Store.getInstance();
  }

  public User verifyUsername(String username) throws Exception {
    user = userService.getByUsername(username);

    if (user != null) return user;

    throw new Exception("Incorrect credentials");
  }

  public boolean verifyPassword (String password, User user) throws Exception {
    BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), user.getHashPass());

    if (result.verified) return true;
    
    throw new Exception("Incorrect credentials");
  }

  public void setStoreUser(User user) {
    store.setUser(user);
  }
}
