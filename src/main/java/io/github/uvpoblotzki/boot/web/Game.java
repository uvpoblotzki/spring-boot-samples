package io.github.uvpoblotzki.boot.web;

import java.util.Random;

public class Game {

  public static enum Result {
    Lower, Higher, Match
  }

  private int goal;
  private static Random RANDOM = new Random();

  public Game() {
    randomGoal();
  }

  public Game(int goal) {
    this.goal = goal;
  }

  /**
   * Decodes the game as two hex integers. Both integers are XORed to decode the
   * Game goal.
   *
   * @param encodedGame encoded Game in the format "seed-encodedGoal"
   * @return Decoded Game
   */
  public static Game decode(String encodedGame) {
    String[] parts = encodedGame.split("-");
    int seed = Integer.parseInt(parts[0], 16);
    int encodedGuess = Integer.parseInt(parts[1], 16);

    return new Game(seed ^ encodedGuess);
  }

  /**
   * Simply encode the game goal using XOR and a seed value
   *
   * @return Encoded Game goal in the form "seed-encodedGoal"
   */
  public String encode() {
    int seed = RANDOM.nextInt(255);
    StringBuilder sb = new StringBuilder();
    sb.append(Integer.toHexString(seed)).append("-").append(Integer.toHexString(getGoal()^seed));

    return sb.toString();
  }

  public Result checkGuess(int guess) {
    Result result = Result.Match;
    if (this.goal > guess) result = Result.Higher;
    if (this.goal < guess) result = Result.Lower;
    return result;
  }

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
    Game.RANDOM = random;
  }
}
