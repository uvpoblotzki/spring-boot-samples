package io.github.uvpoblotzki.boot.web;

public class Hint {

  private boolean match;
  private String hint;

  public Hint(boolean match, String hint) {
    this.match = match;
    this.hint = hint;
  }

  public boolean isMatch() {
    return match;
  }

  public void setMatch(boolean match) {
    this.match = match;
  }

  public String getHint() {
    return hint;
  }

  public void setHint(String hint) {
    this.hint = hint;
  }
}
