package aomine.utils;

import javafx.scene.control.PasswordField;
import javafx.scene.control.skin.TextFieldSkin;

public class PasswordFieldSkin extends TextFieldSkin {
  private static final String SKIN = "\u26AB";

  public PasswordFieldSkin(PasswordField control) {
    super(control);
  }

  @Override
  protected String maskText(String text) {
    return SKIN.repeat(text.length());
  }
}
