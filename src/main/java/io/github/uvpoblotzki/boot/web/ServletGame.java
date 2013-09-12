package io.github.uvpoblotzki.boot.web;

import java.util.Random;

public class ServletGame implements Game {

  private int goal;
  private static Random RANDOM = new Random();

  public ServletGame() {
    randomGoal();
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
  public Result checkGuess(int guess) {
    Result result = Result.Match;
    if (this.goal > guess) result = Result.Higher;
    if (this.goal < guess) result = Result.Lower;
    return result;
  }

  @Override
  public void restart() {
    randomGoal();
  }

  private void randomGoal() {
    this.goal = RANDOM.nextInt(10);
  }

  public int getGoal() {
    return goal;
  }

  public void setGoal(int goal) {
    this.goal = goal;
  }

  protected void setRandom(Random random) {
    ServletGame.RANDOM = random;
  }
}
