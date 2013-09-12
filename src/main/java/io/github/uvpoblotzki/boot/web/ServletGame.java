package io.github.uvpoblotzki.boot.web;

public class ServletGame implements Game {

  private int goal;

  public ServletGame(int goal) {
    this.goal = goal;
  }

  @Override
  public Game currentGame() {
    return this;
  }

  @Override
  public boolean correctGuess(int guess) {
    return getGoal() == guess;
  }

  public int getGoal() {
    return goal;
  }

  public void setGoal(int goal) {
    this.goal = goal;
  }
}
