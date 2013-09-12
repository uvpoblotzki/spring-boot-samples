package io.github.uvpoblotzki.boot.web;

import java.util.Random;

public class ServletGame implements Game {

  private int goal;
  private static Random RANDOM = new Random();

  public ServletGame() {
    this.goal = RANDOM.nextInt(10);
  }

  public ServletGame(int goal) {
    this.goal = goal;
  }

  @Override
  public Game currentGame() {
    //TODO: Implement session management
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
